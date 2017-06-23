package ru.strongit.wunderweather;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.strongit.wunderweather.modelGeoCode.GeoCode;
import ru.strongit.wunderweather.modelGeoCode.GoogleMapsApi;
import ru.strongit.wunderweather.modelGeoCode.Result;
import ru.strongit.wunderweather.modelWeather.Weather;
import ru.strongit.wunderweather.modelWeather10.WeatherForcast10;

public class MainActivity extends AppCompatActivity {


    private FusedLocationProviderClient mFusedLocationClient;
    private Button mBtnThisCity;
    private Button mBtnOtherCity;

    private TextView tvLat;
    private TextView tvLon;
    private TextView tvCity;

    private String mLatitude;
    private String mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLat = (TextView) findViewById(R.id.tvLat);
        tvLon = (TextView) findViewById(R.id.tvLon);
        tvCity = (TextView) findViewById(R.id.tvCity);

        tvLat.setText("");
        tvLon.setText("");
        tvCity.setText("");

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mBtnThisCity = (Button) findViewById(R.id.btnThisCity);
        mBtnThisCity.setEnabled(false);
        mBtnThisCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WeatherActivity.class);
                if(!mLatitude.isEmpty()) i.putExtra(WeatherActivity.EXTRA_LATITUDE, mLatitude);
                if(!mLongitude.isEmpty()) i.putExtra(WeatherActivity.EXTRA_LONGITUDE, mLongitude);
                startActivity(i);
            }
        });

        mBtnOtherCity = (Button) findViewById(R.id.btnOtherCity);
        mBtnOtherCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WeatherActivity.class);
                //i.putExtra()
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {

        super.onStart();
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
                            mLatitude = String.valueOf(location.getLatitude()).replace(',','.');
                            mLongitude = String.valueOf(location.getLongitude()).replace(',','.');

                            tvLat.setText(location.convert(location.getLatitude(), location.FORMAT_SECONDS));
                            tvLon.setText(location.convert(location.getLongitude(), location.FORMAT_SECONDS));
                            String latlon = mLatitude+","+mLongitude;
                            RetrofitHelper.getGoogleMapsRTFT().getGeoCode(latlon, "RU", GoogleMapsApi.GOOGLE_MAPS_KEY).enqueue(new Callback<GeoCode>() {
                                @Override
                                public void onResponse(Call<GeoCode> call, Response<GeoCode> response) {
                                    GeoCode geoCode = response.body();
                                    List<Result> results = geoCode.getResults();
                                    tvCity.setText(results.get(3).getFormattedAddress());
                                    mBtnThisCity.setEnabled(true);
                                }

                                @Override
                                public void onFailure(Call<GeoCode> call, Throwable t) {

                                }
                            });

                            //getForcast(location.getLatitude(), location.getLongitude());
                        }
                    }
                });
    }

//    private void getGeoCode(String latlon) {
//        String language = "ru";
//
//        RetrofitHelper.getGoogleMapsRTFT().getGeoCode(latlon, language, GoogleMapsApi.GOOGLE_MAPS_KEY).enqueue(new Callback<GeoCode>() {
//            @Override
//            public void onResponse(Call<GeoCode> call, Response<GeoCode> response) {
//                GeoCode mGeoCode = response.body();
//                if (mGeoCode != null)
//                    Log.d("TAG", "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<GeoCode> call, Throwable t) {
//                t.printStackTrace();
//                Log.d("TAG", "onFailure: Error");
//            }
//        });
//    }
//
//    private void getForcast(double lat, double lon) {
//
//        String sLat = String.format("%1$,.4f", lat).replace(',', '.');
//
//        String sLon = String.format("%1$,.4f", lon).replace(',', '.');
//
//        getForcast(sLat, sLon);
//    }
//
//    private void getForcast(String lat, String lon) {
//        RetrofitHelper.getWunderGroud10RTFT().getForcast(lat, lon).enqueue(new Callback<WeatherForcast10>() {
//            @Override
//            public void onResponse(Call<WeatherForcast10> call, Response<WeatherForcast10> response) {
//                Weather mWeather = response.body();
//                if (mWeather != null)
//                    Log.d("TAG", "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<Weather> call, Throwable t) {
//                Log.d("TAG", "onFailure: Error");
//            }
//        });
//    }

}
