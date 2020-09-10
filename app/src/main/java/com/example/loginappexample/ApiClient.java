package com.example.loginappexample;

import android.os.SharedMemory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    //this is the default IP for all Android Virtual dEVICE ACCESSING THE LOCALHOST
    public static final String BASE_URL = "http://10.0.2.2/loginapp/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
