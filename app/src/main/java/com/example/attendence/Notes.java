package com.example.attendence;

public class Notes {
    int id;
    String studentName;

    public Notes(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Notes(String studentName) {
        this.studentName = studentName;
    }

    public Notes() {
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
