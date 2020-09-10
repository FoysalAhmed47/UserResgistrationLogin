package com.example.loginappexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.PasswordAuthentication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
private TextView RegText;
private EditText Phone,Password;
private Button LoginBtn;
//handler for interface
OnLoginFormActivityListener loginFormActivityListener;

public interface OnLoginFormActivityListener
{
    public void performRegister();
    public void performLogin(String phone);
}
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        RegText=view.findViewById(R.id.usrRegtxt_2);
        Phone=view.findViewById(R.id.login_userphone_input);
        Password=view.findViewById(R.id.login_password_input);
        LoginBtn=view.findViewById(R.id.login_id);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();

            }
        });

        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFormActivityListener.performRegister();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity=(Activity) context;
        loginFormActivityListener=(OnLoginFormActivityListener)activity;
    }

    private void performLogin()
    {
        String phone = Phone.getText().toString();
        String password = Password.getText().toString();

        Call<User> call = MainActivity.apiInterface.preformUserLogin(phone,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.body().getResponse().equals("ok"))
                {
                    MainActivity.prefConfig.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getPhone());
                }
                else if (response.body().getResponse().equals("failed"))
                {
                    MainActivity.prefConfig.displayToast("Login failed..Please try again!");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        Phone.setText("");
        Password.setText("");
    }

}
