package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.MyHealth.retroapi.ApiClient;
import com.example.MyHealth.retroapi.retromod.IDcheck;
import com.example.MyHealth.retroapi.retromod.OTP;
import com.example.MyHealth.retroapi.retromod.Patient;
import com.example.MyHealth.ui.AdminActivity;
import com.example.MyHealth.ui.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private Button submitBTN;
    private Button submitOTP;

    TextInputEditText idNumber;
    TextInputEditText OTPtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        OTPtxt = findViewById(R.id.txt_OTP);

        idNumber = findViewById(R.id.txt_idNumber);

        submitBTN = findViewById(R.id.subIDBtn);

        submitOTP = findViewById(R.id.submitOTP);

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(idNumber.getText().toString()) ){
                    Toast.makeText(SignUpActivity.this, "ID Number Required", Toast.LENGTH_LONG).show();
                }else{
                    checkID();
                }
            }
        });

        submitOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(OTPtxt.getText().toString()) ){
                    Toast.makeText(SignUpActivity.this, "OTP Required", Toast.LENGTH_LONG).show();
                }else{
                    sendOTP();
                }
            }
        });
    }

  private static  String token;

    private void checkID() {
        IDcheck iDcheck = new IDcheck();
        iDcheck.setNationalIDNumber(idNumber.getText().toString());

        Call<Patient> patientCall = ApiClient.getIDClient().idCheck(iDcheck);

        patientCall.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                if (response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "ID Number found", Toast.LENGTH_LONG).show();
                    //     User user = response.body();
                    token = response.body().getToken();



                }else {
                    Toast.makeText(SignUpActivity.this, "ID not found in system", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void sendOTP() {
        OTP otp = new OTP();
        otp.setOtp(OTPtxt.getText().toString());
        otp.setToken(token.toString());


        Call<OTP> otpCall = ApiClient.getIDClient().onetimesend(otp);

        otpCall.enqueue(new Callback<OTP>() {
            @Override
            public void onResponse(Call<OTP> call, Response<OTP> response) {
                if (response.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "OTP Sent", Toast.LENGTH_LONG).show();
                    //     User user = response.body();


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            startActivity(new Intent(SignUpActivity.this, ConfirmationActivity.class));
                        }
                    }, 700);

                }else {
                    Toast.makeText(SignUpActivity.this, "failure to send", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<OTP> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}