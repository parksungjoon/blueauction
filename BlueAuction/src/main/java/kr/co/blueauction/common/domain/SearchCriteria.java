package kr.co.blueauction.common.domain;

public class SearchCriteria{
	
	private int page; // 요청한 페이지
	private int perPageNum; // 한페이지 당 출력 게시글 수
	private String searchType; // 검색 종류
	private String keyword; // 검색 값
	private int category; // 카테고리 종류
	private int smallCategory; // 소분류
	
	public SearchCriteria() {
		this(1, 8, null, null, 1, 0);
	}
	
	public SearchCriteria(int page, int perPageNum, String searchType, String keyword, int category, int smallCategory) {
		this.page = page;
		this.perPageNum = perPageNum;
		this.searchType = searchType;
		this.keyword = keyword;
		this.category = category;
		this.smallCategory = smallCategory;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
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

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	
	public int getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(int smallCategory) {
		this.smallCategory = smallCategory;
	}

	@Override
	public String toString() {
		return "SearchCriteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType
				+ ", keyword=" + keyword + ", category=" + category + ", smallCategory=" + smallCategory + "]";
	}

}
