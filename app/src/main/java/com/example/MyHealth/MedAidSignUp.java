package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.MyHealth.retroapi.retromod.User;
import com.example.MyHealth.ui.LoginActivity;

import java.util.ArrayList;

public class MedAidSignUp extends AppCompatActivity {
        TextView aidtxt;
        String providername;
        Button sendDetailsBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_aid_sign_up);

        aidtxt = findViewById(R.id.aidprovider);

        sendDetailsBTN = findViewById(R.id.submitmeddetails);

        providername = "No provider set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            providername = extras.getString("name");
        }
        aidtxt.setText(providername);

        sendDetailsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVerify();
            }
        });

    }

    private void openVerify() {
        Intent intent = new Intent(MedAidSignUp.this, OTPVerify.class);
        startActivity(intent);
    }
}