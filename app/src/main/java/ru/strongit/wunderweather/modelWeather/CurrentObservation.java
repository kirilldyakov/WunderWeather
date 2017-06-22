
package ru.strongit.wunderweather.modelWeather;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CurrentObservation {

    @SerializedName("dewpoint_c")
    private Long mDewpointC;
    @SerializedName("dewpoint_f")
    private Long mDewpointF;
    @SerializedName("dewpoint_string")
    private String mDewpointString;
    @SerializedName("display_location")
    private DisplayLocation mDisplayLocation;
    @SerializedName("estimated")
    private Estimated mEstimated;
    @SerializedName("feelslike_c")
    private String mFeelslikeC;
    @SerializedName("feelslike_f")
    private String mFeelslikeF;
    @SerializedName("feelslike_string")
    private String mFeelslikeString;
    @SerializedName("forecast_url")
    private String mForecastUrl;
    @SerializedName("heat_index_c")
    private String mHeatIndexC;
    @SerializedName("heat_index_f")
    private String mHeatIndexF;
    @SerializedName("heat_index_string")
    private String mHeatIndexString;
    @SerializedName("history_url")
    private String mHistoryUrl;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("icon_url")
    private String mIconUrl;
    @SerializedName("image")
    private Image mImage;
    @SerializedName("local_epoch")
    private String mLocalEpoch;
    @SerializedName("local_time_rfc822")
    private String mLocalTimeRfc822;
    @SerializedName("local_tz_long")
    private String mLocalTzLong;
    @SerializedName("local_tz_offset")
    private String mLocalTzOffset;
    @SerializedName("local_tz_short")
    private String mLocalTzShort;
    @SerializedName("ob_url")
    private String mObUrl;
    @SerializedName("observation_epoch")
    private String mObservationEpoch;
    @SerializedName("observation_location")
    private ObservationLocation mObservationLocation;
    @SerializedName("observation_time")
    private String mObservationTime;
    @SerializedName("observation_time_rfc822")
    private String mObservationTimeRfc822;
    @SerializedName("precip_1hr_in")
    private String mPrecip1HrIn;
    @SerializedName("precip_1hr_metric")
    private String mPrecip1HrMetric;
    @SerializedName("precip_1hr_string")
    private String mPrecip1HrString;
    @SerializedName("precip_today_in")
    private String mPrecipTodayIn;
    @SerializedName("precip_today_metric")
    private String mPrecipTodayMetric;
    @SerializedName("precip_today_string")
    private String mPrecipTodayString;
    @SerializedName("pressure_in")
    private String mPressureIn;
    @SerializedName("pressure_mb")
    private String mPressureMb;
    @SerializedName("pressure_trend")
    private String mPressureTrend;
    @SerializedName("relative_humidity")
    private String mRelativeHumidity;
    @SerializedName("solarradiation")
    private String mSolarradiation;
    @SerializedName("station_id")
    private String mStationId;
    @SerializedName("temp_c")
    private Double mTempC;
    @SerializedName("temp_f")
    private Double mTempF;
    @SerializedName("temperature_string")
    private String mTemperatureString;
    @SerializedName("UV")
    private String mUV;
    @SerializedName("visibility_km")
    private String mVisibilityKm;
    @SerializedName("visibility_mi")
    private String mVisibilityMi;
    @SerializedName("weather")
    private String mWeather;
    @SerializedName("wind_degrees")
    private Long mWindDegrees;
    @SerializedName("wind_dir")
    private String mWindDir;
    @SerializedName("wind_gust_kph")
    private String mWindGustKph;
    @SerializedName("wind_gust_mph")
    private String mWindGustMph;
    @SerializedName("wind_kph")
    private Double mWindKph;
    @SerializedName("wind_mph")
    private Double mWindMph;
    @SerializedName("wind_string")
    private String mWindString;
    @SerializedName("windchill_c")
    private String mWindchillC;
    @SerializedName("windchill_f")
    private String mWindchillF;
    @SerializedName("windchill_string")
    private String mWindchillString;

    public Long getDewpointC() {
        return mDewpointC;
    }

    public void setDewpointC(Long dewpointC) {
        mDewpointC = dewpointC;
    }

    public Long getDewpointF() {
        return mDewpointF;
    }

    public void setDewpointF(Long dewpointF) {
        mDewpointF = dewpointF;
    }

    public String getDewpointString() {
        return mDewpointString;
    }

    public void setDewpointString(String dewpointString) {
        mDewpointString = dewpointString;
    }

    public DisplayLocation getDisplayLocation() {
        return mDisplayLocation;
    }

    public void setDisplayLocation(DisplayLocation displayLocation) {
        mDisplayLocation = displayLocation;
    }

    public Estimated getEstimated() {
        return mEstimated;
    }

    public void setEstimated(Estimated estimated) {
        mEstimated = estimated;
    }

    public String getFeelslikeC() {
        return mFeelslikeC;
    }

    public void setFeelslikeC(String feelslikeC) {
        mFeelslikeC = feelslikeC;
    }

    public String getFeelslikeF() {
        return mFeelslikeF;
    }

    public void setFeelslikeF(String feelslikeF) {
        mFeelslikeF = feelslikeF;
    }

    public String getFeelslikeString() {
        return mFeelslikeString;
    }

    public void setFeelslikeString(String feelslikeString) {
        mFeelslikeString = feelslikeString;
    }

    public String getForecastUrl() {
        return mForecastUrl;
    }

    public void setForecastUrl(String forecastUrl) {
        mForecastUrl = forecastUrl;
    }

    public String getHeatIndexC() {
        return mHeatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        mHeatIndexC = heatIndexC;
    }

    public String getHeatIndexF() {
        return mHeatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        mHeatIndexF = heatIndexF;
    }

    public String getHeatIndexString() {
        return mHeatIndexString;
    }

    public void setHeatIndexString(String heatIndexString) {
        mHeatIndexString = heatIndexString;
    }

    public String getHistoryUrl() {
        return mHistoryUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        mHistoryUrl = historyUrl;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        mIconUrl = iconUrl;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

    public String getLocalEpoch() {
        return mLocalEpoch;
    }

    public void setLocalEpoch(String localEpoch) {
        mLocalEpoch = localEpoch;
    }

    public String getLocalTimeRfc822() {
        return mLocalTimeRfc822;
    }

    public void setLocalTimeRfc822(String localTimeRfc822) {
        mLocalTimeRfc822 = localTimeRfc822;
    }

    public String getLocalTzLong() {
        return mLocalTzLong;
    }

    public void setLocalTzLong(String localTzLong) {
        mLocalTzLong = localTzLong;
    }

    public String getLocalTzOffset() {
        return mLocalTzOffset;
    }

    public void setLocalTzOffset(String localTzOffset) {
        mLocalTzOffset = localTzOffset;
    }

    public String getLocalTzShort() {
        return mLocalTzShort;
    }

    public void setLocalTzShort(String localTzShort) {
        mLocalTzShort = localTzShort;
    }

    public String getObUrl() {
        return mObUrl;
    }

    public void setObUrl(String obUrl) {
        mObUrl = obUrl;
    }

    public String getObservationEpoch() {
        return mObservationEpoch;
    }

    public void setObservationEpoch(String observationEpoch) {
        mObservationEpoch = observationEpoch;
    }

    public ObservationLocation getObservationLocation() {
        return mObservationLocation;
    }

    public void setObservationLocation(ObservationLocation observationLocation) {
        mObservationLocation = observationLocation;
    }

    public String getObservationTime() {
        return mObservationTime;
    }

    public void setObservationTime(String observationTime) {
        mObservationTime = observationTime;
    }

    public String getObservationTimeRfc822() {
        return mObservationTimeRfc822;
    }

    public void setObservationTimeRfc822(String observationTimeRfc822) {
        mObservationTimeRfc822 = observationTimeRfc822;
    }

    public String getPrecip1HrIn() {
        return mPrecip1HrIn;
    }

    public void setPrecip1HrIn(String precip1HrIn) {
        mPrecip1HrIn = precip1HrIn;
    }

    public String getPrecip1HrMetric() {
        return mPrecip1HrMetric;
    }

    public void setPrecip1HrMetric(String precip1HrMetric) {
        mPrecip1HrMetric = precip1HrMetric;
    }

    public String getPrecip1HrString() {
        return mPrecip1HrString;
    }

    public void setPrecip1HrString(String precip1HrString) {
        mPrecip1HrString = precip1HrString;
    }

    public String getPrecipTodayIn() {
        return mPrecipTodayIn;
    }

    public void setPrecipTodayIn(String precipTodayIn) {
        mPrecipTodayIn = precipTodayIn;
    }

    public String getPrecipTodayMetric() {
        return mPrecipTodayMetric;
    }

    public void setPrecipTodayMetric(String precipTodayMetric) {
        mPrecipTodayMetric = precipTodayMetric;
    }

    public String getPrecipTodayString() {
        return mPrecipTodayString;
    }

    public void setPrecipTodayString(String precipTodayString) {
        mPrecipTodayString = precipTodayString;
    }

    public String getPressureIn() {
        return mPressureIn;
    }

    public void setPressureIn(String pressureIn) {
        mPressureIn = pressureIn;
    }

    public String getPressureMb() {
        return mPressureMb;
    }

    public void setPressureMb(String pressureMb) {
        mPressureMb = pressureMb;
    }

    public String getPressureTrend() {
        return mPressureTrend;
    }

    public void setPressureTrend(String pressureTrend) {
        mPressureTrend = pressureTrend;
    }

    public String getRelativeHumidity() {
        return mRelativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        mRelativeHumidity = relativeHumidity;
    }

    public String getSolarradiation() {
        return mSolarradiation;
    }

    public void setSolarradiation(String solarradiation) {
        mSolarradiation = solarradiation;
    }

    public String getStationId() {
        return mStationId;
    }

    public void setStationId(String stationId) {
        mStationId = stationId;
    }

    public Double getTempC() {
        return mTempC;
    }

    public void setTempC(Double tempC) {
        mTempC = tempC;
    }

    public Double getTempF() {
        return mTempF;
    }

    public void setTempF(Double tempF) {
        mTempF = tempF;
    }

    public String getTemperatureString() {
        return mTemperatureString;
    }

    public void setTemperatureString(String temperatureString) {
        mTemperatureString = temperatureString;
    }

    public String getUV() {
        return mUV;
    }

    public void setUV(String UV) {
        mUV = UV;
    }

    public String getVisibilityKm() {
        return mVisibilityKm;
    }

    public void setVisibilityKm(String visibilityKm) {
        mVisibilityKm = visibilityKm;
    }

    public String getVisibilityMi() {
        return mVisibilityMi;
    }

    public void setVisibilityMi(String visibilityMi) {
        mVisibilityMi = visibilityMi;
    }

    public String getWeather() {
        return mWeather;
    }

    public void setWeather(String weather) {
        mWeather = weather;
    }

    public Long getWindDegrees() {
        return mWindDegrees;
    }

    public void setWindDegrees(Long windDegrees) {
        mWindDegrees = windDegrees;
    }

    public String getWindDir() {
        return mWindDir;
    }

    public void setWindDir(String windDir) {
        mWindDir = windDir;
    }

    public String getWindGustKph() {
        return mWindGustKph;
    }

    public void setWindGustKph(String windGustKph) {
        mWindGustKph = windGustKph;
    }

    public String getWindGustMph() {
        return mWindGustMph;
    }

    public void setWindGustMph(String windGustMph) {
        mWindGustMph = windGustMph;
    }

    public Double getWindKph() {
        return mWindKph;
    }

    public void setWindKph(Double windKph) {
        mWindKph = windKph;
    }

    public Double getWindMph() {
        return mWindMph;
    }

    public void setWindMph(Double windMph) {
        mWindMph = windMph;
    }

    public String getWindString() {
        return mWindString;
    }

    public void setWindString(String windString) {
        mWindString = windString;
    }

    public String getWindchillC() {
        return mWindchillC;
    }

    public void setWindchillC(String windchillC) {
        mWindchillC = windchillC;
    }

    public String getWindchillF() {
        return mWindchillF;
    }

    public void setWindchillF(String windchillF) {
        mWindchillF = windchillF;
    }

    public String getWindchillString() {
        return mWindchillString;
    }

    public void setWindchillString(String windchillString) {
        mWindchillString = windchillString;
    }

}
