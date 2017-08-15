package cn.zhouyafeng.netease;

import java.util.List;

import org.junit.Test;

import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

/**
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月15日 下午11:43:46
 * @version 1.0
 *
 */
public class MusicServiceTest {

	private IMusicService musicService = new MusicServiceImpl();

	/**
	 * 获取热门单曲列表测试
	 * 
	 * @date 2017年8月15日 下午11:58:49
	 */
	// @Test
	public void songIdTest() {
		List<Long> songIdList = musicService.getTopSongList();
		System.out.println(songIdList);
	}

	@Test
	public void songDetailTest() {
		musicService.getSongDetail(495220123);
	}

}
