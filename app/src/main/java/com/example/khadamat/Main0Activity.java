package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.khadamat.ui.login.LoginActivity;

public class Main0Activity extends AppCompatActivity {

    //splashscreenduration
    private static int SPLASH_SCREEN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
    }

    public void onClickClient(View view) {
    }

    public void onClickService(View view) {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Main0Activity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);


    }
    }

