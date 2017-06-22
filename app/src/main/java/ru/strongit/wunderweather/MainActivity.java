package ru.strongit.wunderweather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.strongit.wunderweather.modelCityResult.AutocompleteApi;
import ru.strongit.wunderweather.modelCityResult.CityResult;
import ru.strongit.wunderweather.modelCityResult.Results;
import ru.strongit.wunderweather.modelGeoCode.GeoCode;
import ru.strongit.wunderweather.modelGeoCode.GoogleMapsApi;
import ru.strongit.wunderweather.modelWeather.Weather;
import ru.strongit.wunderweather.modelWeather.WunderGroundApi;

public class MainActivity extends AppCompatActivity {

    private String GOOGLE_MAPS_KEY = "AIzaSyCJvKcHEGHoFPiIT7YkK1o2KeIq7yLxfjE";

    private FusedLocationProviderClient mFusedLocationClient;

    private WunderGroundApi wunderGroudRTFT;
    private AutocompleteApi autocompleteRTFT;
    private GoogleMapsApi googleMapsRTFT;

    private EditText mCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        initRetrofitServices();

        mCityName = (EditText) findViewById(R.id.edCityName);
        mCityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.equals("")) return;
                autocompleteRTFT.getPosibleCities("RU", s.toString()).enqueue(new Callback<CityResult>() {
                    @Override
                    public void onResponse(Call<CityResult> call, Response<CityResult> response) {
                        CityResult mCityResult = response.body();
                        Log.d("TAG", ">----------");
                        if (mCityResult != null) {
                            Log.d("TAG", "Города:");
                            for (Results res : mCityResult.getRESULTS()) {
                                Log.d("TAG", res.getName() + " " + res.getLat() + ":" + res.getLon());
                            }
                        }
                        Log.d("TAG", "<------------");
                    }

                    @Override
                    public void onFailure(Call<CityResult> call, Throwable t) {
                        Log.d("TAG", "onFailure: Error");
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initRetrofitServices() {
        Retrofit retrofitGM = new Retrofit.Builder()
                .baseUrl(GoogleMapsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(WWApp.MyClientBuilder.configureClient())
                .build();
        googleMapsRTFT = retrofitGM.create(GoogleMapsApi.class);

        Retrofit retrofitWU = new Retrofit.Builder()
                .baseUrl(WunderGroundApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(WWApp.MyClientBuilder.configureClient())
                .build();
        wunderGroudRTFT = retrofitWU.create(WunderGroundApi.class);

        Retrofit retrofitAC = new Retrofit.Builder()
                .baseUrl(AutocompleteApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(WWApp.MyClientBuilder.configureClient())
                .build();
        autocompleteRTFT = retrofitAC.create(AutocompleteApi.class);
    }


    @Override
    public void onBackPressed() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            //retrofitGetData(location.getLatitude()+","+location.getLongitude());

                            getForcast(location.getLatitude(), location.getLongitude());
                        }
                    }
                });


    }

    private void getGeoCode(String latlon) {
        String language = "ru";

        googleMapsRTFT.getGeoCode(latlon, language, GOOGLE_MAPS_KEY).enqueue(new Callback<GeoCode>() {
            @Override
            public void onResponse(Call<GeoCode> call, Response<GeoCode> response) {
                GeoCode mGeoCode = response.body();
                if (mGeoCode != null)
                    Log.d("TAG", "onResponse: ");
            }

            @Override
            public void onFailure(Call<GeoCode> call, Throwable t) {
                t.printStackTrace();
                Log.d("TAG", "onFailure: Error");
            }
        });

    }

    private void getForcast(double lat, double lon) {

        String sLat = String.format("%1$,.4f", lat).replace(',', '.');

        String sLon = String.format("%1$,.4f", lon).replace(',', '.');

        getForcast(sLat, sLon);
    }

    private void getForcast(String lat, String lon) {

        wunderGroudRTFT.getForcast(lat, lon).enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather mWeather = response.body();
                if (mWeather != null)
                    Log.d("TAG", "onResponse: ");
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("TAG", "onFailure: Error");
            }
        });
    }
}
