package cn.zhouyafeng.netease.base;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.zhouyafeng.netease.utils.Helper;
import javazoom.jl.player.Player;

public class Mp3Player {
	public static void main(String[] args) throws Exception{
		//URL url = new URL("http://m10.music.126.net/20171113221313/ec4b9f70dfcb17049cb38a6f1baf4740/ymusic/8a79/f233/0ae0/ab44bd99786f2ec2b594c19a54912590.mp3");
		String musicName= "潇洒走一回";
		String urlStr = Helper.getMusicUrlByMusicName(musicName);
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = new BufferedInputStream(conn.getInputStream(), 8 * 1024);
		Player player = new Player(inputStream);
//		File file = new File("E:/tmp.mp3");
//		InputStream inputStream = new FileInputStream(file);
//		Player player = new Player(inputStream);
		player.play();
	}

}
