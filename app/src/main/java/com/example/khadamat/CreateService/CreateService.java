package com.example.khadamat.CreateService;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.R;

public class CreateService extends AppCompatActivity {
    Spinner SpinnerVille,SpinnerService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createservice);
        //recuperer les spinners
        SpinnerVille = (Spinner)findViewById(R.id.Ville);
        SpinnerService = (Spinner)findViewById(R.id.Service);
        //configurer les adapter
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(CreateService.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Villes));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(CreateService.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Services));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         //configuer les spinners
        SpinnerVille.setAdapter(myAdapter1);
        SpinnerService.setAdapter(myAdapter2);
    }

    public void gomain(View view) {
        Intent intent = new Intent(CreateService.this, HomeActivity.class);
        startActivity(intent);
    }
}