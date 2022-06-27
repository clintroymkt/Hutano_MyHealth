package com.example.MyHealth.retroapi.service;

import com.example.MyHealth.retroapi.retromod.IDcheck;
import com.example.MyHealth.retroapi.retromod.OTP;
import com.example.MyHealth.retroapi.retromod.Patient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PatientService {
    @POST("patients/verify-national-id/")
    Call<Patient> idCheck (@Body IDcheck iDcheck);

    @GET("patients/verify-national-id/")
    Call<ResponseBody> getToken(@Header("Authorization")String authToken);

    @POST("patients/signup/")
    Call<OTP> onetimesend (@Body OTP otp);




}
