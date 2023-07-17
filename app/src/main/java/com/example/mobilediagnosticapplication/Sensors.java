package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sensors extends AppCompatActivity {
    Button acc;
    Button prox;
    Button light;
    Button avail;
    Button grav;
    Button magno;
    Button orient;
    Button rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        acc=findViewById(R.id.accelerometer);
        prox=findViewById(R.id.proximity);
        light=findViewById(R.id.light);
        avail=findViewById(R.id.avail_sensor);
        grav=findViewById(R.id.gravity);
        magno=findViewById(R.id.magno);
        orient=findViewById(R.id.orientation);
        rotate=findViewById(R.id.rotation);
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iacc=new Intent(getApplicationContext(), AccelerometerSensor.class);
                startActivity(iacc);
            }
        });

        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iprox=new Intent(getApplicationContext(), ProximitySensor.class);
                startActivity(iprox);
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilight=new Intent(getApplicationContext(), LightSensor.class);
                startActivity(ilight);
            }
        });
        avail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iavail=new Intent(getApplicationContext(), AvailableSensors.class);
                startActivity(iavail);
            }
        });
        grav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igrav=new Intent(getApplicationContext(), GravitySensor.class);
                startActivity(igrav);
            }
        });
        magno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imag=new Intent(getApplicationContext(), MagnometerSensor.class);
                startActivity(imag);
            }
        });
        orient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iori=new Intent(getApplicationContext(), OrientationSensor.class);
                startActivity(iori);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irot=new Intent(getApplicationContext(), RotationVector.class);
                startActivity(irot);
            }
        });
    }
}