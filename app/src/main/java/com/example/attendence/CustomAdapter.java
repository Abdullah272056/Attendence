package com.example.attendence;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Context context;
    private List<Notes> allNotes;
    List<Notes> copyAllNotes;
    private DataBaseHelper databaseHelper;

    public CustomAdapter(Context context, List<Notes> allNotes){
        this.context = context;
        this.allNotes = allNotes;
        databaseHelper=new DataBaseHelper(context);
        copyAllNotes = new ArrayList<>(allNotes);
        //for searchView//dataList's copy
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.nameTextView.setText(allNotes.get(position).getStudentName());

        

    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        CheckBox checkBox1,checkBox2,checkBox3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.nameTextVIewId);
            checkBox1=itemView.findViewById(R.id.checkbox1);
            checkBox2=itemView.findViewById(R.id.checkbox2);
            checkBox3=itemView.findViewById(R.id.checkbox3);

        }
    }
}
