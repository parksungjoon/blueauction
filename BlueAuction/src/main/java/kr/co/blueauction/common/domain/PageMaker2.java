/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 25.
 */
package kr.co.blueauction.common.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 페이징 처리에서 페이지네이션에 필요한 객체
 * @author 김봉환
 * @since 2017. 11. 25.
 */
public class PageMaker2 {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private Criteria cri;

	/** 생성자 */
	public PageMaker2() {}
	
	/** Setter & Getter */
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	private void calcData() {
		
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum ) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		
		prev = startPage ==1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}
	
	public String makeQuery(int page){
		
		UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", cri.getPerPageNum())
	            .build();	            
		
		return uriComponents.toUriString();
	}

	public String makeSearch(int page){
		
		UriComponents uriComponents =
	            UriComponentsBuilder.newInstance()
	            .queryParam("page", page)
	            .queryParam("perPageNum", cri.getPerPageNum())
	            .build();	            
		
		return uriComponents.toUriString();
	}	
	
	/** toString */
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage="
				+ startPage + ", endPage=" + endPage + ", prev=" + prev
				+ ", next=" + next + ", displayPageNum=" + displayPageNum
				+ ", cri=" + cri + "]";
	}
	
	
}
