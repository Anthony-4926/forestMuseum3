package com.forestmuseum;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.forestmuseum.HelpFragment;
import com.forestmuseum.LocalFragment;
import com.forestmuseum.Mefragement;
import com.forestmuseum.R;
import com.forestmuseum.home_fragment;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView1 = (ImageView) findViewById(R.id.home);//获取布局文件的第一个导航图片
        ImageView imageView2 = (ImageView) findViewById(R.id.location);//获取布局文件的第二个导航图片
        ImageView imageView3 = (ImageView) findViewById(R.id.help);//获取布局文件的第三个导航图片
        ImageView imageView4 = (ImageView) findViewById(R.id.me);//获取布局文件的第四个导航图片
        imageView1.setOnClickListener(l);//为第一个导航图片添加单机事件
        imageView2.setOnClickListener(l);//为第二个导航图片添加单机事件
        imageView3.setOnClickListener(l);//为第三个导航图片添加单机事件
        imageView4.setOnClickListener(l);//为第四个导航图片添加单机事件
    }

    //创建单机事件监听器
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();   // 获取Fragment
            FragmentTransaction ft = fm.beginTransaction(); // 开启一个事务
            Fragment f = null; //为Fragment初始化
            switch (v.getId()) {    //通过获取点击的id判断点击了哪个张图片
                case R.id.home:
                    f = new home_fragment(); //创建第一个Fragment
                    break;
                case R.id.location:
                    f = new LocalFragment();//创建第二个Fragment
                    break;
                case R.id.help:
                    f = new HelpFragment();//创建第三个Fragment
                    break;
                case R.id.me:
                    f = new Mefragement();//创建第四个Fragment
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment, f);
            ft.commit(); //提交事务
        }
    };
}
