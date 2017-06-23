
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class WeatherForcast10 {

    @SerializedName("current_observation")
    private CurrentObservation mCurrentObservation;
    @SerializedName("forecast")
    private Forecast mForecast;
    @SerializedName("response")
    private Response mResponse;

    public CurrentObservation getCurrentObservation() {
        return mCurrentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        mCurrentObservation = currentObservation;
    }

    public Forecast getForecast() {
        return mForecast;
    }

    public void setForecast(Forecast forecast) {
        mForecast = forecast;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

}
