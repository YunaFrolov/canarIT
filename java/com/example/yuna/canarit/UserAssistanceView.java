package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserAssistanceView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_assistance_view);

        // get the user that is currently connected
        final String userName = getIntent().getStringExtra("user_name");

        // declare buttons
        final Button bAddHardware = (Button) findViewById(R.id.bAddHardware);
        final Button bRequestTech = (Button) findViewById(R.id.bRequestTech);
        final Button bCancel = (Button) findViewById(R.id.bCancel);

        // Send and email on button pressed
        //Button add hardware
        bAddHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"canarit.gfd@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, userName+ " requests to add Hardware");
                i.putExtra(Intent.EXTRA_TEXT   , "The user "+userName+" would like to order new Hardware.");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(UserAssistanceView.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Button request technician
        bRequestTech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"canarit.gfd@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, userName+ " requests a technician");
                i.putExtra(Intent.EXTRA_TEXT   , "The user "+userName+" would like to call a technician.");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(UserAssistanceView.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Button cancel
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"canarit.gfd@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, userName+ " requests to cancel the service.");
                i.putExtra(Intent.EXTRA_TEXT   , "The user "+userName+" would like to cancel the service.");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(UserAssistanceView.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
