package com.example.myapplicationtemp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPage();
            }
        });
    }

    public void MainPage () {
        saveData();
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //editor.putString("name", fNameField.getText().toString());

        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
    }
}

