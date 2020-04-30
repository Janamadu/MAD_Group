package com.example.mad_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.snapshot.Index;

import org.w3c.dom.Text;

public class Input_marks extends AppCompatActivity {
     private Button SUBMIT;
     private EditText StudentFullName, Class, IndexNo, Subject1, Subject2, Subject3, Subject4,Subject5, TotalMarks, Average, Position;
     DatabaseReference MADgroup;
     BrighterBee brighterBee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_marks);

        SUBMIT = (Button) findViewById(R.id.btn3);
        StudentFullName = (EditText) findViewById(R.id.editText1);
        Class = (EditText) findViewById(R.id.editText2);
        IndexNo = (EditText) findViewById(R.id.editText3);
        Subject1 = (EditText) findViewById(R.id.editText4);
        Subject2 = (EditText) findViewById(R.id.editText5);
        Subject3 = (EditText) findViewById(R.id.editText6);
        Subject4 = (EditText) findViewById(R.id.editText7);
        Subject5 = (EditText) findViewById(R.id.editText8);
        TotalMarks = (EditText) findViewById(R.id.editText9);
        Average = (EditText) findViewById(R.id.editText10);
        Position = (EditText) findViewById(R.id.editText11);
        brighterBee = new BrighterBee();
        MADgroup = FirebaseDatabase.getInstance().getReference().child("BrighterBee");

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int StudentName = Integer.parseInt(StudentFullName.getText().toString().trim());
                int clas = Integer.parseInt(Class.getText().toString().trim());
                int Index = Integer.parseInt(IndexNo.getText().toString().trim());
                int Sub1Mark = Integer.parseInt(Subject1.getText().toString().trim());
                int Sub2Mark = Integer.parseInt(Subject2.getText().toString().trim());
                int Sub3Mark = Integer.parseInt(Subject3.getText().toString().trim());
                int Sub4Mark = Integer.parseInt(Subject4.getText().toString().trim());
                int Sub5Mark = Integer.parseInt(Subject5.getText().toString().trim());
                int TotMarks  = Integer.parseInt(TotalMarks.getText().toString().trim());
                int Avg = Integer.parseInt(Average.getText().toString().trim());
                int Posi = Integer.parseInt(Position.getText().toString().trim());


                brighterBee.setStudentName(StudentName);
                brighterBee.setClas(clas);
                brighterBee.setIndex(Index);
                brighterBee.setSub1Mark(Sub1Mark);
                brighterBee.setSub2Mark(Sub2Mark);
                brighterBee.setSub3Mark(Sub3Mark);
                brighterBee.setSub4Mark(Sub4Mark);
                brighterBee.setSub5Mark(Sub5Mark);
                brighterBee.setTotMarks(TotMarks);
                brighterBee.setAvg(Avg);
                brighterBee.setPosi(Posi);



                MADgroup.push().setValue(brighterBee);
                Toast.makeText(Input_marks.this,"Data insert successfully",Toast.LENGTH_LONG).show();

            }
        });


    }
}
