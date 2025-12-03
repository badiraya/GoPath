package com.example.gopath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signin extends AppCompatActivity {
    private EditText email,password;
    private TextView signup;
    private Button signIn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        signup = findViewById(R.id.signUpText);
        signIn = findViewById(R.id.signInButton);
        aaaa();
    }
    private void aaaa(){
      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent();
              intent.setClass(signin.this, signup.class);
              startActivity(intent);
          }
      });
      signIn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              testEmail(email.getText().toString(),password.getText().toString());
          }
      });

    }
    private  void testEmail(String em ,String pass){
        if(em.length()>5&&pass.length()>7) {

        }else{
            if(em.length()<5){
                email.setError( "Email not valid");
            }
            if(pass.length()<7){
                email.setError( "for your account security,the password must be at least 8");
            }
        }
    }
}