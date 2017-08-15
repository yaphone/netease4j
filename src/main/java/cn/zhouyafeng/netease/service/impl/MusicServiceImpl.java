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

	/**
	 * 热门单曲
	 * 
	 * @date 2017年8月14日 下午11:23:48
	 */
	@Override
	public void getTopSongList() {
		String url = URL.BASE_URL.getUrl() + URL.TOP_SONG_URL.getUrl();
		System.out.println(url);
		// url = "http://www.baidu.com";
		Request req = new Request.Builder().url(url).build();
		Call call = httpClient.newCall(req);
		try {
			List<String> songIdList = new ArrayList<String>();
			Response resp = call.execute();
			String content = resp.body().string();
			String regEx = "/song\\?id=(\\d+)";
			Matcher matcher = CommonTools.getMatcher(regEx, content);
			while (matcher.find()) {
				songIdList.add(matcher.group().substring("/song?id=".length(), matcher.group().length()));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
