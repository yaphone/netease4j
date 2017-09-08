package cn.zhouyafeng.netease.demo1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

public class MyTest {
	MusicServiceImpl musicService = new MusicServiceImpl();
	
	
	@Test
	public void getMusicInfoTest(){
		List<String> ids = new ArrayList<String>();
		ids.add("347230");
		musicService.getMusicInfo(ids);
	}

}
