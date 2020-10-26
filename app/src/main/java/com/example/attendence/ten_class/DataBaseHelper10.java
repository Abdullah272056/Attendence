package com.example.attendence.ten_class;

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

public class DataBaseHelper10 extends SQLiteOpenHelper {
    Constant10 constant;
    Context context;

    public DataBaseHelper10(@Nullable Context context) {
        super(context, Constant10.TABLE_NAME, null, Constant10.DATABASE_Version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(constant.CREATE_TABLE);
        // Toast.makeText(context, "OnCreate is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(" DROP TABLE IF EXISTS "+constant.TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "onUpgrade is Called",Toast.LENGTH_SHORT).show();
    }





    public List<Notes> getAllNotes(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        List<Notes> dataList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+constant.TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                Notes note = new Notes(
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_ID)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX1)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX2)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX3)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX4)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX5)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX6)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX7)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX8)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX9)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX10)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX11)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX12)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX13)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX14)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX15)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX16)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX17)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX18)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX19)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX20)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX21)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX22)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX23)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX24)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX25)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX26)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX27)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX28)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX29)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX30)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX31)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX32)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX33)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX34)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX35)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX36)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX37)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX38)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX39)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX40)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX41)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX42)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX43)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX44)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX45)),
                        cursor.getInt(cursor.getColumnIndex(constant.COLUMN_CHECKBOX_COUNT)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_STUDENT_NAME)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT1)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT2)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT3)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT4)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT5)),
                        cursor.getString(cursor.getColumnIndex(constant.COLUMN_EXAM_RESULT6))
                );

                dataList.add(note);
            }while (cursor.moveToNext());
        }
        return dataList;
    }
    public int insertData(Notes notes){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(constant.COLUMN_CHECKBOX1,notes.getCheckBox1());
        contentValues.put(constant.COLUMN_CHECKBOX2,notes.getCheckBox2());
        contentValues.put(constant.COLUMN_CHECKBOX3,notes.getCheckBox3());
        contentValues.put(constant.COLUMN_CHECKBOX4,notes.getCheckBox4());
        contentValues.put(constant.COLUMN_CHECKBOX5,notes.getCheckBox5());
        contentValues.put(constant.COLUMN_CHECKBOX6,notes.getCheckBox6());
        contentValues.put(constant.COLUMN_CHECKBOX7,notes.getCheckBox7());
        contentValues.put(constant.COLUMN_CHECKBOX8,notes.getCheckBox8());
        contentValues.put(constant.COLUMN_CHECKBOX9,notes.getCheckBox9());
        contentValues.put(constant.COLUMN_CHECKBOX10,notes.getCheckBox10());

        contentValues.put(constant.COLUMN_CHECKBOX11,notes.getCheckBox11());
        contentValues.put(constant.COLUMN_CHECKBOX12,notes.getCheckBox12());
        contentValues.put(constant.COLUMN_CHECKBOX13,notes.getCheckBox13());
        contentValues.put(constant.COLUMN_CHECKBOX14,notes.getCheckBox14());
        contentValues.put(constant.COLUMN_CHECKBOX15,notes.getCheckBox15());
        contentValues.put(constant.COLUMN_CHECKBOX16,notes.getCheckBox16());
        contentValues.put(constant.COLUMN_CHECKBOX17,notes.getCheckBox17());
        contentValues.put(constant.COLUMN_CHECKBOX18,notes.getCheckBox18());
        contentValues.put(constant.COLUMN_CHECKBOX19,notes.getCheckBox19());
        contentValues.put(constant.COLUMN_CHECKBOX20,notes.getCheckBox20());

        contentValues.put(constant.COLUMN_CHECKBOX21,notes.getCheckBox21());
        contentValues.put(constant.COLUMN_CHECKBOX22,notes.getCheckBox22());
        contentValues.put(constant.COLUMN_CHECKBOX23,notes.getCheckBox23());
        contentValues.put(constant.COLUMN_CHECKBOX24,notes.getCheckBox24());
        contentValues.put(constant.COLUMN_CHECKBOX25,notes.getCheckBox25());
        contentValues.put(constant.COLUMN_CHECKBOX26,notes.getCheckBox26());
        contentValues.put(constant.COLUMN_CHECKBOX27,notes.getCheckBox27());
        contentValues.put(constant.COLUMN_CHECKBOX28,notes.getCheckBox28());
        contentValues.put(constant.COLUMN_CHECKBOX29,notes.getCheckBox29());
        contentValues.put(constant.COLUMN_CHECKBOX30,notes.getCheckBox30());
        contentValues.put(constant.COLUMN_CHECKBOX31,notes.getCheckBox31());
        contentValues.put(constant.COLUMN_CHECKBOX32,notes.getCheckBox32());
        contentValues.put(constant.COLUMN_CHECKBOX33,notes.getCheckBox33());
        contentValues.put(constant.COLUMN_CHECKBOX34,notes.getCheckBox34());
        contentValues.put(constant.COLUMN_CHECKBOX35,notes.getCheckBox35());
        contentValues.put(constant.COLUMN_CHECKBOX36,notes.getCheckBox36());
        contentValues.put(constant.COLUMN_CHECKBOX37,notes.getCheckBox37());
        contentValues.put(constant.COLUMN_CHECKBOX38,notes.getCheckBox38());
        contentValues.put(constant.COLUMN_CHECKBOX39,notes.getCheckBox39());
        contentValues.put(constant.COLUMN_CHECKBOX40,notes.getCheckBox40());
        contentValues.put(constant.COLUMN_CHECKBOX41,notes.getCheckBox41());
        contentValues.put(constant.COLUMN_CHECKBOX42,notes.getCheckBox42());
        contentValues.put(constant.COLUMN_CHECKBOX43,notes.getCheckBox43());
        contentValues.put(constant.COLUMN_CHECKBOX44,notes.getCheckBox44());
        contentValues.put(constant.COLUMN_CHECKBOX45,notes.getCheckBox45());
        contentValues.put(constant.COLUMN_CHECKBOX_COUNT,notes.getCheckBoxCount());

        contentValues.put(constant.COLUMN_STUDENT_NAME,notes.getStudentName());

        contentValues.put(constant.COLUMN_EXAM_RESULT1,notes.getExamResult1());
        contentValues.put(constant.COLUMN_EXAM_RESULT2,notes.getExamResult2());
        contentValues.put(constant.COLUMN_EXAM_RESULT3,notes.getExamResult3());
        contentValues.put(constant.COLUMN_EXAM_RESULT4,notes.getExamResult4());
        contentValues.put(constant.COLUMN_EXAM_RESULT5,notes.getExamResult5());
        contentValues.put(constant.COLUMN_EXAM_RESULT6,notes.getExamResult6());

        int id= (int) sqLiteDatabase.insert(constant.TABLE_NAME,null,contentValues);
        return id;
    }




    public int updateData(Notes notes){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(constant.COLUMN_CHECKBOX1,notes.getCheckBox1());
        contentValues.put(constant.COLUMN_CHECKBOX2,notes.getCheckBox2());
        contentValues.put(constant.COLUMN_CHECKBOX3,notes.getCheckBox3());
        contentValues.put(constant.COLUMN_CHECKBOX4,notes.getCheckBox4());
        contentValues.put(constant.COLUMN_CHECKBOX5,notes.getCheckBox5());
        contentValues.put(constant.COLUMN_CHECKBOX6,notes.getCheckBox6());
        contentValues.put(constant.COLUMN_CHECKBOX7,notes.getCheckBox7());
        contentValues.put(constant.COLUMN_CHECKBOX8,notes.getCheckBox8());
        contentValues.put(constant.COLUMN_CHECKBOX9,notes.getCheckBox9());
        contentValues.put(constant.COLUMN_CHECKBOX10,notes.getCheckBox10());

        contentValues.put(constant.COLUMN_CHECKBOX11,notes.getCheckBox11());
        contentValues.put(constant.COLUMN_CHECKBOX12,notes.getCheckBox12());
        contentValues.put(constant.COLUMN_CHECKBOX13,notes.getCheckBox13());
        contentValues.put(constant.COLUMN_CHECKBOX14,notes.getCheckBox14());
        contentValues.put(constant.COLUMN_CHECKBOX15,notes.getCheckBox15());
        contentValues.put(constant.COLUMN_CHECKBOX16,notes.getCheckBox16());
        contentValues.put(constant.COLUMN_CHECKBOX17,notes.getCheckBox17());
        contentValues.put(constant.COLUMN_CHECKBOX18,notes.getCheckBox18());
        contentValues.put(constant.COLUMN_CHECKBOX19,notes.getCheckBox19());
        contentValues.put(constant.COLUMN_CHECKBOX20,notes.getCheckBox20());

        contentValues.put(constant.COLUMN_CHECKBOX21,notes.getCheckBox21());
        contentValues.put(constant.COLUMN_CHECKBOX22,notes.getCheckBox22());
        contentValues.put(constant.COLUMN_CHECKBOX23,notes.getCheckBox23());
        contentValues.put(constant.COLUMN_CHECKBOX24,notes.getCheckBox24());
        contentValues.put(constant.COLUMN_CHECKBOX25,notes.getCheckBox25());
        contentValues.put(constant.COLUMN_CHECKBOX26,notes.getCheckBox26());
        contentValues.put(constant.COLUMN_CHECKBOX27,notes.getCheckBox27());
        contentValues.put(constant.COLUMN_CHECKBOX28,notes.getCheckBox28());
        contentValues.put(constant.COLUMN_CHECKBOX29,notes.getCheckBox29());
        contentValues.put(constant.COLUMN_CHECKBOX30,notes.getCheckBox30());
        contentValues.put(constant.COLUMN_CHECKBOX31,notes.getCheckBox31());
        contentValues.put(constant.COLUMN_CHECKBOX32,notes.getCheckBox32());
        contentValues.put(constant.COLUMN_CHECKBOX33,notes.getCheckBox33());
        contentValues.put(constant.COLUMN_CHECKBOX34,notes.getCheckBox34());
        contentValues.put(constant.COLUMN_CHECKBOX35,notes.getCheckBox35());
        contentValues.put(constant.COLUMN_CHECKBOX36,notes.getCheckBox36());
        contentValues.put(constant.COLUMN_CHECKBOX37,notes.getCheckBox37());
        contentValues.put(constant.COLUMN_CHECKBOX38,notes.getCheckBox38());
        contentValues.put(constant.COLUMN_CHECKBOX39,notes.getCheckBox39());
        contentValues.put(constant.COLUMN_CHECKBOX40,notes.getCheckBox40());
        contentValues.put(constant.COLUMN_CHECKBOX41,notes.getCheckBox41());
        contentValues.put(constant.COLUMN_CHECKBOX42,notes.getCheckBox42());
        contentValues.put(constant.COLUMN_CHECKBOX43,notes.getCheckBox43());
        contentValues.put(constant.COLUMN_CHECKBOX44,notes.getCheckBox44());
        contentValues.put(constant.COLUMN_CHECKBOX45,notes.getCheckBox45());
        contentValues.put(constant.COLUMN_CHECKBOX_COUNT,notes.getCheckBoxCount());
        contentValues.put(constant.COLUMN_STUDENT_NAME,notes.getStudentName());

        contentValues.put(constant.COLUMN_EXAM_RESULT1,notes.getExamResult1());
        contentValues.put(constant.COLUMN_EXAM_RESULT2,notes.getExamResult2());
        contentValues.put(constant.COLUMN_EXAM_RESULT3,notes.getExamResult3());
        contentValues.put(constant.COLUMN_EXAM_RESULT4,notes.getExamResult4());
        contentValues.put(constant.COLUMN_EXAM_RESULT5,notes.getExamResult5());
        contentValues.put(constant.COLUMN_EXAM_RESULT6,notes.getExamResult6());


        int status = sqLiteDatabase.update(constant.TABLE_NAME,contentValues," id=? ",new String[]{String.valueOf(notes.getId())});
        return status;
    }

    public int deleteData(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int status = sqLiteDatabase.delete(constant.TABLE_NAME,"id=?",new String[]{String.valueOf(id)});
        return status;

    }

    public void deleteAllData(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
       sqLiteDatabase.execSQL("delete from "+ constant.TABLE_NAME);
    }


}

