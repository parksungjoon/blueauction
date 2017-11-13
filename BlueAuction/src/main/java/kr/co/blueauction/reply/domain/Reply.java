package kr.co.blueauction.reply.domain;

public class Reply {
	private int replyId;
	private String memberId;
	private int productId;
	private String content;
	private String regdate;
	
	
	public Reply() {
		this(0, "", 0, "", "");
	}

	public Reply(String memberId, int productId, String content) {
		this(0, memberId, productId, content, "");
	}

	public Reply(int replyId, String memberId, int productId, String content, String regdate) {
		super();
		this.replyId = replyId;
		this.memberId = memberId;
		this.productId = productId;
		this.content = content;
		this.regdate = regdate;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
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
		return "Reply [replyId=" + replyId + ", memberId=" + memberId + ", productId=" + productId + ", content="
				+ content + ", regdate=" + regdate + "]";
	}
	
}
