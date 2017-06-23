package ru.strongit.wunderweather;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.strongit.wunderweather.modelCityResult.CityResult;

/**
 * Created by user on 22.06.17.
 */

public class CityResultsAdapter extends ArrayAdapter<CityResult> {
    private final Context mContext;
    private final List<CityResult> mCityResults;
//    private final List<Department> mDepartments_All;
//    private final List<Department> mDepartments_Suggestion;
    private final int mLayoutResourceId;

    public CityResultsAdapter(Context context, int resource, List<CityResult> cityResults) {
        super(context, resource, cityResults);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mCityResults = new ArrayList<>(cityResults);
        //this.mDepartments_All = new ArrayList<>(cityResults);
        //this.mDepartments_Suggestion = new ArrayList<>();
    }

    public int getCount() {
        return mCityResults.size();
    }

    public CityResult getItem(int position) {
        return mCityResults.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        try {
//            if (convertView == null) {
//                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
//                convertView = inflater.inflate(mLayoutResourceId, parent, false);
//            }
//            Department department = getItem(position);
//            TextView name = (TextView) convertView.findViewById(R.id.textView);
//            name.setText(department.name);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return convertView;
//    }
//
//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            public String convertResultToString(Object resultValue) {
//                return ((Department) resultValue).name;
//            }
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                if (constraint != null) {
//                    mDepartments_Suggestion.clear();
//                    for (Department department : mDepartments_All) {
//                        if (department.name.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
//                            mDepartments_Suggestion.add(department);
//                        }
//                    }
//                    FilterResults filterResults = new FilterResults();
//                    filterResults.values = mDepartments_Suggestion;
//                    filterResults.count = mDepartments_Suggestion.size();
//                    return filterResults;
//                } else {
//                    return new FilterResults();
//                }
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                mDepartments.clear();
//                if (results != null && results.count > 0) {
//                    // avoids unchecked cast warning when using mDepartments.addAll((ArrayList<Department>) results.values);
//                    List<?> result = (List<?>) results.values;
//                    for (Object object : result) {
//                        if (object instanceof Department) {
//                            mDepartments.add((Department) object);
//                        }
//                    }
//                } else if (constraint == null) {
//                    // no filter, add entire original list back in
//                    mDepartments.addAll(mDepartments_All);
//                }
//                notifyDataSetChanged();
//            }
//        };
//    }
}