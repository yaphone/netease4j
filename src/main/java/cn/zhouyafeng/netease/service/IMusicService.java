package cn.zhouyafeng.netease.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
	
	/**
	 * 获取音乐信息
	 * @date 2017年9月12日 下午11:57:44
	 * @param @param ids
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getMusicInfo(List<String> ids);
	
	/**
	 * 搜索建议
	 * @date 2017年9月12日 下午11:58:14
	 * @param @param keywords
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSearchSuggest(String keywords);

}
