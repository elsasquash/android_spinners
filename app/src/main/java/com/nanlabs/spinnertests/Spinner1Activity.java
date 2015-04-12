package com.nanlabs.spinnertests;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class Spinner1Activity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> strings = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);
        strings.add("UNO");
        strings.add("DOS");
        strings.add("TRES");
        strings.add("CUATRO");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, strings);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Toast.makeText(getApplicationContext(), strings.get(pos), Toast.LENGTH_LONG).show();
    }

    public void moveToNextScreen(View view) {
        finish();
        Intent myIntent = new Intent(this, Spinner2Activity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(myIntent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}
