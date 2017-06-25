package ru.strongit.wunderweather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.strongit.wunderweather.modelCityResult.Results;

/**
 * Created by user on 22.06.17.
 */

public class CityResultsAdapter extends ArrayAdapter<Results> {
    private final Context mContext;
    private final List<Results> mResults;
//    private final List<Department> mDepartments_All;
//    private final List<Department> mDepartments_Suggestion;
    private final int mLayoutResourceId;
    private int viewResourceId;

    public CityResultsAdapter(Context context, int resource, List<Results> cityResults) {
        super(context, resource, cityResults);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mResults = new ArrayList<>(cityResults);
        this.viewResourceId = resource;
        //this.mDepartments_All = new ArrayList<>(cityResults);
        //this.mDepartments_Suggestion = new ArrayList<>();
    }

    public int getCount() {
        return mResults.size();
    }

    public Results getItem(int position) {
        return mResults.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(viewResourceId, null);
        }
        Results results = mResults.get(position);
        if (results != null) {
            TextView customerNameLabel = (TextView) v.findViewById(R.id.cityName);
            if (customerNameLabel != null) {
                customerNameLabel.setText(String.valueOf(results.getName()));
            }
        }
        return v;
    }


}