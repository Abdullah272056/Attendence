package com.example.attendence.second_class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.common.Notes;
import com.example.attendence.R;
import com.example.attendence.first_class.DataBaseHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder>{
    Button saveButton,cancelButton;
    EditText nameEditText;

    Context context;
    private List<Notes> allNotes;

    List<Notes> copyAllNotes;
    private DataBaseHelper2 databaseHelper;

    int checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
            checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
            checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
            checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30;

    public CustomAdapter2(Context context, List<Notes> allNotes){
        this.context = context;
        this.allNotes = allNotes;
        databaseHelper=new DataBaseHelper2(context);
        copyAllNotes = new ArrayList<>(allNotes);
        //for searchView//dataList's copy
    }

    @NonNull
    @Override
    public CustomAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item,parent,false);

        databaseHelper=new DataBaseHelper2(context);
        return new CustomAdapter2.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.MyViewHolder holder, final int position){

        holder.nameTextView.setOnLongClickListener(new View.OnLongClickListener() {
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
                        customDialog(position);
                        alertDialog.dismiss();

                    }
                });

                deleteTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int status = databaseHelper.deleteData(allNotes.get(position).getId());
                        if (status == 1){
                            allNotes.remove(allNotes.get(position));
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
        if (checkBox1==0){
            holder.checkBox1.setChecked(false);
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

        if (checkBox4==1){
            holder.checkBox4.setChecked(true);
        }
        if (checkBox4==0){
            holder.checkBox4.setChecked(false);
        }

        if (checkBox5==1){
            holder.checkBox5.setChecked(true);
        }
        if (checkBox5==0){
            holder.checkBox5.setChecked(false);
        }

        if (checkBox6==1){
            holder.checkBox6.setChecked(true);
        }
        if (checkBox6==0){
            holder.checkBox6.setChecked(false);
        }

        if (checkBox7==1){
            holder.checkBox7.setChecked(true);
        }
        if (checkBox7==0){
            holder.checkBox7.setChecked(false);
        }

        if (checkBox8==1){
            holder.checkBox8.setChecked(true);
        }
        if (checkBox8==0){
            holder.checkBox8.setChecked(false);
        }

        if (checkBox9==1){
            holder.checkBox9.setChecked(true);
        }
        if (checkBox9==0){
            holder.checkBox9.setChecked(false);
        }

        if (checkBox10==1){
            holder.checkBox10.setChecked(true);
        }
        if (checkBox10==0){
            holder.checkBox10.setChecked(false);
        }

        if (checkBox11==1){
            holder.checkBox11.setChecked(true);
        }
        if (checkBox11==0){
            holder.checkBox11.setChecked(false);
        }

        if (checkBox12==1){
            holder.checkBox12.setChecked(true);
        }
        if (checkBox12==0){
            holder.checkBox12.setChecked(false);
        }

        if (checkBox13==1){
            holder.checkBox13.setChecked(true);
        }
        if (checkBox13==0){
            holder.checkBox13.setChecked(false);
        }

        if (checkBox14==1){
            holder.checkBox14.setChecked(true);
        }
        if (checkBox14==0){
            holder.checkBox14.setChecked(false);
        }

        if (checkBox15==1){
            holder.checkBox15.setChecked(true);
        }
        if (checkBox15==0){
            holder.checkBox15.setChecked(false);
        }

        if (checkBox16==1){
            holder.checkBox16.setChecked(true);
        }
        if (checkBox16==0){
            holder.checkBox16.setChecked(false);
        }

        if (checkBox17==1){
            holder.checkBox17.setChecked(true);
        }
        if (checkBox17==0){
            holder.checkBox17.setChecked(false);
        }

        if (checkBox18==1){
            holder.checkBox18.setChecked(true);
        }
        if (checkBox18==0){
            holder.checkBox18.setChecked(false);
        }

        if (checkBox19==1){
            holder.checkBox19.setChecked(true);
        }
        if (checkBox19==0){
            holder.checkBox19.setChecked(false);
        }

        if (checkBox20==1){
            holder.checkBox20.setChecked(true);
        }
        if (checkBox20==0){
            holder.checkBox20.setChecked(false);
        }


        if (checkBox21==1){
            holder.checkBox21.setChecked(true);
        }
        if (checkBox21==0){
            holder.checkBox21.setChecked(false);

        }

        if (checkBox22==1){
            holder.checkBox22.setChecked(true);
        }
        if (checkBox22==0){
            holder.checkBox22.setChecked(false);
        }

        if (checkBox23==1){
            holder.checkBox23.setChecked(true);
        }
        if (checkBox23==0){
            holder.checkBox23.setChecked(false);
        }

        if (checkBox24==1){
            holder.checkBox24.setChecked(true);
        }
        if (checkBox24==0){
            holder.checkBox24.setChecked(false);
        }

        if (checkBox25==1){
            holder.checkBox25.setChecked(true);
        }
        if (checkBox25==0){
            holder.checkBox25.setChecked(false);
        }

        if (checkBox26==1){
            holder.checkBox26.setChecked(true);
        }
        if (checkBox26==0){
            holder.checkBox26.setChecked(false);
        }

        if (checkBox27==1){
            holder.checkBox27.setChecked(true);
        }
        if (checkBox27==0){
            holder.checkBox27.setChecked(false);
        }

        if (checkBox28==1){
            holder.checkBox28.setChecked(true);
        }
        if (checkBox28==0){
            holder.checkBox28.setChecked(false);
        }

        if (checkBox29==1){
            holder.checkBox29.setChecked(true);
        }
        if (checkBox29==0){
            holder.checkBox29.setChecked(false);
        }

        if (checkBox30==1){
            holder.checkBox30.setChecked(true);
        }
        if (checkBox30==0){
            holder.checkBox30.setChecked(false);
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
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),1,
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
                    Uncheck(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),0,
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
                            allNotes.get(position).getCheckBox3(),1,allNotes.get(position).getCheckBox5(),
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
                            allNotes.get(position).getCheckBox3(),0,allNotes.get(position).getCheckBox5(),
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


        holder.checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),1,
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
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),0,
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


        holder.checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            1,allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
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
                            0,allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
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


        holder.checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),1,allNotes.get(position).getCheckBox8(),
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
                            allNotes.get(position).getCheckBox6(),0,allNotes.get(position).getCheckBox8(),
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



        holder.checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),1,
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
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),0,
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


        holder.checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            1,allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
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
                            0,allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
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


        holder.checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),1,allNotes.get(position).getCheckBox11(),
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
                            allNotes.get(position).getCheckBox9(),0,allNotes.get(position).getCheckBox11(),
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


        holder.checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),1,
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
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),0,
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


        holder.checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            1,allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
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
                            0,allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
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


        holder.checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),1,allNotes.get(position).getCheckBox14(),
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
                            allNotes.get(position).getCheckBox12(),0,allNotes.get(position).getCheckBox14(),
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


        holder.checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),1,
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
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),0,
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


        holder.checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            1,allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
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
                            0,allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),1,allNotes.get(position).getCheckBox17(),
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
                            allNotes.get(position).getCheckBox15(),0,allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),1,
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
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),0,
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            1,allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
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
                            0,allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),1,allNotes.get(position).getCheckBox20(),
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
                            allNotes.get(position).getCheckBox18(),0,allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Check(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),1,
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
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),0,
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            1,allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
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
                            0,allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });


        holder.checkBox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox21(),1,allNotes.get(position).getCheckBox23(),
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
                            allNotes.get(position).getCheckBox21(),0,allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });
        //
        holder.checkBox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),1,
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
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),0,
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            1,allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
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
                            0,allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox24(),1,allNotes.get(position).getCheckBox26(),
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
                            allNotes.get(position).getCheckBox24(),0,allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),1,
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
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),0,
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            1,allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
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
                            0,allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });
        holder.checkBox28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox27(),1,allNotes.get(position).getCheckBox29(),
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
                            allNotes.get(position).getCheckBox27(),0,allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),1,
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
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),0,
                            allNotes.get(position).getCheckBox30(),allNotes.get(position).getStudentName()
                    );
                }
            }
        });

        holder.checkBox30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                            1,allNotes.get(position).getStudentName()
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
                            0,allNotes.get(position).getStudentName()
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


    private void customDialog(final int position) {androidx.appcompat.app.AlertDialog.Builder builder  = new androidx.appcompat.app.AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.input,null);

        builder.setView(view);

        final androidx.appcompat.app.AlertDialog alertDialog = builder.create();


        saveButton=view.findViewById(R.id.saveButtonId);
        cancelButton=view.findViewById(R.id.cancelButtonId);
        nameEditText=view.findViewById(R.id.nameEditTextId);

        nameEditText.setText(allNotes.get(position).getStudentName());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEditText.getText().toString().isEmpty()){
                    nameEditText.setError("Enter a Name");
                }
                else {
                    String studentName=nameEditText.getText().toString();
                    int id=databaseHelper.updateData(new Notes(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),studentName));
                    if (id==1){
                        Toast.makeText(context, "insert Success", Toast.LENGTH_SHORT).show();
                        allNotes.clear();
                        allNotes.addAll((Collection<? extends Notes>) databaseHelper.getAllNotes());
                        notifyDataSetChanged();
                        alertDialog.dismiss();

                    }else {
                        Toast.makeText(context, "insert fail", Toast.LENGTH_SHORT).show();
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
