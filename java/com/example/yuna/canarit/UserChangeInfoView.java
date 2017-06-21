package com.example.yuna.canarit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
 * This class is the User Change Info screen
 * It displays a table with the data of the current user,
 * And the text fields are editable - so that a user can change the info
 */
public class UserChangeInfoView extends AppCompatActivity {

    JsonObjectRequest postRequest;
    JSONObject jsonBody = new JSONObject();

    /**
     * When the screen is created,
     * Load all the XML data and GET the data from the database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_change_info_view);
        final Context tThis = this;

        // declaration of all text fields and buttons from XML file
        final String userName = getIntent().getStringExtra("user_name");
        final TextView tvAdded = (TextView) findViewById(R.id.tvAdded);
        final EditText trUserName = (EditText) findViewById(R.id.trUserName);
        final EditText trPassword = (EditText) findViewById(R.id.trPassword);
        final EditText trFirstName = (EditText) findViewById(R.id.trFirstName);
        final EditText trLastName = (EditText) findViewById(R.id.trLastName);
        final EditText trPhone = (EditText) findViewById(R.id.trPhone);
        final EditText trEmail = (EditText) findViewById(R.id.trEmail);
        final TextView tvUserID = (TextView) findViewById(R.id.tvUserID);
        final ImageButton ibChangeInfo = (ImageButton) findViewById(R.id.ibChangeInfo);

        String enduserurl ="http://34.204.144.157/api.php?type=end_user";
        // Formulate the request and handle the response.
        JsonArrayRequest endUserArrayRequest = new JsonArrayRequest(Request.Method.GET, enduserurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String user_name = jresponse.getString("user_name");

                                if(user_name.equals(userName)) {
                                    String user_id  = jresponse.getString("user_id");
                                    String f_name = jresponse.getString("f_name");
                                    String l_name = jresponse.getString("l_name");
                                    String Phone = jresponse.getString("Phone");
                                    String email = jresponse.getString("email");
                                    String password = jresponse.getString("password");

                                    trUserName.setText(user_name);
                                    trFirstName.setText(f_name);
                                    trLastName.setText(l_name);
                                    trPhone.setText(Phone);
                                    trEmail.setText(email);
                                    trPassword.setText(password);
                                    tvUserID.setText(user_id);
                                }
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
                        Log.d("endUser", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading end_user", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(endUserArrayRequest);


        /**
         * When the ibChangeInfo button is clicked - check if all the fields are filled,
         * If so - POST the new values to the server
         */
        ibChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean flag = true;
                if( trUserName.getText().toString().trim().equals("")){
                    trUserName.setError( "This field is required!" );
                    flag  = false;}
                if( trPassword.getText().toString().trim().equals("")){
                    trPassword.setError( "This field is required!" );
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
                    final String sUser = trUserName.getText().toString();
                    final String sPassword = trPassword.getText().toString();
                    final String sFirstName = trFirstName.getText().toString();
                    final String sLastName = trLastName.getText().toString();
                    final String sPhone = trPhone.getText().toString();
                    final String sEmail = trEmail.getText().toString();
                    final String sUserID = tvUserID.getText().toString();

                    try {
                        String URL = "http://34.204.144.157/api.php";
                        JSONArray jsonArray = new JSONArray();

                        jsonArray.put(sUser);
                        jsonArray.put(sPassword);
                        jsonArray.put(sFirstName);
                        jsonArray.put(sLastName);
                        jsonArray.put(sPhone);
                        jsonArray.put(sEmail);
                        jsonArray.put(sUserID);

                        jsonBody.put("type", "user_change_user");
                        jsonBody.put("values", jsonArray);
                        Log.i("jVOLLEY", jsonBody.toString());

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