package com.example.yoonseoplee_comp304_003_test02.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.yoonseoplee_comp304_003_test02.Models.Student;
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.StudentViewModel;

import java.util.List;

public class SignInActivity extends AppCompatActivity {


    private StudentViewModel studentViewModel;
    private EditText stId;
    private EditText stPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        stId = findViewById(R.id.login_studentIdEditText);
        stPassword = findViewById(R.id.login_passwordEditText);

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.allStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
            }
        });
    }

    public void signIn(View view) {

        if (stId.getText().toString().matches("") || stPassword.getText().toString().matches(""))
        {
            Toast.makeText(this, "Enter all required information", Toast.LENGTH_LONG).show();
        }

        else if (studentViewModel.checkLogin(Integer.valueOf(stId.getText().toString()), stPassword.getText().toString())) {
            SharedPreferences sharedPreferences = getSharedPreferences("StudentID", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("StudentID", stId.getText().toString());
            editor.commit();

            Intent intent = new Intent(this, ProgramListActivity.class);
            intent.putExtra("studentId", Integer.valueOf(stId.getText().toString()));
            startActivity(intent);

        } else {
            Toast.makeText(this, "Your ID and password does not match", Toast.LENGTH_LONG).show();
        }
    }

}
