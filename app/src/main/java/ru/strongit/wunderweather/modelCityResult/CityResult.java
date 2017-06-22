
package ru.strongit.wunderweather.modelCityResult;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CityResult {

    @SerializedName("RESULTS")
    private List<Results> mResults;

    public List<Results> getRESULTS() {
        return mResults;
    }

    public void setRESULTS(List<Results> results) {
        mResults = results;
    }

}
