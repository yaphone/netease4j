package cn.zhouyafeng.netease.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.enums.URL;
import cn.zhouyafeng.netease.network.HttpClient;
import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.utils.SecurityUtil;

/**
 * 音乐服务实现类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月13日 下午5:05:16
 * @version 1.0
 *
 */
public class MusicServiceImpl implements IMusicService {
	private static Logger LOG = LoggerFactory.getLogger(MusicServiceImpl.class);

	//private Core core = Core.getInsance();
	private HttpClient httpClient = HttpClient.getInstance();

	@Override
	public JSONObject cellphoneLogin(String phoneNum, String password){
		String url = URL.BASE_URL.getUrl() + "/weapi/login/cellphone";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("phone", phoneNum);
		dataMap.put("password", SecurityUtil.getMD5(password));
		dataMap.put("rememberLogin", "true");
		
		return httpClient.doPost(url, dataMap);
	}
	
	
	
	@Override
	public JSONObject getUserDetail(String userId){
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/user/detail/" + userId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserSubcount(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getUserPlaylist(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/user/playlist";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("uid", userId);
		dataMap.put("limit", 1000);
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserDjs(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/dj/program/" + userId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", "0");
		dataMap.put("limit", "30");
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserFollows(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/user/getfollows/" + userId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", "0");
		dataMap.put("limit", "30");
		dataMap.put("order", "true");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserFolloweds(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/user/getfolloweds/";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("userId", userId);
		dataMap.put("offset", "0");
		dataMap.put("limit", "30");
		dataMap.put("order", "true");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserEvent(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/event/get/" + userId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("time", "-1");
		dataMap.put("getcounts", "true");
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getUserRecord(String userId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/event/get/" + userId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("time", "-1");
		dataMap.put("getcounts", "true");
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getEvent() {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/event/get";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getTopPlaylist() {
		String url = URL.BASE_URL.getUrl() + "/weapi/playlist/list";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("cat", "全部");
		dataMap.put("order", "hot");
		dataMap.put("offset", "0");
		dataMap.put("total", "true");
		dataMap.put("limit", "50");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getPlaylistDetail(String playlistId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v3/playlist/detail";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("id", playlistId);
		dataMap.put("offset", "0");
		dataMap.put("total", "true");
		dataMap.put("limit", "1000");
		dataMap.put("n", "1000");
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}

	@Override
	public JSONObject getMusicUrl(List<String> ids) {
		String url = URL.BASE_URL.getUrl() + "/weapi/song/enhance/player/url";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("ids", ids);
		dataMap.put("br", "999000");
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}


	@Override
	public JSONObject getSearch(String keywords, String type) {
		String url = URL.BASE_URL.getUrl() + "/weapi/search/get";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		dataMap.put("limit", "100");
		dataMap.put("type", type);
		dataMap.put("s", keywords);
		
		return httpClient.doPost(url, dataMap);
	}
	
	@Override
	public JSONObject getSearchSuggest(String keywords){
		String url = URL.BASE_URL.getUrl() + "/weapi/search/suggest/web" ;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		dataMap.put("s", keywords);
		
		return httpClient.doPost(url, dataMap);
		
	}



	@Override
	public JSONObject getSearchMultimatch(String keywords) {
		String url = URL.BASE_URL.getUrl() + "/weapi/search/suggest/multimatch" ;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		dataMap.put("type", 1);
		dataMap.put("s", keywords);
		
		return httpClient.doPost(url, dataMap);
	}

	//TODO
	@Override
	public JSONObject operatePlaylist(String op, String userId, String musicId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JSONObject getLyric(String musicId){
		String url = URL.BASE_URL.getUrl() + "/weapi/song/lyric?os=osx&id=" + musicId +  "&lv=-1&kv=-1&tv=-1";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		
		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getMusicComment(String musicId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/resource/comments/R_SO_4_" + musicId +  "/?csrf_token=";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("rid", musicId);
		dataMap.put("limit", 100);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getAlbumComment(String albumId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/resource/comments/R_AL_3_" + albumId +  "/?csrf_token=";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("rid", albumId);
		dataMap.put("limit", 100);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getPlaylistComment(String playlistId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/resource/comments/A_PL_0_" + playlistId +  "/?csrf_token=";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("rid", playlistId);
		dataMap.put("limit", 100);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getMvComment(String mvId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/resource/comments/R_MV_5_" + mvId +  "/?csrf_token=";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("rid", mvId);
		dataMap.put("limit", 100);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getDjComment(String djId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/resource/comments/A_DJ_1_" + djId +  "/?csrf_token=";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("offset", 0);
		dataMap.put("rid", djId);
		dataMap.put("limit", 100);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject upvote(String id, String type, boolean t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public JSONObject getBanner(){
		String url = URL.BASE_URL.getUrl() + "/weapi/v2/banner/get";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		
		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getSongDetail(String musicId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v3/song/detail";
		Map<String, String> idMap = new HashMap<String, String>();
		idMap.put("id", musicId);
		List<Map<String, String>> idMapList = new ArrayList<Map<String,String>>();
		idMapList.add(idMap);

		List<String> ids = new ArrayList<String>();
		ids.add(musicId);
		
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("c", JSON.toJSONString(idMapList));
		dataMap.put("ids", ids);
		dataMap.put("csrf_token", "");
		
		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getAlbumDetail(String albumId) {
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/album/" + albumId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getArtist(String artistId) {
		String offset = "0";
		String limit = "100";
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/artist/" + artistId + "?offset=" + offset + "&limit=" + limit;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getArtistMvs(String artistId, String offset, String limit) {
		String url = URL.BASE_URL.getUrl() + "/weapi/artist/mvs";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("artistId", artistId);
		dataMap.put("total", true);
		dataMap.put("offset", offset);
		dataMap.put("limit", limit);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}



	@Override
	public JSONObject getArtistAlbum(String artistId, String offset, String limit) {
		String url = URL.BASE_URL.getUrl() + "/weapi/artist/albums/" + artistId;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("total", true);
		dataMap.put("offset", offset);
		dataMap.put("limit", limit);
		dataMap.put("csrf_token", "");

		return httpClient.doPost(url, dataMap);
	}


}
