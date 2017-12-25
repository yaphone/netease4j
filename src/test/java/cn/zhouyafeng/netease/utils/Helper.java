package cn.zhouyafeng.netease.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.netease.bean.MusicResponse;
import cn.zhouyafeng.netease.bean.base.BaseResponse;
import cn.zhouyafeng.netease.service.IMusicService;
import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;

public class Helper {
	
	public static String getMusicUrlByMusicName(String musicName){
		IMusicService musicService = new MusicServiceImpl();
    	//String musicName = "成都";
    	JSONObject res1 = musicService.getSearch(musicName, "1");
    	BaseResponse baseResponse = JSON.toJavaObject(res1, BaseResponse.class);
//    	System.out.println(baseInfo.getCode());
//    	System.out.println(baseInfo.getResult().getSongCount());
//    	System.out.println(baseInfo.getResult().getSongs().get(0).getId());
    	String id = String.valueOf(baseResponse.getResult().getSongs().get(0).getId());
    	JSONObject res2 = musicService.getMusicUrl(id);
    	MusicResponse musicResponse = JSON.toJavaObject(res2, MusicResponse.class);
    	//System.out.println(musicResponse.getUrl());
    	return musicResponse.getUrl();
	}

}
