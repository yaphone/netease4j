package cn.zhouyafeng.netease.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


/**  
* @ClassName: HttpClient  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author https://github.com/yaphone
* @date 2017年9月2日 下午11:42:11  
*    
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
                                            //.addHeader("Accept-Encoding", "gzip,deflate,sdch")
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
    
    /**
     * 
     * @date 2017年9月2日 下午11:29:48
     * @param 
     * @return void
     *
     */
    private void doGet(){
    	
    }
    
    private void doPost(){
    	
    }


}
