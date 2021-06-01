package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonHello;
    TextView Output;
    EditText Fname;
    EditText Lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fname =  findViewById(R.id.editTextFname);
        Lname =  findViewById(R.id.editTextLname);
        buttonHello =  findViewById(R.id.buttonHello);
        Output = findViewById(R.id.textViewFLnameOutput);

    }

    public void buttonHello_clicked(View view) {
        try
        {

            String Firstname = Fname.getText().toString();
            String Lastname = Lname.getText().toString();
            Output.setText("Name: " + Firstname + " " + Lastname);
        }
        catch(Exception e)
        {
            Output.setText("ERROR: Try to enter proper value");
        }
    }

}
