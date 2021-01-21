package com.example.khadamat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.khadamat.CreateService.CreateService;
import com.example.khadamat.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private EditText username, Email, password, co_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }

        Email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.full_name);
        password = (EditText) findViewById(R.id.password);
        co_password = (EditText) findViewById(R.id.confirm_password);

    }

    public void createservice(View view) {
        registeruser();

    }

    private void registeruser() {
        String email = Email.getText().toString().trim();
        String full_name = username.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String confirm_password = co_password.getText().toString().trim();
        if (full_name.isEmpty()) {
            username.setError("Le nom complet est requis");
            username.requestFocus();
            return;
        }
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
        if (Password.length() < 6) {
            password.setError("Le mot de passe doit être constituer au moins de 6 characters ");
            password.requestFocus();
            return;
        }
        if (confirm_password.isEmpty()) {
            password.setError("Confirmez le mot de passe");
            password.requestFocus();
            return;
        }
        if (!confirm_password.equals(Password)) {
            password.setError("Le mot de passe n'est pas le même");
            password.requestFocus();
            return;
        }
        Intent intent = new Intent(RegisterActivity.this, CreateService.class);
        intent.putExtra("username",full_name);
        intent.putExtra("email",email);
        intent.putExtra("password",Password);
        startActivity(intent);

    }
}
