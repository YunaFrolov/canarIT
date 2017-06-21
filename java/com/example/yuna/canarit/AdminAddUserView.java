package com.example.yuna.canarit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * This class is the Admin Add User screen
 * It displays the needed text fields to fill in to create a new user.
 * It uses Volley to contact the php server and POST the new values.
 */
public class AdminAddUserView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    /**
     * When the screen is created,
     * Load all the XML data and set a button click listener
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user_view);
        final Context tThis = this;

        final TextView trUser = (TextView) findViewById(R.id.trUser);
        final TextView trPassword = (TextView) findViewById(R.id.trPassword);
        final TextView trUserType = (TextView) findViewById(R.id.trUserType);
        final TextView trFirstName = (TextView) findViewById(R.id.trFirstName);
        final TextView trLastName = (TextView) findViewById(R.id.trLastName);
        final TextView trPhone = (TextView) findViewById(R.id.trPhone);
        final TextView trEmail = (TextView) findViewById(R.id.trEmail);
        final TextView tvAdded = (TextView) findViewById(R.id.tvAdded);
        final ImageButton ibSend = (ImageButton) findViewById(R.id.ibSend);

        /**
         * When the ibSend button is clicked - check if all the fields are filled,
         * If so - POST the new values to the server
         */
        ibSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean flag = true;
                if( trUser.getText().toString().trim().equals("")){
                    trUser.setError( "This field is required!" );
                    flag  = false;}
                if( trPassword.getText().toString().trim().equals("")){
                    trPassword.setError( "This field is required!" );
                    flag  = false;}
                if( trUserType.getText().toString().trim().equals("")){
                    trUserType.setError( "This field is required!" );
                    flag  = false;}
                if( trFirstName.getText().toString().trim().equals("")){
                    trFirstName.setError( "This field is required!" );
                    flag  = false;}
                if( trLastName.getText().toString().trim().equals("")){
                    trLastName.setError( "This field is required!" );
                    flag  = false;}
                if( trPhone.getText().toString().trim().equals("")){
                    trPhone.setError( "This field is required!" );
                    flag  = false;}
                if( trEmail.getText().toString().trim().equals("")){
                    trEmail.setError( "This field is required!" );
                    flag  = false;}

                if (flag){
                    final String sUser = trUser.getText().toString();
                    final String sPassword = trPassword.getText().toString();
                    final String sUserType = trUserType.getText().toString();
                    final String sFirstName = trFirstName.getText().toString();
                    final String sLastName = trLastName.getText().toString();
                    final String sPhone = trPhone.getText().toString();
                    final String sEmail = trEmail.getText().toString();

                    try {
                        String URL = "http://34.204.144.157/api.php";
                        JSONArray jsonArray = new JSONArray();

                        jsonArray.put(null);
                        jsonArray.put(sUser);
                        jsonArray.put(sPassword);
                        jsonArray.put(sUserType);
                        jsonArray.put(sFirstName);
                        jsonArray.put(sLastName);
                        jsonArray.put(sPhone);
                        jsonArray.put(sEmail);

                        jsonBody.put("type", "admin_add_user");
                        jsonBody.put("values", jsonArray);

                        postRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                tvAdded.setText("New user added!");
                                Log.i("jVOLLEY", response.toString());
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("jVOLLEY", error.toString());
                            }
                        }) {
                        //////////////////////////////////////// Handle null response
                            @Override
                            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                                try {
                                    if (response.data.length == 0) {
                                        byte[] responseData = "{}".getBytes("UTF8");
                                        response = new NetworkResponse(response.statusCode, responseData, response.headers, response.notModified);
                                    }
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                return super.parseNetworkResponse(response);
                            }//////////////////////////////////
                        };

                        MySingleton.getInstance(tThis).addToRequestQueue(postRequest);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    tvAdded.setText("All fields are required.");
                }
            }
        });
    }
}
