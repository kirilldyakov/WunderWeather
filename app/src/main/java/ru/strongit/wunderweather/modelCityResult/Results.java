
package ru.strongit.wunderweather.modelCityResult;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Results {

    @SerializedName("c")
    private String mC;
    @SerializedName("l")
    private String mL;
    @SerializedName("lat")
    private String mLat;
    @SerializedName("ll")
    private String mLl;
    @SerializedName("lon")
    private String mLon;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;
    @SerializedName("tz")
    private String mTz;
    @SerializedName("tzs")
    private String mTzs;
    @SerializedName("zmw")
    private String mZmw;

    public String getC() {
        return mC;
    }

    public void setC(String c) {
        mC = c;
    }

    public String getL() {
        return mL;
    }

    public void setL(String l) {
        mL = l;
    }

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLl() {
        return mLl;
    }

    public void setLl(String ll) {
        mLl = ll;
    }

    public String getLon() {
        return mLon;
    }

    public void setLon(String lon) {
        mLon = lon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTz() {
        return mTz;
    }

    public void setTz(String tz) {
        mTz = tz;
    }

    public String getTzs() {
        return mTzs;
    }

    public void setTzs(String tzs) {
        mTzs = tzs;
    }

    public String getZmw() {
        return mZmw;
    }

    public void setZmw(String zmw) {
        mZmw = zmw;
    }

}
