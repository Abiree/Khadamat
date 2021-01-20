package com.example.khadamat.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.khadamat.ProfileActivity;
import com.example.khadamat.R;
public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicee);
    }

    public void goprofile(View view) {
        Intent intent = new Intent(ServiceActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}