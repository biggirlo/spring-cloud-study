/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.core.util;

/**
 *
 * @author 王雁欣
 * create on 2018/3/18 13:38 
 */
public class Validate {

    public static boolean isBlankStr(String str){
        if(str == null || str.trim().equals(""))
            return true;
        else
            return false;
    }
}