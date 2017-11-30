/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.photo.dao;

import java.util.List;

import kr.co.blueauction.photo.domain.Photo;

/**
 * @author 김수진
 * @since 2017. 11. 15.
 */
public interface PhotoDao {

	// photo 등록
	public void create(Photo photo) throws Exception;
	
	//상품 id로 조회
	public List<Photo> readByProductId(int productId) throws Exception;
	
	// photo 삭제 
	public void delete(int bidId) throws Exception;
	
	//photo productId로 삭제
	public void deleteByproductId(int productId) throws Exception;
}
