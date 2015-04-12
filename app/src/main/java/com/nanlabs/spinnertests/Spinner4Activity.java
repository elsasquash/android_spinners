package com.nanlabs.spinnertests;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class Spinner4Activity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner4);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.person_layout, getData());
        spinner.setAdapter(adapter);
    }

    private ArrayList<Person> getData() {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            JSONArray personasJson = new JSONArray("[" +
                    "{\"firstName\":\"John\", \"lastName\":\"Doe\"}," +
                    "{\"firstName\":\"Anna\", \"lastName\":\"Smith\"}," +
                    "{\"firstName\":\"Peter\",\"lastName\":\"Jones\"}" +
                    "]");
            for (int i=0; i<personasJson.length(); i++) {
                persons.add(new Person(personasJson.getString(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Toast.makeText(getApplicationContext(), ((Person) spinner.getAdapter().getItem(position)).getFirstName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void moveToNextScreen(View view) {
        finish();
        Intent myIntent = new Intent(this, Spinner5Activity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(myIntent);
    }
}