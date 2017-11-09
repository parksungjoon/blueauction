package kr.co.blueauction.reply.domain;

public class Reply {
	private int reply_id;
	private String member_id;
	private int product_id;
	private String content;
	private String regdate;
	
	public Reply() {}
	
	public Reply(String member_id, int product_id, String content) {
		this(0, member_id, product_id, content, null);
	}

	public Reply(int reply_id, String member_id, int product_id, String content, String regdate) {
		this.reply_id = reply_id;
		this.member_id = member_id;
		this.product_id = product_id;
		this.content = content;
		this.regdate = regdate;
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

	@Override
	public String toString() {
		return "Reply [reply_id=" + reply_id + ", member_id=" + member_id + ", product_id=" + product_id + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
	
	
	
}
