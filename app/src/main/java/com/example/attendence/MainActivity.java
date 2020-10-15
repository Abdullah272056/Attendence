package com.example.attendence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.attendence.mainpage.NameCustomAdapter;
import com.example.attendence.mainpage.NameDataBaseHelperName;
import com.example.attendence.mainpage.NoteClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NoteClass> classNameList;

    RecyclerView classNameRecyclerView;
    NameDataBaseHelperName nameDataBaseHelperName;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                        drawerLayout.closeDrawers();
                        //Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        //startActivity(intent);

                        Toast.makeText (MainActivity.this, item.getTitle (), Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.editID:
                        drawerLayout.closeDrawers();
                        Toast.makeText (MainActivity.this, item.getTitle (), Toast.LENGTH_SHORT).show ();
                        break;
                    case R.id.colorizeId:
                        drawerLayout.closeDrawers();
                        Toast.makeText (MainActivity.this, item.getTitle (), Toast.LENGTH_SHORT).show ();
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


}