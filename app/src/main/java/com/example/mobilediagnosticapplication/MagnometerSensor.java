package com.example.mobilediagnosticapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MagnometerSensor extends AppCompatActivity implements SensorEventListener {

    private TextView mTemperatureTextView;
    private SensorManager mSensorManager;
    private Sensor mTemperatureSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magno_meter_sensor);

        // Initialize TextView
        mTemperatureTextView = findViewById(R.id.temperatureTextView);

        // Get sensor service and sensor
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mTemperatureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register listener to temperature sensor
        mSensorManager.registerListener(this, mTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister listener when the activity is paused
        mSensorManager.unregisterListener(this);
    }

   // @SuppressLint("StringFormatInvalid")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            // Get the x, y, and z values of the gravity sensor
            // Get temperature value from sensor event
            float temperatureValue = event.values[0];
            // Update TextView with temperature value
            mTemperatureTextView.setText("Temperature");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing
    }
}