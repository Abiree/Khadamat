package com.example.khadamat;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;


public class logoutActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        //get firebase auth instance
       mAuth = FirebaseAuth.getInstance();
        signOut();
        Intent i = new Intent(logoutActivity.this, Main0Activity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finishActivity(1001);
        finish();

    }

    //sign out method
    public void signOut() {
        mAuth.signOut();
    }



}