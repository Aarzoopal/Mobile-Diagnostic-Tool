package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AccelerometerSensor extends AppCompatActivity  {
    private TextView accelerometerTextView;
    private TextView accelerometerValueTextView;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float[] gravity = new float[3];
    private float[] geomagnetic = new float[3];
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor);
        accelerometerTextView = findViewById(R.id.accelerometerTextView);
        imageView=findViewById(R.id.imageView);
        accelerometerValueTextView = findViewById(R.id.accelerometerValueTextView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(sensorEventListener, magnetometer, SensorManager.SENSOR_DELAY_UI);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        imageView.startAnimation(animation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(sensorEventListener);
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            switch (event.sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    gravity = event.values.clone();
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    geomagnetic = event.values.clone();
                    break;
            }

            float[] rotationMatrix = new float[9];
            boolean rotationOK = SensorManager.getRotationMatrix(rotationMatrix, null, gravity, geomagnetic);

            if (rotationOK) {
                float[] orientation = new float[3];
                SensorManager.getOrientation(rotationMatrix, orientation);

                float pitch = orientation[1];
                float roll = orientation[2];

                if (Math.abs(roll) < Math.PI / 4) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else if (Math.abs(roll) > 3 * Math.PI / 4) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                } else if (roll > 0) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);

                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                String values = String.format("%.2f, %.2f, %.2f", x, y, z);
                accelerometerValueTextView.setText(values);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // not needed for this example
        }
    };
}