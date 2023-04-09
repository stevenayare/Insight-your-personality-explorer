package com.example.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Splash extends AppCompatActivity {

     // public static ArrayList<ques> q;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      /*  q =  new ArrayList<>();
        q.add(new ques("You tend to find talking to new people: ","Energizing"," Awkward"));
        q.add(new ques("In general, which of the two are you more likely to feel?  ","Bored and understimulated  ","Overwhelmed and overstimulated"));
        q.add(new ques("You usually get more joy out of:  ","Reading a great book ","Watching a great movie "));
        q.add(new ques("You would hate working with someone who’s:  ","Timid and meek ","Brash and Rude "));
        q.add(new ques("You feel more yourself when you’re:  ","In the background ","The center of attention "));
        q.add(new ques("The people who know you best are more likely to describe you as someone who’s:  ","Quiet and reflective ","Outgoing and talkative "));
        q.add(new ques("In your free time on the weekend, you'd prefer:  ","Sharing a deep conversation with a good friend ","Mingling at a party filled with people you've never met before "));
        q.add(new ques("When you meet someone for the first time:  ","You usually do most of the listening ","You usually do most of the talking "));
        q.add(new ques("You’re more likely to recharge your batteries by:  ","Getting some alone time ","Going out with a group of friends "));
        q.add(new ques("You’re more productive when you’re:  ","In a quiet room ","In a Cafe ")); */






        new Handler().postDelayed(new Runnable() { /* Pararrel threading */
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,login.class);
                startActivity(intent);

            }
        }, 4000);




    }
}