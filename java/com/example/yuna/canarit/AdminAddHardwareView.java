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
 * This class is the Admin Add Hardware screen
 * It displays the needed text fields to fill in to create a new unit and a new location.
 * It uses Volley to contact the php server and POST the new values.
 */
public class AdminAddHardwareView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    /**
     * When the screen is created,
     * Load all the XML data and set a button click listener
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_hardware_view);
        final Context tThis = this;

        // declaration of all text fields and buttons from XML file
        final TextView etUnitID = (TextView) findViewById(R.id.etUnitID);
        final TextView etSensorTypeID = (TextView) findViewById(R.id.etSensorTypeID);
        final TextView trFamilyID = (TextView) findViewById(R.id.trFamilyID);
        final TextView trFamilyName = (TextView) findViewById(R.id.trFamilyName);
        final TextView trNumOfPeople = (TextView) findViewById(R.id.trNumOfPeople);
        final TextView trAddress = (TextView) findViewById(R.id.trAddress);
        final TextView trHouse = (TextView) findViewById(R.id.trHouse);
        final TextView trEndUserId = (TextView) findViewById(R.id.trEndUserId);
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
                if( etUnitID.getText().toString().trim().equals("")){
                    etUnitID.setError( "This field is required!" );
                    flag  = false;}
                if( etSensorTypeID.getText().toString().trim().equals("")){
                    etSensorTypeID.setError( "This field is required!" );
                    flag  = false;}
                if( trFamilyID.getText().toString().trim().equals("")){
                    trFamilyID.setError( "This field is required!" );
                    flag  = false;}
                if( trHouse.getText().toString().trim().equals("")){
                    trHouse.setError( "This field is required!" );
                    flag  = false;}
                if( trFamilyName.getText().toString().trim().equals("")){
                    trFamilyName.setError( "This field is required!" );
                    flag  = false;}
                if( trNumOfPeople.getText().toString().trim().equals("")){
                    trNumOfPeople.setError( "This field is required!" );
                    flag  = false;}
                if( trEndUserId.getText().toString().trim().equals("")){
                    trEndUserId.setError( "This field is required!" );
                    flag  = false;}
                if( trAddress.getText().toString().trim().equals("")){
                    trAddress.setError( "This field is required!" );
                    flag  = false;}

                if (flag){
                    final String sUnitID = etUnitID.getText().toString();
                    final String sSensorTypeID = etSensorTypeID.getText().toString();
                    final String sAddress = trAddress.getText().toString();
                    final String sHouse = trHouse.getText().toString();
                    final String sUnit = etUnitID.getText().toString();
                    final String sFamilyID = trFamilyID.getText().toString();
                    final String sNumOfPeople = trNumOfPeople.getText().toString();
                    final String sEndUserId = trEndUserId.getText().toString();
                    final String sFamilyName = trFamilyName.getText().toString();

                    // try to POST to admin_create_unit
                    try {
                        String URL = "http://34.204.144.157/api.php";
                        JSONArray jsonArray = new JSONArray();

                        jsonArray.put(sUnitID);
                        jsonArray.put(sSensorTypeID);

                        jsonBody.put("type", "admin_create_unit");
                        jsonBody.put("values", jsonArray);

                        postRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                tvAdded.setText("Unit added.");
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

                    // try to POST to admin_add_house
                    try {
                        String URL = "http://34.204.144.157/api.php";
                        JSONArray jsonArray = new JSONArray();

                        jsonArray.put(sFamilyID);
                        jsonArray.put(sFamilyName);
                        jsonArray.put(sNumOfPeople);
                        jsonArray.put(sAddress);
                        jsonArray.put(sHouse);
                        jsonArray.put(sEndUserId);
                        jsonArray.put(sUnit);

                        jsonBody.put("type", "admin_add_house");
                        jsonBody.put("values", jsonArray);

                        postRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                tvAdded.setText("Hardware and Unit added.");
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
