package cn.zhouyafeng.netease.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("ids", new ArrayList<Integer>(){{add(347230);}});
		dataMap.put("br", 999000);
		dataMap.put("csrf_token", "");
		String content = JSON.toJSONString(dataMap);
		System.out.println(content);
		String password = "0CoJUm6Qyw8W8jud";
		encrypt(content, password);
		
		byte[] result = encrypt(content, password);

		for(int i=0; i<result.length; i++){
			System.out.print(result[i]);
		}
		System.out.println();
		System.out.println(new String(result, "utf-8"));
	}
	
	public static byte[] encrypt(String content, String password) {  
        try {             
                KeyGenerator kgen = KeyGenerator.getInstance("AES");  
                kgen.init(128, new SecureRandom(password.getBytes()));  
                SecretKey secretKey = kgen.generateKey();  
                byte[] enCodeFormat = secretKey.getEncoded();  
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
                byte[] byteContent = content.getBytes("utf-8");  
                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
                byte[] result = cipher.doFinal(byteContent);  
                return result; // 加密  
        } catch (NoSuchAlgorithmException e) {  
                e.printStackTrace();  
        } catch (NoSuchPaddingException e) {  
                e.printStackTrace();  
        } catch (InvalidKeyException e) {  
                e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
        } catch (IllegalBlockSizeException e) {  
                e.printStackTrace();  
        } catch (BadPaddingException e) {  
                e.printStackTrace();  
        }  
        return null;  
}  

}
