package com.example.gopath;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBRef {
        public static FirebaseAuth auth = FirebaseAuth.getInstance();
        public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        public static DatabaseReference users = database.child("Users");




}
