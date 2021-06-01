package com.example.yoonseoplee_comp304_003_test02.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yoonseoplee_comp304_003_test02.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signUpButtonClick(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void SignInButtonClick(View view) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }


}
