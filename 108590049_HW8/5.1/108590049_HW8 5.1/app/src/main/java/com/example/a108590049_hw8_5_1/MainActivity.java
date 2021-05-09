package com.example.a108590049_hw8_5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageBattery;
    private int imageLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageBattery = findViewById(R.id.imageView3);
    }

    public void increase_lv(View view) {
        if (imageLevel < 6) {
            imageLevel ++;
            imageBattery.setImageLevel(imageLevel);
        }
    }

    public void decrease_lv(View view) {
        if (imageLevel > 0) {
            imageLevel --;
            imageBattery.setImageLevel(imageLevel);
        }
    }
}