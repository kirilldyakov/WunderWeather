
package ru.strongit.wunderweather.modelWeather10;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TxtForecast {

    @SerializedName("date")
    private String mDate;
    @SerializedName("forecastday")
    private List<Forecastday> mForecastday;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public List<Forecastday> getForecastday() {
        return mForecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        mForecastday = forecastday;
    }

}
