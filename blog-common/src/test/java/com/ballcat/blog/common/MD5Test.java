package com.ballcat.blog.common;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.UUID;

/**
 * @author pengshun
 * @date 2022-04-10 22:49
 * @description
 */
public class MD5Test {

    public static void main(String[] args) {
        String secret = UUID.randomUUID().toString().replace("-", "");
        System.out.println(secret);
        String ballcatsecret = SecureUtil.md5("zyui48" + secret);
        System.out.println(ballcatsecret);

        System.out.println(DateUtil.current(false));
        System.out.println(DateUtil.current(true));

    }
}
