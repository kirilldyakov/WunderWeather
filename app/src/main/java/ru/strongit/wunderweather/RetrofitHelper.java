package ru.strongit.wunderweather;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import ru.strongit.wunderweather.modelCityResult.AutocompleteApi;
import ru.strongit.wunderweather.modelGeoCode.GoogleMapsApi;
//import ru.strongit.wunderweather.modelWeather.WunderGroundApi;
import ru.strongit.wunderweather.modelWeather10.WunderGround10Api;

/**
 * Created by user on 22.06.17.
 */

public class RetrofitHelper {
    private static AutocompleteApi autocompleteRTFT;
    private static WunderGround10Api wunderGroud10RTFT;
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

    public static WunderGround10Api getWunderGroud10RTFT() {
        if (wunderGroud10RTFT == null) {

            Retrofit retrofitWU = new Retrofit.Builder()
                    .baseUrl(WunderGround10Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(WunderWeatherApp.OkHttpClientBuilder.configureClient())
                    .build();
            wunderGroud10RTFT = retrofitWU.create(WunderGround10Api.class);
        }
        return wunderGroud10RTFT;
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
