package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class AIActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai);
        text = (TextView)findViewById(R.id.textView);
        text.append("\nonCreate executed\n");
    }

    public void onStart()
    {
        super.onStart();
        text.append("onStart executed\n");
    }
    public void onStop()
    {
        super.onStop();
        text.append("onStop executed\n");
    }
    public void onDestroy()
    {
        super.onDestroy();
        text.append("onDestroy executed\n");
    }
}
