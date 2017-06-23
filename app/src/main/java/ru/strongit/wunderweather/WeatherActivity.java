package ru.strongit.wunderweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.widget.RecyclerView

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    boolean isSelectedFromDropDownList = false;

    public static final String EXTRA_LATITUDE = "EXTRA_LATITUDE";
    public static final String EXTRA_LONGITUDE = "EXTRA_LONGITUDE";


    private String mLatitude;
    private String mLongitude;

    private WeatherForcast10 mWeatherForcast10;

    private RecyclerView mRecViewWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        isSelectedFromDropDownList = false;

        init_views();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mLatitude = extras.getString(this.EXTRA_LATITUDE);
            mLongitude = extras.getString(this.EXTRA_LONGITUDE);
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
                                RetrofitHelper.getAutocompleteRTFT()
                                        .getPosibleCities("RU", s.toString())
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

        mRecViewWeek = (RecyclerView) findViewById(R.id.rec_week_forcast);
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

        mTvTempC.setText(String.format("%.1f", tempC));

        String preasuseMb = mWeatherForcast10.getCurrentObservation().getPressureMb();

        mTvPreasureMb.setText(preasuseMb);
    }

    private void renderWeekForcast() {
        List<Forecastday> data = new ArrayList<>();
        for(Forecastday fd: mWeatherForcast10.getForecast().getSimpleforecast().getForecastday()){

        }


        RecyclerView.Adapter adapter = new ForcastdayAdapter(this, R.layout.day_forcast, data);
        mRecViewWeek.setAdapter(() adapter);
    }

    private void bindAdapterToCities() {
        mAdapter = new CityResultsAdapter(this, R.layout.city_results, mCities);
    }

}
