package com.example.yuna.canarit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableRow;
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
 * This class is the Admin Users screen
 * It displays a table with the data of the existing users
 */
public class AdminUsersView extends AppCompatActivity {

    /**
     * When the screen is created,
     * Load all the XML data and GET the data from the database
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_view);

        final TextView tvUserAreaText = (TextView) findViewById(R.id.tvRespNotification);
        tvUserAreaText.setText("Here you can see data of all registered users.");

        final ImageButton ibAddUser = (ImageButton) findViewById(R.id.ibAddUser);

        // When clicked, go to the Add User screen
        ibAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminUsersView.this, AdminAddUserView.class);
                startActivity(i);
            }
        });

        // declaration of all text fields and buttons from XML file
        final TextView trName0 = (TextView) findViewById(R.id.trName0);
        final TextView trName1 = (TextView) findViewById(R.id.trName1);
        final TextView trName2 = (TextView) findViewById(R.id.trName2);
        final TextView trName3 = (TextView) findViewById(R.id.trName3);
        final TextView trName4 = (TextView) findViewById(R.id.trName4);
        final TextView trName5 = (TextView) findViewById(R.id.trName5);
        final TextView trName6 = (TextView) findViewById(R.id.trName6);
        final TextView trName7 = (TextView) findViewById(R.id.trName7);
        final TextView trName8 = (TextView) findViewById(R.id.trName8);
        final TextView trName9 = (TextView) findViewById(R.id.trName9);

        final TextView trPhone0 = (TextView) findViewById(R.id.trPhone0);
        final TextView trPhone1 = (TextView) findViewById(R.id.trPhone1);
        final TextView trPhone2 = (TextView) findViewById(R.id.trPhone2);
        final TextView trPhone3 = (TextView) findViewById(R.id.trPhone3);
        final TextView trPhone4 = (TextView) findViewById(R.id.trPhone4);
        final TextView trPhone5 = (TextView) findViewById(R.id.trPhone5);
        final TextView trPhone6 = (TextView) findViewById(R.id.trPhone6);
        final TextView trPhone7 = (TextView) findViewById(R.id.trPhone7);
        final TextView trPhone8 = (TextView) findViewById(R.id.trPhone8);
        final TextView trPhone9 = (TextView) findViewById(R.id.trPhone9);

        final TextView trEmail0 = (TextView) findViewById(R.id.trEmail0);
        final TextView trEmail1 = (TextView) findViewById(R.id.trEmail1);
        final TextView trEmail2 = (TextView) findViewById(R.id.trEmail2);
        final TextView trEmail3 = (TextView) findViewById(R.id.trEmail3);
        final TextView trEmail4 = (TextView) findViewById(R.id.trEmail4);
        final TextView trEmail5 = (TextView) findViewById(R.id.trEmail5);
        final TextView trEmail6 = (TextView) findViewById(R.id.trEmail6);
        final TextView trEmail7 = (TextView) findViewById(R.id.trEmail7);
        final TextView trEmail8 = (TextView) findViewById(R.id.trEmail8);
        final TextView trEmail9 = (TextView) findViewById(R.id.trEmail9);

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
        final TextView NameArray[] = {trName0, trName1, trName2, trName3, trName4, trName5, trName6, trName7, trName8, trName9};
        final TextView PhoneArray[] = {trPhone0, trPhone1, trPhone2, trPhone3, trPhone4, trPhone5, trPhone6, trPhone7, trPhone8, trPhone9};
        final TextView EmailArray[] = {trEmail0, trEmail1, trEmail2, trEmail3, trEmail4, trEmail5, trEmail6, trEmail7, trEmail8, trEmail9};
        final TextView StreetArray[] = {trStreet0, trStreet1, trStreet2, trStreet3, trStreet4, trStreet5, trStreet6, trStreet7, trStreet8, trStreet9};
        final TextView HouseArray[] = {trHouse0, trHouse1, trHouse2, trHouse3, trHouse4, trHouse5, trHouse6, trHouse7, trHouse8, trHouse9};
        final TextView UnitArray[] = {trUnit0, trUnit1, trUnit2, trUnit3, trUnit4, trUnit5, trUnit6, trUnit7, trUnit8, trUnit9};

        // DB Request
        String admingetusersurl ="http://34.204.144.157/api.php?type=admin_get_users";
        // Formulate the request and handle the response.
        JsonArrayRequest getUsersArrayRequest = new JsonArrayRequest(Request.Method.GET, admingetusersurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String f_name = jresponse.getString("f_name");
                                String l_name = jresponse.getString("l_name");
                                String Phone = jresponse.getString("Phone");
                                String email = jresponse.getString("email");
                                String street = jresponse.getString("street");
                                String house_number = jresponse.getString("house_number");
                                String unit_id = jresponse.getString("unit_id");

                                NameArray[i].setText(f_name + " " + l_name);
                                PhoneArray[i].setText(Phone);
                                EmailArray[i].setText(email);
                                StreetArray[i].setText(street);
                                HouseArray[i].setText(house_number);
                                UnitArray[i].setText(unit_id);
                            }
                            // hide unused rows
                            for(int i = 0; i < 10; i++) {
                                if(NameArray[i].getText().equals(""))
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
                        Log.d("getUsers", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading admin_get_users", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(getUsersArrayRequest);
        ///////
    }
}
