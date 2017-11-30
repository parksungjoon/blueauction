/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.photo.domain;

/**
 * 물품 사진
 * @author 김수진
 * @since 2017. 11. 15.
 */

public class Photo {
	private int photoId;
	private int productId;
	private String photoname;
	private String regdate;
	
	/** 생성자 */
	public Photo() {
		this(0, 0, "", "");
	}
	
	public Photo(int productId, String photoname) {
		this(0, productId, photoname, "");
	}

	public Photo(int photoId, int productId, String photoname, String regdate) {
		super();
		this.photoId = photoId;
		this.productId = productId;
		this.photoname = photoname;
		this.regdate = regdate;
	}

	/** Setter & Getter */
	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", productId=" + productId + ", photoname=" + photoname + ", regdate="
				+ regdate + "]";
	}
	
}


