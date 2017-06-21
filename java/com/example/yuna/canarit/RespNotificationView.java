package com.example.yuna.canarit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * This class is the Admin Hardware screen
 * It displays a table with the data of the existing hardware
 * And you can mute or unmute individual sensors
 */
public class RespNotificationView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_notification_view);
        final Context tThis = this;

        final TextView tvRespNotification = (TextView) findViewById(R.id.tvRespNotification);
        tvRespNotification.setText("Insert a change to Silence units");

        final ImageButton ibNotification = (ImageButton) findViewById(R.id.ibNotification);
        final TextView tvAdded = (TextView) findViewById(R.id.tvAdded);

        final TextView trFamily0 = (TextView) findViewById(R.id.trFamily0);
        final TextView trFamily1 = (TextView) findViewById(R.id.trFamily1);
        final TextView trFamily2 = (TextView) findViewById(R.id.trFamily2);
        final TextView trFamily3 = (TextView) findViewById(R.id.trFamily3);
        final TextView trFamily4 = (TextView) findViewById(R.id.trFamily4);
        final TextView trFamily5 = (TextView) findViewById(R.id.trFamily5);
        final TextView trFamily6 = (TextView) findViewById(R.id.trFamily6);
        final TextView trFamily7 = (TextView) findViewById(R.id.trFamily7);
        final TextView trFamily8 = (TextView) findViewById(R.id.trFamily8);
        final TextView trFamily9 = (TextView) findViewById(R.id.trFamily9);

        final TextView trStreet0 = (TextView) findViewById(R.id.trStreet0);
        final TextView trStreet1 = (TextView) findViewById(R.id.trStreet1);
        final TextView trStreet2 = (TextView) findViewById(R.id.trStreet2);
        final TextView trStreet3 = (TextView) findViewById(R.id.trStreet3);
        final TextView trStreet4 = (TextView) findViewById(R.id.trStreet4);
        final TextView trStreet5 = (TextView) findViewById(R.id.trStreet5);
        final TextView trStreet6 = (TextView) findViewById(R.id.trStreet6);
        final TextView trStreet7 = (TextView) findViewById(R.id.trStreet7);
        final TextView trStreet8 = (TextView) findViewById(R.id.trStreet8);
        final TextView trStreet9 = (TextView) findViewById(R.id.trStreet9);

        final TextView trHouse0 = (TextView) findViewById(R.id.trHouse0);
        final TextView trHouse1 = (TextView) findViewById(R.id.trHouse1);
        final TextView trHouse2 = (TextView) findViewById(R.id.trHouse2);
        final TextView trHouse3 = (TextView) findViewById(R.id.trHouse3);
        final TextView trHouse4 = (TextView) findViewById(R.id.trHouse4);
        final TextView trHouse5 = (TextView) findViewById(R.id.trHouse5);
        final TextView trHouse6 = (TextView) findViewById(R.id.trHouse6);
        final TextView trHouse7 = (TextView) findViewById(R.id.trHouse7);
        final TextView trHouse8 = (TextView) findViewById(R.id.trHouse8);
        final TextView trHouse9 = (TextView) findViewById(R.id.trHouse9);

        final TextView trUnit0 = (TextView) findViewById(R.id.trUnit0);
        final TextView trUnit1 = (TextView) findViewById(R.id.trUnit1);
        final TextView trUnit2 = (TextView) findViewById(R.id.trUnit2);
        final TextView trUnit3 = (TextView) findViewById(R.id.trUnit3);
        final TextView trUnit4 = (TextView) findViewById(R.id.trUnit4);
        final TextView trUnit5 = (TextView) findViewById(R.id.trUnit5);
        final TextView trUnit6 = (TextView) findViewById(R.id.trUnit6);
        final TextView trUnit7 = (TextView) findViewById(R.id.trUnit7);
        final TextView trUnit8 = (TextView) findViewById(R.id.trUnit8);
        final TextView trUnit9 = (TextView) findViewById(R.id.trUnit9);

        final TextView trSensorType0 = (TextView) findViewById(R.id.trSensorType0);
        final TextView trSensorType1 = (TextView) findViewById(R.id.trSensorType1);
        final TextView trSensorType2 = (TextView) findViewById(R.id.trSensorType2);
        final TextView trSensorType3 = (TextView) findViewById(R.id.trSensorType3);
        final TextView trSensorType4 = (TextView) findViewById(R.id.trSensorType4);
        final TextView trSensorType5 = (TextView) findViewById(R.id.trSensorType5);
        final TextView trSensorType6 = (TextView) findViewById(R.id.trSensorType6);
        final TextView trSensorType7 = (TextView) findViewById(R.id.trSensorType7);
        final TextView trSensorType8 = (TextView) findViewById(R.id.trSensorType8);
        final TextView trSensorType9 = (TextView) findViewById(R.id.trSensorType9);

        final EditText trIsSilenced0 = (EditText) findViewById(R.id.trIsSilenced0);
        final EditText trIsSilenced1 = (EditText) findViewById(R.id.trIsSilenced1);
        final EditText trIsSilenced2 = (EditText) findViewById(R.id.trIsSilenced2);
        final EditText trIsSilenced3 = (EditText) findViewById(R.id.trIsSilenced3);
        final EditText trIsSilenced4 = (EditText) findViewById(R.id.trIsSilenced4);
        final EditText trIsSilenced5 = (EditText) findViewById(R.id.trIsSilenced5);
        final EditText trIsSilenced6 = (EditText) findViewById(R.id.trIsSilenced6);
        final EditText trIsSilenced7 = (EditText) findViewById(R.id.trIsSilenced7);
        final EditText trIsSilenced8 = (EditText) findViewById(R.id.trIsSilenced8);
        final EditText trIsSilenced9 = (EditText) findViewById(R.id.trIsSilenced9);

        final TableRow trTableRow0 = (TableRow) findViewById(R.id.trTableRow0);
        final TableRow trTableRow1 = (TableRow) findViewById(R.id.trTableRow1);
        final TableRow trTableRow2 = (TableRow) findViewById(R.id.trTableRow2);
        final TableRow trTableRow3 = (TableRow) findViewById(R.id.trTableRow3);
        final TableRow trTableRow4 = (TableRow) findViewById(R.id.trTableRow4);
        final TableRow trTableRow5 = (TableRow) findViewById(R.id.trTableRow5);
        final TableRow trTableRow6 = (TableRow) findViewById(R.id.trTableRow6);
        final TableRow trTableRow7 = (TableRow) findViewById(R.id.trTableRow7);
        final TableRow trTableRow8 = (TableRow) findViewById(R.id.trTableRow8);
        final TableRow trTableRow9 = (TableRow) findViewById(R.id.trTableRow9);

        // save the names of the declarations to arrays for future use
        final TableRow TableRowArray[] = {trTableRow0, trTableRow1, trTableRow2, trTableRow3, trTableRow4, trTableRow5, trTableRow6, trTableRow7, trTableRow8, trTableRow9};
        final TextView StreetArray[] = {trStreet0, trStreet1, trStreet2, trStreet3, trStreet4, trStreet5, trStreet6, trStreet7, trStreet8, trStreet9};
        final TextView HouseArray[] = {trHouse0, trHouse1, trHouse2, trHouse3, trHouse4, trHouse5, trHouse6, trHouse7, trHouse8, trHouse9};
        final TextView UnitArray[] = {trUnit0, trUnit1, trUnit2, trUnit3, trUnit4, trUnit5, trUnit6, trUnit7, trUnit8, trUnit9};
        final TextView SensorTypeArray[] = {trSensorType0, trSensorType1, trSensorType2, trSensorType3, trSensorType4, trSensorType5, trSensorType6, trSensorType7, trSensorType8, trSensorType9};
        final TextView FamilyArray[] = {trFamily0, trFamily1, trFamily2, trFamily3, trFamily4, trFamily5, trFamily6, trFamily7, trFamily8, trFamily9};
        final EditText SilenceArray[] = {trIsSilenced0, trIsSilenced1, trIsSilenced2, trIsSilenced3, trIsSilenced4, trIsSilenced5, trIsSilenced6, trIsSilenced7, trIsSilenced8, trIsSilenced9};


        String getsensorsurl ="http://34.204.144.157/api.php?type=local_fd_get_silenced";
        // Formulate the request and handle the response.
        JsonArrayRequest getSensorsArrayRequest = new JsonArrayRequest(Request.Method.GET, getsensorsurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String family_id = jresponse.getString("family_id");
                                String street = jresponse.getString("street");
                                String house_number = jresponse.getString("house_number");
                                String unit_id = jresponse.getString("unit_id");
                                String sensor_type_id = jresponse.getString("sensor_type_id");
                                String is_silenced = jresponse.getString("is_silenced");

                                StreetArray[i].setText(street);
                                HouseArray[i].setText(house_number);
                                UnitArray[i].setText(unit_id);
                                SensorTypeArray[i].setText(sensor_type_id);
                                FamilyArray[i].setText(family_id);
                                SilenceArray[i].setText(is_silenced);

                            }
                            for(int i = 0; i < 10; i++) {
                                if(FamilyArray[i].getText().equals(""))
                                    TableRowArray[i].setVisibility(View.GONE);
                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Log.d("getSilenced", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading local_fd_get_silenced", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(getSensorsArrayRequest);
        ///////

        ibNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean flag = true;
                for(int i = 0; i < 10; i++) {
                    if(SilenceArray[i].getText().equals("")){
                        SilenceArray[i].setError( "This field is required!" );
                        flag  = false;}
                }
                if (flag){
                    try {
                        for(int i = 0; i < 10; i++) {
                            String URL = "http://34.204.144.157/api.php";
                            JSONArray jsonArray = new JSONArray();

                            jsonArray.put(SilenceArray[i].getText().toString());
                            jsonArray.put(UnitArray[i].getText().toString());
                            jsonArray.put(SensorTypeArray[i].getText().toString());
                            Log.i("jVOLLEY", jsonArray.toString());

                            jsonBody.put("type", "local_fd_silnence");
                            jsonBody.put("values", jsonArray);

                            postRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    tvAdded.setText("Changes have been made.");
                                    Log.i("jVOLLEY", response.toString());
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("jVOLLEY", error.toString());
                                }
                            }) {
                                //////////////////////////////////////// handle null response
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
                        }
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
