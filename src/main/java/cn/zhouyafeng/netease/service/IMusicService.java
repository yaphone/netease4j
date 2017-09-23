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
	
	/**
	 * 获取专辑评论
	 * @date 2017年9月19日 下午10:39:45
	 * @param @param albumId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getAlbumComment(String albumId);
	
	/**
	 * 获取歌单评论
	 * @date 2017年9月19日 下午10:45:53
	 * @param @param playlistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getPlaylistComment(String playlistId);
	
	/**
	 * 获取MV评论
	 * @date 2017年9月19日 下午10:50:10
	 * @param @param mvId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getMvComment(String mvId);
	
	/**
	 * 获取电台节目评论
	 * @date 2017年9月19日 下午11:00:42
	 * @param @param djId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getDjComment(String djId);
	
	/**
	 * 点赞
	 * @date 2017年9月19日 下午11:17:22
	 * @param @param id
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject upvote(String id, String type, boolean t);
	
	/**
	 * 获取banner数据
	 * @date 2017年9月19日 下午11:23:28
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getBanner();
	
	/**
	 * 获取歌曲详情,调用此接口,传入音乐 id, 可获得歌曲详情
	 * @date 2017年9月20日 下午6:58:16
	 * @param @param musicId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSongDetail(String musicId);
	
	/**
	 * 获取专辑内容，调用此接口,传入专辑 id,可获得专辑内容
	 * @date 2017年9月20日 下午8:38:32
	 * @param @param albumId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getAlbumDetail(String albumId);
	
	/**
	 * 获取歌手单曲,调用此接口,传入歌手 id,可获得歌手单曲
	 * @date 2017年9月20日 下午8:43:26
	 * @param @param artistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getArtist(String artistId);
	
	/**
	 * 获取歌手 mv,调用此接口,传入歌手 id,可获得歌手 mv 信息,具体 mv 播放地址可调用/mv传入此接口获得的mvid 来拿到
	 * @date 2017年9月20日 下午8:49:32
	 * @param @param artistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getArtistMvs(String artistId, String offset, String limit);
	
	/**
	 * 
	 * 获取歌手专辑,调用此接口,传入歌手 id,可获得歌手专辑内容
	 * @date 2017年9月20日 下午8:55:35
	 * @param @param artistId
	 * @param @param offset
	 * @param @param limit
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getArtistAlbum(String artistId, String offset, String limit);
	
	/**
	 * 获取歌手描述,调用此接口,传入歌手 id,可获得歌手描述
	 * @date 2017年9月21日 下午11:11:22
	 * @param @param artistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getArtistDesc(String artistId);
	
	/**
	 * 获取相似歌手,,调用此接口,传入歌手 id,可获得相似歌手
	 * @date 2017年9月21日 下午11:15:29
	 * @param @param artistId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	//TODO can not work
	public JSONObject getSimilarArtist(String artistId);
	
	/**
	 * 获取相似歌单,调用此接口,传入歌曲 id,可获得相似歌单
	 * @date 2017年9月21日 下午11:26:53
	 * @param @param musicId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	//TODO can not work
	public JSONObject getSimilarPlaylist(String musicId, String offset, String limit);
	
	/**
	 * 获取相似 mv,调用此接口,传入 mvid 可获取相似 mv 
	 * @date 2017年9月21日 下午11:33:45
	 * @param @param mvId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getSimilarMv(String mvId);
	
	/**
	 * 获取相似音乐,调用此接口,传入歌曲 id,可获得相似歌曲
	 * @date 2017年9月21日 下午11:37:33
	 * @param @return
	 * @return JSONObject
	 *
	 */
	//TODO {"code":301}
	public JSONObject getSimilarSong(String songId, String offset, String limit);
	
	/**
	 * 获取最近5个听了这首歌的用户,调用此接口,传入歌曲 id,最近5个听了这首歌的用户
	 * @date 2017年9月22日 下午9:50:23
	 * @param @param songId
	 * @param @return
	 * @return JSONObject
	 *
	 */
	//TODO {"code":301}
	public JSONObject getSimilarUser(String songId);
	
	/**
	 * 获取每日推荐歌单,调用此接口,可获得每日推荐歌单(需要登录)
	 * @date 2017年9月22日 下午9:57:40
	 * @param @return
	 * @return JSONObject
	 *
	 */
	//TODO
	public JSONObject getRecommendResource();
	
	/**
	 * 获取每日推荐歌曲,调用此接口,可获得每日推荐歌曲(需要登录)
	 * @date 2017年9月22日 下午10:05:38
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getRecommendSongs();
	
	/**
	 * 私人FM( 需要登录)
	 * @date 2017年9月23日 下午11:35:20
	 * @param @return
	 * @return JSONObject
	 *
	 */
	public JSONObject getPersonalFm();

}
