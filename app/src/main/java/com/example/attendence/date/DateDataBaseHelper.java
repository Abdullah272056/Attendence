package com.example.attendence.date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.attendence.Constant;

import java.util.ArrayList;
import java.util.List;

public class DateDataBaseHelper extends SQLiteOpenHelper {
    Context context;
    public DateDataBaseHelper(@Nullable Context context ){
        super(context, Constant.DATE_TABLE_NAME, null, Constant.DATABASE_Version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constant.CREATE_DATE_TABLE);
        Toast.makeText(context, "OnCreate is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+Constant.DATE_TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "onUpgrade is Called",Toast.LENGTH_SHORT).show();
    }

    public int insertData(DateNote dateNote){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put(Constant.COLUMN_DATE,dateNote.getDate());
        int id= (int) sqLiteDatabase.insert(Constant.DATE_TABLE_NAME,null,contentValues);
        return id;
    }


    public List<DateNote> getAllNotes(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<DateNote> dateList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+Constant.DATE_TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                DateNote note = new DateNote(
                        cursor.getInt(cursor.getColumnIndex(Constant.COLUMN_DATE_ID)),
                        cursor.getString(cursor.getColumnIndex(Constant.COLUMN_DATE))
                );

                dateList.add(note);
            }while (cursor.moveToNext());
        }
        return dateList;
    }

}
