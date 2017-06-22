package ru.strongit.wunderweather.modelGeoCode; /**
 * Created by user on 20.06.17.
 */

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.strongit.wunderweather.modelGeoCode.GeoCode;
import ru.strongit.wunderweather.modelWeather.Weather;
import ru.strongit.wunderweather.modelCityResult.CityResult;

/**
 * Интерфейс Api для общения с интернет сервером
 */
public interface GoogleMapsApi {
    String BASE_URL = "https://maps.googleapis.com";


    //Возвращает название местности по коордиатам
    @GET("/maps/api/geocode/json")
    Call<GeoCode> getGeoCode(@Query("latlng") String latlng
               , @Query("language") String language
               , @Query("key") String key);

}
