package com.example.khadamat.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.Prevalent.Prevalent;
import com.example.khadamat.R;
import com.example.khadamat.RegisterActivity;
import com.example.khadamat.ResetPasswordActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    //splashscreenduration
    private static int SPLASH_SCREEN = 100;

    FirebaseAuth mAuth;
    private EditText Email, password;
    private   ProgressBar progressBar ;
    private Bundle extra;
    private CheckBox chkboxRememberme;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
//findviewbyid
        Email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.loading);
        chkboxRememberme=(CheckBox)findViewById(R.id.remember);
        // Initialize paper
        Paper.init(this);
        String UserEmailKey=Paper.book().read(Prevalent.UserEmailKey);
        String UserPasswordKey=Paper.book().read(Prevalent.UserPasswordKey);
        if(UserEmailKey!="" && UserPasswordKey!=""){
            if(!TextUtils.isEmpty(UserEmailKey)&& !TextUtils.isEmpty(UserPasswordKey)){
                Email.setText(UserEmailKey);
                password.setText(UserPasswordKey);
            }
        }


    }


    public void onClickRegister(View view) {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        },SPLASH_SCREEN);
    }

    public void login(View view) {

        String email = Email.getText().toString().trim();
        final String Password = password.getText().toString().trim();
        if (Password.isEmpty()) {
            password.setError("Le mot de passe est requis");
            password.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            Email.setError("Email est requis");
            Email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Email n'est pas valider");
            Email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

       AllowAccessToAccount(email,Password);

    }
    private void AllowAccessToAccount(final String email, final String Password)
    {
        if(chkboxRememberme.isChecked())
        {
            Paper.book().write(Prevalent.UserEmailKey, email);
            Paper.book().write(Prevalent.UserPasswordKey, Password);
        }
        //authenticate user
        mAuth.signInWithEmailAndPassword(email, Password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (Password.length() < 6) {
                                password.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {

                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    public void reset_password(View view) {
        Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
    }
}
