package com.chenjifeng.bean;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uid;
	private String uname;
	private String uphone;
	private String uemail;
	private String sex;
	private String udate;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((udate == null) ? 0 : udate.hashCode());
		result = prime * result + ((uemail == null) ? 0 : uemail.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((uphone == null) ? 0 : uphone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (udate == null) {
			if (other.udate != null)
				return false;
		} else if (!udate.equals(other.udate))
			return false;
		if (uemail == null) {
			if (other.uemail != null)
				return false;
		} else if (!uemail.equals(other.uemail))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (uphone == null) {
			if (other.uphone != null)
				return false;
		} else if (!uphone.equals(other.uphone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uphone=" + uphone + ", uemail=" + uemail + ", sex=" + sex
				+ ", udate=" + udate + "]";
	}
	public User(int uid, String uname, String uphone, String uemail, String sex, String udate) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uphone = uphone;
		this.uemail = uemail;
		this.sex = sex;
		this.udate = udate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
