package cn.zhouyafeng.netease.utils;

import org.junit.Test;

public class PropertyUtilTest {
	@Test
	public void propertyTest() throws Exception{
		//PropertyUtil.setProperty("userinfo.properties", "userid", "11234");
		
		String cellphone = PropertyUtil.getProperty("userinfo.properties", "phonenum");
		String password = PropertyUtil.getProperty("userinfo.properties", "password");
		String userid = PropertyUtil.getProperty("userinfo.properties", "userid");
		
		System.out.println(cellphone);
		System.out.println(password);
		System.out.println(userid);
	}

}
