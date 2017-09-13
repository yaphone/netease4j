package cn.zhouyafeng.netease.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 用户属性工具类
* @ClassName: PropertyUtil  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author https://github.com/yaphone
* @date 2017年9月14日 上午12:24:28  
*
 */
public class PropertyUtil {
	private static final ClassLoader classLoader = PropertyUtil.class.getClassLoader();
	private static final InputStream in = classLoader.getResourceAsStream("userinfo.properties");
	private static final Properties pps = new Properties();

	
	private PropertyUtil(){
		
	}
	
	static{
		try {
			pps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		return pps.getProperty(key);
	}
	
	public static void setProperty(String key, String value){
		pps.put(key, value);
	}
	
	public static void main(String[] args){
		
		PropertyUtil.setProperty("userid", "11234");
		
		String cellphone = PropertyUtil.getProperty("phonenum");
		String password = PropertyUtil.getProperty("password");
		String userid = PropertyUtil.getProperty("userid");
		
		System.out.println(cellphone);
		System.out.println(password);
		System.out.println(userid);
	}
	

}
