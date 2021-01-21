package com.example.khadamat.CreateService;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.khadamat.Home.HomeActivity;
import com.example.khadamat.R;
import com.example.khadamat.RegisterActivity;
import com.example.khadamat.Service;
import com.example.khadamat.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CreateService extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText Tele,Description;
    private Spinner SpinnerVille,SpinnerService;
    private ProgressBar loading;
    private Bundle extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createservice);
        //hideActionBar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
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
        //SpinnerVille.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        SpinnerService.setAdapter(myAdapter2);
       // SpinnerService.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        mAuth = FirebaseAuth.getInstance();
        loading = (ProgressBar) findViewById(R.id.loading);
        Tele=(EditText)findViewById(R.id.Tele);
        Description=(EditText)findViewById(R.id.Description);
        extra = getIntent().getExtras();

    }

    public void gomain(View view) {
        String full_name= (String) extra.get("username");
        String email=extra.getString("email");
        String Password=extra.getString("password");
        String telephone = Tele.getText().toString().trim();
        String description = Description.getText().toString().trim();
        String ville =SpinnerVille.getSelectedItem().toString();
        String service =SpinnerService.getSelectedItem().toString();
        if (telephone.isEmpty()) {
            Tele.setError("Le telephone est requis");
            Tele.requestFocus();
            return;
        }
        if (description.isEmpty()) {
           Description.setError("La description de la service est requise");
            Description.requestFocus();
            return;
        }

        loading.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Service service1 = new Service(telephone,description,ville,service);
                            User user = new User(full_name, email, Password,service1);
                            FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(CreateService.this, "User has been registered successfully.",
                                                Toast.LENGTH_SHORT).show();
                                        loading.setVisibility(View.VISIBLE);
                                    } else {
                                        Toast.makeText(CreateService.this, "Failed to register.Try again",
                                                Toast.LENGTH_SHORT).show();
                                        loading.setVisibility(View.GONE);
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(CreateService.this, " failed to register.",
                                    Toast.LENGTH_SHORT).show();
                            loading.setVisibility(View.GONE);
                        }
                    }
                });
        Intent intent = new Intent(CreateService.this, HomeActivity.class);
        startActivity(intent);
    }
}