package com.example.carbo.shpeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        EditText majorEditText = (EditText) findViewById(R.id.majorTextBox);
        EditText yearEditText = (EditText) findViewById(R.id.yearTextBox);

        Spinner majorSpinner = (Spinner)findViewById(R.id.majorSpinner);
        Spinner yearSpinner = (Spinner)findViewById(R.id.yearSpinner);

        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(this, R.array.majors, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.academicStandings, android.R.layout.simple_spinner_item);

        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        majorSpinner.setAdapter(majorAdapter);
        yearSpinner.setAdapter(yearAdapter);


        majorSpinner.setOnItemSelectedListener(this);
        yearSpinner.setOnItemSelectedListener(this);

        ((EditText) findViewById(R.id.majorTextBox)).setText(majorSpinner.getItemAtPosition(majorSpinner.getSelectedItemPosition()).toString());
        ((EditText) findViewById(R.id.yearTextBox)).setText(yearSpinner.getItemAtPosition(yearSpinner.getSelectedItemPosition()).toString());
        //onItemSelected(majorSpinner,majorSpinner.getRootView(), majorSpinner.getPositionForView(majorSpinner.getRootView()), majorSpinner.getId());
        //majorEditText.setText(majorSpinner.getOnItemSelectedListener().);


    }

    public void goToHomeScreen(View view){
        Intent intent = new Intent(this, shpe.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        // text.setText(parent.getItemAtPosition(position).toString());
    }

    public String getText(AdapterView<?> spinner){

        return spinner.getSelectedItem().toString();
    }


    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


}
