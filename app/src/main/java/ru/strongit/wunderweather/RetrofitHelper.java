package ru.strongit.wunderweather;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import ru.strongit.wunderweather.modelCityResult.AutocompleteApi;
import ru.strongit.wunderweather.modelGeoCode.GoogleMapsApi;
import ru.strongit.wunderweather.modelWeather.WunderGroundApi;

/**
 * Created by user on 22.06.17.
 */

public class RetrofitHelper {
    private static AutocompleteApi autocompleteRTFT;
    private static WunderGroundApi wunderGroudRTFT;
    private static GoogleMapsApi googleMapsRTFT;


    public static AutocompleteApi getAutocompleteRTFT() {
        if (autocompleteRTFT == null) {

            Retrofit retrofitAC = new Retrofit.Builder()
                    .baseUrl(AutocompleteApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(WunderWeatherApp.OkHttpClientBuilder.configureClient())
                    .build();
            autocompleteRTFT = retrofitAC.create(AutocompleteApi.class);
        }
        return autocompleteRTFT;
    }

    public static WunderGroundApi getWunderGroudRTFT() {
        if (wunderGroudRTFT == null) {

            Retrofit retrofitWU = new Retrofit.Builder()
                    .baseUrl(WunderGroundApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(WunderWeatherApp.OkHttpClientBuilder.configureClient())
                    .build();
            wunderGroudRTFT = retrofitWU.create(WunderGroundApi.class);
        }
        return wunderGroudRTFT;
    }

    public static GoogleMapsApi getGoogleMapsRTFT() {
        if (googleMapsRTFT == null) {

            Retrofit retrofitGM = new Retrofit.Builder()
                    .baseUrl(GoogleMapsApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(WunderWeatherApp.OkHttpClientBuilder.configureClient())
                    .build();
            googleMapsRTFT = retrofitGM.create(GoogleMapsApi.class);
        }
        return googleMapsRTFT;
    }

}
