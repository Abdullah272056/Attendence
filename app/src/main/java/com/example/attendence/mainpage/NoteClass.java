package com.example.attendence.mainpage;

public class NoteClass {
    int id;
    String className;

    public NoteClass(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public NoteClass() {
    }

    public NoteClass(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
