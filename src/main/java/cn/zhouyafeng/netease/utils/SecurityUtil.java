package cn.zhouyafeng.netease.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @ClassName: AESUtil
 * @Description: 安全工具类
 * @author https://github.com/yaphone
 * @date 2017年9月5日 上午12:02:01
 *
 */
public class SecurityUtil {

	private static final String ivParameter = "0102030405060708";
	private static final String nonce = "0CoJUm6Qyw8W8jud";
	private static final String pubKey = "010001";
	private static final String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";

	private SecurityUtil() {

	}

	public static String createSecretKey(int size) {
		String keys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String key = "";
		for (int i = 0; i < size; i++) {
			double pos = new Random().nextInt(keys.length());
			pos = Math.floor(pos);
			key = key + keys.charAt((int) pos);
		}
		return key;
	}

	public static LinkedHashMap<String, String> encrypt(LinkedHashMap<String, Object> dataMap) {
		// String text = CommonTools.createDataStringForAES(dataMap);
		String text = JSON.toJSONString(dataMap);
		String secKey = createSecretKey(16);
		String encText = aesEncrypt(aesEncrypt(text, nonce), secKey);
		String encSecKey = rsaEncrypt(secKey, pubKey, modulus);

		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		result.put("params", encText);
		result.put("encSecKey", encSecKey);
		return result;

	}

	// rsa加密
	public static String rsaEncrypt(String text, String pubKey, String modulus) {
		String _text = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			_text += text.substring(i, i + 1);
		}
		String hexText = HexUtil.str2HexStr(_text);
		BigInteger biText = new BigInteger(hexText, 16);
		BigInteger biEx = new BigInteger(pubKey, 16);
		BigInteger biMod = new BigInteger(modulus, 16);
		BigInteger bigRet = biText.modPow(biEx, biMod);

		String result = bigRet.toString(16);
		int fill = 256 - result.length();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < fill; i++) {
			sb.append("0");
		}
		result = sb.toString() + result;
		return result;
	}

	/**
	 * AES加密算法
	 * 
	 * @date 2017年9月5日 上午12:04:33
	 * @param @param
	 *            sSrc
	 * @param @param
	 *            sKey
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @return String
	 *
	 */
	@SuppressWarnings("restriction")
	public static String aesEncrypt(String text, String sKey) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] raw = sKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(text.getBytes("utf-8"));
			return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * AES解密算法
	 * 
	 * @date 2017年9月5日 上午12:04:47
	 * @param @param
	 *            sSrc
	 * @param @param
	 *            sKey
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @return String
	 *
	 */
	@SuppressWarnings("restriction")
	public static String aesEecrypt(String text, String sKey) throws Exception {
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(text);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * MD5加密
	 * 
	 * @date 2017年9月13日 下午11:35:20
	 * @param @param
	 *            text
	 * @param @return
	 * @return String
	 *
	 */
	public static String getMD5(String text) {
		String md5Str = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] input = text.getBytes();
			byte[] buff = md.digest(input);
			md5Str = bytesToHex(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;

	}

	/**
	 * 二进制转十六进制
	 * 
	 * @date 2017年9月13日 下午11:39:15
	 * @param @param
	 *            bytes
	 * @param @return
	 * @return String
	 *
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString();
	}

	public static void main(String[] args) throws Exception {

		// rsaTest("Yc7L6prbU6Rmyfn2");
		//encryptTest();
		md5Test();
	}

	private static void aesTest() {
		String cSrc = "{\"ids\":[\"347230\"],\"br\":999000,\"csrf_token\":\"\"}";
		/*
		 * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
		 */
		String sKey = "0CoJUm6Qyw8W8jud";

		String enString = aesEncrypt(cSrc, sKey);
		System.out.println("加密后的字串是：" + enString);

	}

	private static void rsaTest(String text) {
		String _text = rsaEncrypt(text, pubKey, modulus);
		System.out.println(_text);
	}

	private static void encryptTest() {
		List<String> ids = new ArrayList<String>();
		ids.add("347230");
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("ids", ids);
		dataMap.put("br", "999000");
		dataMap.put("csrf_token", "");
		LinkedHashMap<String, String> result = encrypt(dataMap);
		System.out.println(result);
	}
	
	private static void md5Test(){
		String text = "WO19891226";
		String md5Str = getMD5(text);
		System.out.println(md5Str);
	}
}
