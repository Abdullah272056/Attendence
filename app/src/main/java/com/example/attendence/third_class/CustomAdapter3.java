package com.example.attendence.third_class;

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

import com.example.attendence.R;
import com.example.attendence.SecondClass;
import com.example.attendence.ThirdClass;
import com.example.attendence.common.Notes2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.MyViewHolder>{
    Button saveButton,cancelButton;
    EditText nameEditText;

    Context context;
    private List<Notes2> allNotes;

    List<Notes2> copyAllNotes;
    private DataBaseHelper3 databaseHelper;

    int checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
            checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,
            checkBox16, checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,
            checkBox23, checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,
            checkBox30, checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,
            checkBox37, checkBox38, checkBox39,checkBox40,checkBox41,checkBox42,checkBox43,
            checkBox44, checkBox45;
    int checkBoxCount;

    public CustomAdapter3(Context context, List<Notes2> allNotes){
        this.context = context;
        this.allNotes = allNotes;
        databaseHelper=new DataBaseHelper3(context);
        copyAllNotes = new ArrayList<Notes2>(allNotes);
        //for searchView//dataList's copy
    }

    @NonNull
    @Override
    public CustomAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.present_recyclerview_item,parent,false);

        databaseHelper=new DataBaseHelper3(context);
        return new CustomAdapter3.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter3.MyViewHolder holder, final int position){
        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.valueOf(allNotes.get(position).getCheckBoxCount()), Toast.LENGTH_SHORT).show();
            }
        });
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
                            ((ThirdClass)context).loadStudentInformationData();

                           // notifyDataSetChanged();
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

        checkBox31=allNotes.get(position).getCheckBox31();
        checkBox32=allNotes.get(position).getCheckBox32();
        checkBox33=allNotes.get(position).getCheckBox33();
        checkBox34=allNotes.get(position).getCheckBox34();
        checkBox35=allNotes.get(position).getCheckBox35();
        checkBox36=allNotes.get(position).getCheckBox36();
        checkBox37=allNotes.get(position).getCheckBox37();
        checkBox38=allNotes.get(position).getCheckBox38();
        checkBox39=allNotes.get(position).getCheckBox39();
        checkBox40=allNotes.get(position).getCheckBox40();

        checkBox41=allNotes.get(position).getCheckBox41();
        checkBox42=allNotes.get(position).getCheckBox42();
        checkBox43=allNotes.get(position).getCheckBox43();
        checkBox44=allNotes.get(position).getCheckBox44();
        checkBox45=allNotes.get(position).getCheckBox45();

        checkBoxCount=allNotes.get(position).getCheckBoxCount();

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

        if (checkBox31==1){
            holder.checkBox31.setChecked(true);
        }
        if (checkBox31==0){
            holder.checkBox31.setChecked(false);
        }

        if (checkBox32==1){
            holder.checkBox32.setChecked(true);
        }
        if (checkBox32==0){
            holder.checkBox32.setChecked(false);
        }

        if (checkBox33==1){
            holder.checkBox33.setChecked(true);
        }
        if (checkBox33==0){
            holder.checkBox33.setChecked(false);
        }

        if (checkBox34==1){
            holder.checkBox34.setChecked(true);
        }
        if (checkBox34==0){
            holder.checkBox34.setChecked(false);
        }

        if (checkBox35==1){
            holder.checkBox35.setChecked(true);
        }
        if (checkBox35==0){
            holder.checkBox35.setChecked(false);
        }

        if (checkBox36==1){
            holder.checkBox36.setChecked(true);
        }
        if (checkBox36==0){
            holder.checkBox36.setChecked(false);
        }

        if (checkBox37==1){
            holder.checkBox37.setChecked(true);
        }
        if (checkBox37==0){
            holder.checkBox37.setChecked(false);
        }

        if (checkBox38==1){
            holder.checkBox38.setChecked(true);
        }
        if (checkBox38==0){
            holder.checkBox38.setChecked(false);
        }

        if (checkBox39==1){
            holder.checkBox39.setChecked(true);
        }
        if (checkBox39==0){
            holder.checkBox39.setChecked(false);
        }

        if (checkBox40==1){
            holder.checkBox40.setChecked(true);
        }
        if (checkBox40==0){
            holder.checkBox40.setChecked(false);
        }

        if (checkBox41==1){
            holder.checkBox41.setChecked(true);
        }
        if (checkBox41==0){
            holder.checkBox41.setChecked(false);
        }

        if (checkBox42==1){
            holder.checkBox42.setChecked(true);
        }
        if (checkBox42==0){
            holder.checkBox42.setChecked(false);
        }

        if (checkBox43==1){
            holder.checkBox43.setChecked(true);
        }
        if (checkBox43==0){
            holder.checkBox43.setChecked(false);
        }

        if (checkBox44==1){
            holder.checkBox44.setChecked(true);
        }
        if (checkBox44==0){
            holder.checkBox44.setChecked(false);
        }


        if (checkBox45==1){
            holder.checkBox45.setChecked(true);
        }
        if (checkBox45==0){
            holder.checkBox45.setChecked(false);
        }




        holder.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName(),
                            allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3(),
                            allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6(),
                            allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });



        holder.checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45()
                            ,checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName() ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),

                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });


        holder.checkBox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });
        //
        holder.checkBox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });
        holder.checkBox28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            1,
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            0,
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });





        holder.checkBox31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            1,allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                           0,allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),1, allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),0, allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), 1,
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), 0,
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            1, allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            0, allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), 1,allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), 0,allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),1,
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),0,
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox37.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            1, allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            0, allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox38.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), 1, allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), 0, allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), 1,
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), 0,
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                          1, allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            0, allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox41.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), 1, allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), 0, allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), 1,
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), 0,
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox43.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            1, allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            0, allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), 1, allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), 0, allNotes.get(position).getCheckBox45(),
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
            }
        });

        holder.checkBox45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount++;

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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), 1,
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    );
                }
                else {
                    checkBoxCount=allNotes.get(position).getCheckBoxCount();
                    checkBoxCount--;
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
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(),0,
                            checkBoxCount,allNotes.get(position).getStudentName()
                            ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
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
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,
                checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,
                checkBox37, checkBox38, checkBox39,checkBox40,checkBox41,checkBox42,checkBox43,
                checkBox44, checkBox45;;

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

            checkBox31=itemView.findViewById(R.id.checkbox31);
            checkBox32=itemView.findViewById(R.id.checkbox32);
            checkBox33=itemView.findViewById(R.id.checkbox33);
            checkBox34=itemView.findViewById(R.id.checkbox34);
            checkBox35=itemView.findViewById(R.id.checkbox35);
            checkBox36=itemView.findViewById(R.id.checkbox36);
            checkBox37=itemView.findViewById(R.id.checkbox37);
            checkBox38=itemView.findViewById(R.id.checkbox38);
            checkBox39=itemView.findViewById(R.id.checkbox39);
            checkBox40=itemView.findViewById(R.id.checkbox40);
            checkBox41=itemView.findViewById(R.id.checkbox41);
            checkBox42=itemView.findViewById(R.id.checkbox42);
            checkBox43=itemView.findViewById(R.id.checkbox43);
            checkBox44=itemView.findViewById(R.id.checkbox44);
            checkBox45=itemView.findViewById(R.id.checkbox45);

        }

    }

    public void Uncheck(int id, int checkBox1,int checkBox2,int checkBox3,int checkBox4,int checkBox5,
                        int checkBox6, int checkBox7,int checkBox8, int checkBox9,int checkBox10,
                        int checkBox11,int checkBox12,int checkBox13, int checkBox14,int checkBox15,
                        int checkBox16,int checkBox17,int checkBox18,int checkBox19,int checkBox20,
                        int checkBox21,int checkBox22,int checkBox23,int checkBox24,int checkBox25,
                        int checkBox26,int checkBox27,int checkBox28, int checkBox29,int checkBox30,
                        int checkBox31,int checkBox32,int checkBox33,int checkBox34,int checkBox35,
                        int checkBox36, int checkBox37,int checkBox38, int checkBox39,int checkBox40,
                        int checkBox41,int checkBox42,int checkBox43, int checkBox44,int checkBox45,
                        int checkBoxCount,String name,String examResult1,String examResult2,String examResult3,
                        String examResult4,String examResult5,String examResult6,
                        String examResult7,String examResult8,String examResult9,String examResult10
    ){

        int status = databaseHelper.updateData(new Notes2(id,
                checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
                checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
                checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,
                checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,checkBox37,checkBox38,
                checkBox39,checkBox40,checkBox41,checkBox42,checkBox43,checkBox44,checkBox45,
                checkBoxCount,name,
                examResult1,examResult2,examResult3,examResult4,examResult5,examResult6,
                examResult7,examResult8,examResult9,examResult10
        ));
        if (status==1){
            allNotes.clear();
            allNotes.addAll((Collection<? extends Notes2>) databaseHelper.getAllNotes());
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
            int checkBox31,int checkBox32,int checkBox33,int checkBox34,int checkBox35,
            int checkBox36, int checkBox37,int checkBox38, int checkBox39,int checkBox40,
            int checkBox41,int checkBox42,int checkBox43, int checkBox44,int checkBox45,
            int checkBoxCount,String name,String examResult1,String examResult2,String examResult3,
            String examResult4,String examResult5,String examResult6,
        String examResult7,String examResult8,String examResult9,String examResult10){
        int status = databaseHelper.updateData(new Notes2(id,
                checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,
                checkBox9,checkBox10,checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,
                checkBox17,checkBox18,checkBox19,checkBox20,checkBox21,checkBox22,checkBox23,
                checkBox24, checkBox25,checkBox26,checkBox27,checkBox28,checkBox29,checkBox30,
                checkBox31,checkBox32,checkBox33,checkBox34,checkBox35,checkBox36,
                checkBox37, checkBox38, checkBox39,checkBox40,checkBox41,checkBox42,checkBox43,
                checkBox44, checkBox45, checkBoxCount,name,
                examResult1,examResult2,examResult3,examResult4,examResult5,examResult6,examResult7
                ,examResult8,examResult9,examResult10
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


    private void customDialog(final int position) {
        androidx.appcompat.app.AlertDialog.Builder builder  = new androidx.appcompat.app.AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.student_name_input_box,null);

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
                    int id=databaseHelper.updateData(new Notes2(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
                            allNotes.get(position).getCheckBox3(),allNotes.get(position).getCheckBox4(),allNotes.get(position).getCheckBox5(),
                            allNotes.get(position).getCheckBox6(),allNotes.get(position).getCheckBox7(),allNotes.get(position).getCheckBox8(),
                            allNotes.get(position).getCheckBox9(),allNotes.get(position).getCheckBox10(),allNotes.get(position).getCheckBox11(),
                            allNotes.get(position).getCheckBox12(),allNotes.get(position).getCheckBox13(),allNotes.get(position).getCheckBox14(),
                            allNotes.get(position).getCheckBox15(),allNotes.get(position).getCheckBox16(),allNotes.get(position).getCheckBox17(),
                            allNotes.get(position).getCheckBox18(),allNotes.get(position).getCheckBox19(),allNotes.get(position).getCheckBox20(),
                            allNotes.get(position).getCheckBox21(),allNotes.get(position).getCheckBox22(),allNotes.get(position).getCheckBox23(),
                            allNotes.get(position).getCheckBox24(),allNotes.get(position).getCheckBox25(),allNotes.get(position).getCheckBox26(),
                            allNotes.get(position).getCheckBox27(),allNotes.get(position).getCheckBox28(),allNotes.get(position).getCheckBox29(),
                            allNotes.get(position).getCheckBox30(),
                            allNotes.get(position).getCheckBox31(),allNotes.get(position).getCheckBox32(), allNotes.get(position).getCheckBox33(),
                            allNotes.get(position).getCheckBox34(), allNotes.get(position).getCheckBox35(),allNotes.get(position).getCheckBox36(),
                            allNotes.get(position).getCheckBox37(), allNotes.get(position).getCheckBox38(), allNotes.get(position).getCheckBox39(),
                            allNotes.get(position).getCheckBox40(), allNotes.get(position).getCheckBox41(), allNotes.get(position).getCheckBox42(),
                            allNotes.get(position).getCheckBox43(), allNotes.get(position).getCheckBox44(), allNotes.get(position).getCheckBox45(),
                            allNotes.get(position).getCheckBoxCount(),studentName
                        ,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),allNotes.get(position).getExamResult3()
                            ,allNotes.get(position).getExamResult4(),allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6()
                            , allNotes.get(position).getExamResult7(),allNotes.get(position).getExamResult8(),allNotes.get(position).getExamResult9(),
                            allNotes.get(position).getExamResult10()
                    ));
                    if (id==1){
                        Toast.makeText(context, "update Success", Toast.LENGTH_SHORT).show();
                        allNotes.clear();
                        allNotes.addAll((Collection<? extends Notes2>) databaseHelper.getAllNotes());
                       // notifyDataSetChanged();
                        alertDialog.dismiss();
                        ((ThirdClass)context).loadStudentInformationData();

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
