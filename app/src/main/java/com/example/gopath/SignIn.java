package com.example.gopath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    private EditText emailET,passwordET;
    private TextView signup;
    private Button signIn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        emailET = findViewById(R.id.emailInput);
        passwordET = findViewById(R.id.passwordInput);
        signup = findViewById(R.id.signUpText);
        signIn = findViewById(R.id.signInButton);
        aaaa();
    }
    private void aaaa(){
      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent();
              intent.setClass(SignIn.this, signup.class);
              startActivity(intent);
          }
      });
      signIn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             // testEmail(email.getText().toString(),password.getText().toString());
              String email = emailET.getText().toString();
              String pass = passwordET.getText().toString();
              FBRef.auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(task -> {
                  if(task.isSuccessful()){
                      Toast.makeText(SignIn.this, "success signin", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(SignIn.this, MainActivity.class);
                      startActivity(intent);
                  }else{
                      Toast.makeText(SignIn.this, "error", Toast.LENGTH_SHORT).show();
                  }
              });
              //Toast.makeText(SignIn.this, "error", Toast.LENGTH_SHORT).show();
          }
      });


    }
    private  void testEmail(String em ,String pass){
        if(em.length()>5&&pass.length()>7) {

        }else{
            if(em.length()<5){
                emailET.setError( "Email not valid");
            }
            if(pass.length()<7){
                emailET.setError( "for your account security,the password must be at least 8");
            }
        }
    }
}