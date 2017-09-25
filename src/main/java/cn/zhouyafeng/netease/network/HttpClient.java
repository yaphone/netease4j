package cn.zhouyafeng.netease.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.utils.CommonTools;
import cn.zhouyafeng.netease.utils.SecurityUtil;
import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @ClassName: HttpClient
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author https://github.com/yaphone
 * @date 2017年9月2日 下午11:42:11
 * 
 */
public class HttpClient {
	private static HttpClient instance;

	private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
		@Override
		public Response intercept(Chain chain) throws IOException {
			Request request = chain.request().newBuilder().addHeader("Accept", "*/*")
					// .addHeader("Accept-Encoding", "gzip,deflate,sdch")
					.addHeader("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4")
					.addHeader("Connection", "keep-alive")
					.addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("Host", "music.163.com")
					.addHeader("Referer", "http://music.163.com/search/").addHeader("User-Agent",
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")

					.build();
			return chain.proceed(request);
		}
	}).cookieJar(new CookieJar() {
	    private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
	    @Override
	    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
	    	System.out.println(cookies);
	        cookieStore.put(url.host(), cookies);
	    }
	    @Override
	    public List<Cookie> loadForRequest(HttpUrl url) {
	        List<Cookie> cookies = cookieStore.get(url.host());
	        return cookies != null ? cookies : new ArrayList<Cookie>();
	    }
	}).build();
	
	private HttpClient() {

	}

	public static HttpClient getInstance() {
		if (instance == null) {
			synchronized (HttpClient.class) {
				if (instance == null) {
					instance = new HttpClient();
				}
			}
		}
		return instance;
	}

	/**
	 * 
	 * @date 2017年9月2日 下午11:29:48
	 * @param
	 * @return void
	 *
	 */
	private void doGet() {

	}

	/**
	 * POST方法
	 * @date 2017年9月15日 上午12:01:35
	 * @param @param url
	 * @param @param dataMap
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject doPost(String url, LinkedHashMap<String, Object> dataMap) {
		JSONObject result = null;
		LinkedHashMap<String, String> paramMap = SecurityUtil.encrypt(dataMap);
		String requestParams = CommonTools.createRequestParam(paramMap);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
				requestParams);
		Request req = new Request.Builder().url(url).post(requestBody).build();
		Call call = okHttpClient.newCall(req);

		try {
			Response resp = call.execute();
			result = JSON.parseObject(resp.body().string());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
