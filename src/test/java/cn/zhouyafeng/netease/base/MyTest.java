package cn.zhouyafeng.netease.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

public class MyTest {
	MusicServiceImpl musicService = new MusicServiceImpl();
	
	@Test
	public void loginTest(){
		String phoneNum = "18980869903";
		String password = "WO19891226";
		JSONObject res = musicService.cellphoneLogin(phoneNum, password);
		System.out.println(res);
	}
	
	
	@Test
	public void getMusicInfoTest(){
		List<String> ids = new ArrayList<String>();
		//ids.add("347230");
		ids.add("503207093");
		musicService.getMusicInfo(ids);
	}
	
	@Test
	public void getSearchSuggestTest(){
		String keywords = "海阔天空";
		musicService.getSearchSuggest(keywords);
	}

}
