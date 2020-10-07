package com.example.attendence.mainpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.attendence.common.Notes;

import java.util.ArrayList;
import java.util.List;

public class NameDataBaseHelperName extends SQLiteOpenHelper {
    ConstantName constantName;
    Context context;
    public NameDataBaseHelperName(@Nullable Context context) {
        super(context, ConstantName.TABLE_NAME, null, ConstantName.DATABASE_Version);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(constantName.CREATE_TABLE);
        Toast.makeText(context, "create s", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+constantName.TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "onUpgrade is Called",Toast.LENGTH_SHORT).show();
    }

    public int insertData(NoteClass notes){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(constantName.COLUMN_CLASS_NAME,notes.getClassName());
        int id= (int) sqLiteDatabase.insert(constantName.TABLE_NAME,null,contentValues);
        return id;

    }



    public List<NoteClass> getAllNotes(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<NoteClass> dataList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+constantName.TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                NoteClass note = new NoteClass(
                        cursor.getInt(cursor.getColumnIndex(constantName.COLUMN_ID)),

                        cursor.getString(cursor.getColumnIndex(constantName.COLUMN_CLASS_NAME))
                );

                dataList.add(note);
            }while (cursor.moveToNext());
        }
        return dataList;
    }



}
