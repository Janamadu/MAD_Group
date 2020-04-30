package com.example.mad_new;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Input_marks extends AppCompatActivity {

    private EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11;
    private Button btn;
    DatabaseReference MADgroup;
    com.example.madmad.BrighterBee brighterBee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_marks);

        btn = (Button) findViewById(R.id.btn);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        brighterBee = new com.example.madmad.BrighterBee();
        MADgroup = FirebaseDatabase.getInstance().getReference().child("BrighterBee");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int StudentName = Integer.parseInt(editText1.getText().toString().trim());
                int clas = Integer.parseInt(editText2.getText().toString().trim());
                int Index = Integer.parseInt(editText3.getText().toString().trim());
                int Sub1Mark = Integer.parseInt(editText4.getText().toString().trim());
                int Sub2Mark = Integer.parseInt(editText5.getText().toString().trim());
                int Sub3Mark = Integer.parseInt(editText6.getText().toString().trim());
                int Sub4Mark = Integer.parseInt(editText7.getText().toString().trim());
                int Sub5Mark = Integer.parseInt(editText8.getText().toString().trim());
                int TotMarks  = Integer.parseInt(editText9.getText().toString().trim());
                int Avg = Integer.parseInt(editText10.getText().toString().trim());
                int Posi = Integer.parseInt(editText11.getText().toString().trim());


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
