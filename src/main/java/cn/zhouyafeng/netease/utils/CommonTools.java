package cn.zhouyafeng.netease.utils;

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
	


}
