package com.example.khadamat;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.google.firebase.auth.FirebaseAuth;



public class ProfileActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("My profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

            case R.id.logout:
                startActivityForResult(new Intent(ProfileActivity.this, logoutActivity.class), 1001);
                return true;


        }



//        if (item.getItemId()==R.id.item) {
//            startActivity(new Intent(ProfileActivity.this,SettingsActivity.class));
//            System.out.println(super.onOptionsItemSelected(item));
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
    }
}