package cn.qtone.util.base;

/**
 * 登录后保存用户信息的类的接口
 * @author huanshengqing
 *
 */
public class BaseLoginVO implements java.io.Serializable{
	private Integer id;//用户在数据库中的唯一标识id
	private String account;//用户帐号
	private String password;//密码
	private String userToken;
	private String email;
	private String openId;
	private Integer roleType;//用户角色  
	private String userName;//用户名
	private boolean autologin=false;//是否自动登录
	private boolean rememberme=false;//是否记住密码
	private boolean canEntry=false;
	private boolean repeatedLogin; //是否重复登录，true当前用户被重复	


	public boolean isCanEntry() {
		return canEntry;
	}

	public void setCanEntry(boolean canEntry) {
		this.canEntry = canEntry;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}


	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAutologin() {
		return autologin;
	}

	public void setAutologin(boolean autologin) {
		this.autologin = autologin;
	}

	public boolean isRememberme() {
		return rememberme;
	}

	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}


	/**
	 * 是否重复登录，true当前用户被重复
	 * @return
	 */
	public boolean isRepeatedLogin() {
		return repeatedLogin;
	}

    /**
     * 是否重复登录，
     * @param repeatedLogin  true当前用户被重复
     */
	public void setRepeatedLogin(boolean repeatedLogin) {
		this.repeatedLogin = repeatedLogin;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

}
