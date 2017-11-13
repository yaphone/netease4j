package cn.zhouyafeng.netease.bean.base;

/**
 * 
* @ClassName: Album  
* @Description:   
* @author https://github.com/yaphone
* @date 2017年11月13日 下午10:25:49  
*
 */
public class Album {
	private long publishTime;
	private int size;
	private Artist artist;
	private long copyrightId;
	private String name;
	private long id;
	private long picId;
	private int status;
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public long getCopyrightId() {
		return copyrightId;
	}
	public void setCopyrightId(long copyrightId) {
		this.copyrightId = copyrightId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPicId() {
		return picId;
	}
	public void setPicId(long picId) {
		this.picId = picId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
