package com.example.attendence.sixth_class;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.attendence.R;
import com.example.attendence.common.DateNote;
import com.example.attendence.common.Notes2;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.example.attendence.sixth_class.sixth_class_date.DateCustomAdapter6;
import com.example.attendence.sixth_class.sixth_class_date.DateDataBaseHelper6;
import com.example.attendence.theme.ThemeDataBaseHelper;
import com.example.attendence.theme.ThemeNote;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Sixth_Class extends AppCompatActivity {
    RecyclerView recyclerView,dateRecyclerView;
    Button addButton,examButton;

    CustomAdapter6 customAdapter;

    Button saveButton,cancelButton;
    EditText nameEditText;

    DataBaseHelper6 dataBaseHelper;
    DateDataBaseHelper6 dateDataBaseHelper;

    private List<Notes2> studentInformationDataList;
    private List<DateNote> dateDataList;
    FloatingActionButton addDateButton;

    DateCustomAdapter6 dateCustomAdapter;

    Context context;
    String appBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth__class);

        context=Sixth_Class.this;
        LinearLayout linearLayout=findViewById(R.id.layoutId);
        ThemeDataBaseHelper themeDataBaseHelper=new ThemeDataBaseHelper(context);
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



        // for add back Button in title bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setAppBar Title
        NameDataBaseHelperName nameDataBaseHelperName=new NameDataBaseHelperName(
                Sixth_Class.this);
        nameDataBaseHelperName.getWritableDatabase();
        List<NoteClass> classNameList = nameDataBaseHelperName.getAllNotes();
        getSupportActionBar().setTitle(classNameList.get(5).getClassName());

        dataBaseHelper=new DataBaseHelper6(context);
        dataBaseHelper.getWritableDatabase();
        examButton=findViewById(R.id.examButtonId);
        examButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent =new Intent(Sixth_Class.this, ExamActivity6.class);
                intent.putExtra("appBarTitle",appBarTitle);
                startActivity(intent);
            }
        });
        //add date
        addDateButton=findViewById(R.id.dateFloatingButtonId);
        dateDataBaseHelper=new DateDataBaseHelper6(context);
        dateDataBaseHelper.getWritableDatabase();


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


    //create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle present_recyclerview_item selection
        switch (item.getItemId()) {
            case R.id.studentNameDeleteItemId:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Do you want to delete all student name ?");
                builder.setIcon(R.drawable.ic_baseline_delete);
                builder.setMessage("\n \nPlease click Yes or No button !\n \n");

                builder.setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dataBaseHelper.deleteAllData();
                        dataBaseHelper=new DataBaseHelper6(context);
                        dataBaseHelper.getWritableDatabase();
                        studentInformationDataList= new ArrayList<>();
                        studentInformationDataList = dataBaseHelper.getAllNotes();
                        customAdapter = new CustomAdapter6(context,studentInformationDataList);
                        recyclerView.setAdapter(customAdapter);
                    }
                });
                builder.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                return true;

            case R.id.dateDeleteItemId:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Do you want to delete Date?");
                builder2.setIcon(R.drawable.ic_baseline_delete);
                builder2.setMessage("\n \nPlease click Yes or No button !\n \n");

                builder2.setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dateDataBaseHelper.deleteAllDateData();
                        dateDataBaseHelper=new DateDataBaseHelper6(context);
                        dateDataBaseHelper.getWritableDatabase();
                        dateDataList= new ArrayList<>();
                        dateDataList = dateDataBaseHelper.getAllNotes();
                        dateCustomAdapter = new DateCustomAdapter6(context,dateDataList);
                        dateRecyclerView.setAdapter(dateCustomAdapter);
                    }
                });
                builder2.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder2.show();
                return true;

            case R.id.deleteAllDataId:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("Do you want to delete Date?");
                builder3.setIcon(R.drawable.ic_baseline_delete);
                builder3.setMessage("\n \nPlease click Yes or No button !\n \n");

                builder3.setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dateDataBaseHelper.deleteAllDateData();
                        dateDataBaseHelper=new DateDataBaseHelper6(context);
                        dateDataBaseHelper.getWritableDatabase();
                        dateDataList= new ArrayList<>();
                        dateDataList = dateDataBaseHelper.getAllNotes();
                        dateCustomAdapter = new DateCustomAdapter6(context,dateDataList);
                        dateRecyclerView.setAdapter(dateCustomAdapter);

                        dataBaseHelper.deleteAllData();
                        dataBaseHelper=new DataBaseHelper6(context);
                        dataBaseHelper.getWritableDatabase();
                        studentInformationDataList= new ArrayList<>();
                        studentInformationDataList = dataBaseHelper.getAllNotes();
                        customAdapter = new CustomAdapter6(context,studentInformationDataList);
                        recyclerView.setAdapter(customAdapter);

                    }
                });
                builder3.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder3.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadStudentInformationData(){
        studentInformationDataList= new ArrayList<>();
        studentInformationDataList = dataBaseHelper.getAllNotes();
        if (studentInformationDataList.size() > 0){
            customAdapter = new CustomAdapter6(context,studentInformationDataList);
            recyclerView.setAdapter(customAdapter);
           // customAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No student name found", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadDateListData(){
        dateDataList  = new ArrayList<>();
        dateDataList = dateDataBaseHelper.getAllNotes();
        if (dateDataList.size() > 0){
            dateCustomAdapter = new DateCustomAdapter6(context,dateDataList);
            dateRecyclerView.setAdapter(dateCustomAdapter);
            dateCustomAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No date found", Toast.LENGTH_SHORT).show();
        }
    }


    public void CustomAdapter(){
        AlertDialog.Builder builder     =new AlertDialog.Builder(context);
        LayoutInflater layoutInflater   =LayoutInflater.from(context);
        View view                       =layoutInflater.inflate(R.layout.student_name_input_box,null);
        builder.setView(view);
        final AlertDialog alertDialog   = builder.create();
        saveButton=view.findViewById(R.id.saveButtonId);
        cancelButton=view.findViewById(R.id.cancelButtonId);
        nameEditText=view.findViewById(R.id.nameEditTextId);
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
                    String result7="";
                    String result8="";
                    String result9="";
                    String result10="";

                    int id=dataBaseHelper.insertData(new Notes2(0,0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,0,0,0,
                            0,0,0,
                            0,studentName, result1,result2,result3,result4,result5,result6
                            ,result7,result8,result9,result10));
                    if (id!=-1){
                        Toast.makeText(context, "insert Success", Toast.LENGTH_SHORT).show();
                        loadStudentInformationData();
                        alertDialog.dismiss();

                    }else {
                        Toast.makeText(context, "insert fail", Toast.LENGTH_SHORT).show();
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
                    }
                    else {
                        Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
                    }
                    alertDialog.dismiss();
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