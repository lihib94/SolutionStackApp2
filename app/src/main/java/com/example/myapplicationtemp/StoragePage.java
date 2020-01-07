package com.example.myapplicationtemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import java.io.IOException;
import java.sql.Ref;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class StoragePage extends AppCompatActivity implements View.OnClickListener {

    //Buttons
    private Button buttonChoose;
    private Button buttonUpload;
    StorageReference mStorageRef;
    //ImageView
    private ImageView imageView;

    //a Uri object to store file path
    public Uri imguri;

    //intent to get data from mainpage
   /* Intent intent = getIntent();
    String faculty = intent.getStringExtra("faculty");
    String degree = intent.getStringExtra("degree");
    String subject = intent.getStringExtra("subject");
    String booktest = intent.getStringExtra("booktest");
    String page = intent.getStringExtra("page");
    String ex = intent.getStringExtra("ex");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_page);

        mStorageRef = FirebaseStorage.getInstance().getReference("Images");

        //getting views from layout
        buttonChoose = (Button) findViewById(R.id.buttonChoose);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);

        imageView = (ImageView) findViewById(R.id.imageView);

        //attaching listener
        buttonChoose.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if the clicked button is choose
        if (view == buttonChoose) {
            showFileChooser();
        }
        //if the clicked button is upload
        else if (view == buttonUpload) {
            fileuploader();
        }
    }

    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imguri = data.getData();
            imageView.setImageURI(imguri);
        }
    }

    private String getEx(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mim = MimeTypeMap.getSingleton();
        return mim.getExtensionFromMimeType(cr.getType(uri));
    }

    private void fileuploader() {
        StorageReference ref = mStorageRef.child(System.currentTimeMillis() + "." + getEx(imguri));
        ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        //Toast.makeText(StoragePage.this, "Image uploaded"+ faculty.toString(), Toast.LENGTH_LONG).show();
                        Toast.makeText(StoragePage.this, "Image uploaded", Toast.LENGTH_LONG).show();
                    }
                });
    }
}