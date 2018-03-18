package com.example.m36.doctorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name=(EditText)findViewById(R.id.Name);
        Password=(EditText)findViewById(R.id.Password);
        Login=(Button)findViewById(R.id.Login);
        Register=(Button)findViewById(R.id.Register);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(Login.this,PatientAccess.class);
                pass.putExtra("Name",Name.getText().toString());
                startActivity(pass);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(Login.this,Register.class);
                startActivity(pass);
            }
        });

    }
}
