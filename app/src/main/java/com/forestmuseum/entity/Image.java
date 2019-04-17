package com.forestmuseum.entity;

import android.util.Log;

/**
 * @author xinzhao
 * @create 2019-04-17 9:10
 */

public class Image {
    private int id;
    private String title;
    private String content;
    private int sound;

    public Image(int id, String title, String content, int sound) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sound = sound;
        Log.d("构造的时候传过来的是", String.valueOf(sound));
    }

    //下边内容与Image类无关,传递数据用的。


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getSound() {
        return sound;
    }

}
