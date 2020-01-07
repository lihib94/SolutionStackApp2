package com.example.myapplicationtemp;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    private String year;
    private String semester;
    private String faculty;
    private String degree;
    private  String subjuct;
    private ArrayList <Ex> page;

    public Tests(String yer,String sem, String fac, String deg, String sub, List<Ex> p) {

        this.year = yer;
        this.semester = sem;
        this.faculty = fac;
        this.degree = deg;
        this.subjuct = sub;
        this.page = new ArrayList<Ex>(p);

    }
    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDegree() {
        return degree;
    }

    public String getSubjuct() {
        return subjuct;
    }

    public List<Ex> getPage() {
        return page;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setSubjuct(String subjuct) {
        this.subjuct = subjuct;
    }

    public void setPage(ArrayList<Ex> page) {
        this.page = page;
    }


}