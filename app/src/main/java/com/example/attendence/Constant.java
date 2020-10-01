package com.example.attendence;

public class Constant{
    public  static final String DATABASE_NAME="Reminder.db";
    public  static final int DATABASE_Version=4;
    public  static final String TABLE_NAME="MosQueInFormation";
    public  static final String COLUMN_ID="id";
    public  static final String COLUMN_STUDENT_NAME="STUDENT_NAME";

    public static final String CREATE_TABLE  = " CREATE TABLE "+TABLE_NAME+"("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_STUDENT_NAME+" TEXT "
            +")";
}
