package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextAmount;
    Button buttonCalculate;
    TextView textViewOutput;

    String[] duration = { "1", "2", "3", "4", "5" };

    String interest = "0";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, duration);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        textViewOutput = (TextView) findViewById(R.id.textViewOutput);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!editTextAmount.getText().toString().equals("") && !spin.getSelectedItem().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Loan Alert")
                            .setMessage("You want to see loan amount?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {


                                    String amount = editTextAmount.getText().toString();
                                    String duration = spin.getSelectedItem().toString();
                                    //editTextDuration.getText().toString();
                                    float a = Float.parseFloat(amount);
                                    int b = Integer.parseInt(duration);
                                    float c = Float.parseFloat(interest);
                                    for (int i = 0; i < b; i++) {
                                        a = a + a * (c / 100);
                                    }
                                    textViewOutput.setText("Loan Amount: " + Float.toString(a) + " Interest: " + interest);
                                    Toast.makeText(MainActivity.this, "Loan Amount: " + Float.toString(a) + " Interest: " + interest, Toast.LENGTH_SHORT).show();

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    //Creating dialog box
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                else {
                    textViewOutput.setText("ERROR: Enter Proper Value");
                }
            }
        });
    }

    public void buttonCalculate_clicked(View view) {
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void radio_Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButtonOne:
                if (checked)
                    interest = "2";
                break;
            case R.id.radioButtonTwo:
                if (checked)
                    interest = "2.5";
                break;
            case R.id.radioButtonThree:
                if (checked)
                    interest = "3.0";
                break;
        }
    }
}
