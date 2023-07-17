package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

//import com.example.mobilediagnosticapplication.databinding.ActivitySoundTestingBinding;

//import org.checkerframework.checker.units.qual.A;

public class SoundTesting extends AppCompatActivity {

    private SeekBar seekBar;
    private AudioManager audioManager;

    Intent intent;
    ImageView play;
    ImageView stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_testing);
        seekBar=findViewById(R.id.seekBar);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

       play=findViewById(R.id.playimg);
       stop=findViewById(R.id.stopimg);
       intent=new Intent(this,MyService.class);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //but.setText("Song is Playing");
                startService(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //but.setText("Song is Playing");
                stopService(intent);
            }
        });


    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        stopService(intent);
        super.onPause();
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_sound_testing, menu);
        return true;
    }
*/
    public void upButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
       // Toast.makeText(this, "Volume up", Toast.LENGTH_SHORT).show();

    }
    public void downButton(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        //Toast.makeText(this, "Volume Down", Toast.LENGTH_SHORT).show();

    }


}