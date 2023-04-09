package com.example.firebase;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {
    ProgressBar pb1;
    EditText ed1;
    EditText ed2;
    static EditText ed3;
    FirebaseAuth mAuth;
    Button bt1;
    TextView tv1,tv2r;
    static  String name;
    @Override

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){  // USER DOES  EXISTS
            Intent intent = new Intent(getApplicationContext(),login.class);
            startActivity(intent);
            finish();
        }
    }






    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pb1 = findViewById(R.id.Pb1);
        bt1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.ed1);
        mAuth = FirebaseAuth.getInstance();
        ed2 = findViewById(R.id.ed2);

        tv1 = findViewById(R.id.tv1);
        tv2r = findViewById(R.id.tv2r);
        tv2r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,login.class);
                startActivity(intent);
                finish();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ed1.getText().toString();

                pb1.setVisibility(View.VISIBLE);
                String password = String.valueOf(ed2.getText());
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this, "ENTER EMAIL", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this, "ENTER PASSWORD", Toast.LENGTH_SHORT).show();
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                pb1.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(Register.this,login.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(Register.this, "Authentication Successful.",
                                            Toast.LENGTH_SHORT).show();



                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
    }

}