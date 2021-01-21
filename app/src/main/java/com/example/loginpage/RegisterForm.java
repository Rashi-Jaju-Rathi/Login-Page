package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginpage.databinding.ActivityRegisterFormBinding;


public class RegisterForm extends AppCompatActivity {

    EditText txtName,txtEmail,txtPass, txtConPass, txtMobile;

    public void onRegister(View view)
    {
        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();
        String conPass = txtConPass.getText().toString();
        String mobile = txtMobile.getText().toString();

        if(name.isEmpty())
        {
            txtName.setError("Field cannot be empty");
        }

        if (!email.isEmpty())
        {
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
            if(!email.matches(emailPattern))
                txtEmail.setError("Invalid Email Address");
        }
        else {
            txtEmail.setError("Field cannot be empty");
        }

        if(!pass.isEmpty())
        {
            if(pass.length() < 6)
                txtPass.setError("Password should be atleast 6 characters long");
        }
        else {
            txtPass.setError("Field cannot be empty");
        }

        if(!conPass.isEmpty())
        {
            if(!conPass.matches(pass))
                txtConPass.setError("Password don't match");
        }
        else {
            txtConPass.setError("Field cannot be empty");
        }

        if (!mobile.isEmpty())
        {
            if (mobile.length() != 10)
                txtMobile.setError("Invalid Number");
        }
        else{
            txtMobile.setError("Field cannot be empty");
        }

        if(txtEmail.getError() == null && txtName.getError() == null && txtPass.getError() == null && txtConPass.getError() == null && txtMobile.getError() == null)
        {


            SharedPreferences sh = getSharedPreferences(email,MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sh.edit();
            myEdit.putString("name", name);
            myEdit.putString("pass", pass);
            myEdit.putString("mobile", mobile);
            myEdit.commit();



            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Registered Successfully! You can now login", Toast.LENGTH_LONG).show();

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_form);

         txtName = (EditText)findViewById(R.id.txtRName);
         txtEmail = (EditText)findViewById(R.id.txtREmail);
         txtPass = (EditText)findViewById(R.id.txtRPass);
         txtConPass = (EditText)findViewById(R.id.txtRConPass);
         txtMobile = (EditText)findViewById(R.id.txtRMobile);

    }
}