package com.forestmuseum;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.TextView;

public class ShowScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       TextView score =  findViewById(R.id.score);
        System.out.println("*****************"+ data.getIntExtra("score", 200));
       score.setText(data.getIntExtra("score", 0));
       score.setTextSize(30);
    }
}
