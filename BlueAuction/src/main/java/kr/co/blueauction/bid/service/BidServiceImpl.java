/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.reply.dao.ReplyDao;

@Service
public class BidServiceImpl implements BidService {

	@Inject
	ReplyDao replyDao;
}
