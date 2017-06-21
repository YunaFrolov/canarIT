package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class is the Resp Settings screen
 * It displays a table with the data of the last ten sensor readings
 */
public class RespSettingsView extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data and GET the data from the database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_settings_view);

        final TextView tvLastTen = (TextView) findViewById(R.id.tvLastTen);
        tvLastTen.setText("Here you can see the last ten readings");

        // declaration of all text fields and buttons from XML file
        final TextView trID0 = (TextView) findViewById(R.id.trID0);
        final TextView trID1 = (TextView) findViewById(R.id.trID1);
        final TextView trID2 = (TextView) findViewById(R.id.trID2);
        final TextView trID3 = (TextView) findViewById(R.id.trID3);
        final TextView trID4 = (TextView) findViewById(R.id.trID4);
        final TextView trID5 = (TextView) findViewById(R.id.trID5);
        final TextView trID6 = (TextView) findViewById(R.id.trID6);
        final TextView trID7 = (TextView) findViewById(R.id.trID7);
        final TextView trID8 = (TextView) findViewById(R.id.trID8);
        final TextView trID9 = (TextView) findViewById(R.id.trID9);

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

        final TextView trType0 = (TextView) findViewById(R.id.trType0);
        final TextView trType1 = (TextView) findViewById(R.id.trType1);
        final TextView trType2 = (TextView) findViewById(R.id.trType2);
        final TextView trType3 = (TextView) findViewById(R.id.trType3);
        final TextView trType4 = (TextView) findViewById(R.id.trType4);
        final TextView trType5 = (TextView) findViewById(R.id.trType5);
        final TextView trType6 = (TextView) findViewById(R.id.trType6);
        final TextView trType7 = (TextView) findViewById(R.id.trType7);
        final TextView trType8 = (TextView) findViewById(R.id.trType8);
        final TextView trType9 = (TextView) findViewById(R.id.trType9);

        final TextView trValue0 = (TextView) findViewById(R.id.trValue0);
        final TextView trValue1 = (TextView) findViewById(R.id.trValue1);
        final TextView trValue2 = (TextView) findViewById(R.id.trValue2);
        final TextView trValue3 = (TextView) findViewById(R.id.trValue3);
        final TextView trValue4 = (TextView) findViewById(R.id.trValue4);
        final TextView trValue5 = (TextView) findViewById(R.id.trValue5);
        final TextView trValue6 = (TextView) findViewById(R.id.trValue6);
        final TextView trValue7 = (TextView) findViewById(R.id.trValue7);
        final TextView trValue8 = (TextView) findViewById(R.id.trValue8);
        final TextView trValue9 = (TextView) findViewById(R.id.trValue9);

        final TextView trTime0 = (TextView) findViewById(R.id.trTime0);
        final TextView trTime1 = (TextView) findViewById(R.id.trTime1);
        final TextView trTime2 = (TextView) findViewById(R.id.trTime2);
        final TextView trTime3 = (TextView) findViewById(R.id.trTime3);
        final TextView trTime4 = (TextView) findViewById(R.id.trTime4);
        final TextView trTime5 = (TextView) findViewById(R.id.trTime5);
        final TextView trTime6 = (TextView) findViewById(R.id.trTime6);
        final TextView trTime7 = (TextView) findViewById(R.id.trTime7);
        final TextView trTime8 = (TextView) findViewById(R.id.trTime8);
        final TextView trTime9 = (TextView) findViewById(R.id.trTime9);

        // save the names of the declarations to arrays for future use
        final TextView IDArray[] = {trID0, trID1, trID2, trID3, trID4, trID5, trID6, trID7, trID8, trID9};
        final TextView UnitArray[] = {trUnit0, trUnit1, trUnit2, trUnit3, trUnit4, trUnit5, trUnit6, trUnit7, trUnit8, trUnit9};
        final TextView TypeArray[] = {trType0, trType1, trType2, trType3, trType4, trType5, trType6, trType7, trType8, trType9};
        final TextView ValueArray[] = {trValue0, trValue1, trValue2, trValue3, trValue4, trValue5, trValue6, trValue7, trValue8, trValue9};
        final TextView TimeArray[] = {trTime0, trTime1, trTime2, trTime3, trTime4, trTime5, trTime6, trTime7, trTime8, trTime9};
        // DB Request
        String lasttenurl ="http://34.204.144.157/api.php?type=last_ten";
        // Formulate the request and handle the response.
        JsonArrayRequest getUsersArrayRequest = new JsonArrayRequest(Request.Method.GET, lasttenurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String id = jresponse.getString("id");
                                String unit_id = jresponse.getString("unit_id");
                                String sensor_type = jresponse.getString("sensor_type");
                                String sensor_value = jresponse.getString("sensor_value");
                                String time_stamp = jresponse.getString("time_stamp");

                                IDArray[response.length() - (i+1)].setText(id);
                                UnitArray[response.length() - (i+1)].setText(unit_id);
                                TypeArray[response.length() - (i+1)].setText(sensor_type);
                                ValueArray[response.length() - (i+1)].setText(sensor_value);
                                TimeArray[response.length() - (i+1)].setText(time_stamp);
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
                        Log.d("LastTen", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading last_ten", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(getUsersArrayRequest);
        ///////

        // refresh button
        final ImageButton ibRefresh = (ImageButton) findViewById(R.id.ibRefresh);

        ibRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                startActivity(intent);
            }
        });
    }
}
