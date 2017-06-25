package ru.strongit.wunderweather;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.wunderweather.modelCityResult.CityResult;
import ru.strongit.wunderweather.modelCityResult.Results;
import ru.strongit.wunderweather.modelWeather10.Forecastday;
import ru.strongit.wunderweather.modelWeather10.WeatherForcast10;

public class WeatherActivity extends AppCompatActivity {

    private AutoCompleteTextView mAutoCompleteTextView;
    private List<Results> mCities = new ArrayList<>();
    private CityResultsAdapter mAdapter;

    private LinearLayout llSearchCityGroup;
    private ImageView mImgCurWeatherLogo;
    private TextView mTvTempC;
    private TextView mTvPreasureMb;
    private TextView mTvCity;

    boolean isSelectedFromDropDownList = false;

    public static final String EXTRA_LATITUDE = "EXTRA_LATITUDE";
    public static final String EXTRA_LONGITUDE = "EXTRA_LONGITUDE";
    public static final String EXTRA_IS_RU_CITY = "EXTRA_IS_RU_CITY";


    private String mLatitude;
    private String mLongitude;
    private boolean isRU;

    private WeatherForcast10 mWeatherForcast10;

    private RecyclerView mRecViewWeek;
    private LinearLayoutManager mLayoutManager;

    private int DayWidth;
    private int height;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        isSelectedFromDropDownList = false;

        init_views();

        Bundle extras = getIntent().getExtras();
        mLatitude = extras.getString(this.EXTRA_LATITUDE);
        mLongitude = extras.getString(this.EXTRA_LONGITUDE);
        isRU = extras.getBoolean(this.EXTRA_IS_RU_CITY);

        if (mLatitude!=null) {
            llSearchCityGroup.setVisibility(View.GONE);
            requestForcast();
        } else {
            bindAdapterToCities();
            mAutoCompleteTextView.setAdapter(mAdapter);
            mAutoCompleteTextView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            Results results = (Results) arg0.getItemAtPosition(arg2);
                            mLatitude = results.getLat().replace(',', '.');
                            mLongitude = results.getLon().replace(',', '.');

                            mAutoCompleteTextView.setText(results.getName());
                            isSelectedFromDropDownList = true;
                            mAutoCompleteTextView.post(new Runnable() {
                                public void run() {
                                    mAutoCompleteTextView.dismissDropDown();
                                    mAutoCompleteTextView.setAdapter(null);
                                }
                            });

                            hideSoftKeyboard(WeatherActivity.this);
                            requestForcast();
                        }

                    });
            mAutoCompleteTextView.addTextChangedListener(
                    new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {


                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            if (!isSelectedFromDropDownList) {

                                String loc = isRU?"RU":"";
                                RetrofitHelper.getAutocompleteRTFT()
                                        .getPosibleCities(loc, s.toString())
                                        .enqueue(new Callback<CityResult>() {
                                            @Override
                                            public void onResponse(Call<CityResult> call,
                                                                   Response<CityResult> response) {
                                                CityResult cityResult = response.body();
                                                if (!isSelectedFromDropDownList)
                                                    if (cityResult != null) {
                                                        mCities.clear();
                                                        mAutoCompleteTextView.setAdapter(null);
                                                        for (Results res : cityResult.getRESULTS()) {
                                                            if(res.getType().equals("city"))
                                                                mCities.add(res);
                                                        }
                                                        bindAdapterToCities();
                                                        mAutoCompleteTextView.setAdapter(mAdapter);
                                                        mAutoCompleteTextView.showDropDown();
                                                    }

                                            }

                                            @Override
                                            public void onFailure(Call<CityResult> call, Throwable t) {

                                            }
                                        });
                            }
                            isSelectedFromDropDownList = false;
                        }
                    });

        }

    }

    private void init_views() {
        llSearchCityGroup = (LinearLayout) findViewById(R.id.city_search_string_group);

        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        mAutoCompleteTextView.setThreshold(1);

        mImgCurWeatherLogo = (ImageView) findViewById(R.id.imgCurWeatherMainLogo);

        mTvTempC = (TextView) findViewById(R.id.tvTempC);
        mTvPreasureMb = (TextView) findViewById(R.id.tvPreasure);

        mTvCity = (TextView) findViewById(R.id.tvCity);


        mRecViewWeek = (RecyclerView) findViewById(R.id.rec_week_forcast);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mRecViewWeek.setLayoutManager(mLayoutManager);
        mRecViewWeek.setHasFixedSize(true);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        float padLR = convertDpToPixel(8 * 2, this);
        float padInner = convertDpToPixel(6 * 2, this);

        DayWidth = (int) (((size.x - padInner - padLR) / 7));
        height = size.y;
    }


    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }


    private void requestForcast() {
        RetrofitHelper.getWunderGroud10RTFT().getForcast(mLatitude, mLongitude).enqueue(new Callback<WeatherForcast10>() {
            @Override
            public void onResponse(Call<WeatherForcast10> call, Response<WeatherForcast10> response) {
                mWeatherForcast10 = response.body();
                renderCurrentWeather();
                renderWeekForcast();

            }

            @Override
            public void onFailure(Call<WeatherForcast10> call, Throwable t) {

            }
        });

    }


    private void renderCurrentWeather() {
        String iconUrl = mWeatherForcast10.getCurrentObservation().getIconUrl();
        Glide.with(this)
                .asGif()
                .load(iconUrl)
                .into(mImgCurWeatherLogo);

        double tempC = mWeatherForcast10.getCurrentObservation().getTempC();

        mTvCity.setText(mWeatherForcast10.getCurrentObservation().getObservationLocation().getFull());

        mTvTempC.setText(String.format("%.1f", tempC) + " C");

        String preasuse = mWeatherForcast10.getCurrentObservation().getPressureMb() + "МБ";
        try {
            double prsd = Double.parseDouble(mWeatherForcast10.getCurrentObservation().getPressureMb());
            prsd = prsd / 1.3332;
            int prsi = (int) prsd;
            preasuse = String.valueOf(prsi) + "ммрт";
        } catch (Exception e) {
        }


        mTvPreasureMb.setText(preasuse);
    }

    private void renderWeekForcast() {
        List<Forecastday> data = new ArrayList<>();
        int i = 0;
        for (Forecastday fd : mWeatherForcast10.getForecast().getSimpleforecast().getForecastday()) {
            if (i < 7) data.add(fd);
            i++;
        }
        mRecViewWeek.setAdapter(new ForcastdayAdapter(this, R.layout.day_forcast, data, DayWidth));
        mRecViewWeek.getAdapter().notifyDataSetChanged();
    }

    private void bindAdapterToCities() {
        mAdapter = new CityResultsAdapter(this, R.layout.city_results, mCities);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
