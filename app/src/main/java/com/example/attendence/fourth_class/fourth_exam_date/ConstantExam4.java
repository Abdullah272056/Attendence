package com.example.attendence.fourth_class.fourth_exam_date;

public class ConstantExam4 {
    public  static final String DATABASE_NAME="EXAM_DATE.db4";
    public  static final int DATABASE_Version=1;
    public  static final String DATE_TABLE_NAME="EXAM_DATE4";


    public  static final String COLUMN_DATE_ID="date_id";
    public  static final String COLUMN_DATE="DATE";
    public static final String CREATE_DATE_TABLE  = " CREATE TABLE "+DATE_TABLE_NAME+"("
            +COLUMN_DATE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_DATE+" TEXT "
            +")";
}
