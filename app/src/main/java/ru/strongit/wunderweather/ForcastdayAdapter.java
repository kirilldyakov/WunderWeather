package ru.strongit.wunderweather;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;

import ru.strongit.wunderweather.modelWeather10.Date;
import ru.strongit.wunderweather.modelWeather10.Forecastday;


/**
 * Created by user on 22.06.17.
 */

public class ForcastdayAdapter extends RecyclerView.Adapter<ForcastdayAdapter.ViewHolder> {
    private final Context mContext;
    private final List<Forecastday> mForecastdayList;
    private int viewResourceId;
    private int DayWidth;


    //+
    public ForcastdayAdapter(Context context, int resource, List<Forecastday> forecastdaysList, int width) {
        this.mContext = context;
        this.mForecastdayList = forecastdaysList;
        this.viewResourceId = resource;
        this.DayWidth = width;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent
                        .getContext())
                .inflate(R.layout.day_forcast, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ForcastdayAdapter.ViewHolder holder, int position) {


        Forecastday forecastday = mForecastdayList.get(position);

        LinearLayout llDay = (LinearLayout)holder.itemView.findViewById(R.id.llDayForecast);
        ViewGroup.LayoutParams params = llDay.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = DayWidth;
        llDay.setLayoutParams(params);


         String sDate = forecastday.getDate().getDay()+"."+forecastday.getDate().getMonth();
        TextView tvDate = (TextView) holder.itemView.findViewById(R.id.tvDate);
        tvDate.setText(sDate);

        TextView tvHigh = (TextView) holder.itemView.findViewById(R.id.tvHigh);
        tvHigh.setText(forecastday.getHigh().getCelsius());

        TextView tvLow = (TextView) holder.itemView.findViewById(R.id.tvLow);
        tvLow.setText(forecastday.getLow().getCelsius());

        ImageView dayLogo = (ImageView) holder.itemView.findViewById(R.id.imgDayLogo);
        String iconUrl = forecastday.getIconUrl();

        Glide.with(mContext)
                .asGif()
                .load(iconUrl)
                .into(dayLogo);

    }



    //+
    @Override
    public int getItemCount() {
        if (mForecastdayList == null)
            return 0;
        return mForecastdayList.size();
    }



//Вложенный класс ViewHolder. Используется для наполнения списка данными
class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvHigh;
        TextView tvLow;
        LinearLayout llDayForecast;

        ViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            llDayForecast = (LinearLayout)itemView.findViewById(viewResourceId);
        }

        @Override
        public void onClick(View v) {
            Log.d("LOG_TAG", "onClick: "+v.toString());
            notifyDataSetChanged();
        }

    }
//    public int getCount() {
//        return mForecastdayList.size();
//    }
//
//    public Forecastday getItem(int position) {
//        return mForecastdayList.get(position);
//    }
//
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
////        return super.getView(position, convertView, parent);
//
//        View v = convertView;
//        if (v == null) {
//            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = vi.inflate(viewResourceId, null);
//        }
//        Forecastday forecastday = mForecastdayList.get(position);
//        if (forecastday != null) {
//
//            TextView tvLowTemp = (TextView) v.findViewById(R.id.tvLow);
//                tvLowTemp.setText(String.valueOf(forecastday.getLow().getCelsius()));
//            TextView tvHighTemp = (TextView) v.findViewById(R.id.tvHigh);
//            tvHighTemp.setText(String.valueOf(forecastday.getHigh().getCelsius()));
//
//        }
//        return v;
//    }


}