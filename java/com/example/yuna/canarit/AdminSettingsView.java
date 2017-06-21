package com.example.yuna.canarit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * This class is the Admin Settings screen
 * It displays buttons that represent if the user wants mail alerts or not
 */
public class AdminSettingsView extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_view);

        final TextView tvAdminSettingsText = (TextView) findViewById(R.id.tvAdminSettingsText);
        tvAdminSettingsText.setText("I want to receive alerts via mail");

        final ImageButton ibYes = (ImageButton) findViewById(R.id.ibYes);
        final ImageButton ibNo = (ImageButton) findViewById(R.id.ibNo);
    }
}
