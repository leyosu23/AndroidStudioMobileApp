package com.example.yoonseoplee_comp304_003_test02.Views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.yoonseoplee_comp304_003_test02.Models.Program;
import com.example.yoonseoplee_comp304_003_test02.Models.Course;
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.ProgramViewModel;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.CourseViewModel;

import java.util.List;

import static android.content.Intent.ACTION_VIEW;

public class ProgramInfoActivity extends AppCompatActivity {

    private int programId;
    private ProgramViewModel programViewModel;
    private CourseViewModel courseViewModel;
    private Program curProgram;

    private TextView name, dept, programDuration, tuition;
    private List<Course> courseList;
    private ListView courseListView;

    private String courseNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_info);

        programViewModel = ViewModelProviders.of(this).get(ProgramViewModel.class);
        programId = getIntent().getIntExtra("programId", 0);

        curProgram = programViewModel.getProgramById(programId);

        name = findViewById(R.id.program_info_nameOutputTextView);
        name.setText(curProgram.getProgramName());
        dept = findViewById(R.id.program_info_depOutputTextView);
        dept.setText(curProgram.getDepartment());
        programDuration = findViewById(R.id.program_info_durationOutputTextView);
        programDuration.setText(String.valueOf(curProgram.getDuration() + " Months"));
        tuition = findViewById(R.id.program_info_tuitionOutputTextView);
        tuition.setText("$" + String.valueOf(curProgram.getTuition()));

        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel.class);
        courseList = courseViewModel.getCoursesByProgramId(programId);

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, courseList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView testLine1 = view.findViewById(android.R.id.text1);

                testLine1.setTextSize(18);
                testLine1.setText("- Course ID: " + courseList.get(position).getCourseId() + ", Course Name: " + courseList.get(position).getCourseName());

                courseNum = String.valueOf(courseListView.getAdapter().getCount());

                return view;
            }
        };

        courseListView = findViewById(R.id.courseListView);
        courseListView.setAdapter(arrayAdapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TextView textView = view.findViewById(android.R.id.text1);
                // substring method obtains course ID in the string of list item
                int courseId = 0;
                if (textView.getText().toString().length() == 36)
                { courseId = Integer.valueOf(textView.getText().toString().substring(13, 14)); }
                else if (textView.getText().toString().length() == 37)
                { courseId = Integer.valueOf(textView.getText().toString().substring(13, 15)); }

                Intent intent = new Intent(getApplicationContext(), ViewCourseActivity.class);
                intent.putExtra("courseId", courseId);
                startActivity(intent);
            }
        });
    }

    public void viewDetail(View view) {
        if (programId == 1)
        {
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.centennialcollege.ca/programs-courses/full-time/software-engineering-technology/"));
            startActivity(intent);
        }
        else if (programId == 2)
        {
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.centennialcollege.ca/programs-courses/full-time/game-programming/"));
            startActivity(intent);
        }
        else if (programId == 3)
        {
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.centennialcollege.ca/programs-courses/full-time/business-accounting-summer-2020/"));
            startActivity(intent);
        }
        else if (programId == 4)
        {
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.centennialcollege.ca/programs-courses/full-time/project-management-summer-2020/"));
            startActivity(intent);
        }
        else if (programId == 5)
        {
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.centennialcollege.ca/programs-courses/full-time/culinary-skills-summer-2020/"));
            startActivity(intent);
        }
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("studentId", String.valueOf(curProgram.getStudentId()));
        intent.putExtra("programName", curProgram.getProgramName());
        intent.putExtra("tuition", String.valueOf(curProgram.getTuition()));
        intent.putExtra("courseNum", courseNum);
        startActivity(intent);
    }


}
