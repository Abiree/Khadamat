package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_description);
        setTitle("Edit");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}