package com.example.myapplicationtemp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String text;
    String [] faculty,degree,subject,booktest;
    String facultySend,degreeSend,subjectSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        text = sharedPreferences.getString("name", " ");

        TextView nameTxt = (TextView) findViewById(R.id.nameTxt);
        nameTxt.setText(text);

        Button next = (Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.equals("Tests")) openTestsPage();
                else openBooksPage();
            }
        });

        Spinner spinnerFacolty = findViewById(R.id.facoltySpin);
        ArrayAdapter<CharSequence> adapterFacolty = ArrayAdapter.createFromResource(this,
                R.array.facolty, android.R.layout.simple_spinner_item);
        adapterFacolty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFacolty.setAdapter(adapterFacolty);
        spinnerFacolty.setOnItemSelectedListener(this);
        faculty=getResources().getStringArray(R.array.facolty);
        spinnerFacolty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                facultySend=faculty[i];
               // Toast.makeText(parent.getContext(), faculty[i], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinnerDegree = findViewById(R.id.degreeSpin);
        ArrayAdapter<CharSequence> adapterEngineering0 = ArrayAdapter.createFromResource(this,
                R.array.DegreeEngineering, android.R.layout.simple_spinner_item);
        adapterEngineering0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDegree.setAdapter(adapterEngineering0);
        spinnerDegree.setOnItemSelectedListener(this);
        degree=getResources().getStringArray(R.array.DegreeEngineering);
        spinnerDegree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int j, long id) {
                //Toast.makeText(parent.getContext(), degree[j], Toast.LENGTH_SHORT).show();
                degreeSend=degree[j];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Spinner spinnerSubject = findViewById(R.id.subjectSpin);
        ArrayAdapter<CharSequence> adapterSubject = ArrayAdapter.createFromResource(this,
                R.array.SubjectElectricalEngineering, android.R.layout.simple_spinner_item);
        adapterSubject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapterSubject);
        spinnerSubject.setOnItemSelectedListener(this);
        subject=getResources().getStringArray(R.array.SubjectElectricalEngineering);
        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                //Toast.makeText(parent.getContext(), subject[i], Toast.LENGTH_SHORT).show();
                subjectSend=subject[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner spinnerBookTest = findViewById(R.id.bookTestSpin);
        ArrayAdapter<CharSequence> adapterBookTest = ArrayAdapter.createFromResource(this,
                R.array.bookTest, android.R.layout.simple_spinner_item);
        adapterBookTest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBookTest.setAdapter(adapterBookTest);
        spinnerBookTest.setOnItemSelectedListener(this);
        booktest=getResources().getStringArray(R.array.bookTest);
        spinnerBookTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
               // Toast.makeText(parent.getContext(), booktest[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void openTestsPage() {
        Intent intent = new Intent(this, TestsPage.class);
        startActivity(intent);
    }

    public void openBooksPage() {
        Bundle bundle = new Bundle();
        bundle.putString("FACULTY", facultySend);
        bundle.putString("DEGREE", degreeSend);
        bundle.putString("SEBJECT", subjectSend);
        Intent intent = new Intent(this, BooksPage.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }




    //creating the menu
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}