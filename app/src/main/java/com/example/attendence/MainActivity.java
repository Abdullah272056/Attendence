package com.example.attendence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.attendence.mainpage.NameCustomAdapter;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.example.attendence.theme.ThemeDataBaseHelper;
import com.example.attendence.theme.ThemeNote;
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

    List<ThemeNote>  themeStatusData;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout=findViewById(R.id.mainLayoutId);
        themeDataBaseHelper=new ThemeDataBaseHelper(MainActivity.this);
        themeDataBaseHelper.getWritableDatabase();

         themeStatusData  = new ArrayList<>();
       themeStatusData = themeDataBaseHelper.getAllNotes();

        if (themeStatusData.size()<1){
            for (int i = 1; i <=1; i++) {
                int id=themeDataBaseHelper.insertData(new ThemeNote(1));
                if (id!=0){
                    Toast.makeText(this, "success "+String.valueOf(i), Toast.LENGTH_SHORT).show();
                }
            }
        }


        if (themeStatusData.get(0).getThemeStatus()==1){
            Toast.makeText(this, "theme change", Toast.LENGTH_SHORT).show();
            linearLayout.setBackgroundColor(Color.rgb(0, 0, 0));
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
        //Changing Navigation Drawer Icon (Burger Button) on Actionbar
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        final NavigationView navigationView=findViewById (R.id.myNavigationViewId);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId ()){
                    case R.id.locationId:
                       // drawerLayout.closeDrawers();
                        //Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //startActivity(intent);
                        //Toast.makeText (MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.editID:
                        //drawerLayout.closeDrawers();
                        int id1 = themeDataBaseHelper.updateThemeData(new ThemeNote(1,3));
                        Toast.makeText (MainActivity.this, String.valueOf(id1), Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.colorizeId:
                        drawerLayout.closeDrawers();
                        CustomAdapterForColorChange();
                        break;
                    case R.id.shareId:
                        drawerLayout.closeDrawers();
                        Toast.makeText (MainActivity.this, item.getTitle (), Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.mailId:
                        drawerLayout.closeDrawers();
                        Toast.makeText (MainActivity.this, item.getTitle (), Toast.LENGTH_SHORT).show ();
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