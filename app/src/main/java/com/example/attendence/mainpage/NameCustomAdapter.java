package com.example.attendence.mainpage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.Eight_Class;
import com.example.attendence.ElevenClass;
import com.example.attendence.Fifth_Class;
import com.example.attendence.First_Class;
import com.example.attendence.Fourth_Class;
import com.example.attendence.Nine_Class;
import com.example.attendence.R;
import com.example.attendence.SecondClass;
import com.example.attendence.Seventh_Class;
import com.example.attendence.Sixth_Class;
import com.example.attendence.Ten_Class;
import com.example.attendence.ThirdClass;
import com.example.attendence.common.DateNote;
import com.example.attendence.eight_class_date.DateDataBaseHelper8;

import java.util.Collection;
import java.util.List;

public class NameCustomAdapter extends RecyclerView.Adapter<NameCustomAdapter.MyViewHolder> {
    Button saveButton,cancelButton;

    EditText classNameEditText;


    Context context;
    private List<NoteClass> allClassName;
    NameDataBaseHelperName nameDataBaseHelperName;

    public NameCustomAdapter(Context context, List<NoteClass> allClassName) {
        this.context = context;
        this.allClassName = allClassName;
        nameDataBaseHelperName=new NameDataBaseHelperName(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.class_name_item,parent,false);
        nameDataBaseHelperName=new NameDataBaseHelperName(context);
        return new NameCustomAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nameTextView.setText(allClassName.get(position).getClassName());
        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if(position==0){
                    intent=new Intent(context, First_Class.class);
                }
                else if(position==1){
                    intent=new Intent(context, SecondClass.class);
                }
                else if(position==2){
                    intent=new Intent(context, ThirdClass.class);
                }
                else if(position==3){
                   intent=new Intent(context, Fourth_Class.class);
                }
                else if(position==4){
                   intent=new Intent(context, Fifth_Class.class);
                }
                else if(position==5){
                   intent=new Intent(context, Sixth_Class.class);
                }
                else if(position==6){
                   intent=new Intent(context, Seventh_Class.class);
                }
                else if(position==7){
                    intent=new Intent(context, Eight_Class.class);
                }
                else if(position==8){
                    intent=new Intent(context, Nine_Class.class);
                }
                else if(position==9){
                    intent=new Intent(context, Ten_Class.class);
                }
                else if(position==10){
                    intent=new Intent(context, ElevenClass.class);
                }



                context.startActivity(intent);
            }
        });

        holder.editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog(position);
            }
        });








    }

    @Override
    public int getItemCount() {
        return allClassName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView editImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.classNameTextViewId);
            editImageView=itemView.findViewById(R.id.editImageViewId);
        }
    }
//
    private void customDialog(final int position) {
        androidx.appcompat.app.AlertDialog.Builder builder  = new androidx.appcompat.app.AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.class_name_input_box,null);

        builder.setView(view);

        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();


        saveButton=view.findViewById(R.id.saveButtonId);
        cancelButton=view.findViewById(R.id.cancelButtonId);
        classNameEditText=view.findViewById(R.id.dateEditTextId);

        classNameEditText.setText(allClassName.get(position).getClassName());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classNameEditText.getText().toString().isEmpty()){
                    classNameEditText.setError("Enter a Name");
                }
                else {
                    String className=classNameEditText.getText().toString();
                 int id =nameDataBaseHelperName.updateData(new NoteClass(allClassName.get(position).getId(),className));
                    if (id==1){
                        Toast.makeText(context, "update Success", Toast.LENGTH_SHORT).show();
                        allClassName.clear();
                        allClassName.addAll((Collection<? extends NoteClass>) nameDataBaseHelperName.getAllNotes());
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
