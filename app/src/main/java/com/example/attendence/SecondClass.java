package com.example.attendence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendence.common.DateNote;
import com.example.attendence.common.Notes;
import com.example.attendence.common.Notes2;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.example.attendence.second_class.CustomAdapter2;
import com.example.attendence.second_class.DataBaseHelper2;
import com.example.attendence.second_class_date.DateCustomAdapter2;
import com.example.attendence.second_class_date.DateDataBaseHelper2;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SecondClass extends AppCompatActivity {
    RecyclerView recyclerView,dateRecyclerView;
    Button addButton,examButton;

    CustomAdapter2 customAdapter;

    Button saveButton,cancelButton;
    EditText nameEditText;
    DataBaseHelper2 dataBaseHelper;

    DateDataBaseHelper2 dateDataBaseHelper;

    private List<Notes2> studentInformationDataList;
    private List<DateNote> dateDataList;
    FloatingActionButton addDateButton;

    DateCustomAdapter2 dateCustomAdapter;
    String appBarTitle;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_class);

        context=SecondClass.this;
        // for add back Button in title bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setAppBar Title
        NameDataBaseHelperName nameDataBaseHelperName=new NameDataBaseHelperName(
                SecondClass.this);
        nameDataBaseHelperName.getWritableDatabase();
        List<NoteClass> classNameList = nameDataBaseHelperName.getAllNotes();
        getSupportActionBar().setTitle(classNameList.get(1).getClassName());

        dataBaseHelper=new DataBaseHelper2(context);
        dataBaseHelper.getWritableDatabase();

        //add date
        addDateButton=findViewById(R.id.dateFloatingButtonId);
        dateDataBaseHelper=new DateDataBaseHelper2(context);
        dateDataBaseHelper.getWritableDatabase();
        examButton=findViewById(R.id.examButtonId);
        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(SecondClass.this,ExamActivity2.class);
                intent.putExtra("appBarTitle",appBarTitle);
                startActivity(intent);

            }
        });

        recyclerView=findViewById(R.id.recyclerViewId);
        dateRecyclerView=findViewById(R.id.dateRecyclerViewId);
        addButton=findViewById(R.id.addButtonId);




        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                CustomAdapter();

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadStudentInformationData();



        /// add date
        addDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateCustomAdapter();
            }
        });

        //for Horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        dateRecyclerView.setLayoutManager(layoutManager);
        loadDateListData();



    }

    private void loadStudentInformationData(){
        studentInformationDataList= new ArrayList<>();
        studentInformationDataList = dataBaseHelper.getAllNotes();
        if (studentInformationDataList.size() > 0){
            customAdapter = new CustomAdapter2(context,studentInformationDataList);
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
            dateCustomAdapter = new DateCustomAdapter2(context,dateDataList);
            dateRecyclerView.setAdapter(dateCustomAdapter);
            dateCustomAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No date found", Toast.LENGTH_SHORT).show();
        }
    }


    public void CustomAdapter(){
        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.input);
        bottomSheetDialog.setCanceledOnTouchOutside(false);

        saveButton=bottomSheetDialog.findViewById(R.id.saveButtonId);
        cancelButton=bottomSheetDialog.findViewById(R.id.cancelButtonId);
        nameEditText=bottomSheetDialog.findViewById(R.id.nameEditTextId);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEditText.getText().toString().isEmpty()){
                    nameEditText.setError("Enter a Name");
                }
                else {
                    String studentName=nameEditText.getText().toString();
                    String result1="";
                    String result2="";
                    String result3="";
                    String result4="";
                    String result5="";
                    String result6="";

                    int id=dataBaseHelper.insertData(new Notes2(0,0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,studentName, result1,result2,result3,result4,result5,result6));

                    if (id!=-1){
                        Toast.makeText(context, "insert Success", Toast.LENGTH_SHORT).show();
                        loadStudentInformationData();
                        bottomSheetDialog.dismiss();

                    }else {
                        Toast.makeText(context, "insert fail", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                }

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();
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