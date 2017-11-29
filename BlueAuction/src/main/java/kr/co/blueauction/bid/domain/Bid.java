/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.domain;

/**
 * 입찰 도메인 
 * @author 김수진
 * @since 2017. 11. 15.
 */
public class Bid {
	private int bidId; 
	private int productId;
	private String memberId;
	private int bidprice;
	private String biddate;
	private String winning;
	
	/** 생성자 */
	public Bid() {
		this(0, 0, "", 0, "", "");
	}
	
	public Bid(int productId, String memberId, int bidprice) {
		this.productId = productId;
		this.memberId = memberId;
		this.bidprice = bidprice;
	}

	public Bid(int bidId, int productId, String memberId, int bidprice, String biddate, String winning) {
		this.bidId = bidId;
		this.productId = productId;
		this.memberId = memberId;
		this.bidprice = bidprice;
		this.biddate = biddate;
		this.winning = winning;
	}

	/** Getter & Setter */
	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBidprice() {
		return bidprice;
	}

	public void setBidprice(int bidprice) {
		this.bidprice = bidprice;
	}

	public String getBiddate() {
		return biddate;
	}

	public void setBiddate(String biddate) {
		this.biddate = biddate;
	}

	public String getWinning() {
		return winning;
	}

	public void setWinning(String winning) {
		this.winning = winning;
	}

	
	/** To String */
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", productId=" + productId + ", memberId=" + memberId + ", bidprice=" + bidprice
				+ ", biddate=" + biddate + ", winning=" + winning + "]";
	}
	
}


