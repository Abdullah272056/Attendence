package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addButton,addButton2,addButton3,addButton4,addButton5,addButton6,addButton7,addButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton=findViewById(R.id.addButtonId);
        addButton2=findViewById(R.id.addButtonId2);
        addButton3=findViewById(R.id.addButtonId3);
        addButton4=findViewById(R.id.addButtonId4);
        addButton5=findViewById(R.id.addButtonId5);
        addButton6=findViewById(R.id.addButtonId6);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,SecondClass.class);
                startActivity(intent);
            }
        });

        addButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,ThirdClass.class);
                startActivity(intent);
            }
        });

        addButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,Fourth_Class.class);
                startActivity(intent);
            }
        });

        addButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,Fifth_Class.class);
                startActivity(intent);
            }
        });

        addButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,Sixth_Class.class);
                startActivity(intent);
            }
        });


    }
}