package com.example.khadamat.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khadamat.ProfileActivity;
import com.example.khadamat.R;
public class ServiceActivity extends AppCompatActivity {
    private TextView Name,serviceName,description,price;
    private ImageView serviceImage;
    private String tele;
    private Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicee);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        //getEelements
        Name = (TextView)findViewById(R.id.Name);
        serviceName=(TextView)findViewById(R.id.ServiceName);
        description=(TextView)findViewById(R.id.description);
        price=(TextView)findViewById(R.id.Price);
        serviceImage=(ImageView)findViewById(R.id.servImg) ;
        //getInfos from previous Acctivity
        extra = getIntent().getExtras();
        int img = (int) extra.get("serviceImg");
        String nameExtra = (String)extra.get("fullname");
        String servicenameExtra = (String)extra.get("servicename");
        String servicepriceExtra =(String)extra.get("serviceprice");
        String teleExtra = (String)extra.get("telephone");
        String descriptionExtra = (String)extra.get("servicedescription");
        Name.setText(nameExtra);
        serviceName.setText(servicenameExtra);
        description.setText(descriptionExtra);
        price.setText(servicepriceExtra);
        serviceImage.setImageDrawable(getApplicationContext().getResources().getDrawable(img,null));

    }

    public void goprofile(View view) {
        Intent intent = new Intent(ServiceActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}