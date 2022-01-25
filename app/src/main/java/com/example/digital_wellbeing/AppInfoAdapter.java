package com.example.digital_wellbeing;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class AppInfoAdapter extends BaseAdapter {
    private Context mContext;
    private List mListAppInfo;
    private PackageManager mPackManager;

    public AppInfoAdapter(Context c, List list, PackageManager pm) {
        mContext = c;
        mListAppInfo = list;
        mPackManager = pm;
    }

    @Override
    public int getCount() {
        return mListAppInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return mListAppInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the selected entry
        ApplicationInfo entry = (ApplicationInfo) mListAppInfo.get(position);

        // reference to convertView
        View v = convertView;

        // inflate new layout if null
        if(v == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            v = inflater.inflate(R.layout.installed_app_list, null);
        }

        // load controls from layout resources
        ImageView ivAppIcon = (ImageView)v.findViewById(R.id.ivIcon);
        TextView tvAppName = (TextView)v.findViewById(R.id.tvName);
        ImageView setTimer_App = (ImageView)v.findViewById(R.id.setTimer);

        // set data to display
        ivAppIcon.setImageDrawable(entry.loadIcon(mPackManager));
        tvAppName.setText(entry.loadLabel(mPackManager));


        setTimer_App.setOnClickListener(new View.OnClickListener() {
            private Object Bundle;

            @Override
            public void onClick(View v) {
                timepick();

            }
        });
        // return view
        return v;
    }
    public void timepick(){
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        mcurrentTime.set(Calendar.MINUTE, minute);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                Toast.makeText(mContext.getApplicationContext(), ""+selectedHour+": "+selectedMinute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Choose hour:");
        mTimePicker.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
        mTimePicker.setMessage("This app timer for Application will reset at midnight");
        mTimePicker.show();

    }
//    You can try using Thread.sleep(5000) like this:



}
