package cn.zhouyafeng.netease.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.core.Core;
import cn.zhouyafeng.netease.enums.URL;
import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.utils.CommonTools;
import cn.zhouyafeng.netease.utils.SecurityUtil;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

	private Core core = Core.getInsance();
	private OkHttpClient httpClient = core.getHttpClient();

	@Override
	public List<Long> getTopSongList() {
		List<Long> songIdList = new ArrayList<Long>();
		String url = URL.BASE_URL.getUrl() + URL.TOP_SONG_URL.getUrl();
		Request req = new Request.Builder().url(url).build();
		Call call = httpClient.newCall(req);
		try {
			Response resp = call.execute();
			String result = resp.body().string();
			String regEx = "/song\\?id=(\\d+)";
			Matcher matcher = CommonTools.getMatcher(regEx, result);
			while (matcher.find()) {
				songIdList.add(Long.valueOf(matcher.group().substring("/song?id=".length(), matcher.group().length())));
			}
		} catch (Exception e) {
			LOG.error("getTopSongList ", e.getMessage());
		}
		System.out.println(songIdList);
		return songIdList;
	}
	
	/**
	 * 手机登陆
	 * @date 2017年9月13日 下午11:44:58
	 * @param @param phoneNum
	 * @param @param password
	 * @return void
	 *
	 */
	public JSONObject cellphoneLogin(String phoneNum, String password){
		JSONObject result = null;
		String url = URL.BASE_URL.getUrl() + "/weapi/login/cellphone";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("phone", phoneNum);
		dataMap.put("password", SecurityUtil.getMD5(password));
		dataMap.put("rememberLogin", "true");
		
		LinkedHashMap<String, String> paramMap = SecurityUtil.encrypt(dataMap);

		//System.out.println(paramMap);
		String requestParams = CommonTools.createRequestParam(paramMap);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
				requestParams);
		Request req = new Request.Builder().url(url).post(requestBody).build();
		Call call = httpClient.newCall(req);

		try {
			Response resp = call.execute();
			result = JSON.parseObject(resp.body().string());
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	/**
	 * 获取歌曲详情
	 * 
	 * @date 2017年8月16日 上午12:05:47
	 * @param songId
	 */
	@Override
	public JSONArray getSongDetail(long songId) {
		String url = String.format(URL.SONG_DETAIL_URL.getUrl(), songId, songId);
		Request req = new Request.Builder().url(url).build();
		Call call = httpClient.newCall(req);
		try {
			Response resp = call.execute();
			JSONObject songInfo = JSON.parseObject(resp.body().string());
			return songInfo.getJSONArray("songs");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	@Override
	public JSONObject getMusicInfo(List<String> ids) {
		JSONObject result = null;
		String url = URL.BASE_URL.getUrl() + "/weapi/song/enhance/player/url";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("ids", ids);
		dataMap.put("br", "999000");
		dataMap.put("csrf_token", "");
		
		LinkedHashMap<String, String> paramMap = SecurityUtil.encrypt(dataMap);

		//System.out.println(paramMap);
		String requestParams = CommonTools.createRequestParam(paramMap);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
				requestParams);
		Request req = new Request.Builder().url(url).post(requestBody).build();
		Call call = httpClient.newCall(req);

		try {
			Response resp = call.execute();
			result = JSON.parseObject(resp.body().string());
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public JSONObject getSearchSuggest(String keywords){
		JSONObject result = null;
		String url = URL.BASE_URL.getUrl() + "/weapi/search/suggest/web" ;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		dataMap.put("s", keywords);
		
		LinkedHashMap<String, String> paramMap = SecurityUtil.encrypt(dataMap);

		//System.out.println(paramMap);
		String requestParams = CommonTools.createRequestParam(paramMap);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),
				requestParams);
		Request req = new Request.Builder().url(url).post(requestBody).build();
		Call call = httpClient.newCall(req);

		try {
			Response resp = call.execute();
			result = JSON.parseObject(resp.body().string());
			//System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	

}
