package com.example.baitaptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        pass= findViewById(R.id.pass);
        btnLogin=findViewById(R.id.login);

        String userName= name.getText().toString().trim();
        String password= pass.getText().toString().trim();
        if(userName.isEmpty()){
            name.setError("Name khong duoc rong");
            name.requestFocus();
        }
        if(password.isEmpty()){
            name.setError("Pass khong duoc rong");
            name.requestFocus();
        }

        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(userName,password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(MainActivity.this,UserActivity.class);
                    }
                });



    }


}