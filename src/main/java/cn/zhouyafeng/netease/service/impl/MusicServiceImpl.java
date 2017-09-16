package cn.zhouyafeng.netease.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	public JSONObject search(String keywords, String type) {
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
	

}
