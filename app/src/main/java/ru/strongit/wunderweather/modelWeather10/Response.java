
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("features")
    private Features mFeatures;
    @SerializedName("termsofService")
    private String mTermsofService;
    @SerializedName("version")
    private String mVersion;

    public Features getFeatures() {
        return mFeatures;
    }

    public void setFeatures(Features features) {
        mFeatures = features;
    }

    public String getTermsofService() {
        return mTermsofService;
    }

    public void setTermsofService(String termsofService) {
        mTermsofService = termsofService;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
