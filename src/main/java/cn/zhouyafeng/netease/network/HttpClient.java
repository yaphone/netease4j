package cn.zhouyafeng.netease.network;

import okhttp3.OkHttpClient;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2017/8/14 21:49
 */
public class HttpClient {
    private OkHttpClient instance;

    private OkHttpClient getInstance(){
        if(instance == null){
            synchronized (HttpClient.class){
                if (instance == null){
                    instance = new OkHttpClient();
                }
            }
        }
        return instance;
    }

    /**
     * @Desc:
     * @Date:2017/8/14 22:20
     *
     */
    private void addHeader(){

    }


}
