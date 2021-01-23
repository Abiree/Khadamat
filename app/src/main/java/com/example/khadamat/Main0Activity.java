package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main0Activity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        //session
        mAuth= FirebaseAuth.getInstance();
        firebaseUser=mAuth.getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(Main0Activity.this, HomeActivity.class));
        }
    }

    public void onClickClient(View view) {
        Intent intento = new Intent(Main0Activity.this, HomeActivity.class);
        startActivity(intento);
    }

    public void onClickService(View view) {

            Intent intent = new Intent(Main0Activity.this, LoginActivity.class);
            startActivity(intent);

    }
    }

