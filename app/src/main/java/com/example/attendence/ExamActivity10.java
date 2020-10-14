package com.example.attendence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendence.common.DateNote;
import com.example.attendence.common.Notes2;
import com.example.attendence.ten_class.DataBaseHelper10;
import com.example.attendence.ten_class.ExamCustomAdapter10;
import com.example.attendence.ten_exam_date.CustomAdapterTenExamDate;
import com.example.attendence.ten_exam_date.DataBaseHelperTenExamDate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ExamActivity10 extends AppCompatActivity {
    private List<Notes2> studentInformationDataList;
    DataBaseHelper10 dataBaseHelper;
    RecyclerView recyclerView;
    RecyclerView dateRecyclerView;
    ExamCustomAdapter10 customAdapter;
    Context context;
    Button saveButton;
    FloatingActionButton examDateFloatingActionButton;

    DataBaseHelperTenExamDate dateDataBaseHelper;
    private List<DateNote> dateDataList;
    CustomAdapterTenExamDate dateCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_exam);

        context= ExamActivity10.this;
        // for add back Button in title bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataBaseHelper=new DataBaseHelper10(context);
        dataBaseHelper.getWritableDatabase();

        dateDataBaseHelper=new DataBaseHelperTenExamDate(context);
        dateDataBaseHelper.getWritableDatabase();

        recyclerView=findViewById(R.id.examRecyclerViewId);
        dateRecyclerView=findViewById(R.id.examDateRecyclerViewId);


        saveButton=findViewById(R.id.saveButtonId);

        examDateFloatingActionButton=findViewById(R.id.examDateFloatingButtonId);

        examDateFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateCustomAdapter();
            }
        });

        //for Horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dateRecyclerView.setLayoutManager(layoutManager);
        loadDateListData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadStudentInformationData();
    }



    private void loadStudentInformationData(){
        studentInformationDataList= new ArrayList<>();
        studentInformationDataList = dataBaseHelper.getAllNotes();
        if (studentInformationDataList.size() > 0){
            customAdapter = new ExamCustomAdapter10(context,studentInformationDataList);
            recyclerView.setAdapter(customAdapter);
            customAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No student name found", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadDateListData(){
        dateDataList  = new ArrayList<>();
        dateDataList = dateDataBaseHelper.getAllNotes();
        if (dateDataList.size() > 0){
            dateCustomAdapter = new CustomAdapterTenExamDate(context,dateDataList);
            dateRecyclerView.setAdapter(dateCustomAdapter);
            dateCustomAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No date found", Toast.LENGTH_SHORT).show();
        }
    }

    public void DateCustomAdapter(){

        AlertDialog.Builder builder     =new AlertDialog.Builder(context);
        LayoutInflater layoutInflater   =LayoutInflater.from(context);
        View view                       =layoutInflater.inflate(R.layout.date_input,null);
        builder.setView(view);
        final AlertDialog alertDialog   = builder.create();

        final EditText dateEditText=view.findViewById(R.id.dateEditTextId);
        Button saveButton=view.findViewById(R.id.saveButtonId);
        Button cancelButton=view.findViewById(R.id.cancelButtonId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dateEditText.getText().toString().isEmpty()){
                    dateEditText.setError("Enter a Date");
                }else {
                    int id =dateDataBaseHelper.insertData(new DateNote(dateEditText.getText().toString()));
                    if (id!=-1){
                        Toast.makeText(context, id+"Success", Toast.LENGTH_SHORT).show();
                        loadDateListData();
                        alertDialog.dismiss();
                    }
                    else {
                        Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


        alertDialog.show();

    }

}