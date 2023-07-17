package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BatteryInfo extends AppCompatActivity {

    TextView infor;
    TextView batterylevel;
    TextView batteryStatus;
    TextView warning;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_info);

        infor=(TextView) findViewById(R.id.infor);
        batterylevel=(TextView) findViewById(R.id.batterlevel);
        batteryStatus=findViewById(R.id.btstatus);
        warning=findViewById(R.id.warning);
        registerReceiver(this.BatteryInfoReciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

    }
    BroadcastReceiver BatteryInfoReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            int plugged=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
            int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
            boolean present=intent.getExtras() .getBoolean(BatteryManager.EXTRA_PRESENT);
            String technology=intent.getExtras() .getString(BatteryManager.EXTRA_TECHNOLOGY);
            int temperature=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
            int voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);


            batterylevel.setText(level +"%");
            if(status==1)
            {
                batteryStatus.setText("BATTERY_STATUS_UNKNOWN");
            }
            else if(status == 2)
            {
               if(plugged == 1)
               {
                   batteryStatus.setText(" The device is currently charging from AC power " );
               }
               else if(plugged ==2)
               {

                   batteryStatus.setText(" The device is currently charging from USB power " );
               }
               else
               {
                   batteryStatus.setText(" The device is not currently charging " );
               }
            }
            else if(status == 3)
            {
                batteryStatus.setText("BATTERY_STATUS_DISCHARGING");
            }
            else if(status == 4)
            {
                batteryStatus.setText("BATTERY_STATUS_NOT_CHARGING");
            }
            else
            {
                batteryStatus.setText("BATTERY_STATUS_FULL");
            }
            infor.setText(
                   // "Level:"+level+"\n"+
                           // "Plugged:"+plugged+"\n"+
                           // "status:"+status+"\n"+  "Present:"+present+"\n"+
                            "Technology used in battery is: "+technology+"\n\n"+
                            "Temperature of your device is: "+(temperature /10 )+"\n\n"+
                            "Voltage of your device is: "+voltage+"\n");
            if((temperature/10)>=35)
            {
                warning.setText("Your phone temperature is above the normal temperature");
            }
            else if(voltage<=3000)
            {
                warning.setText("voltage of your phone is below than normal voltage");
            }
            else
            {
                warning.setText("Your battery is in optimal condition");
            }


            BroadcastReceiver broadcastReceiverTemperature = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    Integer integerTemperatureLevel = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);
                    infor.setText(integerTemperatureLevel.toString());
                    if (integerTemperatureLevel > 20) {
                        Ringtone ringtone = null;
                        ringtone.play();
                    }

                }


            };




        }

    };

}



