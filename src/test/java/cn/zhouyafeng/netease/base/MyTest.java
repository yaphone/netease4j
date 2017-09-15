package cn.zhouyafeng.netease.base;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;
import cn.zhouyafeng.netease.utils.PropertyUtil;

public class MyTest {
	MusicServiceImpl musicService = new MusicServiceImpl();
	
	//@Test
	public void loginTest(){
		String phoneNum = "18980869903";
		String password = "WO19891226";
		JSONObject res = musicService.cellphoneLogin(phoneNum, password);
		System.out.println(res);
	}
	
	//@Test
	public void getUserDetailTest() throws Exception{
		String id = PropertyUtil.getProperty("userinfo.properties", "userid");
		
		JSONObject res = musicService.getUserDetail(id);
		System.out.println(res);
	}
	
	
	//@Test
	public void getMusicInfoTest(){
		List<String> ids = new ArrayList<String>();
		//ids.add("347230");
		ids.add("503207093");
		JSONObject res = musicService.getMusicInfo(ids);
		System.out.println(res);
	}
	
	//@Test
	public void getSearchSuggestTest(){
		String keywords = "海阔天空";
		JSONObject res = musicService.getSearchSuggest(keywords);
		System.out.println(res);
	}

}
