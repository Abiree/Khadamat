 package com.example.khadamat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.khadamat.Home.HomeActivity;

 public class MainActivity extends AppCompatActivity {
    //variables d'animation
     Animation topAnim,bottomAnim;
     //image and text
     ImageView logo;
     TextView welcome,to,khadamat;
     //splashscreenduration
     private static int SPLASH_SCREEN = 3500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pour eliminer la barre de status du tele
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        //loading animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //applying animations
        logo=(ImageView)findViewById(R.id.Logo);
        welcome=(TextView)findViewById(R.id.Welcome);
        to=(TextView)findViewById(R.id.To);
        khadamat=(TextView)findViewById(R.id.khadamat);
        logo.setAnimation(topAnim);
        welcome.setAnimation(bottomAnim);
        khadamat.setAnimation(bottomAnim);
        to.setAnimation(bottomAnim);
        //go to main page after a certain duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);


    }
}