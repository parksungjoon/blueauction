package kr.co.blueauction.login;

public class LoginDTO {

	private String member_id;
	private String passwd;
	private boolean useCookie;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String member_id, String passwd, boolean useCookie) {
		super();
		this.member_id = member_id;
		this.passwd = passwd;
		this.useCookie = useCookie;
	}
	/**
	 * @return the member_id
	 */
	public String getMember_id() {
		return member_id;
	}
	/**
	 * @param member_id the member_id to set
	 */
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	 * @return the useCookie
	 */
	public boolean isUseCookie() {
		return useCookie;
	}
	/**
	 * @param useCookie the useCookie to set
	 */
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginDTO [member_id=" + member_id + ", passwd=" + passwd + ", useCookie=" + useCookie + "]";
	}
	
}
