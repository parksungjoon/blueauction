package kr.co.blueauction.member.domain;

import java.util.Date;

public class Member {
	
	private String member_id;
	private String passwd;
	private String name;
	private String zipcode;
	private String baseaddress;
	private String detailaddress;
	private String email;
	private String sessionid;
	private String sessionlimit;
	private String accountNumber;
	private String bank;
	private String regdate;
	
	public Member() {
	}
	
	public Member(String passwd, String name, String zipcode, String baseaddress,
			String detailaddress, String email, String accountNumber,
			String bank) {
		this(null, passwd, name, zipcode, baseaddress, detailaddress, email, null, null, accountNumber, bank, null);
	}

	public Member(String member_id, String passwd, String name, String zipcode, String baseaddress,
			String detailaddress, String email, String sessionid, String sessionlimit, String accountNumber,
			String bank, String regdate) {
		super();
		this.member_id = member_id;
		this.passwd = passwd;
		this.name = name;
		this.zipcode = zipcode;
		this.baseaddress = baseaddress;
		this.detailaddress = detailaddress;
		this.email = email;
		this.sessionid = sessionid;
		this.sessionlimit = sessionlimit;
		this.accountNumber = accountNumber;
		this.bank = bank;
		this.regdate = regdate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getBaseaddress() {
		return baseaddress;
	}

	public void setBaseaddress(String baseaddress) {
		this.baseaddress = baseaddress;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getSessionlimit() {
		return sessionlimit;
	}

	public void setSessionlimit(String sessionlimit) {
		this.sessionlimit = sessionlimit;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", passwd=" + passwd + ", name=" + name + ", zipcode=" + zipcode
				+ ", baseaddress=" + baseaddress + ", detailaddress=" + detailaddress + ", email=" + email
				+ ", sessionid=" + sessionid + ", sessionlimit=" + sessionlimit + ", accountNumber=" + accountNumber
				+ ", bank=" + bank + ", regdate=" + regdate + "]";
	}
	
	

	

	
	
	
	
	

}
