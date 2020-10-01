package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addButton;

    CustomAdapter  customAdapter;

    Button saveButton,cancelButton;
    EditText nameEditText;
    DataBaseHelper dataBaseHelper;

    private List<Notes> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper=new DataBaseHelper(MainActivity.this);
        dataBaseHelper.getWritableDatabase();


        recyclerView=findViewById(R.id.recyclerViewId);
        addButton=findViewById(R.id.addButtonId);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAdapter();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        loadData();


    }


    private void loadData(){
        dataList  = new ArrayList<>();
        dataList = dataBaseHelper.getAllNotes();
        if (dataList.size() > 0){
            customAdapter = new CustomAdapter(MainActivity.this,dataList);
            recyclerView.setAdapter(customAdapter);
            customAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    public void CustomAdapter(){


        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
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
                    int id=dataBaseHelper.insertData(new Notes(studentName ));
                    if (id!=-1){
                        Toast.makeText(MainActivity.this, "insert Success", Toast.LENGTH_SHORT).show();
                        loadData();
                        bottomSheetDialog.dismiss();

                    }else {
                        Toast.makeText(MainActivity.this, "insert fail", Toast.LENGTH_SHORT).show();
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
}