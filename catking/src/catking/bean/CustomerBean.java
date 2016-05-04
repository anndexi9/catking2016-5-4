package catking.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String name;
	private String address;
	private String tel;
	private String email;
	//addition
	private String username;
	private String password;
	private String regtime;
	

	public CustomerBean(int code, String name, String address, String tel,
			String email) {
		this.code = code;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}
	
	public CustomerBean(int code, String name, String address, String tel,
			String email, String username, String password, String regtime) {
		this.code = code;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.username =username;
		this.password = password;
		this.regtime = regtime;
	}

	public CustomerBean() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//addition
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRegTime() {
		return regtime;
	}

	public void setregTime(String regtime) {
		this.regtime = regtime;
	}
}
