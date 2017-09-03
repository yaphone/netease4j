package cn.zhouyafeng.netease.demo1;

import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;
import com.alibaba.fastjson.JSONArray;

public class MyTest {
	public static void main(String[] args) {
		MusicServiceImpl musicService = new MusicServiceImpl();
		//musicService.getTopSongList();
		//JSONArray songDetail = musicService.getSongDetail(499274178);
		//System.out.println(songDetail);
		musicService.getMusicInfo();
	}

}
