package kr.co.blueauction.favorite.domain;

public class Favorite {

	private int favorite_id;
	private String member_id;
	private int product_id;
	private String regdate;
	
	public Favorite() {
	}

	public Favorite(int favorite_id, String member_id, int product_id, String regdate) {
		
		this.favorite_id = favorite_id;
		this.member_id = member_id;
		this.product_id = product_id;
		this.regdate = regdate;
	}


	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Favorite [favorite_id=" + favorite_id + ", member_id=" + member_id + ", product_id=" + product_id
				+ ", regdate=" + regdate + "]";
	}
	
	
	
	
}
