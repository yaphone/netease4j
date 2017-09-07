package cn.zhouyafeng.netease.utils;


/**
 * 
* @ClassName: HexUtil  
* @Description: 字符串转Hex工具类  
* @author https://github.com/yaphone
* @date 2017年9月6日 下午11:47:55  
*
 */
public class HexUtil {
    
private final static char[] mChars = "0123456789abcdef".toCharArray();
	
	public static void main(String[] args){
		System.out.println(str2HexStr("6BBrjdDW9kR0Btnl"));
	}
	
    public static String str2HexStr(String str){  
        StringBuilder sb = new StringBuilder();
        byte[] bs = str.getBytes();  
        
        for (int i = 0; i < bs.length; i++){  
            sb.append(mChars[(bs[i] & 0xFF) >> 4]);  
            sb.append(mChars[bs[i] & 0x0F]);
        }  
        return sb.toString().trim();  
    }
    
}