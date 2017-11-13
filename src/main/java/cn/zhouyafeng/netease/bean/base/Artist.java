package cn.zhouyafeng.netease.bean.base;

import java.util.ArrayList;

/**
 * 
* @ClassName: Artist  
* @Description:   
* @author https://github.com/yaphone
* @date 2017年11月13日 下午10:25:35  
*
 */
public class Artist {
	private String img1v1Url;
	private int img1v1;
	private String name;
	private ArrayList<String> alias;
	private long id;
	private long albumSize;
	private long picId;
	
	public String getImg1v1Url() {
		return img1v1Url;
	}
	public void setImg1v1Url(String img1v1Url) {
		this.img1v1Url = img1v1Url;
	}
	public int getImg1v1() {
		return img1v1;
	}
	public void setImg1v1(int img1v1) {
		this.img1v1 = img1v1;
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
	public long getAlbumSize() {
		return albumSize;
	}
	public void setAlbumSize(long albumSize) {
		this.albumSize = albumSize;
	}
	public long getPicId() {
		return picId;
	}
	public void setPicId(long picId) {
		this.picId = picId;
	}

}
