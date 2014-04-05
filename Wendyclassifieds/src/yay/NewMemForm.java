package yay;

import org.apache.struts.action.ActionForm;

public class NewMemForm extends ActionForm {
	private String username;
	private String pswd;
	private String pswdconf;
	private String name;
	private String email;
	private String location;
	private String telno;
	private String bio;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswdconf() {
		return pswdconf;
	}

	public void setPswdconf(String pswdconf) {
		this.pswdconf = pswdconf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
