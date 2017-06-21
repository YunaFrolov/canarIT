package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * This class is the Admin Area screen
 * It displays four buttons - one for each feature they can access.
 */
public class AdminAreaActivity extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data and set button click listeners
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_area);

        final TextView etUsername = (TextView) findViewById(R.id.etUsername);
        String userName = getIntent().getStringExtra("user_name");
        etUsername.setText(userName);

        final ImageButton ibAdminUsers = (ImageButton) findViewById(R.id.ibAdminUsers);
        final ImageButton ibAdminHardware = (ImageButton) findViewById(R.id.ibAdminHardware);
        final ImageButton ibAdminAdd = (ImageButton) findViewById(R.id.ibAdminAdd);
        final ImageButton ibAdminSettings = (ImageButton) findViewById(R.id.ibAdminSettings);

        /**
         * When the ibAdminSettings button is clicked -
         * send the user to the AdminSettingsView screen
         */
        ibAdminSettings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminAreaActivity.this, AdminSettingsView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibAdminAdd button is clicked -
         * send the user to the AdminAddView screen
         */
        ibAdminAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminAreaActivity.this, AdminAddView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibAdminHardware button is clicked -
         * send the user to the AdminHardwareView screen
         */
        ibAdminHardware.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminAreaActivity.this, AdminHardwareView.class);
                startActivity(i);
            }
        });
        /**
         * When the ibAdminUsers button is clicked -
         * send the user to the AdminUsersView screen
         */
        ibAdminUsers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminAreaActivity.this, AdminUsersView.class);
                startActivity(i);
            }
        });
    }
}
