package ru.strongit.wunderweather;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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


    private FusedLocationProviderClient mFusedLocationClient;
    private Button mBtnThisCity;
    private Button mBtnOtherCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mBtnThisCity = (Button) findViewById(R.id.btnThisCity);
        mBtnThisCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WeatherActivity.class);
                //i.putExtra()
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

        RetrofitHelper.getGoogleMapsRTFT().getGeoCode(latlon, language, GoogleMapsApi.GOOGLE_MAPS_KEY).enqueue(new Callback<GeoCode>() {
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
        RetrofitHelper.getWunderGroudRTFT().getForcast(lat, lon).enqueue(new Callback<Weather>() {
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
