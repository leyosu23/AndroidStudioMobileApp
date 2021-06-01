package com.example.yoonseoplee_comp304_003_test02.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.yoonseoplee_comp304_003_test02.R;

public class RegisterActivity extends AppCompatActivity {

    private String studentId, programName, tuition, courseNum;
    private EditText fName, lName, telePhone, emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        studentId = getIntent().getStringExtra("studentId");
        programName = getIntent().getStringExtra("programName");
        tuition = getIntent().getStringExtra("tuition");
        courseNum = getIntent().getStringExtra("courseNum");

        fName = findViewById(R.id.register_fNameEditText);
        lName = findViewById(R.id.register_lNameEditText);
        telePhone = findViewById(R.id.register_phoneEditText);
        emailAddress = findViewById(R.id.register_emailEditText);
    }

    public void register(View view) {
        Intent intent = new Intent(this, ConfirmedActivity.class);
        intent.putExtra("firstName", fName.getText().toString());
        intent.putExtra("lastName", lName.getText().toString());
        intent.putExtra("phone", telePhone.getText().toString());
        intent.putExtra("email", emailAddress.getText().toString());
        intent.putExtra("studentId", studentId);
        intent.putExtra("programName", programName);
        intent.putExtra("tuition", tuition);
        intent.putExtra("courseNum", courseNum);
        startActivity(intent);
    }
}
