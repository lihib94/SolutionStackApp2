package com.example.myapplicationtemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class TestsPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_page);

        //profile

        Spinner spinnerYear = findViewById(R.id.yearSpin);
        ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapterYear);
        spinnerYear.setOnItemSelectedListener(this);

        Spinner spinnerSemester = findViewById(R.id.semesterSpin);
        ArrayAdapter<CharSequence> adapterSemester = ArrayAdapter.createFromResource(this,
                R.array.semester, android.R.layout.simple_spinner_item);
        adapterSemester.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapterSemester);
        spinnerSemester.setOnItemSelectedListener(this);

        Spinner spinnerMoed = findViewById(R.id.moedSpin);
        ArrayAdapter<CharSequence> adapterMoed = ArrayAdapter.createFromResource(this,
                R.array.moed, android.R.layout.simple_spinner_item);
        adapterMoed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMoed.setAdapter(adapterMoed);
        spinnerMoed.setOnItemSelectedListener(this);

        Button uploadBtn = (Button) findViewById(R.id.nextBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClass();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void dialogClass() {
        DialogClass uploadDialog = new DialogClass(2);
        uploadDialog.show(getSupportFragmentManager(), "Take a pic / upload a photo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //if manager -   inflater.inflate(R.menu.menu_file_manager, menu);
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if manager:
        switch (item.getItemId()) {
            case R.id.Profile_item:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                return true;
            case R.id.ManagerP_item:
                Intent intent2 = new Intent(this, ManagerProfile.class);
                startActivity(intent2);
                return true;
            case R.id.LogOut_item:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

        /*if user:
         switch (item.getItemId()) {
            case R.id.Profile_item:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                return true;
            case R.id.ManagerP_item:
                Intent intent2 = new Intent(this, ManagerProfile.class);
                startActivity(intent2);
                return true;
            case R.id.LogOut_item:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
    }      */
    }
}