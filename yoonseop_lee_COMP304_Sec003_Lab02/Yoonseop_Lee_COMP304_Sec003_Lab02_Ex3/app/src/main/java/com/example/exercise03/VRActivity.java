package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VRActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);
        text = (TextView)findViewById(R.id.textView2);
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
