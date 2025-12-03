package com.example.gopath;

import com.google.firebase.auth.FirebaseAuth;

public class FBRef {
        public static FirebaseAuth auth = FirebaseAuth.getInstance();
        public static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

}
