package com.forestmuseum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forestmuseum.controller.ImagesService;
import com.forestmuseum.entity.Image;

import java.util.List;
import java.util.Map;

public class Unit03DetailActivity extends AppCompatActivity {
    //    所有图片对象
    private Map<Integer, Image> imgs = ImagesService.imgs;
    //    图片索引
    private List<Integer> pic = ImagesService.pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit03_detail);

        LinearLayout left = findViewById(R.id.left_img_3);
        LinearLayout right = findViewById(R.id.right_img_3);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LinearLayout left = findViewById(R.id.left_img_3);
//                LinearLayout right = findViewById(R.id.right_img_3);
//                for (int i = 7; i <20; i += 2) {
//                    ImageView  imageView = new ImageView(Unit03DetailActivity.this);
//                    ImageView imageView2 = new ImageView(Unit03DetailActivity.this);
//
//                    LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    imageView.setLayoutParams(paramsImageView);
//                    LinearLayout.LayoutParams layoutParamsImageView = (LinearLayout.LayoutParams) imageView.getLayoutParams();
//                    layoutParamsImageView.setMargins(10,10,10,10);
//
//
//                    imageView.setImageResource(pic.get(i));
//                    imageView.setId(pic.get(i));
//                    imageView.setAdjustViewBounds(true);
//                    imageView.setOnClickListener(L);
//
//                    left.addView(imageView, layoutParamsImageView);
//                    imageView2.setImageResource(pic.get(i+1));
//                    imageView2.setAdjustViewBounds(true);
//                    imageView2.setId(pic.get(i+1));
//                    right.addView(imageView2 , layoutParamsImageView);
//                    imageView2.setOnClickListener(L);
//                }
//            }
//        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LinearLayout left = findViewById(R.id.left_img_3);
//                LinearLayout right = findViewById(R.id.right_img_3);
//                for (int i = 13; i < 20; i += 2) {
//                    ImageView  imageView = new ImageView(Unit03DetailActivity.this);
//                    ImageView imageView2 = new ImageView(Unit03DetailActivity.this);
//
//                    LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    imageView.setLayoutParams(paramsImageView);
//                    LinearLayout.LayoutParams layoutParamsImageView = (LinearLayout.LayoutParams) imageView.getLayoutParams();
//                    layoutParamsImageView.setMargins(10,10,10,10);
//
//
//                    imageView.setImageResource(pic.get(i));
//                    imageView.setId(pic.get(i));
//                    imageView.setAdjustViewBounds(true);
//                    imageView.setOnClickListener(L);
//
//                    left.addView(imageView, layoutParamsImageView);
//                    imageView2.setImageResource(pic.get(i+1));
//                    imageView2.setAdjustViewBounds(true);
//                    imageView2.setId(pic.get(i+1));
//                    right.addView(imageView2 , layoutParamsImageView);
//                    imageView2.setOnClickListener(L);
//                }
//            }
//        }).start();

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LinearLayout left = findViewById(R.id.left_img_3);
//                LinearLayout right = findViewById(R.id.right_img_3);
//                for (int i = 15; i < 19; i += 2) {
//                    ImageView  imageView = new ImageView(Unit03DetailActivity.this);
//                    ImageView imageView2 = new ImageView(Unit03DetailActivity.this);
//
//                    LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    imageView.setLayoutParams(paramsImageView);
//                    LinearLayout.LayoutParams layoutParamsImageView = (LinearLayout.LayoutParams) imageView.getLayoutParams();
//                    layoutParamsImageView.setMargins(10,10,10,10);
//
//
//                    imageView.setImageResource(pic.get(i));
//                    imageView.setId(pic.get(i));
//                    imageView.setAdjustViewBounds(true);
//                    imageView.setOnClickListener(L);
//
//                    left.addView(imageView, layoutParamsImageView);
//                    imageView2.setImageResource(pic.get(i+1));
//                    imageView2.setAdjustViewBounds(true);
//                    imageView2.setId(pic.get(i+1));
//                    right.addView(imageView2 , layoutParamsImageView);
//                    imageView2.setOnClickListener(L);
//                }
//            }
//        }).start();
//
        for (int i = 7; i < 20; i += 2) {
            ImageView imageView = new ImageView(this);
            ImageView imageView2 = new ImageView(this);

            LinearLayout.LayoutParams paramsImageView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(paramsImageView);
            LinearLayout.LayoutParams layoutParamsImageView = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParamsImageView.setMargins(10,10,10,10);


            imageView.setImageResource(pic.get(i));
            imageView.setId(pic.get(i));
            imageView.setAdjustViewBounds(true);
            imageView.setOnClickListener(L);

            left.addView(imageView, layoutParamsImageView);
            imageView2.setImageResource(pic.get(i+1));
            imageView2.setAdjustViewBounds(true);
            imageView2.setId(pic.get(i+1));
            right.addView(imageView2 , layoutParamsImageView);
            imageView2.setOnClickListener(L);
        }
    }

    //    对图片进行监听
    View.OnClickListener L = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Unit03DetailActivity.this, ItemFormatActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id", v.getId());
            bundle.putInt("sound", imgs.get(v.getId()).getSound());
            bundle.putString("title", imgs.get(v.getId()).getTitle());
            bundle.putString("content", imgs.get(v.getId()).getContent());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };
}
