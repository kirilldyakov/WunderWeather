package ru.strongit.wunderweather.modelWeather10;

/**
 * Created by user on 20.06.17.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.strongit.wunderweather.modelWeather.Weather;


//http://api.wunderground.com/api/c7409bebc12a3b47/conditions/forecast/q/Moskow.json
//http://api.wunderground.com/api/c7409bebc12a3b47/conditions/forecast/q/51.6630,39.2060.json


//http://api.wunderground.com/conditions/forecast/q/Moscow.json


/**
 * Интерфейс Api для общения с интернет сервером
 */
public interface WunderGround10Api {
     String BASE_URL = "http://api.wunderground.com/";


    //Возвращает название местности по коордиатам
    @GET("/api/c7409bebc12a3b47/conditions/forecast10day/q/{latitude},{longitude}.json")
    Call<WeatherForcast10> getForcast(@Path("latitude") String latitude, @Path("longitude") String longitude);


//    @GET("/maps/api/place/autocomplete/json")
//    Call<GeoCode> getCityResults(
//              @Query("types") String types
//            , @Query("input") String input
//            , @Query("location") String location
//            , @Query("radius") Integer radius
//            , @Query("key") String key);

}
