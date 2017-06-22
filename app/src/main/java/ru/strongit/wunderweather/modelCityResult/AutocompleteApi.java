package ru.strongit.wunderweather.modelCityResult; /**
 * Created by user on 20.06.17.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.strongit.wunderweather.modelGeoCode.GeoCode;

/**
 * Интерфейс Api для общения с интернет сервером
 */
public interface AutocompleteApi {
    String BASE_URL = "http://autocomplete.wunderground.com/";


    //Возвращает название местности по коордиатам
    @GET("aq")
    Call<CityResult> getPosibleCities(@Query("c") String c
            , @Query("query") String query);


}

