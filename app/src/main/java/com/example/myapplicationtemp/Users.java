package com.example.myapplicationtemp;


public class Users {

    private String firstName;
    private String lastName;
    private String email;
    private  String password;



    public Users(String firstName, String lastName, String email, String password){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.password = password;



    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {

        lastName = lName;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {

        email = mail;
    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String pass) {

        password = pass;

    }

}