package com.example.attendence.eleven_date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.R;
import com.example.attendence.common.DateNote;

import java.util.Collection;
import java.util.List;

public class DateCustomAdapter11 extends RecyclerView.Adapter<DateCustomAdapter11.MyViewHolder> {
    Button saveButton,cancelButton;

    EditText dateEditText;


    Context context;
    private List<DateNote> allDate;
    DateDataBaseHelper11 dateDataBaseHelper;

    public DateCustomAdapter11(Context context, List<DateNote> allDate) {
        this.context = context;
        this.allDate = allDate;
        dateDataBaseHelper=new DateDataBaseHelper11(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.date_box,parent,false);
        dateDataBaseHelper=new DateDataBaseHelper11(context);
        return new DateCustomAdapter11.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.dateTextView.setText(allDate.get(position).getDate());

        holder.dateTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder  = new androidx.appcompat.app.AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_operation,null);

                builder.setView(view);

                final androidx.appcompat.app.AlertDialog alertDialog = builder.create();

                TextView updateTextView=view.findViewById(R.id.updateTextViewId);
                TextView deleteTextView=view.findViewById(R.id.deleteTextViewId);
                TextView cancelTextView=view.findViewById(R.id.cancelTextViewId);

                updateTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                      customDialog(position);
                        alertDialog.dismiss();

                    }
                });

                deleteTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int status = dateDataBaseHelper.deleteDate(allDate.get(position).getId());

                        if (status == 1){
                            allDate.remove(allDate.get(position));
                            alertDialog.dismiss();
                            notifyDataSetChanged();
                        }else {
                        }
                    }
                });

                cancelTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();

                    }
                });



                alertDialog.show();
                return false;
            }
        });
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

    private void customDialog(final int position) {androidx.appcompat.app.AlertDialog.Builder builder  = new androidx.appcompat.app.AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.date_input,null);

        builder.setView(view);

        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();


        saveButton=view.findViewById(R.id.saveButtonId);
        cancelButton=view.findViewById(R.id.cancelButtonId);
        dateEditText=view.findViewById(R.id.dateEditTextId);

        dateEditText.setText(allDate.get(position).getDate());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dateEditText.getText().toString().isEmpty()){
                    dateEditText.setError("Enter a Name");
                }
                else {
                    String date=dateEditText.getText().toString();
                 int id =dateDataBaseHelper.updateData(new DateNote(allDate.get(position).getId(),date));
                    if (id==1){
                        Toast.makeText(context, "update Success", Toast.LENGTH_SHORT).show();
                        allDate.clear();
                        allDate.addAll((Collection<? extends DateNote>) dateDataBaseHelper.getAllNotes());
                        notifyDataSetChanged();
                        alertDialog.dismiss();

                    }else {
                        Toast.makeText(context, "update fail", Toast.LENGTH_SHORT).show();
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

}
