/**
  * Copyright 2017 bejson.com 
  */
package cn.zhouyafeng.netease.bean.login;
import java.util.List;

/**
 * 登陆后返回的信息实体
 * Auto-generated: 2017-12-02 22:45:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LoginBean {

    private int code;
    private int loginType;
    private Profile profile;
    private List<Bindings> bindings;
    private Account account;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setLoginType(int loginType) {
         this.loginType = loginType;
     }
     public int getLoginType() {
         return loginType;
     }

    public void setProfile(Profile profile) {
         this.profile = profile;
     }
     public Profile getProfile() {
         return profile;
     }

    public void setBindings(List<Bindings> bindings) {
         this.bindings = bindings;
     }
     public List<Bindings> getBindings() {
         return bindings;
     }

    public void setAccount(Account account) {
         this.account = account;
     }
     public Account getAccount() {
         return account;
     }

}