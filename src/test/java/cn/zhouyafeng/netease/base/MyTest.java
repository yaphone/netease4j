package cn.zhouyafeng.netease.base;

import cn.zhouyafeng.netease.enums.RankListType;
import cn.zhouyafeng.netease.service.impl.MusicServiceImpl;
import cn.zhouyafeng.netease.utils.PropertyUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
	
	private static String userId = "32953014";
	
	MusicServiceImpl musicService = new MusicServiceImpl();
	
	
	@Test
	public void loginTest(){
		String phoneNum = "18980869903";
		String password = "WO19891226";
		JSONObject res = musicService.cellphoneLogin(phoneNum, password);
		System.out.println(res);
	}
	
	@Test
	public void getUserDetailTest() throws Exception{
		String userId = PropertyUtil.getProperty("userinfo.properties", "userid");
		JSONObject res = musicService.getUserDetail(userId);
		
		System.out.println(res);
	}
	
	
	@Test
	public void getUserSubcontTest(){
		//TODO
	}
	
	@Test
	public void getUserPlaylistTest() throws Exception{
		String userId = PropertyUtil.getProperty("userinfo.properties", "userid");
		JSONObject res = musicService.getUserPlaylist(userId);
		
		System.out.println(res);
	}
	
	@Test
	public void getUserDjListTest() {
		JSONObject res = musicService.getUserDjs(userId);
		
		System.out.println(res);
	}
	
	@Test
	public void getUserFollowsTest(){
		JSONObject res = musicService.getUserFollows(userId);
		
		System.out.println(res);
	}
	
	@Test
	public void getUserFollowedsTest(){
		JSONObject res = musicService.getUserFolloweds(userId);
		
		System.out.println(res);
	}
	
	@Test
	public void getUserEventTest(){
		JSONObject res = musicService.getUserEvent(userId);
		
		System.out.println(res);
	}
	
	@Test
	public void getEventTest(){
		JSONObject res = musicService.getEvent();
		
		System.out.println(res);
	}
	
	@Test
	public void getTopPlaylistTest(){
		JSONObject res = musicService.getTopPlaylist();
		
		System.out.println(res);
	}
	
	@Test
	public void getPlaylistDetailTest(){
		String playlistId = "24381616";
		JSONObject res = musicService.getPlaylistDetail(playlistId);
		
		System.out.println(res);
	}
	
	@Test
	public void getMusicUrlTest(){
		List<String> ids = new ArrayList<String>();
		ids.add("509311657");
		JSONObject res = musicService.getMusicUrl(ids);
		
		System.out.println(res);
	}
	
	@Test
	public void searchTest(){
		String keywords = "海阔天空";
		String type = "100";
		JSONObject res = musicService.getSearch(keywords, type);
		
		System.out.println(res);
	}
	
	@Test
	public void getSearchSuggestTest(){
		String keywords = "海阔天空";
		JSONObject res = musicService.getSearchSuggest(keywords);
		
		System.out.println(res);
	}
	
	@Test
	public void getSearchMultimatch(){
		String keywords = "海阔天空";
		JSONObject res = musicService.getSearchMultimatch(keywords);
		
		System.out.println(res);
	}
	
	@Test
	public void getLyricTest(){
		long musicId = 509311657L;
		JSONObject res = musicService.getLyric(musicId);
		
		System.out.println(res);
	}
	
	@Test
	public void getMusicCommentTest(){
		String musicId = "186016";
		JSONObject res = musicService.getMusicComment(musicId);
		
		System.out.println(res);
	}
	
	@Test
	public void getAlbumCommentTest(){
		String albumId = "32311";
		JSONObject res = musicService.getAlbumComment(albumId);
		
		System.out.println(res);
	}
	
	@Test
	public void getPlaylistCommentTest(){
		String playlistId = "705123491";
		JSONObject res = musicService.getPlaylistComment(playlistId);
		
		System.out.println(res);
	}
	
	@Test
	public void getMvCommentTest(){
		String mvId = "5436712";
		JSONObject res = musicService.getMvComment(mvId);
		
		System.out.println(res);
	}
	
	@Test
	public void getDjCommentTest(){
		String djId = "794062371";
		JSONObject res = musicService.getDjComment(djId);
		
		System.out.println(res);
	}
	
	@Test
	public void getBannerTest(){
		JSONObject res = musicService.getBanner();
		
		System.out.println(res);
	}
	
	@Test
	public void getSongDetailTest(){
		String musicId = "347230";
		JSONObject res = musicService.getSongDetail(musicId);
		
		System.out.println(res);
	}
	
	@Test
	public void getAlbumDetailTest(){
		String albumId = "32311";
		JSONObject res = musicService.getAlbumDetail(albumId);
		
		System.out.println(res);
	}
	
	@Test
	public void getArtistTest(){
		String artistId = "6452";
		JSONObject res = musicService.getArtist(artistId);
		
		System.out.println(res);
	}
	
	@Test
	public void getArtistMvsTest(){
		String artistId = "6452";
		String offset = "0";
		String limit = "10";
		JSONObject res = musicService.getArtistMvs(artistId, offset, limit);
		
		System.out.println(res);
	}
	
	@Test
	public void getArtistAlbumTest(){
		String artistId = "6452";
		String offset = "0";
		String limit = "10";
		JSONObject res = musicService.getArtistAlbum(artistId, offset, limit);
		
		System.out.println(res);
	}
	
	@Test
	public void getArtistDescTest(){
		String artistId = "6452";
		JSONObject res = musicService.getArtistDesc(artistId);
		
		System.out.println(res);
	}
	
	@Test
	public void getSimilarArtistTest(){
		String artistId = "6452";
		JSONObject res = musicService.getSimilarArtist(artistId);
		
		System.out.println(res);
	}
	
	@Test
	public void getSimilarPlaylist(){
		String musicId = "347230";
		String offset = "0";
		String limit = "50";
		
		JSONObject res = musicService.getSimilarPlaylist(musicId, offset, limit);
		
		System.out.println(res);
	}
	
	@Test
	public void getSimilarMvTest(){
		String mvId = "5436712";
		JSONObject res = musicService.getSimilarMv(mvId);
		
		System.out.println(res);
	}
	
	@Test
	public void getSimilarSongTest(){
		String songId = "347230";
		String offset = "0";
		String limit = "100";
		JSONObject res = musicService.getSimilarSong(songId, offset, limit);
		
		System.out.println(res);
	}
	
	@Test
	public void getSimilarUserTest(){
		String songId = "347230";
		JSONObject res = musicService.getSimilarUser(songId);
		
		System.out.println(res);
	}
	
	@Test
	public void getRecommendResourceTest(){
		JSONObject res = musicService.getRecommendResource();
		
		System.out.println(res);
	}
	
	@Test
	public void getRecommendSongsTest(){
		JSONObject res = musicService.getRecommendSongs();
		
		System.out.println(res);
	}
	
	@Test
	public void dailySignInTest(){
		JSONObject res = musicService.dailySignIn(0);
		
		System.out.println(res);
	}

	@Test
	public void getRankListTest(){
		JSONObject res = musicService.getRankList(RankListType.CHINA_TOP.getPlaylistId(), 30, 0);

		System.out.println(res);
	}

}
