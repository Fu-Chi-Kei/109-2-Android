package com.example.HelloConstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.HelloConstraint.R.color.gray;
import static com.example.HelloConstraint.R.color.green;
import static com.example.HelloConstraint.R.color.pink;
import static com.example.HelloConstraint.R.color.red;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView myShowCount;
    private Button Btn_Zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_Zero = (Button) findViewById(R.id.button_zero);
        myShowCount = (TextView) findViewById(R.id.textView);

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Zero(View view) {
        mCount = 0;
        if (myShowCount != null) {
            myShowCount.setText(Integer.toString(mCount));
            Btn_Zero.setBackgroundColor(getResources().getColor(gray));
        }
    }

    public void countUp(View view) {
        mCount++;
        if (myShowCount != null) {
            myShowCount.setText(Integer.toString(mCount));
            Btn_Zero.setBackgroundColor(getResources().getColor(pink));

            if (mCount%2 == 0) {
                view.setBackgroundColor(getResources().getColor(red));
            } else {
                view.setBackgroundColor(getResources().getColor(green));
            }
        }
    }

}