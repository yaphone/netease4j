package cn.zhouyafeng.netease.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 网易云音乐服务接口
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月13日 下午5:04:26
 * @version 1.0
 *
 */
public interface IMusicService {

	/**
	 * 热门单曲
	 * 
	 * @date 2017年8月14日 下午11:23:48
	 */
	public List<Long> getTopSongList();

	public JSONArray getSongDetail(long songId);

}
