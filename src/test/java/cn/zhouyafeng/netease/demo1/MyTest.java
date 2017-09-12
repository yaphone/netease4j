package cn.zhouyafeng.netease.demo1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

public class MyTest {
	MusicServiceImpl musicService = new MusicServiceImpl();
	
	//@Test
	public void getTopSongListTest(){
		musicService.getTopSongList();
	}
	
	
	@Test
	public void getSongDetailTest(){
		System.out.println(musicService.getSongDetail(503207093));
	}
	
	//@Test
	public void getMusicInfoTest(){
		List<String> ids = new ArrayList<String>();
		//ids.add("347230");
		ids.add("503207093");
		musicService.getMusicInfo(ids);
	}
	
	//@Test
	public void getSearchSuggestTest(){
		String keywords = "海阔天空";
		musicService.getSearchSuggest(keywords);
	}

}
