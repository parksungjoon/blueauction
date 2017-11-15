package kr.co.blueauction.product.domain;

public class Product {

	private int productId;
	private int categoryId;
	private int smallid;
	private String seller;
	private String salemotive;
	private String usingtime;
	private String productinfo;
	private int price;
	private String deliverytype;
	private String regdate;
	private String auctionFlag;
	private String auctionstart;
	private String auctionend;
	private int basicprice;
	private String auctionstate;
	private String name;
	
	private String[] photo;
	
	public Product() {
		this(0, 0, 0, "", "",  "", "", "", 0, "", "", null, "", "", 0, "");
	}

	public Product(int categoryId, int smallid, String name, String seller, String salemotive, String usingtime, String productinfo, int price,
			String deliverytype) {
		this(0, categoryId, smallid, name,  seller, salemotive, usingtime, productinfo, price, deliverytype, "", "", "", "", 0, "");
	}
	
	public Product(int categoryId, int smallid, String name, String seller, String salemotive, String usingtime, String productinfo,
			String deliverytype, String auctionFlag, String auctionstart, String auctionend, int basicprice,
			String auctionstate) {
		this(0, categoryId, smallid, name, seller, salemotive, usingtime, productinfo, 0, deliverytype, "", auctionFlag, auctionstart, auctionend, basicprice, auctionstate);
	}

	public Product(int productId, int categoryId, int smallid, String name, String seller, String salemotive, String usingtime,
			String productinfo, int price, String deliverytype, String regdate, String auctionFlag, String auctionstart,
			String auctionend, int basicprice, String auctionstate) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.smallid = smallid;
		this.name = name;
		this.seller = seller;
		this.salemotive = salemotive;
		this.usingtime = usingtime;
		this.productinfo = productinfo;
		this.price = price;
		this.deliverytype = deliverytype;
		this.regdate = regdate;
		this.auctionFlag = auctionFlag;
		this.auctionstart = auctionstart;
		this.auctionend = auctionend;
		this.basicprice = basicprice;
		this.auctionstate = auctionstate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getSmallid() {
		return smallid;
	}

	public void setSmallid(int smallid) {
		this.smallid = smallid;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public String getAuctionFlag() {
		return auctionFlag;
	}

	public void setAuctionFlag(String auctionFlag) {
		this.auctionFlag = auctionFlag;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getPhoto() {
		return photo;
	}

	public void setPhoto(String[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", smallid=" + smallid + ", seller="
				+ seller + ", salemotive=" + salemotive + ", usingtime=" + usingtime + ", productinfo=" + productinfo
				+ ", price=" + price + ", deliverytype=" + deliverytype + ", regdate=" + regdate + ", auctionFlag="
				+ auctionFlag + ", auctionstart=" + auctionstart + ", auctionend=" + auctionend + ", basicprice="
				+ basicprice + ", auctionstate=" + auctionstate + ", name=" + name + "]";
	}
	
}
