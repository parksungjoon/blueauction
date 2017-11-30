/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 14.
 */
package kr.co.blueauction.product.scheduler;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.product.service.ProductService;

/**
 * 경매를 자동으로 실행, 종료시켜주기 위한 스케쥴러
 * 
 * @author 김수진
 * @since 2017. 11. 14.
 */
@Component
public class Scheduler {
	
	@Inject
	private ProductService productService;
	
	@Inject
	private BidService bidService;
	
	private Logger logger = Logger.getLogger(Scheduler.class);
	
	
	// 경매 진행 및 종료 - 매시간 정각, 30분마다 실행
	@Scheduled(cron = "0 00,30 * * * *")
	public void auctionState() {
		try {
			logger.info("현재시간: " + (new Date()).toString() + " 에 auctionState 실행");
			productService.updateAuctionsatate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 경매 낙찰자 - 매시간 30분마다 실행
	@Scheduled(cron = "00 30 * * * *")
	public void winningState() {
		try {
			logger.info("현재시간: " + (new Date()).toString() + " 에 winningState 실행");
			List<Bid> winningList=bidService.selectWinningList();
			logger.info(winningList);
			if(winningList.size()>0) {
			bidService.updateWinning(winningList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
