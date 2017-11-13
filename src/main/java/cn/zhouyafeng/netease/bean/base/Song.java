package cn.zhouyafeng.netease.bean.base;

import java.util.ArrayList;

/**
 * 
* @ClassName: Song  
* @Description:
* @author https://github.com/yaphone
* @date 2017年11月13日 下午10:26:01  
*
 */
public class Song {
	private Album album;
	private int fee;
	private int duration;
	private int rtype;
	private int ftype;
	private ArrayList<Artist> artists;
	private long copyrightId;
	private long mvid;
	private String name;
	private ArrayList<String> alias;
	private long id;
	private int status;
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getRtype() {
		return rtype;
	}
	public void setRtype(int rtype) {
		this.rtype = rtype;
	}
	public int getFtype() {
		return ftype;
	}
	public void setFtype(int ftype) {
		this.ftype = ftype;
	}
	public ArrayList<Artist> getArtists() {
		return artists;
	}
	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}
	public long getCopyrightId() {
		return copyrightId;
	}
	public void setCopyrightId(long copyrightId) {
		this.copyrightId = copyrightId;
	}
	public long getMvid() {
		return mvid;
	}
	public void setMvid(long mvid) {
		this.mvid = mvid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getAlias() {
		return alias;
	}
	public void setAlias(ArrayList<String> alias) {
		this.alias = alias;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
