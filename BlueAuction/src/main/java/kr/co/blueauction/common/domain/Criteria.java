/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.common.domain;

/**
 * Criteria - 페이징 처리를 위한 객체
 * @author 김봉환
 * @since 2017. 11. 20.
 */
public class Criteria {

	private int page;	
	private int perPageNum;
	private String keyword;
	
	/** 생성자 */
	public Criteria(){
		this.page = 1;
		this.perPageNum = 10;
	}

	/** Setter & Getter */
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setPage(int page){
		
		if(page <= 0){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum){
		
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}	
	
	public int getPageStart() {
		
		return (this.page -1)* perPageNum;
	}
	
	public int getPerPageNum(){
		
		return this.perPageNum;
	}

	
	/** toString */
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}


