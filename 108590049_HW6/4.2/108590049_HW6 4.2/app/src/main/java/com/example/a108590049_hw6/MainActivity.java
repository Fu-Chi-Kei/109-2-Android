package com.example.a108590049_hw6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = (CheckBox) findViewById(R.id.CheckBox1);
        checkBox2 = (CheckBox) findViewById(R.id.CheckBox2);
        checkBox3 = (CheckBox) findViewById(R.id.CheckBox3);
        checkBox4 = (CheckBox) findViewById(R.id.CheckBox4);
        checkBox5 = (CheckBox) findViewById(R.id.CheckBox5);

        if (savedInstanceState != null) {
            checkBox1.setChecked(savedInstanceState.getBoolean("checkBox1"));
            checkBox2.setChecked(savedInstanceState.getBoolean("checkBox2"));
            checkBox3.setChecked(savedInstanceState.getBoolean("checkBox3"));
            checkBox4.setChecked(savedInstanceState.getBoolean("checkBox4"));
            checkBox5.setChecked(savedInstanceState.getBoolean("checkBox5"));
        }
    }

    public void on_submit(View view) {
        String textview = "Toppings: ";
        if (checkBox1.isChecked())
            textview += checkBox1.getText().toString() + " ";
        if (checkBox2.isChecked())
            textview += checkBox2.getText().toString() + " ";
        if (checkBox3.isChecked())
            textview += checkBox3.getText().toString() + " ";
        if (checkBox4.isChecked())
            textview += checkBox4.getText().toString() + " ";
        if (checkBox5.isChecked())
            textview += checkBox5.getText().toString() + " ";

        Toast toast = Toast.makeText(this, textview, Toast.LENGTH_LONG);
        toast.show();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("checkBox1", checkBox1.isChecked());
        outState.putBoolean("checkBox2", checkBox2.isChecked());
        outState.putBoolean("checkBox3", checkBox3.isChecked());
        outState.putBoolean("checkBox4", checkBox4.isChecked());
        outState.putBoolean("checkBox5", checkBox5.isChecked());
    }
}