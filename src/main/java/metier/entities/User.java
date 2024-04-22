package metier.entities;

import java.io.Serializable;

public class User implements Serializable{

	private long user_id;
	private String fullName;
	private String pseudo;
	private String email;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String fullName,String pseudo, String email, String password) {
		super();
		this.fullName = fullName;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}

	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", pseudo=" + pseudo + ", email=" + email + ", password=" + password + "]";
	}
	
}
