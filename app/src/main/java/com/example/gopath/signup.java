package com.example.gopath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class signup extends AppCompatActivity {

    private EditText emailET;
    private EditText passwordET;
    private EditText confirm;
    private Button signUp;
    private EditText nameET;
    private TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailET = findViewById(R.id.emailInput);
        passwordET = findViewById(R.id.passwordInput);
        signin = findViewById(R.id.signInText);
        signUp = findViewById(R.id.signUpButton);
        init();
    }
    private void init(){
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(signup.this, SignIn.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String pass = passwordET.getText().toString();
                String name = nameET.getText().toString();
                if( true ){
                    FBRef.auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                User user = new User(name,email,pass);
                                FBRef.users.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {
                                        if( task.isSuccessful()){
                                            Intent intent = new Intent(signup.this, SignIn.class);
                                            startActivity(intent);
                                        }

                                    }

                                });

                            }else{
                                Toast.makeText(signup.this, "error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(signup.this, "error", Toast.LENGTH_SHORT).show();
                            }


                //testEmail(email.getText().toString(),password.getText().toString());

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
