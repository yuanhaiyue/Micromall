package com.example.micromall.common;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @author Rex
 * @create 2020-11-04 10:52
 */
public class MD5Utils {
    /**
     * 根据源数据生成MD5摘要
     * @param source 源数据
     * @return MD5摘要
     */
    public static String md5Digest(String source) throws UnsupportedEncodingException {
        return DigestUtils.md5DigestAsHex(source.getBytes());
    }

    /**
     * 对源数据加盐混淆后生成MD5摘要
     * @param source 源数据
     * @param salt 盐值
     * @return MD5摘要
     */
    public static String md5Digest(String source, Integer salt) {
        //混淆源数据
        char[] ca = source.toCharArray();
        for (int i = 0; i < ca.length; i++){
            ca[i] = (char) (ca[i] + salt);
        }
        String target = new String(ca);
        return DigestUtils.md5DigestAsHex(target.getBytes());
    }

    /**
     * 生成一个随机的盐值
     * @return salt 盐值
     */
    public static Integer generateSalt(){
        return new Random().nextInt(1000);
    }


//  测试
    public static void main(String[] args) {
        String password = "123456";
        String md5Digest = md5Digest(password, 111);
        //ae5b2ef6db117ec617cc0dae55e5cc89
        System.out.println(md5Digest);
    }
}
