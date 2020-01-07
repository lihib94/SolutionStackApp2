package com.example.myapplicationtemp;
import java.util.ArrayList;

public class Page {
    private String numberPage;
    private ArrayList<Ex> Ex;

    public Page(String n,ArrayList<Ex> exlist){
        this.numberPage=n;
        this.Ex=new ArrayList<Ex>(exlist);
    }


    public String getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(String numberPage) {
        this.numberPage = numberPage;
    }

    public ArrayList<com.example.myapplicationtemp.Ex> getEx() {
        return Ex;
    }

    public void setEx(ArrayList<com.example.myapplicationtemp.Ex> ex) {
        Ex = ex;
    }
}
