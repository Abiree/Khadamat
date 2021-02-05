package com.example.khadamat.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.ProfileActivity;
import com.example.khadamat.R;
import com.example.khadamat.ServiceDetail;

import java.io.IOException;
import java.io.InputStream;

public class ServiceActivity extends AppCompatActivity {
    private TextView Name, serviceName, description, price, servicetype;
    private ImageView serviceImage;
    private String tele;
    private Bundle extra;
    private String nameExtra, servicenameExtra, servicepriceExtra, teleExtra, descriptionExtra, servicetypeextra, localisationExtra, villeExtra, ProfileImage;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicee);
        //hideActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //getEelements
        Name = (TextView) findViewById(R.id.Name);
        serviceName = (TextView) findViewById(R.id.ServiceName);
        description = (TextView) findViewById(R.id.description);
        price = (TextView) findViewById(R.id.Price);
        serviceImage = (ImageView) findViewById(R.id.servImg);
        servicetype = (TextView) findViewById(R.id.ServiceType);
        profileImage = (ImageView) findViewById(R.id.imageView2);
        //getInfos from previous Acctivity
        extra = getIntent().getExtras();
        int img = (int) extra.get("serviceImg");
        nameExtra = (String) extra.get("fullname");
        servicenameExtra = (String) extra.get("servicename");
        servicepriceExtra = (String) extra.get("serviceprice");
        teleExtra = (String) extra.get("telephone");
        descriptionExtra = (String) extra.get("servicedescription");
        servicetypeextra = (String) extra.get("servicetype");
        localisationExtra = (String) extra.get("localisation");
        villeExtra = (String) extra.get("city");
        ProfileImage = extra.getString("profileImage");
        //setting text
        Name.setText(nameExtra);
        serviceName.setText(servicenameExtra);
        description.setText(descriptionExtra);
        price.setText(servicepriceExtra);
        servicetype.setText(servicetypeextra);
        serviceImage.setImageDrawable(getApplicationContext().getResources().getDrawable(img, null));
        //setimageprofile

        if (!ProfileImage.equals("")) {
            LoadImage loadImage = new LoadImage(profileImage);
            loadImage.execute(ProfileImage);
        }
    }

    public void goprofile(View view) {
        Intent intent = new Intent(ServiceActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void goDetail(View view) {
        Intent intent = new Intent(ServiceActivity.this, ServiceDetail.class);
        intent.putExtra("nameService", servicenameExtra);
        intent.putExtra("nameDescription", descriptionExtra);
        intent.putExtra("ville", villeExtra);
        intent.putExtra("localisation", localisationExtra);
        startActivity(intent);
    }
    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        public LoadImage (ImageView result)
        {
            this.imageView = result;
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new java.net.URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            profileImage.setImageBitmap(bitmap);
        }
    }

}