package kr.co.blueauction.favorite.domain;

public class Favorite {

	private int favoriteId;
	private String memberId;
	private int productId;
	private String regdate;
	
	public Favorite() {
		this(0, "", 0, "");	
	}
	
	
	public Favorite(String memberId, int productId, String regdate) {
		this(0, memberId, productId, regdate);
	}

	public Favorite(int favoriteId, String memberId, int productId, String regdate) {
		this.favoriteId = favoriteId;
		this.memberId = memberId;
		this.productId = productId;
		this.regdate = regdate;
	}
	
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


	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", memberId=" + memberId + ", productId=" + productId
				+ ", regdate=" + regdate + "]";
	}
	
	
}
