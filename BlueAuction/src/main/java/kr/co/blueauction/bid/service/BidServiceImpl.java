/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.bid.dao.BidDao;
import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.reply.dao.ReplyDao;

@Service
public class BidServiceImpl implements BidService {

	@Inject
	BidDao bidDao;

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
	public List<Bid> bidList(String memberId, String winning) throws Exception{
		return bidDao.bidList(memberId, winning);
		
	}
	
	@Override
	public String leastTime(String memberId) throws Exception {
		return bidDao.leastTime(memberId);
	}
}
