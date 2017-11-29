/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.bid.dao.BidDao;
import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;
import kr.co.blueauction.reply.dao.ReplyDao;

/**
 * 입찰 관련 기능 
 * @author 김수진
 * @since 2017. 11. 15.
 */
@Service
public class BidServiceImpl implements BidService {

	@Inject
	BidDao bidDao;
	@Inject
	ProductDao productdao;

	/* 
	 * 입찰 등록
	 * @parameter Bid
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void create(Bid bid) throws Exception {
		bidDao.create(bid);
	}
	
	/* 
	 * 상품번호로 입찰 조회
	 * @ parameter productId
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void update(Bid bid) throws Exception {
		bidDao.update(bid);
	}

	/* 
	 * 상품번호로 입찰 조회
	 * @ parameter productId
	 * @ return List<Bid>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> readByProductId(int productId) throws Exception {
		return bidDao.readByProductId(productId);
	}

	/* 
	 * 회원 아이디로 입찰 조회
	 * @ parameter memberId
	 * @ return List<Bid>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> readByMemberId(String memberId) throws Exception {
		return bidDao.readByMemberId(memberId);
	}

	/* 
	 * 입찰번호로 입찰 삭제
	 * @ parameter bidId
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void delete(int bidId) throws Exception {
		bidDao.delete(bidId);
	}
	
	/* 
	 * 회원아이디 및 낙찰자로 입찰 조회
	 * @ parameter memberId, winning
	 * @ return Map<String, Object>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public Map<String, Object> bidList(String memberId, String winning) throws Exception{
		
		List<Bid> bidList= bidDao.bidList(memberId, winning);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("bidList", bidList);
		List<Product> productList=new ArrayList<Product>();
		for (Bid bid : bidList) {
			Product product = productdao.read(bid.getProductId());
			productList.add(product);
		}
		
		map.put("productList", productList);
		
		return map;
		
	}
	
	/* 
	 * 회원아이디에 입찰 리스트 수
	 * @ parameter memberId, winning
	 * @ return int
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public int bidCountCriteria(String memberId, String winning) throws Exception
	{
		return bidDao.bidcount(memberId, winning);
	}
	
	/* 
	 * 회원아이디 및 낙찰자로 입찰 조회 - 페이징
	 * @ parameter memberId, winning
	 * @ return Map<String, Object>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public Map<String, Object> bidListCriteria(Criteria cri, String memberId, String winning) throws Exception{

		List<Bid> bidList= bidDao.bidListCriteria(cri, memberId, winning);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("bidList", bidList);
		List<Product> productList=new ArrayList<Product>();
		for (Bid bid : bidList) {
			Product product = productdao.read(bid.getProductId());
			productList.add(product);
		}
		
		map.put("productList", productList);
		
		
		return map;
	}
			
			
	/* 
	 * 회원 아이디로 가장 적게 남은 경매시간 조회
	 * @ parameter memberId
	 * @ return String 경매시간
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public String leastTime(String memberId) throws Exception {
		return bidDao.leastTime(memberId);
	}

	/* 
	 * 회원 아이디로 입찰 조회
	 * @ parameter memberId
	 * @ return List<Bid>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public List<Bid> selectWinningList() {
		// TODO Auto-generated method stub
		return bidDao.selectWinningList();
	}

	/* 
	 * 낙찰 결과 변경
	 * @ parameter List<Bid>
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public void updateWinning(List<Bid> winningList) {
		bidDao.updateWinning(winningList);
	}

	/* 
	 * 물품번호로 최고 입찰가 조회
	 * @ parameter productId
	 * @ return int
	 * @see kr.co.blueauction.bid.service.BidService#create(kr.co.blueauction.bid.domain.Bid)
	 */
	@Override
	public int getMaxPrice(int productId) {
		return bidDao.getMaxPrice(productId);
	}
}
