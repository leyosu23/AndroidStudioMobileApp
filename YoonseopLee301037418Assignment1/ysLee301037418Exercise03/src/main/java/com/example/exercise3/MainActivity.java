package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonCalculate;
    TextView textViewOutput;
    EditText editTextAmount;
    EditText editTextDuration;
    EditText editTextInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        editTextDuration =  findViewById(R.id.editTextDuration);
        editTextInterest =  findViewById(R.id.editTextInterest);
        buttonCalculate =  findViewById(R.id.buttonCalculate);
        textViewOutput =  findViewById(R.id.textViewOutput);
    }

    public void buttonCalculate_clicked(View view) {
        try {
            String amount = editTextAmount.getText().toString();
            String duration = editTextDuration.getText().toString();
            String interest = editTextInterest.getText().toString();
            float a = Float.parseFloat(amount);
            int b = Integer.parseInt(duration);
            float c = Float.parseFloat(interest);
            for (int i = 0; i < b; i++) {
                a = a + a * (c / 100);
            }
            textViewOutput.setText(Float.toString(a));
        }
        catch (Exception e)
        {
            textViewOutput.setText("ERROR: Try to enter proper value");
        }
    }
}
