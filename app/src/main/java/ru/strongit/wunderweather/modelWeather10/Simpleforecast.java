
package ru.strongit.wunderweather.modelWeather10;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Simpleforecast {

    @SerializedName("forecastday")
    private List<Forecastday> mForecastday;

    public List<Forecastday> getForecastday() {
        return mForecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        mForecastday = forecastday;
    }

}
