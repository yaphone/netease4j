package cn.zhouyafeng.netease.service;

import java.util.List;

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
	 * 手机登陆
	 * @date 2017年9月15日 上午12:05:48
	 * @param @param phoneNum
	 * @param @param password
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject cellphoneLogin(String phoneNum, String password);
	
	/**
	 * 获取用户详情
	 * @date 2017年9月15日 下午10:05:02
	 * @param @param id
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserDetail(String userId);
	
	/**
	 * 获取用户信息,歌单，收藏，mv, dj 数量
	 * @date 2017年9月16日 上午12:21:14
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserSubcount(String userId);
	
	/**
	 * 获取用户歌单
	 * @date 2017年9月16日 上午12:23:30
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserPlaylist(String userId);
	
	/**
	 * 获取用户电台
	 * @date 2017年9月16日 下午5:36:19
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserDjs(String userId);
	
	/**
	 * 获取用户关注列表
	 * @date 2017年9月16日 下午5:49:37
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserFollows(String userId);
	
	/**
	 * 获取用户粉丝列表
	 * @date 2017年9月16日 下午6:03:17
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserFolloweds(String userId);
	
	/**
	 * 获取用户动态
	 * @date 2017年9月16日 下午6:07:06
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserEvent(String userId);
	
	
	/**
	 * 获取用户播放记录 //TODO set cookies
	 * @date 2017年9月16日 下午6:10:34
	 * @param @param userId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getUserRecord(String userId);
	
	/**
	 * 获取动态消息  //TODO set cookies
	 * @date 2017年9月16日 下午6:14:37
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getEvent();
	
	/**
	 * 获取精品歌单
	 * @date 2017年9月16日 下午6:23:56
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getTopPlaylist();
	
	/**
	 * 获取歌单详情
	 * @date 2017年9月16日 下午6:31:40
	 * @param @param playlistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getPlaylistDetail(String playlistId);
	
	/**
	 * 获取音乐 url, 调用此接口,传入的音乐 id(可多个),可以获取对应的音乐的 url(不需要登录)
	 * @date 2017年9月16日 下午6:37:54
	 * @param @param ids
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getMusicUrl(List<String> ids);
	
	/**
	 * 搜索
	 * 说明:调用此接口,传入搜索关键词可以搜索该音乐/专辑/歌手/歌单/用户,关键词可以多个,以空格隔开,如"周杰伦 搁浅"(不需要登录),搜索获取的 mp3url 不能直接用,可通过 /music/url 接口传入歌曲 id 获取具体的播放链接
	 * 1: 单曲
	 * 10: 专辑
	 * 100: 歌手
	 * 1000: 歌单
	 * 1002: 用户
	 * 1004: MV
	 * 1006: 歌词
	 * 1009: 电台
	 * @date 2017年9月16日 下午6:52:36
	 * @param @param keyword
	 * @param @param type
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSearch(String keywords, String type);
	
	/**
	 * 搜索建议,调用此接口,传入搜索关键词可获得搜索建议,搜索结果同时包含单曲,歌手,歌单,mv 信息
	 * @date 2017年9月12日 下午11:58:14
	 * @param @param keywords
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSearchSuggest(String keywords);
	
	/**
	 * 搜索多重匹配，调用此接口,传入搜索关键词可获得搜索结果
	 * @date 2017年9月17日 上午12:27:27
	 * @param @param keywords
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSearchMultimatch(String keywords);
	
	/**
	 * 收藏单曲到歌单,调用此接口,传入音乐 id和 limit 参数, 可获得该专辑的所有评论(需要登录)
	 * @date 2017年9月17日 上午12:34:46
	 * @param @param op
	 * @param @param userId
	 * @param @param musicId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject operatePlaylist(String op, String userId, String musicId);
	
	/**
	 * 获取歌词,调用此接口,传入音乐 id 可获得对应音乐的歌词(不需要登录)
	 * @date 2017年9月17日 上午12:36:20
	 * @param @param musicId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getLyric(String musicId);
	
	/**
	 * 获取歌曲评论 
	 * @date 2017年9月18日 下午10:59:11
	 * @param @param musicId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getMusicComment(String musicId);

}
