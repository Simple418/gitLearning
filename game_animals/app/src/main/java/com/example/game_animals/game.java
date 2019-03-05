package com.example.game_animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class game extends AppCompatActivity {

    int score = 0;
    Button bear,cat,elephant,giraffe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        init();
        btn_click();

    }

    private void init(){

        bear = findViewById(R.id.hypo);
        cat = findViewById(R.id.kangaroo);
        elephant = findViewById(R.id.leo);
        giraffe = findViewById(R.id.tiger);
    }

    private void btn_click(){

        bear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(game.this,game1.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
               // startActivity(new Intent(game.this,game1.class));

            }
        });
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(game.this,game1.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
               // startActivity(new Intent(game.this,game1.class));

            }
        });

        elephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(game.this,game1.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
               // startActivity(new Intent(game.this,game1.class));

            }
        });

        giraffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                score+=50;
                Intent intent = new Intent();
                intent.setClass(game.this,game1.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
                //startActivity(new Intent(game.this,game1.class));
            }
        });

    }

}
