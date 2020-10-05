package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addButton,addButton2,addButton3,addButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton=findViewById(R.id.addButtonId);
        addButton2=findViewById(R.id.addButtonId2);
        addButton3=findViewById(R.id.addButtonId3);
        addButton4=findViewById(R.id.addButtonId4);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
                //CustomAdapter();

            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent=new Intent(MainActivity.this,SecondClass.class);
                startActivity(intent);
                //CustomAdapter();

            }
        });
        addButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent=new Intent(MainActivity.this,ThirdClass.class);
                startActivity(intent);
                //CustomAdapter();

            }
        });
        addButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent intent=new Intent(MainActivity.this,Fourth_Class.class);
                startActivity(intent);
                //CustomAdapter();

            }
        });


    }
}