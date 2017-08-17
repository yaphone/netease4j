package cn.zhouyafeng.netease.beans;

/**
 * 歌曲信息
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年8月17日 下午11:14:38
 * @version 1.0
 *
 */
public class SongInfo {
	private long songId;
	private String songName;
	private String albumName;
	private String albumId;
	private String mp3Url;
	private String quality;
	private String playTime;

	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getMp3Url() {
		return mp3Url;
	}

	public void setMp3Url(String mp3Url) {
		this.mp3Url = mp3Url;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
}
