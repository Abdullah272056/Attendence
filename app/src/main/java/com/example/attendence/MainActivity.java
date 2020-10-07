package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.attendence.mainpage.NameCustomAdapter;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NoteClass> classNameList;

    RecyclerView classNameRecyclerView;
    NameDataBaseHelperName nameDataBaseHelperName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameDataBaseHelperName=new NameDataBaseHelperName(MainActivity.this);
        nameDataBaseHelperName.getWritableDatabase();

        classNameRecyclerView=findViewById(R.id.classNameRecyclerViewId);
        classNameList  = new ArrayList<>();
        classNameList = nameDataBaseHelperName.getAllNotes();
        if (classNameList.size()<1){
            for (int i = 1; i <=11; i++) {
                int id =nameDataBaseHelperName.insertData(new NoteClass("Class No "+String.valueOf(i)));
                if (id!=0){
                    Toast.makeText(this, "success "+String.valueOf(i), Toast.LENGTH_SHORT).show();
                }
            }
        }

        classNameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadClassNameListData();
    }
    private void loadClassNameListData(){
        classNameList  = new ArrayList<>();
        classNameList = nameDataBaseHelperName.getAllNotes();
        if (classNameList.size() > 0){
            NameCustomAdapter  nameCustomAdapter = new NameCustomAdapter(MainActivity.this,classNameList);
            classNameRecyclerView.setAdapter(nameCustomAdapter);
            nameCustomAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No date found", Toast.LENGTH_SHORT).show();
        }
    }


}