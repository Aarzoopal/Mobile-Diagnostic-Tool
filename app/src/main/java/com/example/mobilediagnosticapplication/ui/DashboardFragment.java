package com.example.mobilediagnosticapplication.ui;

import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobilediagnosticapplication.BatteryInfo;
import com.example.mobilediagnosticapplication.CallLogs;
import com.example.mobilediagnosticapplication.CameraSound;
import com.example.mobilediagnosticapplication.DisplayTesting;
import com.example.mobilediagnosticapplication.MainActivity;
import com.example.mobilediagnosticapplication.NetworkInfo;
import com.example.mobilediagnosticapplication.R;
import com.example.mobilediagnosticapplication.Sensors;
import com.example.mobilediagnosticapplication.SoftwareHardware;
import com.example.mobilediagnosticapplication.SoundTesting;
import com.example.mobilediagnosticapplication.SystemInfo;

public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;
    ImageView batteryinfo;
    ImageView sensor;
    ImageView softhard;
    ImageView system;
    ImageView network;
    ImageView call;
    ImageView camsound;
    ImageView display;
    ImageView sound;

    Context context;
    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        context=view.getContext();
        batteryinfo=view.findViewById(R.id.batteryinfo);
        system=view.findViewById(R.id.systeminfo);
        sensor=view.findViewById(R.id.sensor);
        camsound=view.findViewById(R.id.camsound);
        call=view.findViewById(R.id.calllogs);
        network=view.findViewById(R.id.networkinfo);
        softhard=view.findViewById(R.id.softhard);
        display=view.findViewById(R.id.displaytesting);
        sound=view.findViewById(R.id.soundtesting);
        batteryinfo.setOnClickListener(new View.OnClickListener() {
           // Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iBattery=new Intent(context, BatteryInfo.class);
                startActivity(iBattery);

            }
        });
        system.setOnClickListener(new View.OnClickListener() {
           // Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iSystem=new Intent(context, SystemInfo.class);
                startActivity(iSystem);

            }
        });
        softhard.setOnClickListener(new View.OnClickListener() {
            //Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iSoft=new Intent(context, SoftwareHardware.class);
                startActivity(iSoft);

            }
        });
        sensor.setOnClickListener(new View.OnClickListener() {
            //Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iSensor=new Intent(context, Sensors.class);
                startActivity(iSensor);

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
          //  Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iCall=new Intent(context, CallLogs.class);
                startActivity(iCall);

            }
        });
        camsound.setOnClickListener(new View.OnClickListener() {
            //Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iCamera=new Intent(context, CameraSound.class);
                startActivity(iCamera);

            }
        });
        network.setOnClickListener(new View.OnClickListener() {
            //Activity activity=getActivity();
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, "open", Toast.LENGTH_SHORT).show();
                Intent iNetwork=new Intent(context, NetworkInfo.class);
                startActivity(iNetwork);

            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDisplay=new Intent(context, DisplayTesting.class);
                startActivity(iDisplay);
            }
        });
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSound=new Intent(context, SoundTesting.class);
                startActivity(iSound);
            }
        });




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        // TODO: Use the ViewModel
    }

}