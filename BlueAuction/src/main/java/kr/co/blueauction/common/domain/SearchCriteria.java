/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 정지현
 * @since 2017. 11. 18.
 */
package kr.co.blueauction.common.domain;

/**
 * @author 정지현
 * @since 2017. 11. 18.
 */
public class SearchCriteria{
	
	private int page; // 요청한 페이지
	private int perPageNum; // 한페이지 당 출력 게시글 수
	private String keyword; // 검색 값
	private int category; // 카테고리 종류
	private int smallid; // 소분류
	
	/** 생성자 */
	public SearchCriteria() {
		this(1, 10, null, 1, 0);
	}
	
	public SearchCriteria(int page, int perPageNum, String keyword, int category, int smallid) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.keyword = keyword;
		this.category = category;
		this.smallid = smallid;
	}

	
	/** Setter & Getter */
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 0;
			return;
		}
		
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum >100) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getSmallid() {
		return smallid;
	}

	public void setSmallid(int smallid) {
		this.smallid = smallid;
	}

	
	/** toString */
	@Override
	public String toString() {
		return "SearchCriteria [page=" + page + ", perPageNum=" + perPageNum + ", keyword=" + keyword + ", category="
				+ category + ", smallid=" + smallid + "]";
	}
	
}
