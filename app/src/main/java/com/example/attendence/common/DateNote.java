package com.example.attendence.common;

public class DateNote {
    int id;

    String date;

    public DateNote(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public DateNote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateNote(String date) {
        this.date = date;
    }
}
