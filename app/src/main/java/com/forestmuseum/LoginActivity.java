package com.forestmuseum;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.forestmuseum.R;

public class LoginActivity extends Activity {
    private String userName;
    private String password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = ((EditText)findViewById(R.id.userName)).getText().toString();
                password = ((EditText)findViewById(R.id.password)).getText().toString();
                System.out.println("用户名是："+userName);
                System.out.println("密码是："+password);
            }
        });
    }
}
