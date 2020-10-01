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

    int checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
            checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
            checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
            checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position){

        holder.nameTextView.setText(allNotes.get(position).getStudentName());
        checkBox1=allNotes.get(position).getCheckBox1();
        checkBox2=allNotes.get(position).getCheckBox2();
        checkBox3=allNotes.get(position).getCheckBox3();
        checkBox4=allNotes.get(position).getCheckBox4();
        checkBox5=allNotes.get(position).getCheckBox5();
        checkBox6=allNotes.get(position).getCheckBox6();
        checkBox7=allNotes.get(position).getCheckBox7();
        checkBox8=allNotes.get(position).getCheckBox8();
        checkBox9=allNotes.get(position).getCheckBox9();
        checkBox10=allNotes.get(position).getCheckBox10();

        checkBox11=allNotes.get(position).getCheckBox11();
        checkBox12=allNotes.get(position).getCheckBox12();
        checkBox13=allNotes.get(position).getCheckBox13();
        checkBox14=allNotes.get(position).getCheckBox14();
        checkBox15=allNotes.get(position).getCheckBox15();
        checkBox16=allNotes.get(position).getCheckBox16();
        checkBox17=allNotes.get(position).getCheckBox17();
        checkBox18=allNotes.get(position).getCheckBox18();
        checkBox19=allNotes.get(position).getCheckBox19();
        checkBox20=allNotes.get(position).getCheckBox20();

        checkBox21=allNotes.get(position).getCheckBox21();
        checkBox22=allNotes.get(position).getCheckBox22();
        checkBox23=allNotes.get(position).getCheckBox23();
        checkBox24=allNotes.get(position).getCheckBox24();
        checkBox25=allNotes.get(position).getCheckBox25();
        checkBox26=allNotes.get(position).getCheckBox26();
        checkBox27=allNotes.get(position).getCheckBox27();
        checkBox28=allNotes.get(position).getCheckBox28();
        checkBox29=allNotes.get(position).getCheckBox29();
        checkBox30=allNotes.get(position).getCheckBox30();

        if (checkBox1==1){
            holder.checkBox1.setChecked(true);
        }
        else if (checkBox1==0){
            holder.checkBox1.setChecked(false);
        }else {

        }


        if (checkBox2==1){
            holder.checkBox2.setChecked(true);
        }
        if (checkBox2==0){
            holder.checkBox2.setChecked(false);
        }


        if (checkBox3==1){
            holder.checkBox3.setChecked(true);
        }
        if (checkBox3==0){
            holder.checkBox3.setChecked(false);
        }


        holder.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                   Check(allNotes.get(position).getId(),1,allNotes.get(position).getCheckBox2(),
                           allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                   allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                           allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                           allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                           allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                           allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                           allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                           allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                           allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                           allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                           );
                }
                else {
                    Uncheck(allNotes.get(position).getId(),0,allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });
        holder.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox2(),1,
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
                else {
                    Uncheck(allNotes.get(position).getId(),allNotes.get(position).getCheckBox2(),0,
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            1,allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
                else {
                    Uncheck(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            0,allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });
        holder.checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
                else {
                    Uncheck(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
                checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
                checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.nameTextVIewId);
            checkBox1=itemView.findViewById(R.id.checkbox1);
            checkBox2=itemView.findViewById(R.id.checkbox2);
            checkBox3=itemView.findViewById(R.id.checkbox3);
            checkBox4=itemView.findViewById(R.id.checkbox4);
            checkBox5=itemView.findViewById(R.id.checkbox5);
            checkBox6=itemView.findViewById(R.id.checkbox6);
            checkBox7=itemView.findViewById(R.id.checkbox7);
            checkBox8=itemView.findViewById(R.id.checkbox8);
            checkBox9=itemView.findViewById(R.id.checkbox9);
            checkBox10=itemView.findViewById(R.id.checkbox10);
            checkBox11=itemView.findViewById(R.id.checkbox11);
            checkBox12=itemView.findViewById(R.id.checkbox12);
            checkBox13=itemView.findViewById(R.id.checkbox13);
            checkBox14=itemView.findViewById(R.id.checkbox14);
            checkBox15=itemView.findViewById(R.id.checkbox15);
            checkBox16=itemView.findViewById(R.id.checkbox16);
            checkBox17=itemView.findViewById(R.id.checkbox17);
            checkBox18=itemView.findViewById(R.id.checkbox18);
            checkBox19=itemView.findViewById(R.id.checkbox19);
            checkBox20=itemView.findViewById(R.id.checkbox20);
            checkBox21=itemView.findViewById(R.id.checkbox21);
            checkBox22=itemView.findViewById(R.id.checkbox22);
            checkBox23=itemView.findViewById(R.id.checkbox23);
            checkBox24=itemView.findViewById(R.id.checkbox24);
            checkBox25=itemView.findViewById(R.id.checkbox25);
            checkBox26=itemView.findViewById(R.id.checkbox26);
            checkBox27=itemView.findViewById(R.id.checkbox27);
            checkBox28=itemView.findViewById(R.id.checkbox28);
            checkBox29=itemView.findViewById(R.id.checkbox29);
            checkBox30=itemView.findViewById(R.id.checkbox30);

        }

    }

    public void Uncheck(int id, int checkBox1,int checkBox2,int checkBox3,int checkBox4,int checkBox5,
                        int checkBox6, int checkBox7,int checkBox8, int checkBox9,int checkBox10,
                        int checkBox11,int checkBox12,int checkBox13, int checkBox14,int checkBox15,
                        int checkBox16,int checkBox17,int checkBox18,int checkBox19,int checkBox20,
                        int checkBox21,int checkBox22,int checkBox23,int checkBox24,int checkBox25,
                        int checkBox26,int checkBox27,int checkBox28, int checkBox29,int checkBox30,
                        String name){

        int status = databaseHelper.updateData(new Notes(id,
                checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
                checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
                checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,name
        ));
        if (status==1){
            allNotes.clear();
            allNotes.addAll(databaseHelper.getAllNotes());
            //notifyDataSetChanged();
            Toast.makeText(context, "uncheck successful", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "uncheck fail", Toast.LENGTH_SHORT).show();
        }
    }


    public void Check(
            int id, int checkBox1,int checkBox2,int checkBox3,int checkBox4,int checkBox5,
            int checkBox6, int checkBox7,int checkBox8, int checkBox9,int checkBox10,
            int checkBox11,int checkBox12,int checkBox13, int checkBox14,int checkBox15,
            int checkBox16,int checkBox17,int checkBox18,int checkBox19,int checkBox20,
            int checkBox21,int checkBox22,int checkBox23,int checkBox24,int checkBox25,
            int checkBox26,int checkBox27,int checkBox28, int checkBox29,int checkBox30,
            String name
    ){
        int status = databaseHelper.updateData(new Notes(id,
                checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
                checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
                checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,name
        ));
        if (status==1){
            allNotes.clear();
            allNotes.addAll(databaseHelper.getAllNotes());
            // notifyDataSetChanged();
            Toast.makeText(context, "check successful", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "check fail", Toast.LENGTH_SHORT).show();
        }
    }



}
