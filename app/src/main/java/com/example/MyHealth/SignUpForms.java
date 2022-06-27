package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.MyHealth.ui.LoginActivity;

public class SignUpForms extends AppCompatActivity {
    private Button membersignupBTN;
    private Button medaidsignupBTN;
    private Button cashsignupBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_forms);

        membersignupBTN = findViewById(R.id.membersignupBTN);

        cashsignupBTN = findViewById(R.id.cashsignupBTN);

        medaidsignupBTN = findViewById(R.id.medaidsignupBTN);

        medaidsignupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMedAidSignUp();
            }
        });


        cashsignupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCashSignUp();
            }
        });

        membersignupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMemberSignUp();
            }
        });
    }

    private void openMedAidSignUp() {
        Intent intent = new Intent(SignUpForms.this, MedAidList.class);
        startActivity(intent);
    }

    private void openCashSignUp() {
        Intent intent = new Intent(SignUpForms.this, CashSignUp.class);
        startActivity(intent);
    }

    private void openMemberSignUp() {
        Intent intent = new Intent(SignUpForms.this, SignUpActivity.class);
        startActivity(intent);
    }
}