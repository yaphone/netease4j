package cn.zhouyafeng.netease.enums;

/**
 * @Author: http://github.com/yaphone
 * @Date: 2017/12/24 0024下午 11:44
 */
public enum RankListType {
    NEW(0, 3779629),  //云音乐新歌榜
    HOT(1, 3778678),  //云音乐热歌榜
    ORIGINAL(2, 2884035), //网易原创歌曲榜
    BIAO(3, 19723756), //云音乐飙升榜
    ELEC(4, 10520166), //云音乐电音榜
    UK(5, 180106), //UK(5, UK排行榜周榜)
    BILLBOARD(6, 60198), //美国Billboard周榜
    KTVHIGH(7, 21845217), //KTV嗨榜
    ITUNES(8, 11641012), //iTunes榜
    HITFM(9, 120001),//Hit FM Top榜"
    ORICON(10, 60131), //日本Oricon周榜
    MELON_1(11, 3733003), //韩国Melon排行榜周榜
    MNET(12, 60255), //韩国Mnet排行榜周榜
    MELON_2(13, 46772709), //韩国Melon原声周榜
    CHINA_TOP_GAT(14, 112504), //中国TOP排行榜(港台榜)
    CHINA_TOP(15, 64016), //中国TOP排行榜(内地榜)
    LONGHU(16, 10169002), //香港电台中文歌曲龙虎榜
    HUAYUJINQU(17, 4395559), //华语金曲榜
    CHINAXIHA(18, 1899724), //中国嘻哈榜
    NRJ(19, 27135204), //法国 NRJ EuroHot 30周榜
    HITO(20, 112463), //台湾Hito排行榜
    BEATPORT(21, 3812895), //Beatport全球电子舞曲榜
    ACG(22, 71385702), //云音乐ACG音乐榜
    NETEASEXIHA(23, 991319590); //云音乐嘻哈榜

    private int idx;
    private int playlistId;

    RankListType(int idx, int playlistId) {
        this.idx = idx;
        this.playlistId = playlistId;
    }

    public int getIdx() {return idx;}

    public int getPlaylistId() {
        return playlistId;
    }

    public static int getPlaylistId(int idx){
        for(RankListType type: RankListType.values()){
            if(idx == type.getIdx()){
                return type.getPlaylistId();
            }
        }
        return -1;
    }


}
