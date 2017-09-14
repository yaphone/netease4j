package cn.zhouyafeng.netease.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * 
* @ClassName: PropertyUtil  
* @Description: 用户属性工具类 
* @author https://github.com/yaphone
* @date 2017年9月14日 上午12:24:28  
*
 */
public class PropertyUtil {
	private static final ClassLoader classLoader = PropertyUtil.class.getClassLoader();

	private PropertyUtil(){
		
	}
	
	/**
	 * 读取properties
	 * @date 2017年9月15日 上午12:19:03
	 * @param @param key
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 *
	 */
	public static String getProperty(String filename ,String key) throws Exception{
		Properties pps = new Properties();
		InputStream in = classLoader.getResourceAsStream(filename);
		pps.load(in);
		return pps.getProperty(key);
	}
	
	/**
	 * 设置properties
	 * @date 2017年9月15日 上午12:18:43
	 * @param @param key
	 * @param @param value
	 * @param @throws IOException
	 * @return void
	 *
	 */
	public static void setProperty(String filename ,String key, String value) throws IOException{
		Properties pps = new Properties();
		String filePath = classLoader.getResource(filename).getFile();
		OutputStream os = new FileOutputStream(filePath, true);
		pps.setProperty(key, value);
		pps.store(os, "new");
		os.close();
	}
	
}
