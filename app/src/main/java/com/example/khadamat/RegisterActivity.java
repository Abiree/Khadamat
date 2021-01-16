package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.khadamat.CreateService.CreateService;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void createservice(View view) {
        Intent intent = new Intent(RegisterActivity.this, CreateService.class);
        startActivity(intent);
    }
}
