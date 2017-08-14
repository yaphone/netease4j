package cn.zhouyafeng.netease.demo1;

import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

public class MyTest {
	public static void main(String[] args) {
		IMusicService musicService = new MusicServiceImpl();
		musicService.getTopSongList();
	}

}
