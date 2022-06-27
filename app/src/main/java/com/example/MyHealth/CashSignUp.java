package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class CashSignUp extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    AutoCompleteTextView autoCompleteTextView;
    Button dateBTN;
    Button submitdetailsBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_sign_up);

        dateBTN = findViewById(R.id.dateselectBtn);

        autoCompleteTextView = findViewById(R.id.signupautoCompleteText);

        submitdetailsBTN = findViewById(R.id.sendcashdetails);





        String[]option = {"Select Sex", "Male", "Female", };
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.option_item, option);
        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);

        autoCompleteTextView.setAdapter(arrayAdapter);

        dateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new com.example.MyHealth.ui.DatePicker();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        submitdetailsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVerify();
            }
        });
    }

    private void openVerify() {
        Intent intent = new Intent(CashSignUp.this, OTPVerify.class);
        startActivity(intent);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        TextView textView = (TextView) findViewById(R.id.dateTextRev);
        textView.setText(currentDateString);
    }
}