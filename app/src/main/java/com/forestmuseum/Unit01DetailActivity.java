package com.forestmuseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forestmuseum.entity.Image;

import java.util.HashMap;
import java.util.Map;

public class Unit01DetailActivity extends Activity {
    Map<Integer, Image> imgs = getImgs();
    int[] pic = new int[]{
            R.drawable.pic_1, R.drawable.pic_2, R.drawable.pic_3, R.drawable.pic_4

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3

            , R.drawable.pic_2, R.drawable.pic_3
    };
    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit01_detail);
        LinearLayout left = findViewById(R.id.left_img);
        LinearLayout right = findViewById(R.id.right_img);


        for (int i = 0; i < pic.length; i += 2) {
            imageView = new ImageView(this);
            imageView2 = new ImageView(this);
            // Log.d("这是第几个图片", String.valueOf(i));
            imageView.setImageResource(pic[i]);
            imageView.setId(pic[i]);
            imageView.setAdjustViewBounds(true);
            imageView.setOnClickListener(L);

            left.addView(imageView);
            imageView2.setImageResource(pic[i + 1]);
            imageView2.setAdjustViewBounds(true);
            imageView2.setId(pic[i+1]);
            right.addView(imageView2);

            imageView2.setOnClickListener(L);
            //Log.d("+++++这是第几个图片", String.valueOf(i + 1));
        }
    }

    View.OnClickListener L = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title = imgs.get(v.getId()).getTitle();
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

    /**
     *创建资源
     * @return
     */

    public  static Map<Integer, Image> getImgs(){
        Map<Integer, Image> imgs = new HashMap<>();
        System.out.println(R.raw.kongziniao);
        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));


        /****************************************************/
        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_1,
                new Image(R.drawable.pic_1,
                        "孔子鸟",
                        "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。",
                        R.raw.kongziniao));
        imgs.put(R.drawable.pic_2,
                new Image(R.drawable.pic_2,"巨型马陆",
                        "巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。",
                        R.raw.kongziniao));

        imgs.put(R.drawable.pic_3, new Image(R.drawable.pic_3,"东北野牛" + "披毛犀",
                "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝",
                R.raw.kongziniao));

        imgs.put(R.drawable.pic_4, new Image(R.drawable.pic_4,"鹦鹉螺",
                "我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。",
                R.raw.kongziniao));

        return imgs;
    }



}
