package cn.zhouyafeng.netease.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zhouyafeng.netease.core.Core;
import cn.zhouyafeng.netease.enums.URL;
import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.utils.CommonTools;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
		return songIdList;
	}

	/**
	 * 获取歌曲详情
	 * 
	 * @date 2017年8月16日 上午12:05:47
	 * @param songId
	 */
	@Override
	public void getSongDetail(long songId) {
		String url = String.format(URL.SONG_DETAIL_URL.getUrl(), songId, songId);
		Request req = new Request.Builder().url(url).build();
		Call call = httpClient.newCall(req);
		try {
			Response resp = call.execute();
			String result = resp.body().string();
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
