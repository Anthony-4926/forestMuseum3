package com.forestmuseum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
//        TextView score =  findViewById(R.id.score);
        ImageView score = findViewById(R.id.score);
        System.out.println(getIntent().getIntExtra("score", 0));
//        score.setText(String.valueOf(getIntent().getIntExtra("score", 0)));
        score.setImageResource(getpic(getIntent().getIntExtra("score", 0)));
    }


    public static int getpic(int s) {
        int id = R.drawable.s0;
        switch (s) {
            case 1:
                id = R.drawable.s10;
                break;
            case 2:
                id = R.drawable.s20;
                break;
            case 3:
                id = R.drawable.s30;
                break;
            case 4:
                id = R.drawable.s40;
                break;
            case 5:
                id = R.drawable.s50;
                break;
            case 6:
                id = R.drawable.s60;
                break;
            case 7:
                id = R.drawable.s70;
                break;
            case 8:
                id = R.drawable.s80;
                break;
            case 9:
                id = R.drawable.s90;
                break;
            case 10:
                id = R.drawable.s100_;
                break;
        }
        return id;
    }


}
