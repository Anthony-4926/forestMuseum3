package com.forestmuseum;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.forestmuseum.adapter.Adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListActivity extends Activity {
    //    定义要发送的消息代码
    final int FLAG_MSG = 0x001;
    //    定义ViewFlipper
    private ViewFlipper flipper;
    //    声明消息对象
    private Message message;
    //    定义图片数组
    private int[] images = new int[]{R.drawable.carousel_01, R.drawable.carousel_01,
            R.drawable.carousel_01, R.drawable.carousel_01,
            R.drawable.carousel_01, R.drawable.carousel_01};
    //    定义动画数组，为ViewFlipper指定切换动画
    private Animation[] animation = new Animation[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /************************轮播图************************/
        //获取ViewFlipper
        flipper = findViewById(R.id.viewFlipper);
        for (int i = 0; i < images.length; i++) {      //遍历图片数组中的图片
            ImageView imageView = new ImageView(this);  //创建ImageView对象
            imageView.setImageResource(images[i]);  //将遍历的图片保存在ImageView中
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            flipper.addView(imageView);             //加载图片
        }
        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right); //右侧平移进入动画
        animation[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left); //左侧平移退出动画
        flipper.setInAnimation(animation[0]);   //为flipper设置图片进入动画效果
        flipper.setOutAnimation(animation[1]);  //为flipper设置图片退出动画效果

        message = Message.obtain();       //获得消息对象
        message.what = FLAG_MSG;  //设置消息代码
        handler.sendMessage(message); //发送消息


        /********************************单元列表************************************/
        ListView listView =  ListActivity.this.findViewById(R.id.unitList);
        Adapter adapter = new Adapter(this, getData(), R.layout.unit_item,
                new String[]{"title", "subTitle"}, new int[]{R.id.title, R.id.subTitle});
        listView.setAdapter(adapter);
    }


    Handler handler = new Handler() {  //创建android.os.Handler对象
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == FLAG_MSG) {  //如果接收到的是发送的标记消息
                flipper.showPrevious();                  //示下一张图片
            }
            message = handler.obtainMessage(FLAG_MSG);   //获取要发送的消息
            handler.sendMessageDelayed(message, 3000);  //延迟3秒发送消息
        }
    };

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "01/第一单元");
        map.put("subTitle", "森林的演化与分布");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "02/第二单元");
        map.put("subTitle", "中国森林的分类与分布");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "03/第三单元");
        map.put("subTitle", "森林动物");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "00/序厅");
        map.put("subTitle", "");
        list.add(map);

        return list;
    }


}
