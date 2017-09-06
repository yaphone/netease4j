package cn.zhouyafeng.netease.utils;

import java.io.UnsupportedEncodingException;

public class UrlUtil {
    private final static String ENCODE = "GBK"; 
    /**
     * URL 解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:09:51
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * URL 转码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:10:28
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 
     * @return void
     * @author lifq
     * @date 2015-3-17 下午04:09:16
     */
    public static void main(String[] args) {
        String str = "d6q84mPBTFoc5VqJeEabM/YyMEi7UuOLHmXj++y+nqEHROrd7ghojw3gr/5QPoCIXBRJJnmo6YxZJv0D8wCp9j/FJUV5ofxbAjsCF/GD7JxYsdKosKmrwwG4FVIuOKCU";
        System.out.println(getURLEncoderString(str));
        System.out.println(getURLDecoderString(str));
        
    }

}