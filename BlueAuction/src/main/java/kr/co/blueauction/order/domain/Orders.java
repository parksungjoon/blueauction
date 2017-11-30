/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.domain;

/**
 * 중고, 옥션 물품 구매를위한 Order 
 * @author 김봉환
 * @since 2017. 11. 15
 */
public class Orders {
	private int orderId; 
	private String memberId;
	private int productId;
	private String phone;
	private String orderdate;
	private String dstate;
	private String zipcode;
	private String baseaddress;
	private String detailaddress;
	private int price;
	private String paystate;
	
	/** 생성자  */
	public Orders() {
		super();
	}

	public Orders(String memberId, int productId, String phone, String zipcode, String baseaddress,
			String detailaddress, int price) {
		super();
		this.memberId = memberId;
		this.productId = productId;
		this.phone = phone;
		this.zipcode = zipcode;
		this.baseaddress = baseaddress;
		this.detailaddress = detailaddress;
		this.price = price;
	}


	public Orders(int orderId, String memberId, int productId, String phone, String orderdate, String dstate,
			String zipcode, String baseaddress, String detailaddress, int price, String paystate) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.productId = productId;
		this.phone = phone;
		this.orderdate = orderdate;
		this.dstate = dstate;
		this.zipcode = zipcode;
		this.baseaddress = baseaddress;
		this.detailaddress = detailaddress;
		this.price = price;
		this.paystate = paystate;
	}


	public int getOrderId() {
		return orderId;
	}


	/**  Setter % Getter */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}


	public String getDstate() {
		return dstate;
	}


	public void setDstate(String dstate) {
		this.dstate = dstate;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getPaystate() {
		return paystate;
	}


	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", memberId=" + memberId + ", productId=" + productId + ", phone=" + phone
				+ ", orderdate=" + orderdate + ", dstate=" + dstate + ", zipcode=" + zipcode + ", baseaddress="
				+ baseaddress + ", detailaddress=" + detailaddress + ", price=" + price + ", paystate=" + paystate
				+ "]";
	}
	
}
