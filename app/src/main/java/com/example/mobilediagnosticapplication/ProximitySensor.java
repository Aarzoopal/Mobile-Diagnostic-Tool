package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ProximitySensor extends AppCompatActivity {

    private static final String TAG = "ProximitySensor";
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private PowerManager.WakeLock wakeLock;
    private TextView distanceTextView;


    ImageView imageView;
    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        distanceTextView = findViewById(R.id.distance_text_view);
        imageView=findViewById(R.id.ball);


        // Initialize the sensor manager and proximity sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the proximity sensor listener
        sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the proximity sensor listener
        sensorManager.unregisterListener(proximitySensorListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the wake lock

    }

    private final SensorEventListener proximitySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float distance = event.values[0];
            Log.d(TAG, "Proximity sensor value: " + distance);
            distanceTextView.setText("Distance: " + distance);
            if(distance==0.0)
            {

                imageView.animate().translationX(-400);
            }
            else
            {
                //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                // imageView.startAnimation(animation);
                imageView.animate().translationX(400);
                imageView.clearAnimation();
            }

            // Handle the distance value as per your requirement

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Do nothing
        }
    };
}

