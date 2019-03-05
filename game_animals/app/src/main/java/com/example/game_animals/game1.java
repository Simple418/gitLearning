package com.example.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game1 extends AppCompatActivity {

    int score;
    Button btn_go_on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

       // TextView textView3 =(TextView)this.findViewById(R.id.textView3);
       // textView3.setText(score1);
        Intent getintent=getIntent();
        String temp = null;
        temp=getintent.getStringExtra("selectBearScore");
        score=Integer.parseInt(temp);

        settextname();

        btn_go_on = findViewById(R.id.btn_go_on);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font_one.TTF");
        btn_go_on.setTypeface(typeface);
        btn_go_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(game1.this,game2.class);
                intent.putExtra("selectBearScore",String.valueOf(score));
                startActivity(intent);
            }
        });

    }
    private void settextname(){

        TextView text5 =this.findViewById(R.id.textView3);
        text5.setText(" "+score);
    }
}
