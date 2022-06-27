package com.example.MyHealth.retroapi;

import com.example.MyHealth.retroapi.service.PatientService;
import com.example.MyHealth.retroapi.service.UserClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://192.168.0.90:8000/api/")
               // .baseUrl("http://transcarehealth.org:8000/")
                .client(okHttpClient)
                .build();






        return  retrofit;
    }

    public static UserClient getUserClient(){
        UserClient userClient = getRetrofit().create(UserClient.class);

        return userClient;
    }

    public static PatientService getIDClient(){
        PatientService patientService = getRetrofit().create(PatientService.class);

        return patientService;
    }
}
