package com.forestmuseum;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

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

    private int[] unitList = new int[]{R.drawable.unit00, R.drawable.unit01, R.drawable.unit02, R.drawable.unit03,
            R.drawable.unit04, R.drawable.unit05, R.drawable.unit06, R.drawable.unit07};

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

        LinearLayout linearLayout = getActivity().findViewById(R.id.unit_list);
        for (int i = 0; i < unitList.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(unitList[i]);
            imageView.setId(unitList[i]);
//            imageView.setMaxHeight(70);
            imageView.setAdjustViewBounds(true);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //        添加监听

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getActivity(), String.valueOf(id),Toast.LENGTH_SHORT).show();
                    if (v.getId() == unitList[1]) {
                        startActivity(new Intent(getActivity(), Unit01DetailActivity.class));
                        MediaPlayer mediaPlayer;
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.first_unit);
                        mediaPlayer.start();
                    } else {
                        Toast.makeText(getActivity(), "单元待开发", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }


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


}
