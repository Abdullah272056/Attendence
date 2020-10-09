package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.attendence.common.Notes;
import com.example.attendence.test.CustomAdapter11;
import com.example.attendence.test.DataBaseHelper11;
import com.example.attendence.test.ExamCustomAdapter;
import com.example.attendence.test.Notes2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestExamActivity extends AppCompatActivity {
    private List<Notes2> studentInformationDataList;
    DataBaseHelper11 dataBaseHelper;
    RecyclerView recyclerView;
    ExamCustomAdapter customAdapter;
    Context context;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_exam);

        context=TestExamActivity.this;
        dataBaseHelper=new DataBaseHelper11(context);
        dataBaseHelper.getWritableDatabase();
        saveButton=findViewById(R.id.saveButtonId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView=findViewById(R.id.examRecyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadStudentInformationData();
    }

    private void loadStudentInformationData(){
        studentInformationDataList= new ArrayList<>();
        studentInformationDataList = dataBaseHelper.getAllNotes();
        if (studentInformationDataList.size() > 0){
            customAdapter = new ExamCustomAdapter(context,studentInformationDataList);
            recyclerView.setAdapter(customAdapter);
            customAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No student name found", Toast.LENGTH_SHORT).show();
        }
    }


}