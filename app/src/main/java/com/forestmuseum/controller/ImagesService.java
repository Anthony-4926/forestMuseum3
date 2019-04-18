package com.forestmuseum.controller;

import com.forestmuseum.R;
import com.forestmuseum.entity.Image;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xinzhao
 * @create 2019-04-18 15:37
 */
public class ImagesService {
    public static List<Image> allImages=getAllImages();
    public static Map<Integer, Image> imgs=getImgs();
    public static List<Integer> pic = getPic();
   private static List<Image> getAllImages() {
        List<Image> allImages = new ArrayList<>();
        allImages.add(new Image(R.drawable.pic_1, "孔子鸟","kongziniao", "孔子鸟是目前已知的最早拥有无齿角质喙部的鸟类。", R.raw.kongziniao));
        allImages.add(new Image(R.drawable.pic_2,"巨型马陆","juxingmalu" ,"巨型马陆，体长可以达到 3 米，而现在生活在地球上的马陆体长只有十几厘米左右。", R.raw.kongziniao));
        allImages.add(new Image(R.drawable.pic_3,"东北野牛" + "披毛犀","dongbeiyeniupimaoxi", "前方玻璃展柜里展示的是东北野牛和披毛犀的头骨化石，这些原来生活在新生代森林的动物在很久以前都已经灭绝", R.raw.kongziniao));
        allImages.add(new Image(R.drawable.pic_4,"鹦鹉螺", "yinwuluo","我们现在来到的是奇妙的古生代时期。我们还可以看到在这个时期著名的鹦鹉螺也已经出现，它在地球上经历了数亿年的演变，被称为海洋中的活化石。", R.raw.kongziniao));
        return allImages;
    }
    private static List<Integer> getPic() {
        List<Integer> pic = new ArrayList<>();
        for(int i=0; i<allImages.size(); i++){
            pic.add(allImages.get(i).getId());
        }
        return  pic;
    }

    public static List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(int i=0; i<allImages.size(); i++){
            names.add(allImages.get(i).getTitle());
        }
        return names;
    }

    /**
     *创建资源
     * @return
     */

    public  static Map<Integer, Image> getImgs(){
        Map<Integer, Image> imgs = new HashMap<>();
        for(int i=0; i<allImages.size(); i++){
            imgs.put(allImages.get(i).getId(), allImages.get(i));
        }
        return imgs;
    }

    public static int getIdByName(String name){
        int id=-1;
        for(Image i : allImages){
            if (i.getTitle().equals(name)) {
                id = i.getId();
            }
        }
        return id;
    }

    public static int getIdByPositon(int p){
        return allImages.get(p).getId();
    }
}
