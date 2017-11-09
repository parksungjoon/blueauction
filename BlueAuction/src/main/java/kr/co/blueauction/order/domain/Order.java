package kr.co.blueauction.order.domain;

public class Order {
	private int order_id;
	private String member_id;
	private int product_id;
	private String orderdate;
	private String dstate;
	private String dest;
	private String price;
	private String paystate;

	public Order() {
	}

	public Order(int order_id, String member_id, int product_id, String orderdate, String dstate, String dest,
			String price, String paystate) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.product_id = product_id;
		this.orderdate = orderdate;
		this.dstate = dstate;
		this.dest = dest;
		this.price = price;
		this.paystate = paystate;
	}
	
	public Order(String member_id, int product_id, String dstate, String price) {
		this(0,member_id,product_id,null,dstate,null,price,null);
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
		return "Order [order_id=" + order_id + ", member_id=" + member_id + ", product_id=" + product_id
				+ ", orderdate=" + orderdate + ", dstate=" + dstate + ", dest=" + dest + ", price=" + price
				+ ", paystate=" + paystate + "]";
	}
	
	
	
	
}
