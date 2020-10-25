package com.example.attendence.fifth_class;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendence.R;
import com.example.attendence.common.Notes;

import java.util.Collection;
import java.util.List;

public class ExamCustomAdapter5 extends RecyclerView.Adapter<ExamCustomAdapter5.MyViewHolder> {
    Context context;
    private List<Notes> allNotes;
    DataBaseHelper5 dataBaseHelper;

    public ExamCustomAdapter5(Context context, List<Notes> allNotes) {
        this.context = context;
        this.allNotes = allNotes;
        dataBaseHelper=new DataBaseHelper5(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.item2,parent,false);
        dataBaseHelper=new DataBaseHelper5(context);
        return new ExamCustomAdapter5.MyViewHolder(view);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.nameTextView.setText(allNotes.get(position).getStudentName());
        holder.examEditText1.setText(allNotes.get(position).getExamResult1());
        holder.examEditText2.setText(allNotes.get(position).getExamResult2());
        holder.examEditText3.setText(allNotes.get(position).getExamResult3());
        holder.examEditText4.setText(allNotes.get(position).getExamResult4());
        holder.examEditText5.setText(allNotes.get(position).getExamResult5());
        holder.examEditText6.setText(allNotes.get(position).getExamResult6());


        holder.examEditText1.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            public void onTextChanged(CharSequence s, int start,int before, int count) {
                String editTextContent = holder.examEditText1.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,result,allNotes.get(position).getExamResult2(),
                            allNotes.get(position).getExamResult3(),allNotes.get(position).getExamResult4(),
                            allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6());
                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.examEditText2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start,int count, int after) { }
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                String editTextContent = holder.examEditText2.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,allNotes.get(position).getExamResult1(),result,
                            allNotes.get(position).getExamResult3(),allNotes.get(position).getExamResult4(),
                            allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6());
                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
                } }
        });


        holder.examEditText3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String editTextContent = holder.examEditText3.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),
                            result,allNotes.get(position).getExamResult4(),
                            allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6());
                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
                }


            }
        });


        holder.examEditText4.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) { }
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                String editTextContent = holder.examEditText4.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),
                            allNotes.get(position).getExamResult3(),result,
                            allNotes.get(position).getExamResult5(),allNotes.get(position).getExamResult6());

                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
                }



            }
        });


        holder.examEditText5.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                String editTextContent = holder.examEditText5.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),
                            allNotes.get(position).getExamResult3(),allNotes.get(position).getExamResult4(),
                            result,allNotes.get(position).getExamResult6());
                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.examEditText6.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editTextContent = holder.examEditText6.getText().toString();
                if(editTextContent != null && editTextContent.trim().length() > 0) {
                    String result=String.valueOf(s);
                    customDialog(position,allNotes.get(position).getExamResult1(),allNotes.get(position).getExamResult2(),
                            allNotes.get(position).getExamResult3(),allNotes.get(position).getExamResult4(),
                            allNotes.get(position).getExamResult5(),result);
                }
                else {
                    Toast.makeText(context, "Enter a value", Toast.LENGTH_SHORT).show();
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
        EditText examEditText1,examEditText2,examEditText3,
                examEditText4,examEditText5,examEditText6;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView=itemView.findViewById(R.id.nameTextVIewId);
            examEditText1=itemView.findViewById(R.id.examEditTextId1);
            examEditText2=itemView.findViewById(R.id.examEditTextId2);
            examEditText3=itemView.findViewById(R.id.examEditTextId3);
            examEditText4=itemView.findViewById(R.id.examEditTextId4);
            examEditText5=itemView.findViewById(R.id.examEditTextId5);
            examEditText6=itemView.findViewById(R.id.examEditTextId6);
        }
    }
    private void customDialog(final int position,String result1,String result2,String result3
                            ,String result4,String result5,String result6) {

        int id=dataBaseHelper.updateData(new Notes(allNotes.get(position).getId(),allNotes.get(position).getCheckBox1(),allNotes.get(position).getCheckBox2(),
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
                allNotes.get(position).getCheckBoxCount(),allNotes.get(position).getStudentName()
                ,result1,result2,result3,result4,result5,result6));
        if (id==1){
            Toast.makeText(context, "s", Toast.LENGTH_SHORT).show();
            allNotes.clear();
            allNotes.addAll((Collection<? extends Notes>) dataBaseHelper.getAllNotes());
            //notifyDataSetChanged();

        } else {
            Toast.makeText(context, "f", Toast.LENGTH_SHORT).show();
        }

    }

}
