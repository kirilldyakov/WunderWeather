
package ru.strongit.wunderweather.modelGeoCode;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Geometry {

    @SerializedName("bounds")
    private Bounds mBounds;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("location_type")
    private String mLocationType;
    @SerializedName("viewport")
    private Viewport mViewport;

    public Bounds getBounds() {
        return mBounds;
    }

    public void setBounds(Bounds bounds) {
        mBounds = bounds;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public String getLocationType() {
        return mLocationType;
    }

    public void setLocationType(String locationType) {
        mLocationType = locationType;
    }

    public Viewport getViewport() {
        return mViewport;
    }

    public void setViewport(Viewport viewport) {
        mViewport = viewport;
    }

}
