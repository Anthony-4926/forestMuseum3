package com.forestmuseum.entity;

/**
 * @author xinzhao
 * @create 2019-04-17 9:10
 */

public class Image {
    private int id;
    private String title;
    private String content;
    private int sound;
    private String pinyin;

    public String getPinyin() {
        return pinyin;
    }

    public Image(int id, String title, String pinyin, String content, int sound) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.sound = sound;
        this.pinyin = pinyin;
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
