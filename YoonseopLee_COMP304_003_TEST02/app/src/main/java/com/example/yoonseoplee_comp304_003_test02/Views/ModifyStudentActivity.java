package com.example.yoonseoplee_comp304_003_test02.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoonseoplee_comp304_003_test02.Models.Student;
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.StudentViewModel;

public class ModifyStudentActivity extends AppCompatActivity {


    private StudentViewModel studentViewModel;
    private int studentId;
    private EditText firstName, lastName, emailAddress, gender, password;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_student);

        firstName = findViewById(R.id.edit_student_fNameEditText);
        lastName = findViewById(R.id.edit_student_lNameEditText);
        emailAddress = findViewById(R.id.edit_student_emailEditText);
        gender = findViewById(R.id.edit_student_dobEditText);
        password = findViewById(R.id.edit_student_passwordEditText);

        studentId = getIntent().getIntExtra("studentId", 0);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        student = studentViewModel.getStudentById(studentId);

        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
        emailAddress.setText(student.getEmail());
        gender.setText(student.getGender());
        password.setText(student.getPassword());

    }

    public void modifyStudent(View view)
    {
        student.setFirstName(firstName.getText().toString());
        student.setLastName(lastName.getText().toString());
        student.setEmail(emailAddress.getText().toString());
        student.setGender(gender.getText().toString());
        student.setPassword(password.getText().toString());

        studentViewModel.update(student);
        Toast.makeText(this, "Student information updated.", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ProgramListActivity.class);
        intent.putExtra("studentId", student.getStudentId());
        startActivity(intent);
    }
}
