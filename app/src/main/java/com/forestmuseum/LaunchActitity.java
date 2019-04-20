package com.forestmuseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActitity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_actitity);
        Integer time = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActitity.this,MainActivity.class));
//                startActivity(new Intent(LaunchActitity.this, LoginActivity.class));
//                startActivity(new Intent(LaunchActitity.this, DialogActivity.class));
                LaunchActitity.this.finish();
            }
        },time);
    }
}
