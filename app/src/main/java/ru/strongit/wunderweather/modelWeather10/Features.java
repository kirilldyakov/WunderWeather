
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Features {

    @SerializedName("conditions")
    private Long mConditions;
    @SerializedName("forecast10day")
    private Long mForecast10day;

    public Long getConditions() {
        return mConditions;
    }

    public void setConditions(Long conditions) {
        mConditions = conditions;
    }

    public Long getForecast10day() {
        return mForecast10day;
    }

    public void setForecast10day(Long forecast10day) {
        mForecast10day = forecast10day;
    }

}
