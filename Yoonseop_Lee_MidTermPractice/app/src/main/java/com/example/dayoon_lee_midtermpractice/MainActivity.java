package com.example.dayoon_lee_midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    private int[] checkedStates = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setTitle("Hands-On Test 1 COMP-304 001");
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.Lose:
                if (checked)
                    checkedStates[0]=1;
                else
                    checkedStates[0]=0;
                break;
            case R.id.Remember:
                if (checked)
                    checkedStates[1]=1;
                else
                    checkedStates[1]=0;
                break;
            case R.id.LearnThings:
                if (checked)
                    checkedStates[2]=1;
                else
                    checkedStates[2]=0;
                break;
            case R.id.KeepTrack:
                if (checked)
                    checkedStates[3]=1;
                else
                    checkedStates[3]=0;
                break;
            default:
                break;
        }
    }
    //
    //handling image button
    public void showChartActivity(View v)
    {
        //put selected items in Extras
        intent = new Intent(this, ChartActivity.class);
        intent.putExtra("checkedStates",checkedStates);
        //
        startActivity(intent);
    }

}
