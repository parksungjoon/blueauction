package kr.co.blueauction.product.domain;

public class Product {

	private int product_id;
	private int category_id;
	private String seller;
	private String salemotive;
	private String usingtime;
	private String productinfo;
	private String price;
	private String deliverytype;
	private String regdate;
	private String auction_flag;
	private String auctionstart;
	private String auctionend;
	private int basicprice;
	private String auctionstate;
	
	public Product() {
	}

	public Product(int product_id, int category_id, String seller, String salemotive, String usingtime,
			String productinfo, String price, String deliverytype, String regdate, String auction_flag,
			String auctionstart, String auctionend, int basicprice, String auctionstate) {
		super();
		this.product_id = product_id;
		this.category_id = category_id;
		this.seller = seller;
		this.salemotive = salemotive;
		this.usingtime = usingtime;
		this.productinfo = productinfo;
		this.price = price;
		this.deliverytype = deliverytype;
		this.regdate = regdate;
		this.auction_flag = auction_flag;
		this.auctionstart = auctionstart;
		this.auctionend = auctionend;
		this.basicprice = basicprice;
		this.auctionstate = auctionstate;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSalemotive() {
		return salemotive;
	}

	public void setSalemotive(String salemotive) {
		this.salemotive = salemotive;
	}

	public String getUsingtime() {
		return usingtime;
	}

	public void setUsingtime(String usingtime) {
		this.usingtime = usingtime;
	}

	public String getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getAuction_flag() {
		return auction_flag;
	}

	public void setAuction_flag(String auction_flag) {
		this.auction_flag = auction_flag;
	}

	public String getAuctionstart() {
		return auctionstart;
	}

	public void setAuctionstart(String auctionstart) {
		this.auctionstart = auctionstart;
	}

	public String getAuctionend() {
		return auctionend;
	}

	public void setAuctionend(String auctionend) {
		this.auctionend = auctionend;
	}

	public int getBasicprice() {
		return basicprice;
	}

	public void setBasicprice(int basicprice) {
		this.basicprice = basicprice;
	}

	public String getAuctionstate() {
		return auctionstate;
	}

	public void setAuctionstate(String auctionstate) {
		this.auctionstate = auctionstate;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", category_id=" + category_id + ", seller=" + seller
				+ ", salemotive=" + salemotive + ", usingtime=" + usingtime + ", productinfo=" + productinfo
				+ ", price=" + price + ", deliverytype=" + deliverytype + ", regdate=" + regdate + ", auction_flag="
				+ auction_flag + ", auctionstart=" + auctionstart + ", auctionend=" + auctionend + ", basicprice="
				+ basicprice + ", auctionstate=" + auctionstate + "]";
	}
	
	
	
	
}
