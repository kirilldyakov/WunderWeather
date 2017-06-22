
package ru.strongit.wunderweather.modelWeather;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Weather {

    @SerializedName("current_observation")
    private CurrentObservation mCurrentObservation;
    @SerializedName("response")
    private Response mResponse;

    public CurrentObservation getCurrentObservation() {
        return mCurrentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        mCurrentObservation = currentObservation;
    }

    public Response getResponse() {
        return mResponse;
    }

    public void setResponse(Response response) {
        mResponse = response;
    }

}
