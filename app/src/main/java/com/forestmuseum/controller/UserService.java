package com.forestmuseum.controller;

import android.content.Context;

import com.forestmuseum.entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author xinzhao
 * @create 2019-04-15 17:15
 */
public class UserService {


    public static boolean saveProUserInfo(Context context, User user) {
        try {
            // 使用Android上下问获取当前项目的路径
            File file = new File(context.getFilesDir(), "info.properties");
            // 创建输出流对象
            FileOutputStream fos = new FileOutputStream(file);
            // 创建属性文件对象
            Properties pro = new Properties();
            // 设置用户名或密码
            pro.setProperty("userName", user.getUserName());
            pro.setProperty("password", user.getPassword());
            // 保存文件
            pro.store(fos, "info.properties");
            // 关闭输出流对象
            fos.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    /**
     * 返回属性文件对象
     *
     * @param context 上下文
     * @return
     */
    public static Properties getProObject(Context context) {
        try {
            // 创建File对象
            File file = new File(context.getFilesDir(), "info.properties");

            System.out.println(context.getFilesDir());
            // 创建FileIutputStream 对象
            FileInputStream fis = new FileInputStream(file);



            // 创建属性对象
            Properties pro = new Properties();
            // 加载文件
            pro.load(fis);
            // 关闭输入流对象
            fis.close();


            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断用户是否存在
     * @param user
     * @param context
     * @return
     */
    public static boolean isExist(User user, Context context){
        boolean result = false;
        Properties pro = getProObject(context);
        if (user.getUserName().equals(pro.get("userName")) &&
                user.getPassword().equals(pro.get("password"))) {
            result = true;
        }


        System.out.println("数据库中的"+pro.get("userName")+pro.get("password"));
        System.out.println("用户存在否"+result);
        return result;
    }
}
