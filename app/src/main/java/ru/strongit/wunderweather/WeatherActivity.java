package ru.strongit.wunderweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.wunderweather.modelCityResult.CityResult;
import ru.strongit.wunderweather.modelCityResult.Results;

public class WeatherActivity extends AppCompatActivity {

    AutoCompleteTextView mAutoCompleteTextView;
    List<String> mCities = new ArrayList<>();

    private ArrayAdapter<String> mAdapter;

    boolean selectedText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        mAutoCompleteTextView.setThreshold(1);

        bindAdapterToCats();

        mAutoCompleteTextView.setAdapter(mAdapter);
        //mAutoCompleteTextView.setThreshold(1);


        boolean selectedText = false;
        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String r = (String)arg0.getItemAtPosition(arg2);
                Log.d("TAG", "onItemClick: "+r);
                mAutoCompleteTextView.post(new Runnable() {
                    public void run() {
                        mAutoCompleteTextView.dismissDropDown();
                    }
                });
            }

        });


        mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                    RetrofitHelper.getAutocompleteRTFT().getPosibleCities("RU", s.toString()).enqueue(new Callback<CityResult>() {
                    @Override
                    public void onResponse(Call<CityResult> call, Response<CityResult> response) {

                        CityResult cityResult = response.body();
                        if (cityResult != null) {
                            mCities.clear();
                            mAutoCompleteTextView.setAdapter(null);
                            for (Results res : cityResult.getRESULTS()) {
                                mCities.add(res.getName());
                            }
                            bindAdapterToCats();
                            mAutoCompleteTextView.setAdapter(mAdapter);

                            //mAdapter.notifyDataSetChanged();
                            mAutoCompleteTextView.showDropDown();
                        }

                    }

                    @Override
                    public void onFailure(Call<CityResult> call, Throwable t) {

                    }
                });

            }
        });


    }

    private void bindAdapterToCats() {
        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, mCities);
    }

}
