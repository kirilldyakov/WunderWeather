
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class QpfNight {

    @SerializedName("in")
    private Double mIn;
    @SerializedName("mm")
    private Long mMm;

    public Double getIn() {
        return mIn;
    }

    public void setIn(Double in) {
        mIn = in;
    }

    public Long getMm() {
        return mMm;
    }

    public void setMm(Long mm) {
        mMm = mm;
    }

}
