
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DisplayLocation {

    @SerializedName("city")
    private String mCity;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("country_iso3166")
    private String mCountryIso3166;
    @SerializedName("elevation")
    private String mElevation;
    @SerializedName("full")
    private String mFull;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("magic")
    private String mMagic;
    @SerializedName("state")
    private String mState;
    @SerializedName("state_name")
    private String mStateName;
    @SerializedName("wmo")
    private String mWmo;
    @SerializedName("zip")
    private String mZip;

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCountryIso3166() {
        return mCountryIso3166;
    }

    public void setCountryIso3166(String countryIso3166) {
        mCountryIso3166 = countryIso3166;
    }

    public String getElevation() {
        return mElevation;
    }

    public void setElevation(String elevation) {
        mElevation = elevation;
    }

    public String getFull() {
        return mFull;
    }

    public void setFull(String full) {
        mFull = full;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getMagic() {
        return mMagic;
    }

    public void setMagic(String magic) {
        mMagic = magic;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String stateName) {
        mStateName = stateName;
    }

    public String getWmo() {
        return mWmo;
    }

    public void setWmo(String wmo) {
        mWmo = wmo;
    }

    public String getZip() {
        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }

}
