package com.example.khadamat.Home;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.khadamat.ProfileActivity;
import com.example.khadamat.R;
import com.example.khadamat.service.ServiceActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }

    public void Service(View view) {
        Intent intent = new Intent(HomeActivity.this, ServiceActivity.class);
        startActivity(intent);
    }

    public void goprofile(View view) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}