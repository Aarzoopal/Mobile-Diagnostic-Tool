package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SystemInfo extends AppCompatActivity {

    TextView System_Info,device,model,id;
    //Button SystemInfo;
    long bytesAvailable, megAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        device=findViewById(R.id.device);
        String d=Build.MANUFACTURER;
        device.setText(d);
        model=findViewById(R.id.model);
        String m=Build.MODEL;
        model.setText(m);
        id=findViewById(R.id.id);
        String i=Build.ID;
        id.setText(i);
      //  initView();
        StatFs statFs = new StatFs(Environment.getDownloadCacheDirectory().getPath());
        bytesAvailable = statFs.getBlockCountLong()  * statFs.getAvailableBlocksLong();

        megAvailable = bytesAvailable / (1024 * 1024);

    }




}




