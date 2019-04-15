package com.forestmuseum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.forestmuseum.controller.UserService;
import com.forestmuseum.entity.User;
import com.forestmuseum.tools.DataCheck;

import java.io.File;
import java.io.FileOutputStream;

public class LoginActivity extends Activity {
    private String userName;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        creatInfo(getApplicationContext());
//        已经登录的用户，下次无需再次登录
        if (!UserService.getProObject(getApplicationContext()).isEmpty()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            LoginActivity.this.finish();
        }

        Button btn = findViewById(R.id.loginButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = ((EditText) findViewById(R.id.userName)).getText().toString();
                password = ((EditText) findViewById(R.id.password)).getText().toString();

                boolean isLegal = true;
                if (!DataCheck.isMobileNO(userName)) {
                    isLegal = false;
                    Toast.makeText(LoginActivity.this, "用户名不合法", Toast.LENGTH_SHORT).show();

                }
                if (!DataCheck.isPassword(password)) {
                    isLegal = false;
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if (isLegal) {
                    if (UserService.isExist(new User(userName, password), getApplicationContext())) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        LoginActivity.this.finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


//        跳转注册页面
        TextView regist = findViewById(R.id.regist);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
            }
        });
    }


    /**
     * 创建info文件
     *
     * @param context
     */
    public static void creatInfo(Context context) {
        try {
            // 使用Android上下问获取当前项目的路径
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建输出流对象
            if (!file.exists()) {
                FileOutputStream fos = new FileOutputStream(file);
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
