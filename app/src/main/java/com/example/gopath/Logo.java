package com.example.gopath;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseUser;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Thread t = new Thread(new logoThread());
        t.start();
    }
    public class logoThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                FirebaseUser user = FBRef.auth.getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(Logo.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(Logo.this, SignIn.class);
                    startActivity(intent);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}



