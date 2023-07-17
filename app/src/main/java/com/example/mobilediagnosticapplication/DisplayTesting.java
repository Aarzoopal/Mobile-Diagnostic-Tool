package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class DisplayTesting extends AppCompatActivity implements View.OnTouchListener{

    private View mColorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_testing);

        mColorView = findViewById(R.id.color_view);
        mColorView.setOnTouchListener((View.OnTouchListener) this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int expectedColor = getResources().getColor(R.color.teal_700);
        int actualColor = getPixelColor(x, y);
        if (actualColor != expectedColor) {
            // Dead pixel detected
            Toast.makeText(this, "Dead pixel detected at (" + x + "," + y + ")", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, " no Dead pixel detected at (" + x + "," + y + ")", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private int getPixelColor(int x, int y) {
        Bitmap bitmap = Bitmap.createBitmap(mColorView.getWidth(), mColorView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        mColorView.draw(canvas);
        return bitmap.getPixel(x, y);
    }
}