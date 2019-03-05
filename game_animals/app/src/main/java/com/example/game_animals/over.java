package com.example.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class over extends AppCompatActivity {

    int final_score;
    Button btn_try_again,btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);

        Intent getintent=getIntent();
        String temp = null;
        temp=getintent.getStringExtra("selectBearScore");
        final_score=Integer.parseInt(temp);

        TextView textView5 =this.findViewById(R.id.textView5);
        textView5.setText(""+final_score);

        btn_try_again = findViewById(R.id.btn_try_again);
        btn_exit = findViewById(R.id.btn_exit);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font_one.TTF");
        btn_try_again.setTypeface(typeface);
        btn_exit.setTypeface(typeface);

        btn_try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(over.this,game.class);
                startActivity(intent);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


    }
}
