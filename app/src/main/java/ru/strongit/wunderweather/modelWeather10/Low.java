
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Low {

    @SerializedName("celsius")
    private String mCelsius;
    @SerializedName("fahrenheit")
    private String mFahrenheit;

    public String getCelsius() {
        return mCelsius;
    }

    public void setCelsius(String celsius) {
        mCelsius = celsius;
    }

    public String getFahrenheit() {
        return mFahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        mFahrenheit = fahrenheit;
    }

}
