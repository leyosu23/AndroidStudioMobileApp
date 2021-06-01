package com.example.yoonseoplee_comp304_003_test02.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoonseoplee_comp304_003_test02.Models.Course;
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.CourseViewModel;

public class ViewCourseActivity extends AppCompatActivity {

    private CourseViewModel courseViewModel;
    private TextView courseId, courseName, professor, department, duration, studentId;

    private int curCourseId;
    private Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);


        curCourseId = getIntent().getIntExtra("courseId", 0);
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        course = courseViewModel.getCourseById(curCourseId);


        department = findViewById(R.id.view_course_depOutputTextView);
        duration = findViewById(R.id.view_course_durationOutputTextView);
        studentId = findViewById(R.id.view_course_studentIdOutputTextView);
        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        courseId = findViewById(R.id.view_course_courseIdOutputTextView);
        courseName = findViewById(R.id.view_course_nameOutputTextView);
        professor = findViewById(R.id.view_course_profOutputTextView);
        courseId.setText(String.valueOf(course.getCourseId()));
        courseName.setText(course.getCourseName());
        professor.setText(course.getProfessor());
        department.setText(course.getDepartment());
        duration.setText(String.valueOf(course.getDuration()) + " Months");
        studentId.setText(String.valueOf(course.getStudentId()));
    }

    public void RemoveCourse(View view) {
        courseViewModel.delete(course);

        Intent intent = new Intent(this, ProgramInfoActivity.class);
        intent.putExtra("programId", course.getProgramId());
        startActivity(intent);

        Toast.makeText(this,"Course " + curCourseId + " is deleted.", Toast.LENGTH_LONG).show();
    }
}
