package kr.co.blueauction.member.domain;

public class Member {
	
	private String memberId;
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
	private String phoneNumber;
	private String regdate;
	public Member(String memberId, String passwd, String name, String zipcode, String baseaddress, String detailaddress,
			String email, String sessionid, String sessionlimit, String accountNumber, String bank, String phoneNumber,
			String regdate) {
		this.memberId = memberId;
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
		this.phoneNumber = phoneNumber;
		this.regdate = regdate;
	}
	public Member() {
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the baseaddress
	 */
	public String getBaseaddress() {
		return baseaddress;
	}
	/**
	 * @param baseaddress the baseaddress to set
	 */
	public void setBaseaddress(String baseaddress) {
		this.baseaddress = baseaddress;
	}
	/**
	 * @return the detailaddress
	 */
	public String getDetailaddress() {
		return detailaddress;
	}
	/**
	 * @param detailaddress the detailaddress to set
	 */
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}
	/**
	 * @param sessionid the sessionid to set
	 */
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	/**
	 * @return the sessionlimit
	 */
	public String getSessionlimit() {
		return sessionlimit;
	}
	/**
	 * @param sessionlimit the sessionlimit to set
	 */
	public void setSessionlimit(String sessionlimit) {
		this.sessionlimit = sessionlimit;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the regdate
	 */
	public String getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", passwd=" + passwd + ", name=" + name + ", zipcode=" + zipcode
				+ ", baseaddress=" + baseaddress + ", detailaddress=" + detailaddress + ", email=" + email
				+ ", sessionid=" + sessionid + ", sessionlimit=" + sessionlimit + ", accountNumber=" + accountNumber
				+ ", bank=" + bank + ", phoneNumber=" + phoneNumber + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	

}
