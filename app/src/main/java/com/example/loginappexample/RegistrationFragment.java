package com.example.loginappexample;


import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
private EditText fName,lName,Email,Phone,Password;
private Button SignUp;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        fName=view.findViewById(R.id.firstname_input);
        lName=view.findViewById(R.id.lastname_input);
        Email=view.findViewById(R.id.email_input);
        Phone=view.findViewById(R.id.phone_input);
        Password=view.findViewById(R.id.password_input);
        SignUp=view.findViewById(R.id.signupbtn_id);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();

            }
        });
        return view;
    }
    public void performRegistration()
    {
        String fname=fName.getText().toString();
        String lname=lName.getText().toString();
        String email=Email.getText().toString();
        String phone=Phone.getText().toString();
        String password=Password.getText().toString();

        Call<User> call=MainActivity.apiInterface.preformRegistration(fname,lname,email,phone,password);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.body().getResponse().equals("ok"))
                {
                    MainActivity.prefConfig.displayToast("Registration Success...");
                }
                else if (response.body().getResponse().equals("exist"))
                {
                    MainActivity.prefConfig.displayToast("User already exist...");
                }
                else if (response.body().getResponse().equals("error"))
                {
                    MainActivity.prefConfig.displayToast("Something went wrong...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        fName.setText("");
        lName.setText("");
        Email.setText("");
        Phone.setText("");
        Password.setText("");
    }

}

