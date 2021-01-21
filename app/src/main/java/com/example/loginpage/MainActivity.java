package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;

    public void onRegister(View view)
    {
        Intent intent = new Intent(this,RegisterForm.class);
        startActivity(intent);
    }

    public void onLogin(View view) {

        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        SharedPreferences sh = getSharedPreferences(email, MODE_PRIVATE);
        if(sh.getString("pass","").equals(password))
            Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Invalid email/password",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportActionBar().hide();

        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);





    }
}