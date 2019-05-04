package com.forestmuseum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        TextView score = findViewById(R.id.score);
        score.setText(String.valueOf(getIntent().getIntExtra("score", 0)*10));
        if (getIntent().getIntExtra("score", 0)>=8){
            TextView gift = findViewById( R.id.gift_text);
           gift.setVisibility(TextView.VISIBLE);
        }
//        score.setImageResource(getpic(getIntent().getIntExtra("score", 0)));
    }





}
