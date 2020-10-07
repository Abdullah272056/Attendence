package com.example.attendence.mainpage;

public class ConstantName {
    public  static final String DATABASE_NAME="ClassName.db";
    public  static final int DATABASE_Version=1;
    public  static final String TABLE_NAME="ClassName";


    public  static final String COLUMN_ID="id";
    public  static final String COLUMN_CLASS_NAME="CLASS_NAME";
    public static final String CREATE_TABLE  = " CREATE TABLE "+TABLE_NAME+"("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_CLASS_NAME+" TEXT "
            +")";
}
