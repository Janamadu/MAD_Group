package com.example.mad_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup_page extends AppCompatActivity {

    EditText etEmail, etPass, etName, etConPass;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etConPass = findViewById(R.id.etConPass);

        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, pass, conPass;

                name = etName.getText().toString();
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                conPass = etConPass.getText().toString();

                if(name.equals("")){
                    Toast.makeText(Signup_page.this, "Name Required", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals("")){
                    Toast.makeText(Signup_page.this, "Password Required", Toast.LENGTH_SHORT).show();
                }

                else if(pass.equals("")){
                    Toast.makeText(Signup_page.this, "Email Required", Toast.LENGTH_SHORT).show();
                }
                else if (conPass.equals("")){
                    Toast.makeText(Signup_page.this, "Password Required", Toast.LENGTH_SHORT).show();
                }
                else if (!conPass.equals("pass")){
                    Toast.makeText(Signup_page.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Authentication
                }

            }
        });
    }
}
