package com.example.yoonseoplee_comp304_003_test02.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yoonseoplee_comp304_003_test02.R;

public class ConfirmedActivity extends AppCompatActivity {


    private String firstName, lastName, telePhone, emailAdress;
    private String studentId, programName, tuition, courseNum;
    private Button ButtonSNS;
    private Button ButtonEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed);


        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        telePhone = getIntent().getStringExtra("phone");
        emailAdress = getIntent().getStringExtra("email");
        studentId = getIntent().getStringExtra("studentId");
        programName = getIntent().getStringExtra("programName");
        tuition = getIntent().getStringExtra("tuition");
        courseNum = getIntent().getStringExtra("courseNum");


        // Send SMS
        ButtonSNS = (Button)findViewById(R.id.smsBtn);
        ButtonSNS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage("+1"+ telePhone,null, firstName + " " + lastName + " registered "  + programName  + " successfully." + courseNum +" courses registered" +"Tuition: $"+ tuition,null,null);
                    Toast.makeText(ConfirmedActivity.this, "Message sent successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), ProgramInfoActivity.class));
                }
                catch (Exception e){
                    Toast.makeText(ConfirmedActivity.this, "Message did not sent :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Send EMail
        ButtonEmail = (Button)findViewById(R.id.emailBtn);
        ButtonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);

                it.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAdress});
                it.putExtra(Intent.EXTRA_SUBJECT,"Successfully registered!");
                it.putExtra(Intent.EXTRA_TEXT,(firstName + " " + lastName +" (" + studentId + ")" + " registered "  + programName  + " successfully.\n" + courseNum +" courses registered" +"\nTuition: $"+ tuition));
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });

    }
}
