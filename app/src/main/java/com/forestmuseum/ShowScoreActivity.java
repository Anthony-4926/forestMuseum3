package com.forestmuseum;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);
        TextView score =  findViewById(R.id.score);
        System.out.println(getIntent().getStringExtra("score"));
        score.setText(getIntent().getStringExtra("score"));
    }


}
