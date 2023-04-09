package com.example.firebase;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import java.util.Collections;
import java.util.List;

public class Questions extends AppCompatActivity implements View.OnClickListener {

     static int index = 0;

    TextView question, option1, option2, rv1;
    CardView cv1, cv2, cv3;
    Button button,bit1,bit2,exit;
    static int introvert = 0;
    static int extrovert = 0;
    int totQ = ques.Question.length;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        question = findViewById(R.id.question);
      //  option1 = findViewById(R.id.option1);
       // option2 = findViewById(R.id.option2);
        button = findViewById(R.id.button);

        bit1 = findViewById(R.id.bit1);
        bit2 = findViewById(R.id.bit2);
        exit = findViewById(R.id.exit);
       // cv2 = findViewById(R.id.cv2);
      //  cv3 = findViewById(R.id.cv3);




        bit1.setOnClickListener(this);
        bit2.setOnClickListener(this);
        button.setOnClickListener(this);


        setall();


    }


    @Override
    public void onClick(View v) {
        Button click = (Button) v;
        AlertDialog.Builder builder;
        TextView click2 = (TextView) v;
        // CardView click1 = (CardView) v;
       //  TextView click2 = (TextView) v;
        bit1.setBackgroundColor(getResources().getColor(R.color.white));
        bit2.setBackgroundColor(getResources().getColor(R.color.white));
        if (click.getId() == button.getId()) {   // NEXT BUTTON
                    index++;
            Log.d("debugger","initial if\t "+index);
                    if (index == 10)  {


                        String res;
                        if (introvert > extrovert) {
                            res = "YOU ARE AN INTROVERT";
                        } else if (introvert == extrovert) {
                            res = "YOU ARE AN AMBIVERT";
                        } else {
                            res = "YOU ARE AN EXTROVERT";
                            Log.d("debugger","gregrt"+res);
                        }

                            builder = new AlertDialog.Builder(this);
                            builder.setTitle("RESULTS! ").setMessage(res).setCancelable(false).setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Questions.this, win.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).show();













                    }


                       else {
                        question.setText(ques.Question[index]);
                        bit1.setText(ques.choice[index][0]);
                        bit2.setText(ques.choice[index][1]);
                    }








        } else if (click.getId() == bit1.getId()) {     // First card
            introvert = introvert + 2;
            bit1.setBackgroundColor(getResources().getColor(R.color.light_green));
            bit2.setBackgroundColor(getResources().getColor(R.color.white));


        } else if (click.getId() == bit2.getId()) {     // First card
            extrovert = extrovert + 2;
            bit2.setBackgroundColor(getResources().getColor(R.color.light_green));
            bit1.setBackgroundColor(getResources().getColor(R.color.white));


        }
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Questions.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void setall() {
        /*   Questions and options  */

        if (index == 10) {
            Final();
        }
        question.setText(ques.Question[index]);
        bit1.setText(ques.choice[index][0]);
        bit2.setText(ques.choice[index][1]);
    }




    public void Final() {  /* Next Act */

        String res = "";
        if (introvert > extrovert) {
            res = "YOU ARE AN INTROVERT";
        } else if (introvert == extrovert) {
            res = "YOU ARE AN AMBIVERT";
        } else {
            res = "YOU ARE AN EXTROVERT";
        }


        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(res);
        alertDialog.setMessage("\nTHANK YOU!");
        alertDialog.setButton(1, "CONTINUE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Questions.this, win.class);
                startActivity(intent);
                finish();
            }
        });

        alertDialog.show();


        // ("CONTINUE",(dialogInterface, i)-> Continue() ).setCancelable(false).show();


    }


    public void Continue() {
        Intent intent = new Intent(Questions.this, win.class);
        startActivity(intent);
        finish();
    }






}