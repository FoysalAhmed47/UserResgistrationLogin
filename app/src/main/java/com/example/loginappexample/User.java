package com.example.loginappexample;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

public class User
{
    //this is the model class for retrofit
    //@SerializedName for the proper mapping

   @SerializedName("response")
    private String Response;

   @SerializedName("phone")
    private String Phone;

    public String getResponse()
    {
        return Response;
    }

    public String getPhone()
    {
        return Phone;
    }
}


