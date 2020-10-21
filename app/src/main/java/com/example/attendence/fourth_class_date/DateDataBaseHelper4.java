package com.example.attendence.fourth_class_date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.attendence.common.DateNote;
import com.example.attendence.fourth_class.Constant4;

import java.util.ArrayList;
import java.util.List;

public class DateDataBaseHelper4 extends SQLiteOpenHelper {
    Context context;
   Constant4 constant;
    public DateDataBaseHelper4(@Nullable Context context ){
        super(context, Constant4.DATE_TABLE_NAME, null, Constant4.DATABASE_Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(constant.CREATE_DATE_TABLE);
        Toast.makeText(context, "OnCreate is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+constant.DATE_TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "onUpgrade is Called",Toast.LENGTH_SHORT).show();
    }

    public int insertData(DateNote dateNote){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put(constant.COLUMN_DATE,dateNote.getDate());
        int id= (int) sqLiteDatabase.insert(constant.DATE_TABLE_NAME,null,contentValues);
        return id;
    }


    public List<DateNote> getAllNotes(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<DateNote> dateList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+constant.DATE_TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                DateNote note = new DateNote(
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_DATE_ID)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_DATE))
                );

                dateList.add(note);
            }while (cursor.moveToNext());
        }
        return dateList;
    }


    public int updateData(DateNote notes){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(constant.COLUMN_DATE,notes.getDate());
        int status = sqLiteDatabase.update(constant.DATE_TABLE_NAME,contentValues," date_id=? ",new String[]{String.valueOf(notes.getId())});
        return status;
    }

    public int deleteDate(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int status = sqLiteDatabase.delete(constant.DATE_TABLE_NAME,"date_id=?",new String[]{String.valueOf(id)});
        return status;

    }

    public void deleteAllDateData(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ constant.DATE_TABLE_NAME);
    }
}
