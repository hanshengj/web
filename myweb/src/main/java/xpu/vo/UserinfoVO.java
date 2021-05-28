package xpu.vo;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-05-28
 * Time: 17:13
 */
public class UserinfoVO {
    private String username;//用户名
    private String password;//口令
    public UserinfoVO()
    {
        this.username="";
        this.password="";
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
