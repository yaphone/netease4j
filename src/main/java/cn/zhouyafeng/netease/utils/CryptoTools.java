package cn.zhouyafeng.netease.utils;

import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class CryptoTools {
	
	private static String nonce = "0CoJUm6Qyw8W8jud";
	
	/**
	 * 加密操作
	 * @date 2017年9月3日 下午8:38:17
	 * @param @param data
	 * @return void
	 *
	 */
	public static void entrypt(Map<String, String> data){
		String text = JSON.toJSONString(data);
		String secKey = createSecretKey(16);
		
	}
	
	private static String createSecretKey(int size){
		String keys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String key = "";
		for(int i=0; i<size; i++){
			double pos = new Random().nextInt(keys.length());
			pos = Math.floor(pos);
			key = key + keys.charAt((int) pos);
		}
		return key;
	}
	
	private static String aesEncrypt(String text, String secKey){
		
		
		return null;
		
	}
	
	public static void main(String[] args){
		System.out.println(createSecretKey(16));
	}

}
