package cn.zhouyafeng.netease.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月15日 下午11:04:58
 * @version 1.0
 *
 */
public class CommonTools {

	/**
	 * 正则表达式处理工具
	 * 
	 * @date 2017年8月15日 下午11:05:43
	 * @param regEx
	 * @param text
	 * @return
	 */
	public static Matcher getMatcher(String regEx, String text) {
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(text);
		return matcher;
	}
	
	/**
	 * 将dataMap转换为要加密的字符串
	 * @date 2017年9月5日 下午11:14:20
	 * @param @return
	 * @return String
	 *
	 */
	public static String createDataStringForAES(Map<String, Object> dataMap){
		String result = "{\"ids\":[\"";
		@SuppressWarnings("unchecked")
		List<String> ids = (List<String>) dataMap.get("ids");
		for (int i = 0; i < ids.size(); i++) {
			result += ids.get(i) + ",";
		}
		//去掉最后一个","
		result = result.substring(0, result.length() - 1);
		result += "\"],\"br\":";
		result += dataMap.get("br");
		result += ",\"csrf_token\":\"";
		result += dataMap.get("csrf_token");
		result += "\"}";
		
		return result;
	}
	
	public static void main(String[] args){
		List<String> ids = new ArrayList<String>();
		ids.add("347230");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("ids", ids);
		dataMap.put("br", "999000");
		dataMap.put("csrf_token", "");
		
		String text = createDataStringForAES(dataMap);
		String result = null;
		
		try {
			result = AESUtil.aesEncrypt(text, "0CoJUm6Qyw8W8jud");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(result);
	}
	


}
