
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SnowNight {

    @SerializedName("cm")
    private Double mCm;
    @SerializedName("in")
    private Double mIn;

    public Double getCm() {
        return mCm;
    }

    public void setCm(Double cm) {
        mCm = cm;
    }

    public Double getIn() {
        return mIn;
    }

    public void setIn(Double in) {
        mIn = in;
    }

}
