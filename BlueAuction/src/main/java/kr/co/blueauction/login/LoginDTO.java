package kr.co.blueauction.login;

public class LoginDTO {

	private String memberId;
	private String passwd;
	private boolean useCookie;
	public LoginDTO(String memberId, String passwd, boolean useCookie) {
		super();
		this.memberId = memberId;
		this.passwd = passwd;
		this.useCookie = useCookie;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
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
		return "LoginDTO [memberId=" + memberId + ", passwd=" + passwd + ", useCookie=" + useCookie + "]";
	}
	
	
	
}
