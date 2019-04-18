package com.forestmuseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forestmuseum.controller.ImagesService;
import com.forestmuseum.entity.Image;

import java.util.List;
import java.util.Map;

public class Unit01DetailActivity extends Activity {
//    所有图片对象
   private Map<Integer, Image> imgs = ImagesService.imgs;
//    图片索引
    private List<Integer> pic = ImagesService.pic;
    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit01_detail);
        LinearLayout left = findViewById(R.id.left_img);
        LinearLayout right = findViewById(R.id.right_img);
        for (int i = 0; i < pic.size(); i += 2) {
            imageView = new ImageView(this);
            imageView2 = new ImageView(this);
            // Log.d("这是第几个图片", String.valueOf(i));
            imageView.setImageResource(pic.get(i));
            imageView.setId(pic.get(i));
            imageView.setAdjustViewBounds(true);
            imageView.setOnClickListener(L);

            left.addView(imageView);
            imageView2.setImageResource(pic.get(i+1));
            imageView2.setAdjustViewBounds(true);
            imageView2.setId(pic.get(i+1));
            right.addView(imageView2);

            imageView2.setOnClickListener(L);
            //Log.d("+++++这是第几个图片", String.valueOf(i + 1));
        }
    }

    View.OnClickListener L = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            String title = imgs.get(v.getId()).getTitle();
//            Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Unit01DetailActivity.this, ItemFormatActivity.class);
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
