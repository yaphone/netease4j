package cn.zhouyafeng.netease.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;
import cn.zhouyafeng.netease.utils.PropertyUtil;

public class MyTest {
	
	private static String userId = "32953014";
	
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
	public void getUserSubcontTest(){
		//TODO
	}
	
	//@Test
	public void getUserPlaylistTest() throws Exception{
		String userId = PropertyUtil.getProperty("userinfo.properties", "userid");
		JSONObject res = musicService.getUserPlaylist(userId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getUserDjListTest() {
		JSONObject res = musicService.getUserDjs(userId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getUserFollowsTest(){
		JSONObject res = musicService.getUserFollows(userId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getUserFollowedsTest(){
		JSONObject res = musicService.getUserFolloweds(userId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getUserEventTest(){
		JSONObject res = musicService.getUserEvent(userId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getEventTest(){
		JSONObject res = musicService.getEvent();
		
		System.out.println(res);
	}
	
	//@Test
	public void getTopPlaylistTest(){
		JSONObject res = musicService.getTopPlaylist();
		
		System.out.println(res);
	}
	
	//@Test
	public void getPlaylistDetailTest(){
		String playlistId = "24381616";
		JSONObject res = musicService.getPlaylistDetail(playlistId);
		
		System.out.println(res);
	}
	
	//@Test
	public void getMusicUrlTest(){
		List<String> ids = new ArrayList<String>();
		ids.add("347230");
		ids.add("347231");
		JSONObject res = musicService.getMusicUrl(ids);
		
		System.out.println(res);
	}
	
	//@Test
	public void searchTest(){
		String keywords = "海阔天空";
		String type = "100";
		JSONObject res = musicService.getSearch(keywords, type);
		
		System.out.println(res);
	}
	
	//@Test
	public void getSearchSuggestTest(){
		String keywords = "海阔天空";
		JSONObject res = musicService.getSearchSuggest(keywords);
		
		System.out.println(res);
	}
	
	//@Test
	public void getSearchMultimatch(){
		String keywords = "海阔天空";
		JSONObject res = musicService.getSearchMultimatch(keywords);
		
		System.out.println(res);
	}
	
	@Test
	public void getLyric(){
		String musicId = "347230";
		JSONObject res = musicService.getLyric(musicId);
		
		System.out.println(res);
	}

}
