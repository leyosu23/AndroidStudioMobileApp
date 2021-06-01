package com.example.yoonseoplee_comp304_003_test02.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.yoonseoplee_comp304_003_test02.Models.Student;
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.StudentViewModel;

public class SignUpActivity extends AppCompatActivity {

    private EditText stId, fName, lName, email, password, gender;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.sign_up_emailEditText);
        password = findViewById(R.id.sign_up_passwordEditText);
        gender = findViewById(R.id.sign_up_dobEditText);
        stId = findViewById(R.id.sign_up_studentIdEditText);
        fName = findViewById(R.id.sign_up_fNameEditText);
        lName = findViewById(R.id.sign_up_lNameEditText);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
    }

    public void signUp(View view) {
        try {
                Student student = new Student();

                student.setStudentId(Integer.valueOf(stId.getText().toString()));
                student.setFirstName(fName.getText().toString());
                student.setLastName(lName.getText().toString());
                student.setEmail(email.getText().toString());
                student.setPassword(password.getText().toString());
                student.setGender(gender.getText().toString());

                studentViewModel.insert(student);
                Toast.makeText(this,"You have been registered successfully.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

        } catch (Exception ex) {
            Toast.makeText(this,"Please check all information needed.", Toast.LENGTH_LONG).show();
        }
    }
}
