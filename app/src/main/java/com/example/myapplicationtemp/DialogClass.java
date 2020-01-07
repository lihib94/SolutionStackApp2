package com.example.myapplicationtemp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DialogClass extends AppCompatDialogFragment {

    int WhereDidComeFrom = 0;
    private EditText email, mEmailField, mPasswordField;
    private FirebaseAuth mAuth;

    public DialogClass(int WhereDidComeFrom) {
        this.WhereDidComeFrom = WhereDidComeFrom;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        

        mAuth = FirebaseAuth.getInstance();
        //forgot your password
        if (this.WhereDidComeFrom == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            final View view = inflater.inflate(R.layout.layout_forgot_your_pass, null);
            email = view.findViewById(R.id.email);
            builder.setView(view)
                    .setTitle("Don't worry we're here to help you")
                    .setMessage("Please enter your email address")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //take the pass from the DB and send an email
                            String pass = "123456478";
                            Intent intert = new Intent(Intent.ACTION_VIEW, Uri.parse("mailyo:" + email.getText().toString()));
                            intert.putExtra(intert.EXTRA_SUBJECT, "Reset Password For SolutionStack");
                            intert.putExtra(intert.EXTRA_TEXT, "Your password is:" + pass);
                            startActivity(intert);
                            Toast.makeText(getActivity(), "The password was sent to your E-mail", Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            return builder.create();
        } else if (this.WhereDidComeFrom == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("What is your choice?")
                    .setMessage("Please select:")
                    .setPositiveButton("Take a Picture", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 0);
                        }
                    })
                    .setNegativeButton("Upload a file", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(DialogClass.this.getActivity(), StoragePage.class);
                            startActivity(intent);
                        }
                    });
            return builder.create();
        } else if (this.WhereDidComeFrom == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            final View view = inflater.inflate(R.layout.layout_login_manager, null);
            mEmailField = view.findViewById(R.id.edit_username);
            mPasswordField = view.findViewById(R.id.edit_password);
            builder.setView(view)
                    .setTitle("Login Managers")
                    .setMessage("Please enter your email address& password")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String mail = mEmailField.getText().toString().trim();
                            String password = mPasswordField.getText().toString().trim();

                            //Email is not empty
                            if (mail.isEmpty()) {
                                mEmailField.setError("Email is required");
                                mEmailField.requestFocus();
                                return;
                            }
                            //Email is real
                            if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                                mEmailField.setError("Please enter a valid email");
                                mEmailField.requestFocus();
                                return;
                            }
                            //Pass is not empty
                            if (password.isEmpty()) {
                                mPasswordField.setError("Password is required");
                                mPasswordField.requestFocus();
                                return;
                            }
                            //Pass is greater then 8
                            if (password.length() < 8) {
                                mPasswordField.setError("Password must be with length of 8");
                                mPasswordField.requestFocus();
                                return;
                            }
                            //check if all the info connection is on the DB
                            mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(DialogClass.this.getActivity(), MainPage.class);
                                        startActivity(intent);
                                    } else {
                                        //Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            return builder.create();
        } else {
            return null;
        }
    }
}
