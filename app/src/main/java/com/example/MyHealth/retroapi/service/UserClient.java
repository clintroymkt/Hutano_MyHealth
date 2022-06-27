package com.example.MyHealth.retroapi.service;


import com.example.MyHealth.retroapi.retromod.Login;
import com.example.MyHealth.retroapi.retromod.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserClient {
    @Headers({"Accept: application/json"})

    @POST("login")
    Call<User> login(@Body Login login);





}
