package cn.zhouyafeng.netease.enums;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2017/8/14 21:29
 */
public enum Url {

    RECOMMAND_URL("http://music.163.com/weapi/v1/discovery/recommend/songs?csrf_token=", "推荐歌单");


    private String url;
    private String desc;

    Url (String url, String desc){
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
