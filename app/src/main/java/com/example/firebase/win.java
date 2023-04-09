package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;

public class win extends AppCompatActivity {

    FirebaseUser user;


    String name;

    String gender;
    String type;
    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference reference;
    Button bit2;
    Button bit1;
    EditText ed1;
    EditText ed2;
    EditText ed3;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        bit1 = findViewById(R.id.but1);
        bit2 = findViewById(R.id.but2);
        db = FirebaseDatabase.getInstance();
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);


         bit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = ed1.getText().toString();

                gender = ed2.getText().toString();
                type = ed1.getText().toString();

                String values[] = {name, gender, type};
                if (!name.isEmpty()&& !gender.isEmpty()&&!type.isEmpty()){

//                    database user = new database(name,age,gender,type);
                        HashMap<String, Object> data = new HashMap<>(); // DIC
                        data.put("Name",name);
                        data.put("Gender",gender);
                        data.put("TYPE",type);

                        db.getReference().child("USER").push().setValue(data);


                        Toast.makeText(win.this, "DETAILS ADDED", Toast.LENGTH_LONG).show();
//                    reference.child().setValue(user);
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Log.d("final","This is   "+user);
//                            binding.ed1.setText("");
//                            binding.ed2.setText("");
//                            binding.ed3.setText("");



//                        }
//                    });
                }

                else{

                    Toast.makeText(win.this, "ENTER ALL DETAILS", Toast.LENGTH_LONG).show();
                }



            }
        });

        //LOGOUT




        bit2.setOnClickListener(new View.OnClickListener() {
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