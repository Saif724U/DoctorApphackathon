package com.example.m36.doctorapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Register extends AppCompatActivity {

    private EditText Name;
    private EditText HospitalName;
    private EditText HospitalAddress;
    private Button Verify;
    private Button Register;

    private final int SELECT_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Verify=(Button)findViewById(R.id.Verify);
        Register=(Button)findViewById(R.id.Register);

        Name=(EditText)findViewById(R.id.Name);
        HospitalName=(EditText)findViewById(R.id.HospitalName);
        HospitalAddress=(EditText)findViewById(R.id.HospitalAddress);

        Verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass= new Intent(Register.this,Login.class);
                startActivity(pass);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }
}
