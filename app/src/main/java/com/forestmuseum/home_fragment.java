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
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.forestmuseum.controller.ImagesService;

import java.util.List;

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
    //    轮播图图片数组
    private int[] images = new int[]{R.drawable.pic_10, R.drawable.pic_14, R.drawable.pic_8};
    //    定义动画数组，为ViewFlipper指定切换动画
    private Animation[] animation = new Animation[2];
    //    自动提示需要的动物名字
    private List<String> names = ImagesService.getNames();
    private TextView seachItem;
    private LinearLayout seachList;


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
        /**********************搜索框******************************/
//        拿到搜索框和下列表
        seachList = getActivity().findViewById(R.id.seach_list);

        seachItem = new TextView(getActivity());
        final SearchView searchView = getActivity().findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                seachList.removeAllViews();
                for (int j = 0; j < names.size(); j++) {
                    boolean isExist = false;
                    int i = 0;
                    if (newText.length() != 0 && ImagesService.imgs
                            .get(ImagesService.getIdByPositon(j))
                            .getPinyin()
                            .contains(newText)) {
                        i = names.get(j).length();
                        isExist = true;
                    }
//                    判断是否已存在
                    for (; i < names.get(j).length(); i++) {
                        if (newText != null && newText.contains(names.get(j).charAt(i) + "")) {
                            isExist = true;
                            break;
                        }
                    }
//                    存在插入到页面
                    if (isExist) {
                        seachItem = new TextView(getActivity());
                        seachItem.setPadding(0, 10, 0, 10);
                        seachItem.setTextSize(16);
                        seachItem.setText(names.get(j));

                        seachItem.setId(ImagesService.getIdByPositon(j));
                        seachItem.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getActivity(), ItemFormatActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("id", v.getId());
                                bundle.putInt("sound", ImagesService.imgs.get(v.getId()).getSound());
                                bundle.putString("title", ImagesService.imgs.get(v.getId()).getTitle());
                                bundle.putString("content", ImagesService.imgs.get(v.getId()).getContent());
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                        seachList.addView(seachItem);
                    }
                }
                return false;
            }
        });

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
        RelativeLayout unit00 = getActivity().findViewById(R.id.unit_00);
        RelativeLayout unit01 = getActivity().findViewById(R.id.unit_01);
        RelativeLayout unit02 = getActivity().findViewById(R.id.unit_02);
        RelativeLayout unit03 = getActivity().findViewById(R.id.unit_03);
        RelativeLayout unit04 = getActivity().findViewById(R.id.unit_04);
        RelativeLayout unit05 = getActivity().findViewById(R.id.unit_05);
        RelativeLayout unit06 = getActivity().findViewById(R.id.unit_06);
        RelativeLayout unit07 = getActivity().findViewById(R.id.unit_07);

        unit00.setOnClickListener(L);
        unit02.setOnClickListener(L);
//        unit03.setOnClickListener(L);
        unit04.setOnClickListener(L);
        unit05.setOnClickListener(L);
        unit06.setOnClickListener(L);
        unit07.setOnClickListener(L);


        //        添加监听
        unit01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Unit01DetailActivity.class));
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.first_unit);
                mediaPlayer.start();
            }
        });
        unit03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Unit03DetailActivity.class));
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.unit_03);
                mediaPlayer.start();
            }
        });

    }

    //    对未开发单元统一监听
    View.OnClickListener L = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "单元还没开发呦", Toast.LENGTH_SHORT).show();
        }
    };


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
