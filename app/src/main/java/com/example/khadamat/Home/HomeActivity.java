package com.example.khadamat.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;

import com.example.khadamat.ProfileActivity;
import com.example.khadamat.R;
import com.example.khadamat.Service;
import com.example.khadamat.ServiceAdapter;
import com.example.khadamat.User;
import com.example.khadamat.service.ServiceActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    RecyclerView recyclerView;
    ServiceAdapter adapter;
    List<Service> serviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //hideActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //adapter settings;
        serviceList = new ArrayList<>();


        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ServiceAdapter(this, serviceList);
        recyclerView.setAdapter(adapter);

        //SELECT * from USERS

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Users");
        ref.addListenerForSingleValueEvent(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            serviceList.clear();
            if(snapshot.exists()){
                Log.i("child", String.valueOf(snapshot.getChildren()));
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                   User user = snapshot1.getValue(User.class);
                   serviceList.add(user.getService());
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };



    public void Service(View view) {
        Intent intent = new Intent(HomeActivity.this, ServiceActivity.class);
        startActivity(intent);
    }

    public void goprofile(View view) {
        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(intent);
    }



}