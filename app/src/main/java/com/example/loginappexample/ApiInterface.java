package com.example.loginappexample;

import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface
{
    @POST("register.php")
    Call<User> preformRegistration(@Query("first_name") String fname, @Query("last_name") String lname, @Query("email")String email, @Query("phone") String phone, @Query("password") String password);
    //Json Object Properties= @Query("user_name") String UserName,@Query("user_password") String UserPassword
    @GET("login.php")
    Call<User> preformUserLogin (@Query("phone") String Phone,@Query("password") String Password);

}
