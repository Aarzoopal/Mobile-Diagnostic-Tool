package com.example.mobilediagnosticapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AvailableSensors extends Activity {

    private TableLayout mTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_available_sensors);
        mTableLayout = findViewById(R.id.tablelayout);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            boolean isActive = sensorManager.registerListener(null, sensor, SensorManager.SENSOR_DELAY_NORMAL);

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            // TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView nameTextView = new TextView(this);
            nameTextView.setText(sensor.getName());
            //  nameTextView.setLayoutParams(layoutParams);
            row.addView(nameTextView);

            TextView maxRangeTextView = new TextView(this);
            maxRangeTextView.setText(Float.toString(sensor.getMaximumRange()));
            row.addView(maxRangeTextView);


         /*   TextView statusTextView = new TextView(this);
            if (isActive) {
                statusTextView.setText("Active");
            } else {
                statusTextView.setText("Not Active");
            }
            row.addView(statusTextView);
         */
            mTableLayout.addView(row);
        }
    }
}
