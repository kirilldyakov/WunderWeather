
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class QpfDay {

    @SerializedName("in")
    private Object mIn;
    @SerializedName("mm")
    private Object mMm;

    public Object getIn() {
        return mIn;
    }

    public void setIn(Object in) {
        mIn = in;
    }

    public Object getMm() {
        return mMm;
    }

    public void setMm(Object mm) {
        mMm = mm;
    }

}
