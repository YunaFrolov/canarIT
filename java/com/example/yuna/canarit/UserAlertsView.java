package com.example.yuna.canarit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
 * This class is the User Alerts View screen
 * It has a button for the user to press if a manual alert is needed.
 *  * It uses Volley to contact the php server to GET values and POST an alert.
 */
public class UserAlertsView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    /**
     * When the screen is created,
     * Load all the XML data and set a button click listener
     * Also, it loads the needed values from the server to know where to POST an alert
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_alerts_view);
        final Context tThis = this;

        // get the user that is currently connected
        final String userName = getIntent().getStringExtra("user_name");
        final TextView tvUserID = (TextView) findViewById(R.id.tvUserID);
        final ImageButton ibMail = (ImageButton) findViewById(R.id.ibMail);

        //////////// get the useID according to the username logged in
        String enduserurl = "http://34.204.144.157/api.php?type=get_unit_user";
        // Formulate the request and handle the response.
        JsonArrayRequest endUserArrayRequest = new JsonArrayRequest(Request.Method.GET, enduserurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jresponse = response.getJSONObject(i);
                                String user_name = jresponse.getString("user_name");
                                // get the unit id that matched the user currently connected
                                if (user_name.equals(userName)) {
                                    String userID = jresponse.getString("unit_id");
                                    tvUserID.setText(userID);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Log.d("endUser", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading end_user", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(endUserArrayRequest);
        ///////

        /**
         * When the ibMail button is clicked - let the user send an Email asking for help,
         * And in the background send a POST request to the server setting an alert to 1.
         */
        ibMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send an email requesting aid
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"canarit.gfd@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "A manual alert from " + userName);
                i.putExtra(Intent.EXTRA_TEXT, "The user " + userName + " has requested aid!");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(UserAlertsView.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

                // after getting the userID we can send a POST request to update the alarms db to the unit
                try {
                    String URL = "http://34.204.144.157/api.php";
                    JSONArray jsonArray = new JSONArray();

                    jsonArray.put("1");
                    jsonArray.put(tvUserID.getText().toString());
                    Log.i("jVOLLEY", jsonArray.toString());

                    jsonBody.put("type", "alarms");
                    jsonBody.put("values", jsonArray);
                    Log.i("jVOLLEY", jsonBody.toString());

                    postRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
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
            }
        });
    }
}