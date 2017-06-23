
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Forecast {

    @SerializedName("simpleforecast")
    private Simpleforecast mSimpleforecast;
    @SerializedName("txt_forecast")
    private TxtForecast mTxtForecast;

    public Simpleforecast getSimpleforecast() {
        return mSimpleforecast;
    }

    public void setSimpleforecast(Simpleforecast simpleforecast) {
        mSimpleforecast = simpleforecast;
    }

    public TxtForecast getTxtForecast() {
        return mTxtForecast;
    }

    public void setTxtForecast(TxtForecast txtForecast) {
        mTxtForecast = txtForecast;
    }

}
