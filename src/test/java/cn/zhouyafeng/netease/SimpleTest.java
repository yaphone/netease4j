package cn.zhouyafeng.netease;

import java.math.BigInteger;

public class SimpleTest {
	
	private final static char[] mChars = "0123456789abcdef".toCharArray();
	
	public static void main(String[] args){
		String str = new BigInteger("364242726a644457396b523042746e6c", 16).toString(10);
		System.out.println(str);
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
	
   
}//class