package cn.zhouyafeng.netease.core;

import cn.zhouyafeng.netease.network.HttpClient;
import okhttp3.OkHttpClient;

/**
 * 核心存储类， 单例
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月13日 下午5:01:23
 * @version 1.0
 *
 */
public class Core {

	private static Core instance;
	private OkHttpClient httpClient = HttpClient.getHttpClient();

	private Core() {

	}

	public static Core getInsance() {
		if (instance == null) {
			synchronized (Core.class) {
				if (instance == null) {
					instance = new Core();
				}
			}
		}
		return instance;
	}

	public OkHttpClient getHttpClient() {
		return httpClient;
	}

}
