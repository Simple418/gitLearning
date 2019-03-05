package com.example.game_animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class game2 extends AppCompatActivity {
    int score;
    Button kangaroo,hypo,tiger,leo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        Intent getintent=getIntent();
        String temp = null;
        temp=getintent.getStringExtra("selectBearScore");
        score=Integer.parseInt(temp);

        init1();
        btn1();

    }

    private void init1(){
        kangaroo = findViewById(R.id.kangaroo);
        hypo = findViewById(R.id.hypo);
        tiger = findViewById(R.id.tiger);
        leo = findViewById(R.id.leo);
    }
    private void btn1()
    {

        kangaroo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=0;
                Intent intent = new Intent();
                intent.setClass(game2.this,over.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);

            }
        });
        hypo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=0;
                Intent intent = new Intent();
                intent.setClass(game2.this,over.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);

            }
        });

        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=0;
                Intent intent = new Intent();
                intent.setClass(game2.this,over.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);

            }
        });

        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score+=50;
                Intent intent = new Intent();
                intent.setClass(game2.this,over.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
            }
        });
    }
}
