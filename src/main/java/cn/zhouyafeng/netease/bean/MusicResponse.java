package cn.zhouyafeng.netease.bean;

/**
 * 
* @ClassName: MusicResponse  
* @Description:   
* @author https://github.com/yaphone
* @date 2017年11月13日 下午10:43:03  
*
 */
public class MusicResponse {
	private int code;
	private int expi;
	private int flag;
	private int fee;
	private String type;
	private boolean canExtend;
	private String url;
	private double gain;
	private long br;
	private long size;
	private long id;
	private String md5;
	private int played;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getExpi() {
		return expi;
	}
	public void setExpi(int expi) {
		this.expi = expi;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isCanExtend() {
		return canExtend;
	}
	public void setCanExtend(boolean canExtend) {
		this.canExtend = canExtend;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getGain() {
		return gain;
	}
	public void setGain(double gain) {
		this.gain = gain;
	}
	public long getBr() {
		return br;
	}
	public void setBr(long br) {
		this.br = br;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	
}
