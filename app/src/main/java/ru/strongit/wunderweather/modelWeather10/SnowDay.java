
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SnowDay {

    @SerializedName("cm")
    private Object mCm;
    @SerializedName("in")
    private Object mIn;

    public Object getCm() {
        return mCm;
    }

    public void setCm(Object cm) {
        mCm = cm;
    }

    public Object getIn() {
        return mIn;
    }

    public void setIn(Object in) {
        mIn = in;
    }

}
