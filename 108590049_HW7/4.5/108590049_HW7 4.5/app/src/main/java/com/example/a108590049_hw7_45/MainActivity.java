package com.example.a108590049_hw7_45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_dount(View view) {
        Intent intent = new Intent(this, dount.class);
        startActivity(intent);
    }

    public void click_icecream(View view) {
        Intent intent = new Intent(this, ice_cream.class);
        startActivity(intent);
    }
    public void click_froyo(View view) {
        Intent intent = new Intent(this, froyo.class);
        startActivity(intent);
    }
}