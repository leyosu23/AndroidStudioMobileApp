package com.example.yoonseoplee_comp304_003_test02.Views;

import android.content.Intent;
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
import com.example.yoonseoplee_comp304_003_test02.R;
import com.example.yoonseoplee_comp304_003_test02.ViewModels.ProgramViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramListActivity extends AppCompatActivity {

    private ProgramViewModel programViewModel;
    private int studentId;
    private List<Program> programList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);
        studentId = getIntent().getIntExtra("studentId", 0);
        programList = new ArrayList<Program>();
        programViewModel = ViewModelProviders.of(this).get(ProgramViewModel.class);
        programList = programViewModel.allPrograms();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, programList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView programName = view.findViewById(android.R.id.text1);
                TextView programInfo = view.findViewById(android.R.id.text2);

                programName.setTextSize(16);
                programName.setText(programList.get(position).getProgramId() + " - " + programList.get(position).getProgramName());

                programInfo.setText(" Duration: " + programList.get(position).getDuration() + " / Months" + "Dept: " + programList.get(position).getDepartment() +  " / Tuition: " + "$" + programList.get(position).getTuition());

                return view;
            }
        };

        listView = findViewById(R.id.programListView);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TextView textView = view.findViewById(android.R.id.text1);
                String[] str = textView.getText().toString().split("-");
                int programId = Integer.valueOf(str[0].trim());

                Intent intent = new Intent(getApplicationContext(), ProgramInfoActivity.class);
                intent.putExtra("programId", programId);
                startActivity(intent);
            }
        });
    }

    public void modifyStudentInfo(View view) {
        Intent intent = new Intent(this, ModifyStudentActivity.class);
        intent.putExtra("studentId", studentId);
        startActivity(intent);
    }

    public void ViewMap(View view) {
        Intent intent = new Intent(this, ViewMap.class);
        startActivity(intent);
    }

}
