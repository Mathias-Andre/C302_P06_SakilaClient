package com.example.c302_p0_sakilaclient;


import java.io.Serializable;

public class Film implements Serializable {
    private String title;
    private int year;
    private String rating;

    public Film(String title, int year, String rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;//to display in ListView
    }
}
