package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NetworkInfo extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_info);
        textView=findViewById(R.id.textView12);
        imageView=findViewById(R.id.network);
        if(isConnected())
        {
            textView.setText("You are connected to network");
            imageView.setImageResource(R.drawable.signal);
        }
        else
        {
            textView.setText("You are not connected to network");
            imageView.setImageResource(R.drawable.nosignal);
        }
    }
    boolean isConnected()
    {
        ConnectivityManager cm= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni!=null)
        {
            if(ni.isConnected()) return true;
        }
        return false;
    }
}