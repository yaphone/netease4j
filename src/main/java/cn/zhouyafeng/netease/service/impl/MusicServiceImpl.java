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
	public JSONObject getMusicInfo(List<String> ids) {
		String url = URL.BASE_URL.getUrl() + "/weapi/song/enhance/player/url";
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("ids", ids);
		dataMap.put("br", "999000");
		dataMap.put("csrf_token", "");
		
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
	public JSONObject getUserDetail(String id){
		String url = URL.BASE_URL.getUrl() + "/weapi/v1/user/detail/" + id;
		LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("csrf_token", "");
		return httpClient.doPost(url, dataMap);
	}
	

}
