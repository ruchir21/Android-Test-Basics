package com.brillicaservices.studentlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

    class Student1
{
    String name;
    String course;
    String college;
    int fees;



    public Student1(String name, String course, int fees,String college)

    {
        this.name = name;
        this.course = course;
        this.fees = fees;
        this.college=college;
    }
}
public class Main2Activity extends AppCompatActivity {
        EditText getname;
        EditText getcourse;
        EditText getfees;
        EditText getcollege;
        TextView tv;
        Button submit;
        Button display;


        ArrayList<Student1> al = new ArrayList<Student1>();



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);



            getname = (EditText) findViewById(R.id.nameid);
            getcourse = (EditText) findViewById(R.id.courseid);
            getfees = (EditText) findViewById(R.id.feesid);
            getcollege=(EditText)findViewById(R.id.collegeid);
            tv=(TextView)findViewById(R.id.res);
            submit = (Button) findViewById(R.id.submitbtn);
            display=(Button)findViewById(R.id.displayres);


            submit.setOnClickListener(new View.OnClickListener() {


                public void onClick(View v) {
                   // Intent i = new Intent(Main2Activity.this, FinalActi.class);
                    //startActivity(i);
                    try {
                        String name = String.valueOf(getname.getText());
                        String course = String.valueOf(getcourse.getText());
                        int fees = Integer.parseInt(getfees.getText().toString());
                        String college=String.valueOf(getcollege.getText());


                        if (name.isEmpty() || course.isEmpty() || fees == 0 || college.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(), "Please Enter All The Values and Then Try Again", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {

                            Student1 obj = new Student1(name, course, fees,college);
                            al.add(new Student1(name, course, fees,college));
                            Toast.makeText(getApplicationContext(), "Student Details Added", Toast.LENGTH_SHORT).show();
                        }

                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter All The Values and Then Try Again", Toast.LENGTH_SHORT).show();
                    }
                }

            });

                    display.setOnClickListener(new View.OnClickListener() {


                        public void onClick(View v) {

                    for (int b = 0; b < al.size(); b++)

                    {
                        tv.setText(tv.getText()+"\n\nName of " + b + " User is :" + al.get(b).name + "\nAddress of " + b + " User is :" + al.get(b).course + "\nPhone No of " + b + " User is :" + al.get(b).fees + "\nCollege Of " + b + "User is :" + al.get(b).college);
                        // Toast.makeText(getApplicationContext(), "Name of " + b + " User is :" + al.get(b).name + "\nAddress of " + b + " User is :" + al.get(b).course + "\nPhone No of " + b + " User is :" + al.get(b).fees + "\nCollege Of " + b + "User is :" + al.get(b).college, Toast.LENGTH_LONG).show();
                    }



                }

            });

    }
}
