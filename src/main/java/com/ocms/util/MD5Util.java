package com.ocms.util;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5Util {
    private static String key = "wuliucheng";
    /**
     * MD5方法
     *
     * @param text 明文
     * @return 密文
     */
    public static String md5(String text)   {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        //System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5 密文
     * @return true/false
     */
    public static boolean verify(String text, String md5){
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            //System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }
}
