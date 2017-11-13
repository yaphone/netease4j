package cn.zhouyafeng.netease.bean.base;

import java.util.ArrayList;

/**
 * 
* @ClassName: Result  
* @Description:   
* @author https://github.com/yaphone
* @date 2017年11月13日 下午10:25:10  
*
 */
public class Result {
	private ArrayList<Song> songs;
	private int songCount;
	
	public int getSongCount() {
		return songCount;
	}
	public void setSongCount(int songCount) {
		this.songCount = songCount;
	}
	public ArrayList<Song> getSongs() {
		return songs;
	}
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

}
