package cn.zhouyafeng.netease.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zhouyafeng.netease.beans.SongInfo;
import cn.zhouyafeng.netease.core.Core;
import cn.zhouyafeng.netease.enums.URL;
import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.utils.CommonTools;

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
	 * 获取歌曲详情
	 * 
	 * @date 2017年8月16日 上午12:05:47
	 * @param songId
	 */
	@Override
	public JSONArray getSongDetail(long songId) {
		String result = null;
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

	public String getUrlNewApi(JSONArray songDetail){
		String bateRate = "320000";
		String id = songDetail.getJSONObject(0).getString("id");
		String url = URL.NEW_SONG_DETAIL_URL.getUrl();
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("ids", id);
		dataMap.put("br", bateRate);
		dataMap.put("csrf_token", "");
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(dataMap));
		Request req = new Request.Builder().url(url).post(requestBody).build();
		Call call = httpClient.newCall(req);

		try {
			Response resp = call.execute();
			System.out.println(resp.body().string());
			JSONObject result = JSON.parseObject(resp.body().string());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private SongInfo digInfo() {
		return null;
		// TODO
	}

}
