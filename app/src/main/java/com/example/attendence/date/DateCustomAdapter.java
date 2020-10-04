package com.example.attendence.date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.R;

import java.util.List;

public class DateCustomAdapter extends RecyclerView.Adapter<DateCustomAdapter.MyViewHolder> {
    Context context;
    private List<DateNote> allDate;

    public DateCustomAdapter(Context context, List<DateNote> allDate) {
        this.context = context;
        this.allDate = allDate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.date_box,parent,false);
        return new DateCustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dateTextView.setText(allDate.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return allDate.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView=itemView.findViewById(R.id.dateTextViewId);
        }
    }
}
