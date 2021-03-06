package com.bittch.chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
封装基础的工具方法,如加载配置文件、json序列化等
 */
public class CommUtils {
    private static final Gson gson = new GsonBuilder().create();
    private CommUtils(){}

    /**
     * 根据指定的文件名加载配置文件
     * fileName 配置文件名

     */
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        // 获取当前配置文件夹下的文件输入流
        /*InputStream in = CommUtils.class.getClassLoader()
                .getResourceAsStream(fileName);*/

        // 加载配置文件中的所有内容
        try {
            properties.load(new FileReader("F:\\Work Code\\IDEA Project\\java7_chatroom\\src\\main\\java\\resources\\datasource.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String object2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static Object json2Object(String jsonStr,Class objClass) {
        return gson.fromJson(jsonStr,objClass);
    }

    public static boolean strIsNull(String str) {
        return str == null || str.equals("");
    }
}
