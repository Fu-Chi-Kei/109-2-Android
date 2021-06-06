package com.example.android.droidcafeinput;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
/**
 * This activity handles radio buttons for choosing
 * a delivery method for an order, and EditText input controls.
 */
public class OrderActivity extends AppCompatActivity {
    /**
     * Sets the content view to activity_order, and gets the intent and its
     * data.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

        RadioButton sameday_rb = findViewById(R.id.sameday);
        RadioButton nextday_rb = findViewById(R.id.nextday);
        RadioButton pickup_rb = findViewById(R.id.pickup);

        SharedPreferences sharedPref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String deliveryMethod = sharedPref
                .getString("delivery_list", "Same day messenger service");
        switch (deliveryMethod) {
            case "Same day messenger service":
                sameday_rb.setChecked(true);
                break;
            case "Next day ground delivery":
                nextday_rb.setChecked(true);
                break;
            case "Pick up":
                pickup_rb.setChecked(true);
                break;
        }
    }

    public void onRadioButtonClicked(@NonNull View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            // Do nothing.
            default: break;
        }
    }
    /**
     * Displays the actual message in a toast message.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
