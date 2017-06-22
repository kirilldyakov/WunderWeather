
package ru.strongit.wunderweather.modelWeather;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Features {

    @SerializedName("conditions")
    private Long mConditions;

    public Long getConditions() {
        return mConditions;
    }

    public void setConditions(Long conditions) {
        mConditions = conditions;
    }

}
