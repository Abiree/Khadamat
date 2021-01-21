package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.ui.login.LoginActivity;

public class Main0Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
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

