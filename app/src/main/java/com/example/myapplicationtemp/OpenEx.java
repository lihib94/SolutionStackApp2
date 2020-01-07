package com.example.myapplicationtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class OpenEx extends AppCompatActivity {

    public static TextView myAwesomeTextView = null;
    String faculty,degree,subject,pageSend,exSend,bookSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_ex);
        myAwesomeTextView = (TextView)findViewById(R.id.openExtxt);
       Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        faculty = bundle.getString("FACULTY");
        degree = bundle.getString("DEGREE");
        subject = bundle.getString("SEBJECT");
        pageSend = bundle.getString("PAGESEND");
        exSend = bundle.getString("EXSEND");
        bookSend = bundle.getString("BOOKSEND");
        myAwesomeTextView.setText("Book: "+bookSend+" Page: "+pageSend+" Ex: "+exSend);
        //Toast.makeText(getApplicationContext(), faculty+""+degree+""+subject, Toast.LENGTH_LONG).show();


    }




}
