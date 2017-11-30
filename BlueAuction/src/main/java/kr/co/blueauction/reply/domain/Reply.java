/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 최명승
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.reply.domain;

/**
 * 댓글 Domain
 * @author 최명승
 * @since 2017. 11. 15.
 */
public class Reply {
	private int replyId;
	private String memberId;
	private int productId;
	private String content;
	private String regdate;
	private int groupNo;
	private int levelNo;
	private int orderNo;
	private String deleteFlag;
	
	/** 생성자 */
	public Reply() {
		this(0, "", 0, "", "", 0, 0, 0, "N");
	}

	public Reply(String memberId, int productId, String content) {
		this(0, memberId, productId, content, "", 0, 0, 0, "N");
	}

	public Reply(int replyId, String memberId, int productId, String content, String regdate, int groupNo, int levelNo,
			int orderNo, String deleteFlag) {
		this.replyId = replyId;
		this.memberId = memberId;
		this.productId = productId;
		this.content = content;
		this.regdate = regdate;
		this.groupNo = groupNo;
		this.levelNo = levelNo;
		this.orderNo = orderNo;
		this.deleteFlag = deleteFlag;
	}

	/** Setter & Getter */
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
	
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/** toString */
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", memberId=" + memberId + ", productId=" + productId + ", content="
				+ content + ", regdate=" + regdate + ", groupNo=" + groupNo + ", levelNo=" + levelNo + ", orderNo="
				+ orderNo + ", deleteFlag=" + deleteFlag + "]";
	}
}	
