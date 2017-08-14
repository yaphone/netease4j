package cn.zhouyafeng.netease.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2017/8/14 21:49
 */
public class HttpClient {
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getHttpClient(){
        if(okHttpClient == null){
            synchronized (HttpClient.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient().newBuilder().addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request()
                                            .newBuilder()
                                            .addHeader("Accept", "*/*")
                                            .addHeader("Accept-Encoding", "gzip,deflate,sdch")
                                            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4")
                                            .addHeader("Connection", "keep-alive")
                                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                                            .addHeader("Host", "music.163.com")
                                            .addHeader("Referer", "http://music.163.com/search/")
                                            .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                                            .build();
                                    return chain.proceed(request);
                                }
                            }).build();
                }
            }
        }
        return okHttpClient;
    }


}
