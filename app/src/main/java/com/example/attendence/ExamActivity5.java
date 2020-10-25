package com.example.attendence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.attendence.common.DateNote;
import com.example.attendence.common.Notes;
import com.example.attendence.common.Notes2;
import com.example.attendence.fifth_class.DataBaseHelper5;
import com.example.attendence.fifth_class.ExamCustomAdapter5;
import com.example.attendence.fifth_exam_date.CustomAdapterExamDate5;
import com.example.attendence.fifth_exam_date.DataBaseHelperExamDate5;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.example.attendence.theme.ThemeDataBaseHelper;
import com.example.attendence.theme.ThemeNote;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ExamActivity5 extends AppCompatActivity {
    private List<Notes> studentInformationDataList;
    DataBaseHelper5 dataBaseHelper;
    RecyclerView recyclerView;
    RecyclerView dateRecyclerView;
    ExamCustomAdapter5 customAdapter;
    Context context;
    Button saveButton;
    FloatingActionButton examDateFloatingActionButton;

    DataBaseHelperExamDate5 dateDataBaseHelper;
    private List<DateNote> dateDataList;
    CustomAdapterExamDate5 dateCustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam5);
        LinearLayout linearLayout=findViewById(R.id.layoutId);
        ThemeDataBaseHelper themeDataBaseHelper=new ThemeDataBaseHelper(ExamActivity5.this);
        themeDataBaseHelper.getWritableDatabase();
        List<ThemeNote>  themeStatusData = themeDataBaseHelper.getAllNotes();

        if (themeStatusData.get(0).getThemeStatus()==1){
            Toast.makeText(this, "theme change", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(128, 0, 128));
        }
        else if (themeStatusData.get(0).getThemeStatus()==2){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(50, 50, 50));
        }
        else  if (themeStatusData.get(0).getThemeStatus()==3){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        else if (themeStatusData.get(0).getThemeStatus()==4){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(255, 0, 0));
        }

        else  if (themeStatusData.get(0).getThemeStatus()==5){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(0, 0, 255));
        }
        else  if (themeStatusData.get(0).getThemeStatus()==6){
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        }


        //setAppBar Title
        NameDataBaseHelperName nameDataBaseHelperName=new NameDataBaseHelperName(
                ExamActivity5.this);
        nameDataBaseHelperName.getWritableDatabase();
        List<NoteClass> classNameList = nameDataBaseHelperName.getAllNotes();
        getSupportActionBar().setTitle("<Exam Result>"+classNameList.get(4).getClassName());

        context=ExamActivity5.this;
        // for add back Button in title bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataBaseHelper=new DataBaseHelper5(context);
        dataBaseHelper.getWritableDatabase();

        dateDataBaseHelper=new DataBaseHelperExamDate5(context);
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
            customAdapter = new ExamCustomAdapter5(context,studentInformationDataList);
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
            dateCustomAdapter = new CustomAdapterExamDate5(context,dateDataList);
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