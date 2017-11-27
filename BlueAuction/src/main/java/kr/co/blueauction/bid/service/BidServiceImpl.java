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
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;
import kr.co.blueauction.reply.dao.ReplyDao;

@Service
public class BidServiceImpl implements BidService {

	@Inject
	BidDao bidDao;
	
	@Inject
	ProductDao productdao;

	@Override
	public void create(Bid bid) throws Exception {
		bidDao.create(bid);
	}

	@Override
	public void update(Bid bid) throws Exception {
		bidDao.update(bid);
	}

	@Override
	public List<Bid> readByProductId(int productId) throws Exception {
		return bidDao.readByProductId(productId);
	}

	@Override
	public List<Bid> readByMemberId(String memberId) throws Exception {
		return bidDao.readByMemberId(memberId);
	}

	@Override
	public void delete(int bidId) throws Exception {
		bidDao.delete(bidId);
	}
	
	@Override
	//해당아이디에 입찰, 낙찰 목록조회
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
	
	@Override
	public String leastTime(String memberId) throws Exception {
		return bidDao.leastTime(memberId);
	}

	@Override
	public List<Bid> selectWinningList() {
		// TODO Auto-generated method stub
		return bidDao.selectWinningList();
	}

	@Override
	public void updateWinning(List<Bid> winningList) {
		bidDao.updateWinning(winningList);
		
	}

	@Override
	public int getMaxPrice(int productId) {
		// TODO Auto-generated method stub
		return bidDao.getMaxPrice(productId);
	}
}
