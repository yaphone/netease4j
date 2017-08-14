package cn.zhouyafeng.netease.enums;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2017/8/14 21:29
 */
public enum URL {

	BASE_URL("http://music.163.com", "基本URL"),
	TOP_SONG_URL("/discover/toplist?id=3779629", "新歌榜"),

	RECOMMAND_URL("http://music.163.com/weapi/v1/discovery/recommend/songs?csrf_token=", "推荐歌单");

	private String url;
	private String desc;

	URL(String url, String desc) {
		this.url = url;
		this.desc = desc;
	};

	public String getUrl() {
		return url;
	}

	public String getDesc() {
		return desc;
	}
}