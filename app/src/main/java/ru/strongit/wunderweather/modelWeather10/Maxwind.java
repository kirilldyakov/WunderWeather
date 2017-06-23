
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Maxwind {

    @SerializedName("degrees")
    private Long mDegrees;
    @SerializedName("dir")
    private String mDir;
    @SerializedName("kph")
    private Long mKph;
    @SerializedName("mph")
    private Long mMph;

    public Long getDegrees() {
        return mDegrees;
    }

    public void setDegrees(Long degrees) {
        mDegrees = degrees;
    }

    public String getDir() {
        return mDir;
    }

    public void setDir(String dir) {
        mDir = dir;
    }

    public Long getKph() {
        return mKph;
    }

    public void setKph(Long kph) {
        mKph = kph;
    }

    public Long getMph() {
        return mMph;
    }

    public void setMph(Long mph) {
        mMph = mph;
    }

}
