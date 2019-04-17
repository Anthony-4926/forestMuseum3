package com.forestmuseum;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class home_fragment extends Fragment {
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




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
/***********************轮播图***********************/
        //获取ViewFlipper
        flipper = getActivity().findViewById(R.id.viewFlipper);
        for (int i = 0; i < images.length; i++) {      //遍历图片数组中的图片
            ImageView imageView = new ImageView(getActivity());  //创建ImageView对象
            imageView.setImageResource(images[i]);  //将遍历的图片保存在ImageView中
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            flipper.addView(imageView);             //加载图片
        }
        //初始化动画数组
        animation[0] = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right); //右侧平移进入动画
        animation[1] = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left); //左侧平移退出动画
        flipper.setInAnimation(animation[0]);   //为flipper设置图片进入动画效果
        flipper.setOutAnimation(animation[1]);  //为flipper设置图片退出动画效果

        message = Message.obtain();       //获得消息对象
        message.what = FLAG_MSG;  //设置消息代码
        handler.sendMessage(message); //发送消息


/*******************************单元列表***********************************/

        ListView listView = getActivity().findViewById(R.id.unitList);
//        创建适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(), R.layout.unit_item,
                new String[]{"unit_img"}, new int[]{R.id.unit_img});
        listView.setAdapter(adapter);

//        添加监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), String.valueOf(id),Toast.LENGTH_SHORT).show();
                if(id==1){
                    startActivity(new Intent(getActivity(), Unit01DetailActivity.class));
                }
            }
        });

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


    /*
     * 创建item资源
     * @return
     */

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("unit_img", R.drawable.unit00);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit01);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit02);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit03);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit04);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit05);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit06);
        list.add(map);

        map = new HashMap<>();
        map.put("unit_img", R.drawable.unit07);
        list.add(map);
        return list;
    }


}
