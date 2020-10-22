package com.example.attendence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.attendence.common.Notes2;
import com.example.attendence.eight_class.DataBaseHelper8;
import com.example.attendence.eight_class_date.DateDataBaseHelper8;
import com.example.attendence.eight_exam_date.DataBaseHelperExamDate8;
import com.example.attendence.fifth_class.DataBaseHelper5;
import com.example.attendence.fifth_class_date.DateDataBaseHelper5;
import com.example.attendence.fifth_exam_date.DataBaseHelperExamDate5;
import com.example.attendence.first_class.DataBaseHelper;
import com.example.attendence.first_class_date.DateDataBaseHelper;
import com.example.attendence.first_exam_date.DataBaseHelperExamDate1;
import com.example.attendence.fourth_class.DataBaseHelper4;
import com.example.attendence.fourth_class_date.DateDataBaseHelper4;
import com.example.attendence.foutth_exam_date.DataBaseHelperExamDate4;
import com.example.attendence.mainpage.NameCustomAdapter;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.example.attendence.nine_class.DataBaseHelper9;
import com.example.attendence.nine_class_date.DateDataBaseHelper9;
import com.example.attendence.nine_exam_date.DataBaseHelperExamDate9;
import com.example.attendence.second_class.DataBaseHelper2;
import com.example.attendence.second_class_date.DateDataBaseHelper2;
import com.example.attendence.second_exam_date.DataBaseHelperExamDate2;
import com.example.attendence.seventh_class.DataBaseHelper7;
import com.example.attendence.seventh_class_date.DateDataBaseHelper7;
import com.example.attendence.seventh_exam_date.DataBaseHelperExamDate7;
import com.example.attendence.sixth_class.DataBaseHelper6;
import com.example.attendence.sixth_class_date.DateDataBaseHelper6;
import com.example.attendence.sixth_exam_date.DataBaseHelperExamDate6;
import com.example.attendence.ten_class.DataBaseHelper10;
import com.example.attendence.ten_class_date.DateDataBaseHelper10;
import com.example.attendence.ten_exam_date.DataBaseHelperExamDate10;
import com.example.attendence.test_class.DataBaseHelper11;
import com.example.attendence.test_date.DateCustomAdapter11;
import com.example.attendence.test_date.DateDataBaseHelper11;
import com.example.attendence.test_exam_date.DataBaseHelperExamDate11;
import com.example.attendence.theme.ThemeDataBaseHelper;
import com.example.attendence.theme.ThemeNote;
import com.example.attendence.third_class.DataBaseHelper3;
import com.example.attendence.third_class_date.DateDataBaseHelper3;
import com.example.attendence.third_exam_date.DataBaseHelperExamDate3;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NoteClass> classNameList;
    NameDataBaseHelperName nameDataBaseHelperName;
    RecyclerView classNameRecyclerView;
    Toolbar toolbar;

    ThemeDataBaseHelper themeDataBaseHelper;
    LinearLayout linearLayout;
    View view;

    Button saveButton ,cancelButton;
    int colorStatus;

    private List<ThemeNote>  themeStatusData;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.mainLayoutId);





        toolbar=findViewById (R.id.toolbarId);
        if (toolbar!=null){
            setSupportActionBar (toolbar);
        }

        final DrawerLayout drawerLayout=findViewById (R.id.drawerLayoutId);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(
                MainActivity.this,drawerLayout,toolbar,R.string.open,R.string.closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText (MainActivity.this, "Open", Toast.LENGTH_SHORT).show ();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText (MainActivity.this, "Closed", Toast.LENGTH_SHORT).show ();

            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        final NavigationView navigationView=findViewById (R.id.myNavigationViewId);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId ()){
                    case R.id.aboutItemIdId:
                        break;
                    case R.id.resetAllDataItemIdId:

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                        builder2.setTitle("Do you want to delete Date?");
                        builder2.setIcon(R.drawable.ic_baseline_delete_24);
                        builder2.setMessage("\n \nPlease click Yes or No button !\n \n");
                        builder2.setPositiveButton(" Yes ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                new DataBaseHelper11(MainActivity.this).deleteAllData();
                                new DataBaseHelper10(MainActivity.this).deleteAllData();
                                new DataBaseHelper9(MainActivity.this).deleteAllData();
                                new DataBaseHelper8(MainActivity.this).deleteAllData();
                                new DataBaseHelper7(MainActivity.this).deleteAllData();
                                new DataBaseHelper6(MainActivity.this).deleteAllData();
                                new DataBaseHelper5(MainActivity.this).deleteAllData();
                                new DataBaseHelper4(MainActivity.this).deleteAllData();
                                new DataBaseHelper3(MainActivity.this).deleteAllData();
                                new DataBaseHelper2(MainActivity.this).deleteAllData();
                                new DataBaseHelper(MainActivity.this).deleteAllData();

                                new DateDataBaseHelper11(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper10(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper9(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper8(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper7(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper6(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper5(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper4(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper3(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper2(MainActivity.this).deleteAllDateData();
                                new DateDataBaseHelper(MainActivity.this).deleteAllDateData();

                               new  DataBaseHelperExamDate11(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate10(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate9(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate8(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate7(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate6(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate5(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate4(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate3(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate2(MainActivity.this).deleteAllExamDateData();
                               new DataBaseHelperExamDate1(MainActivity.this).deleteAllExamDateData();
                                Toast.makeText(MainActivity.this, "Delete All Data", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder2.setNegativeButton(" No ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder2.show();


                        break;
                    case R.id.themeItemIdId:
                        CustomAdapterForColorChange();
                        break;
                    case R.id.shareItemIdId:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.contactItemId:
                        drawerLayout.closeDrawers();
                        break;
                }
                return false;
            }
        });


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

        themeDataBaseHelper=new ThemeDataBaseHelper(MainActivity.this);
        themeDataBaseHelper.getWritableDatabase();

        themeStatusData  = new ArrayList<>();
        if (themeDataBaseHelper.getAllNotes().size()<1){
            for (int i = 0; i <=1; i++) {
                int id=themeDataBaseHelper.insertData(new ThemeNote(1));
                if (id!=0){
                    Toast.makeText(this, "success "+String.valueOf(i), Toast.LENGTH_SHORT).show();
                }
            }
        }
        themeStatusData  = new ArrayList<>();
        themeStatusData = themeDataBaseHelper.getAllNotes();

        if (themeStatusData.get(1).getThemeStatus()==1){
            linearLayout.setBackgroundColor(Color.rgb(0, 0, 0));
        }
        else if (themeStatusData.get(1).getThemeStatus()==2){
            linearLayout.setBackgroundColor(Color.rgb(50, 50, 50));
        }
        else  if (themeStatusData.get(1).getThemeStatus()==3){
            linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        else if (themeStatusData.get(1).getThemeStatus()==4){
            linearLayout.setBackgroundColor(Color.rgb(255, 0, 0));
        }
        else  if (themeStatusData.get(1).getThemeStatus()==5){
            linearLayout.setBackgroundColor(Color.rgb(0, 0, 255));
        }
        else  if (themeStatusData.get(1).getThemeStatus()==6){
            linearLayout.setBackgroundColor(Color.rgb(0, 255, 0));
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


    public void CustomAdapterForColorChange(){
        AlertDialog.Builder builder     =new AlertDialog.Builder(MainActivity.this);
        LayoutInflater layoutInflater   =LayoutInflater.from(MainActivity.this);
        final View view                       =layoutInflater.inflate(R.layout.color_change_box,null);
        builder.setView(view);
        final AlertDialog alertDialog   = builder.create();
        saveButton=view.findViewById(R.id.colorOkButtonId);
        cancelButton=view.findViewById(R.id.colorCancelButtonId);

        final RadioGroup radio =view.findViewById(R.id.radioGroupId);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radio.findViewById(checkedId);
                int index = radio.indexOfChild(radioButton);
                switch (index){
                    case 0:
                        colorStatus=1;
                        break;
                    case 1:
                        colorStatus=2;
                        break;
                    case 2:
                        colorStatus=3;
                        break;
                    case 3:
                        colorStatus=4;
                        break;
                    case 4:
                        colorStatus=5;

                        break;
                    case 5:
                        colorStatus=6;
                        break;
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int id=themeDataBaseHelper.updateThemeData(new ThemeNote(1,colorStatus));
                if (id==1){
                    if (colorStatus==1){
                        linearLayout.setBackgroundColor(Color.rgb(0, 0, 0));
                    }
                    else if (colorStatus==2){
                        linearLayout.setBackgroundColor(Color.rgb(50, 50, 50));
                    }
                    else  if (colorStatus==3){
                        linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));
                    }
                    else if (colorStatus==4){
                        linearLayout.setBackgroundColor(Color.rgb(255, 0, 0));
                    }
                    else  if (colorStatus==5){
                        linearLayout.setBackgroundColor(Color.rgb(0, 0, 255));
                    }
                    else  if (colorStatus==6){
                        linearLayout.setBackgroundColor(Color.rgb(0, 255, 0));
                    }
                    Toast.makeText(getApplicationContext(), "update success", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "update fail", Toast.LENGTH_LONG).show();
                }




        alertDialog.dismiss();
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