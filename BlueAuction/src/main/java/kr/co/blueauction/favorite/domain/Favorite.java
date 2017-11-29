/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 18.
 */
package kr.co.blueauction.favorite.domain;

/**
 * 관심경매 도메인
 * @author 김수진
 * @since 2017. 11. 18.
 */
public class Favorite {

	private int favoriteId;
	private String memberId;
	private int productId;
	private String regdate;
	
	/** 생성자 */
	public Favorite() {
		this(0, "", 0, "");	
	}
	
	
	public Favorite(String memberId, int productId) {
		this(0, memberId, productId, "");
	}

	public Favorite(int favoriteId, String memberId, int productId, String regdate) {
		this.favoriteId = favoriteId;
		this.memberId = memberId;
		this.productId = productId;
		this.regdate = regdate;
	}
	
	
	/** Setter & Getter */
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	
	/** toString */
	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", memberId=" + memberId + ", productId=" + productId
				+ ", regdate=" + regdate + "]";
	}
	
	
}
