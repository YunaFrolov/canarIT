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
 * This class is the Resp High Alert screen
 * It displays a table with the data of the existing hardware
 * And you can set individual units as at risk or not
 */
public class RespHighAlertView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    /**
     * When the screen is created,
     * Load all the XML data and GET the data from the database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resp_high_alert_view);
        final Context tThis = this;

        // declaration of all text fields and buttons from XML file
        final TextView tvAlert = (TextView) findViewById(R.id.tvAlert);
        tvAlert.setText("Here you can update risky units");

        final ImageButton ibAlert = (ImageButton) findViewById(R.id.ibAlert);
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

        final TextView trFamilyName0 = (TextView) findViewById(R.id.trFamilyName0);
        final TextView trFamilyName1 = (TextView) findViewById(R.id.trFamilyName1);
        final TextView trFamilyName2 = (TextView) findViewById(R.id.trFamilyName2);
        final TextView trFamilyName3 = (TextView) findViewById(R.id.trFamilyName3);
        final TextView trFamilyName4 = (TextView) findViewById(R.id.trFamilyName4);
        final TextView trFamilyName5 = (TextView) findViewById(R.id.trFamilyName5);
        final TextView trFamilyName6 = (TextView) findViewById(R.id.trFamilyName6);
        final TextView trFamilyName7 = (TextView) findViewById(R.id.trFamilyName7);
        final TextView trFamilyName8 = (TextView) findViewById(R.id.trFamilyName8);
        final TextView trFamilyName9 = (TextView) findViewById(R.id.trFamilyName9);

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

        final EditText trIsHigh0 = (EditText) findViewById(R.id.trIsHigh0);
        final EditText trIsHigh1 = (EditText) findViewById(R.id.trIsHigh1);
        final EditText trIsHigh2 = (EditText) findViewById(R.id.trIsHigh2);
        final EditText trIsHigh3 = (EditText) findViewById(R.id.trIsHigh3);
        final EditText trIsHigh4 = (EditText) findViewById(R.id.trIsHigh4);
        final EditText trIsHigh5 = (EditText) findViewById(R.id.trIsHigh5);
        final EditText trIsHigh6 = (EditText) findViewById(R.id.trIsHigh6);
        final EditText trIsHigh7 = (EditText) findViewById(R.id.trIsHigh7);
        final EditText trIsHigh8 = (EditText) findViewById(R.id.trIsHigh8);
        final EditText trIsHigh9 = (EditText) findViewById(R.id.trIsHigh9);

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
        final TextView UnitArray[] = {trUnit0, trUnit1, trUnit2, trUnit3, trUnit4, trUnit5, trUnit6, trUnit7, trUnit8, trUnit9};
        final TextView FamilyNameArray[] = {trFamilyName0, trFamilyName1, trFamilyName2, trFamilyName3, trFamilyName4, trFamilyName5, trFamilyName6, trFamilyName7, trFamilyName8, trFamilyName9};
        final TextView FamilyArray[] = {trFamily0, trFamily1, trFamily2, trFamily3, trFamily4, trFamily5, trFamily6, trFamily7, trFamily8, trFamily9};
        final EditText HighArray[] = {trIsHigh0, trIsHigh1, trIsHigh2, trIsHigh3, trIsHigh4, trIsHigh5, trIsHigh6, trIsHigh7, trIsHigh8, trIsHigh9};


        String getsensorsurl ="http://34.204.144.157/api.php?type=local_fd_get_risks";
        // Formulate the request and handle the response.
        JsonArrayRequest getSensorsArrayRequest = new JsonArrayRequest(Request.Method.GET, getsensorsurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String family_id = jresponse.getString("family_id");
                                String family_name = jresponse.getString("family_name");
                                String unit_id = jresponse.getString("unit_id");
                                String is_high = jresponse.getString("is_at_risk");


                                FamilyArray[i].setText(family_id);
                                FamilyNameArray[i].setText(family_name);
                                UnitArray[i].setText(unit_id);
                                HighArray[i].setText(is_high);

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
                        Log.d("getRisks", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading local_fd_get_risks", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(getSensorsArrayRequest);
        ///////

        /**
         * When the ibAlert button is clicked - check if all the fields are filled,
         * If so - POST the new values to the server
         */
        ibAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean flag = true;
                for(int i = 0; i < 10; i++) {
                    if(HighArray[i].getText().equals("")){
                        HighArray[i].setError( "This field is required!" );
                        flag  = false;}
                }
                if (flag){
                    try {
                        for(int i = 0; i < 10; i++) {
                            String URL = "http://34.204.144.157/api.php";
                            JSONArray jsonArray = new JSONArray();

                             jsonArray.put(HighArray[i].getText().toString());
                             jsonArray.put(FamilyArray[i].getText().toString());

                            jsonBody.put("type", "local_fd_risk");
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

