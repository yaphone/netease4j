package cn.zhouyafeng.netease.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
* @ClassName: AESUtil  
* @Description: AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，再进行Base64编码转化；
* @author https://github.com/yaphone
* @date 2017年9月5日 上午12:02:01  
*
 */
public class AESUtil {

	private static String ivParameter = "0102030405060708";

	private AESUtil() {

	}

	/**
	 * 加密算法
	 * @date 2017年9月5日 上午12:04:33
	 * @param @param sSrc
	 * @param @param sKey
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 *
	 */
	@SuppressWarnings("restriction")
	public static String encrypt(String sSrc, String sKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] raw = sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
	}

	/**
	 * 解密算法
	 * @date 2017年9月5日 上午12:04:47
	 * @param @param sSrc
	 * @param @param sKey
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 *
	 */
	@SuppressWarnings("restriction")
	public static String decrypt(String sSrc, String sKey) throws Exception {
		try {
			byte[] raw = sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "utf-8");
			return originalString;
		} catch (Exception ex) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		String cSrc = "{\"ids\":[\"347230\"],\"br\":999000,\"csrf_token\":\"\"}";
		/*
		 * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
		 */
		String sKey = "0CoJUm6Qyw8W8jud";

		String enString = encrypt(cSrc, sKey);
		System.out.println("加密后的字串是：" + enString);

	}
}
