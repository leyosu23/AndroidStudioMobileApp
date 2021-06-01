package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonHello;
    EditText editTextNum1;
    EditText editTextNum2;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 =  findViewById(R.id.editTextNum2);
        buttonHello =  findViewById(R.id.buttonAdd);
        textViewOutput =  findViewById(R.id.textViewOutput);
    }
    public void buttonAdd_clicked(View view) {
        try{
        String num1 = editTextNum1.getText().toString();
        String num2 = editTextNum2.getText().toString();
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int sum = a+b;
        textViewOutput.setText(Integer.toString(sum));
        }
            catch (Exception e)
        {

        }
    }
    public void buttonSub_clicked(View view) {
        try {
            String num1 = editTextNum1.getText().toString();
            String num2 = editTextNum2.getText().toString();
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int sub = a - b;
            textViewOutput.setText(Integer.toString(sub));
        }
            catch (Exception e)
        {

        }
    }

    public void buttonMpy_clicked(View view) {
        try {
            String num1 = editTextNum1.getText().toString();
            String num2 = editTextNum2.getText().toString();
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int mpy = a * b;
            textViewOutput.setText(Integer.toString(mpy));
        }
        catch (Exception e)
            {

            }
    }

    public void buttonDiv_clicked(View view) {
        try {
            String num1 = editTextNum1.getText().toString();
            String num2 = editTextNum2.getText().toString();
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int div = a / b;
            textViewOutput.setText(Integer.toString(div));
        }
        catch (Exception e)
        {
            textViewOutput.setText("ERROR: Try to enter proper value");
        }
    }

}
