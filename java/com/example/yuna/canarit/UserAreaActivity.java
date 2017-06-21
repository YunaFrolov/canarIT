package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * This class is the User Area screen
 * It displays four buttons - one for each feature they can access.
 */
public class UserAreaActivity extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data and set button click listeners
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView etUsername = (TextView) findViewById(R.id.etUsername);
        final String userName = getIntent().getStringExtra("user_name");
        etUsername.setText(userName);

        final ImageButton ibUserChangeInfo = (ImageButton) findViewById(R.id.ibUserChangeInfo);
        final ImageButton ibUserAssistance = (ImageButton) findViewById(R.id.ibUserAssistance);
        final ImageButton ibUserAlerts = (ImageButton) findViewById(R.id.ibUserAlerts);
        final ImageButton ibUserSettings = (ImageButton) findViewById(R.id.ibUserSettings);
        /**
         * When the ibUserChangeInfo button is clicked -
         * send the user to the UserChangeInfoView screen
         */
        ibUserChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserAreaActivity.this, UserChangeInfoView.class);
                i.putExtra("user_name", userName);
                startActivity(i);
            }
        });
        /**
         * When the ibUserAssistance button is clicked -
         * send the user to the UserAssistanceView screen
         */
        ibUserAssistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserAreaActivity.this, UserAssistanceView.class);
                i.putExtra("user_name", userName);
                startActivity(i);
            }
        });
        /**
         * When the ibUserAlerts button is clicked -
         * send the user to the UserAlertsView screen
         */
        ibUserAlerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserAreaActivity.this, UserAlertsView.class);
                i.putExtra("user_name", userName);
                startActivity(i);
            }
        });
        /**
         * When the ibUserSettings button is clicked -
         * send the user to the UserSettingsView screen
         */
        ibUserSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserAreaActivity.this, UserSettingsView.class);
                startActivity(i);
            }
        });
    }
}
