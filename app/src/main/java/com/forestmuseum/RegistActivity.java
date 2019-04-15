package com.forestmuseum;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.forestmuseum.controller.UserService;
import com.forestmuseum.entity.User;
import com.forestmuseum.tools.DataCheck;


public class RegistActivity extends Activity {
    private String password;
    private String conPassword;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        final Button registButton = findViewById(R.id.regist_button);
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLegal = true;
                userName = ((EditText) findViewById(R.id.r_userName)).getText().toString();
                password = ((EditText) findViewById(R.id.r_password)).getText().toString();
                conPassword = ((EditText) findViewById(R.id.confirm_password)).getText().toString();
//                用户名校验
                if (!DataCheck.isMobileNO(userName)) {
                    isLegal = false;
                    Toast.makeText(RegistActivity.this, "用户名不合法", Toast.LENGTH_SHORT).show();
                }
//                密码校验
                System.out.println(DataCheck.isPassword(password));
                System.out.println(DataCheck.isPassword(conPassword));
                if (DataCheck.isPassword(password) && DataCheck.isPassword(conPassword)) {
                    if (!password.equals(conPassword)) {
                        Toast.makeText(RegistActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                        isLegal = false;
                    }
                } else {
                    isLegal = false;
                    Toast.makeText(RegistActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if (isLegal) {
//                    持久化
                    UserService.saveProUserInfo(getApplicationContext(), new User(userName, password));
                }
            }
        });
    }
}
