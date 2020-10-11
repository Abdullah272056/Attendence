package com.example.attendence.seventh_exam_date;

public class ConstantExam7 {
    public  static final String DATABASE_NAME="EXAM_DATE.db7";
    public  static final int DATABASE_Version=2;
    public  static final String DATE_TABLE_NAME="EXAM_DATE7";


    public  static final String COLUMN_DATE_ID="date_id";
    public  static final String COLUMN_DATE="DATE";
    public static final String CREATE_DATE_TABLE  = " CREATE TABLE "+DATE_TABLE_NAME+"("
            +COLUMN_DATE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_DATE+" TEXT "
            +")";
}
