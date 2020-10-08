package com.example.attendence.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.R;


import java.util.List;

public class ExamCustomAdapter extends RecyclerView.Adapter<ExamCustomAdapter.MyViewHolder> {
    Context context;
    private List<Notes2> allName;
    DataBaseHelper11 dataBaseHelper;

    public ExamCustomAdapter(Context context, List<Notes2> allName) {
        this.context = context;
        this.allName = allName;
        dataBaseHelper=new DataBaseHelper11(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item2,parent,false);
        dataBaseHelper=new DataBaseHelper11(context);
        return new ExamCustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTextView.setText(allName.get(position).getStudentName());
    }

    @Override
    public int getItemCount() {
        return allName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView=itemView.findViewById(R.id.nameTextVIewId);
        }
    }


}
