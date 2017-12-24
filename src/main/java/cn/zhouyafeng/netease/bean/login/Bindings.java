/**
  * Copyright 2017 bejson.com 
  */
package cn.zhouyafeng.netease.bean.login;

/**
 * Auto-generated: 2017-12-02 22:45:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Bindings {

    private int expiresIn;
    private boolean expired;
    private String tokenJsonStr;
    private int refreshTime;
    private int id;
    private int type;
    private int userId;
    private String url;
    public void setExpiresIn(int expiresIn) {
         this.expiresIn = expiresIn;
     }
     public int getExpiresIn() {
         return expiresIn;
     }

    public void setExpired(boolean expired) {
         this.expired = expired;
     }
     public boolean getExpired() {
         return expired;
     }

    public void setTokenJsonStr(String tokenJsonStr) {
         this.tokenJsonStr = tokenJsonStr;
     }
     public String getTokenJsonStr() {
         return tokenJsonStr;
     }

    public void setRefreshTime(int refreshTime) {
         this.refreshTime = refreshTime;
     }
     public int getRefreshTime() {
         return refreshTime;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setUserId(int userId) {
         this.userId = userId;
     }
     public int getUserId() {
         return userId;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

}