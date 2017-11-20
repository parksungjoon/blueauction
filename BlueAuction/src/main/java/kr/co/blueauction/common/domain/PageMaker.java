package kr.co.blueauction.common.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	Logger logger = LoggerFactory.getLogger(PageMaker.class);
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10; // 화면에 보여지는 페이지의 수
	
	private SearchCriteria cri;
	
	public void setCri(SearchCriteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData(); // 페이지 처리 산술 메소드
	}
	
	private void calcData() {
		
		if (cri.getPage() == 0) {
			endPage = (int) (Math.ceil((cri.getPage()+1) / (double) displayPageNum) * displayPageNum);
		} else {
			double page = (double)(cri.getPage() + 10) / (double)(displayPageNum*displayPageNum);
			endPage = (int) (Math.ceil(page) * 10) ;
		}
		
		startPage = (endPage - displayPageNum) + 1;
		int tempEndPage = (int) (Math.ceil(totalCount / cri.getPerPageNum())+1);
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = (startPage == 1) ? false : true;
		next = ((endPage * 10) >= totalCount) ? false : true;
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum()).build();
		return uriComponents.toUriString();
	}
	
	/** 검색 */
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
																			.queryParam("perPageNum", cri.getPerPageNum()).queryParam("keyword",  encoding(cri.getKeyword()))
																			.queryParam("category", cri.getCategory()).queryParam("smallCategory", cri.getSmallid()).build();
		
		return uriComponents.toUriString();
	}
	
	/** 인코딩 메소드 */
	private String encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch(UnsupportedEncodingException e){
			return "";
		}
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public SearchCriteria getCri() {
		return cri;
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}

}
