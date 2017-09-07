package cn.zhouyafeng.netease.utils;

import java.io.UnsupportedEncodingException;

/**
 * 
* @ClassName: UrlUtil  
* @Description: URL编解码工具类
* @author https://github.com/yaphone
* @date 2017年9月6日 下午11:46:53  
*
 */
public class UrlUtil {
    private final static String ENCODE = "GBK"; 
    /**
     * URL解码
     * @date 2017年9月6日 下午11:46:44
     * @param @param str
     * @param @return
     * @return String
     *
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
     * URL转码
     * @date 2017年9月6日 下午11:46:27
     * @param @param str
     * @param @return
     * @return String
     *
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
     * @date 2017年9月6日 下午11:46:17
     * @param @param args
     * @return void
     *
     */
    public static void main(String[] args) {
        String str = "d6q84mPBTFoc5VqJeEabM/YyMEi7UuOLHmXj++y+nqEHROrd7ghojw3gr/5QPoCIXBRJJnmo6YxZJv0D8wCp9j/FJUV5ofxbAjsCF/GD7JxYsdKosKmrwwG4FVIuOKCU";
        System.out.println(getURLEncoderString(str));
        System.out.println(getURLDecoderString(str));
        
    }

}