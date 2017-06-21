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
 * This class is the Admin Add screen
 * It displays a table with the Hardware the is currently installed.
 * It uses Volley to contact the php server to GET the values.
 */
public class AdminAddView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_view);

        final TextView tvAdminAddAreaText = (TextView) findViewById(R.id.tvAdminAddAreaText);
        tvAdminAddAreaText.setText("Here you can add a new unit location.");

        // declare all table text fields
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

        /// put the names into arrays for future use
        final TableRow TableRowArray[] = {trTableRow0, trTableRow1, trTableRow2, trTableRow3, trTableRow4, trTableRow5, trTableRow6, trTableRow7, trTableRow8, trTableRow9};
        final TextView StreetArray[] = {trStreet0, trStreet1, trStreet2, trStreet3, trStreet4, trStreet5, trStreet6, trStreet7, trStreet8, trStreet9};
        final TextView HouseArray[] = {trHouse0, trHouse1, trHouse2, trHouse3, trHouse4, trHouse5, trHouse6, trHouse7, trHouse8, trHouse9};
        final TextView UnitArray[] = {trUnit0, trUnit1, trUnit2, trUnit3, trUnit4, trUnit5, trUnit6, trUnit7, trUnit8, trUnit9};

        // GET REQUEST ----------------
        String gethouseurl ="http://34.204.144.157/api.php?type=admin_get_house";
        // Formulate the request and handle the response.
        JsonArrayRequest getHouseArrayRequest = new JsonArrayRequest(Request.Method.GET, gethouseurl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String street = jresponse.getString("street");
                                String house_number = jresponse.getString("house_number");
                                String unit_id = jresponse.getString("unit_id");

                                StreetArray[i].setText(street);
                                HouseArray[i].setText(house_number);
                                UnitArray[i].setText(unit_id);

                            }
                            for(int i = 0; i < 10; i++) {
                                if(StreetArray[i].getText().equals(""))
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
                        Log.d("getHouse", error.getLocalizedMessage());
                        Toast.makeText(getApplicationContext(), "error while reading admin_get_house", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(getHouseArrayRequest);
        ///////

        final ImageButton ibAddHardware = (ImageButton)findViewById(R.id.ibAddHardware);
        ibAddHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminAddView.this, AdminAddHardwareView.class);
                startActivity(i);
            }
        });
    }
}
