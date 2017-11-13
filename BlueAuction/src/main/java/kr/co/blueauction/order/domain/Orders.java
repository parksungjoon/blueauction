package kr.co.blueauction.order.domain;

public class Orders {
	private int orderId; 
	private String memberId;
	private int productId;
	private String orderdate;
	private String dstate;
	private String dest;
	private String price;
	private String paystate;
	
	
	public Orders() {
		this(0, "", 0, "", "", "", "", "");
	}
	
	public Orders(String memberId, int productId, String dstate, String dest, String price, String paystate) {
		this(0, memberId, productId, "", dstate, dest, price, paystate);
	}

	public Orders(int orderId, String memberId, int productId, String orderdate, String dstate, String dest,
			String price, String paystate) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.productId = productId;
		this.orderdate = orderdate;
		this.dstate = dstate;
		this.dest = dest;
		this.price = price;
		this.paystate = paystate;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
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
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
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
		return "Orders [orderId=" + orderId + ", memberId=" + memberId + ", productId=" + productId + ", orderdate="
				+ orderdate + ", dstate=" + dstate + ", dest=" + dest + ", price=" + price + ", paystate=" + paystate
				+ "]";
	}
	
}
