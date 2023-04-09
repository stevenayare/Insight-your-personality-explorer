package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

        FirebaseAuth mAuth;
        Button  bt1;
        Button   bt2;
        TextView tv1;
        FirebaseUser user;


        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                mAuth = FirebaseAuth.getInstance();
                tv1 = findViewById(R.id.tv1);
                bt1 = findViewById(R.id.button);
                bt2 = findViewById(R.id.bt2);
                user = mAuth.getCurrentUser();
                if (user == null) {  // USER DOES NOT EXISTS
                        Intent intent = new Intent(getApplicationContext(), login.class);
                        startActivity(intent);
                        finish();
                } else {


                }

                bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(),Questions.class);
                                startActivity(intent);

                        }
                });

                bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(getApplicationContext(), login.class);
                                startActivity(intent);
                                finish();
                        }
                });


        }
}


