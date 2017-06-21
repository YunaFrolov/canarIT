package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * This class is the Responsible Area screen
 * It displays four buttons - one for each feature they can access.
 */
public class ResponsibleAreaActivity extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data and set button click listeners
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsible_area);

        final TextView etUsername = (TextView) findViewById(R.id.etUsername);
        String userName = getIntent().getStringExtra("user_name");
        etUsername.setText(userName);

        final ImageButton ibRespLocation = (ImageButton) findViewById(R.id.ibRespLocation);
        final ImageButton ibRespNotifications = (ImageButton) findViewById(R.id.ibRespNotifications);
        final ImageButton ibRespHighAlert = (ImageButton) findViewById(R.id.ibRespHighAlert);
        final ImageButton ibRespSettings = (ImageButton) findViewById(R.id.ibRespSettings);

        /**
         * When the ibRespLocation button is clicked -
         * send the user to the RespLocationView screen
         */
        ibRespLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponsibleAreaActivity.this, RespLocationView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibRespNotifications button is clicked -
         * send the user to the RespNotificationView screen
         */
        ibRespNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponsibleAreaActivity.this, RespNotificationView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibRespHighAlert button is clicked -
         * send the user to the RespHighAlertView screen
         */
        ibRespHighAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponsibleAreaActivity.this, RespHighAlertView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibRespSettings button is clicked -
         * send the user to the RespSettingsView screen
         */
        ibRespSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResponsibleAreaActivity.this, RespSettingsView.class);
                startActivity(i);
            }
        });
    }
}
