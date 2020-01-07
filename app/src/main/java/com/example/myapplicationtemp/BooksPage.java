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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BooksPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String [] book;
    String bookSend;

    String faculty,degree,subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //intent to get data from mainpage
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        faculty = bundle.getString("FACULTY");
        degree = bundle.getString("DEGREE");
        subject = bundle.getString("SEBJECT");
        //Toast.makeText(get ApplicationContext(), faculty+""+degree+""+subject, Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_page);

        //profile
        Button openBtn = (Button) findViewById(R.id.openBtn) ;
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenExclass();
            }
        });
        Button uploadBtn = (Button) findViewById(R.id.nextBtn);
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClass();
            }
        });


        Spinner spinnerBooks = findViewById(R.id.bookTestSpin);
        ArrayAdapter<CharSequence> adapterBooks = ArrayAdapter.createFromResource(this,
                R.array.booksComputerSciense, android.R.layout.simple_spinner_item);
        adapterBooks.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBooks.setAdapter(adapterBooks);
        spinnerBooks.setOnItemSelectedListener(this);
        book=getResources().getStringArray(R.array.booksComputerSciense);
        spinnerBooks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                bookSend=book[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

   public void OpenExclass() {
       EditText page = (EditText) findViewById(R.id.pageNoInput);
       EditText ex = (EditText) findViewById(R.id.ExInput);
      final String pageSend = page.getText().toString();
      final String exSend = ex.getText().toString();
      Intent intent = new Intent(this, OpenEx.class);
      Bundle bundle = new Bundle();
      bundle.putString("FACULTY", faculty);
      bundle.putString("DEGREE", degree);
      bundle.putString("SEBJECT", subject);
      bundle.putString("PAGESEND", pageSend);
      bundle.putString("EXSEND", exSend);
      bundle.putString("BOOKSEND", bookSend);
      intent.putExtras(bundle);
      startActivity(intent);
  }
    public void dialogClass() {
        DialogClass uploadDialog = new DialogClass(2);
        uploadDialog.show(getSupportFragmentManager(), "Take a pic / upload a photo");
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
}
