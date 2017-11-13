package kr.co.blueauction.reply.domain;

public class Reply {
	private int reply_id;
	private String member_id;
	private int product_id;
	private String content;
	private String regdate;
	private int groupNo;
	private int levelNo;
	private int orderNo;
	
	public Reply() {}
	
	public Reply(String member_id, int product_id, String content) {
		this(0, member_id, product_id, content, null, 0, 0, 0);
	}
	
	public Reply(int reply_id, String member_id, int product_id, String content, String regdate, int groupNo,
			int levelNo, int orderNo) {
		super();
		this.reply_id = reply_id;
		this.member_id = member_id;
		this.product_id = product_id;
		this.content = content;
		this.regdate = regdate;
		this.groupNo = groupNo;
		this.levelNo = levelNo;
		this.orderNo = orderNo;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "Reply [reply_id=" + reply_id + ", member_id=" + member_id + ", product_id=" + product_id + ", content="
				+ content + ", regdate=" + regdate + ", groupNo=" + groupNo + ", levelNo=" + levelNo + ", orderNo="
				+ orderNo + "]";
	}

}
