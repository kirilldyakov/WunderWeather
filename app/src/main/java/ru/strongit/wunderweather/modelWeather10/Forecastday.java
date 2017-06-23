
package ru.strongit.wunderweather.modelWeather10;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Forecastday {

    @SerializedName("avehumidity")
    private Long mAvehumidity;
    @SerializedName("avewind")
    private Avewind mAvewind;
    @SerializedName("conditions")
    private String mConditions;
    @SerializedName("date")
    private Date mDate;
    @SerializedName("fcttext")
    private String mFcttext;
    @SerializedName("fcttext_metric")
    private String mFcttextMetric;
    @SerializedName("high")
    private High mHigh;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("icon_url")
    private String mIconUrl;
    @SerializedName("low")
    private Low mLow;
    @SerializedName("maxhumidity")
    private Long mMaxhumidity;
    @SerializedName("maxwind")
    private Maxwind mMaxwind;
    @SerializedName("minhumidity")
    private Long mMinhumidity;
    @SerializedName("period")
    private Long mPeriod;
    @SerializedName("pop")
    private String mPop;
    @SerializedName("qpf_allday")
    private QpfAllday mQpfAllday;
    @SerializedName("qpf_day")
    private QpfDay mQpfDay;
    @SerializedName("qpf_night")
    private QpfNight mQpfNight;
    @SerializedName("skyicon")
    private String mSkyicon;
    @SerializedName("snow_allday")
    private SnowAllday mSnowAllday;
    @SerializedName("snow_day")
    private SnowDay mSnowDay;
    @SerializedName("snow_night")
    private SnowNight mSnowNight;
    @SerializedName("title")
    private String mTitle;

    public Long getAvehumidity() {
        return mAvehumidity;
    }

    public void setAvehumidity(Long avehumidity) {
        mAvehumidity = avehumidity;
    }

    public Avewind getAvewind() {
        return mAvewind;
    }

    public void setAvewind(Avewind avewind) {
        mAvewind = avewind;
    }

    public String getConditions() {
        return mConditions;
    }

    public void setConditions(String conditions) {
        mConditions = conditions;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getFcttext() {
        return mFcttext;
    }

    public void setFcttext(String fcttext) {
        mFcttext = fcttext;
    }

    public String getFcttextMetric() {
        return mFcttextMetric;
    }

    public void setFcttextMetric(String fcttextMetric) {
        mFcttextMetric = fcttextMetric;
    }

    public High getHigh() {
        return mHigh;
    }

    public void setHigh(High high) {
        mHigh = high;
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

    public Low getLow() {
        return mLow;
    }

    public void setLow(Low low) {
        mLow = low;
    }

    public Long getMaxhumidity() {
        return mMaxhumidity;
    }

    public void setMaxhumidity(Long maxhumidity) {
        mMaxhumidity = maxhumidity;
    }

    public Maxwind getMaxwind() {
        return mMaxwind;
    }

    public void setMaxwind(Maxwind maxwind) {
        mMaxwind = maxwind;
    }

    public Long getMinhumidity() {
        return mMinhumidity;
    }

    public void setMinhumidity(Long minhumidity) {
        mMinhumidity = minhumidity;
    }

    public Long getPeriod() {
        return mPeriod;
    }

    public void setPeriod(Long period) {
        mPeriod = period;
    }

    public String getPop() {
        return mPop;
    }

    public void setPop(String pop) {
        mPop = pop;
    }

    public QpfAllday getQpfAllday() {
        return mQpfAllday;
    }

    public void setQpfAllday(QpfAllday qpfAllday) {
        mQpfAllday = qpfAllday;
    }

    public QpfDay getQpfDay() {
        return mQpfDay;
    }

    public void setQpfDay(QpfDay qpfDay) {
        mQpfDay = qpfDay;
    }

    public QpfNight getQpfNight() {
        return mQpfNight;
    }

    public void setQpfNight(QpfNight qpfNight) {
        mQpfNight = qpfNight;
    }

    public String getSkyicon() {
        return mSkyicon;
    }

    public void setSkyicon(String skyicon) {
        mSkyicon = skyicon;
    }

    public SnowAllday getSnowAllday() {
        return mSnowAllday;
    }

    public void setSnowAllday(SnowAllday snowAllday) {
        mSnowAllday = snowAllday;
    }

    public SnowDay getSnowDay() {
        return mSnowDay;
    }

    public void setSnowDay(SnowDay snowDay) {
        mSnowDay = snowDay;
    }

    public SnowNight getSnowNight() {
        return mSnowNight;
    }

    public void setSnowNight(SnowNight snowNight) {
        mSnowNight = snowNight;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
