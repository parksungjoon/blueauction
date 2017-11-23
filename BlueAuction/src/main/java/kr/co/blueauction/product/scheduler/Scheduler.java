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
	
	
	// 매시간 정각, 30분마다 실행
	@Scheduled(cron = "0 00,30 * * * *")
	public void auctionState() {
		try {
			logger.info("현재시간: " + (new Date()).toString() + " 에 auctionState 실행");
			productService.updateAuctionsatate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Scheduled(cron = "0 30 * * * *")
	public void winningState() {
		try {
			logger.info("현재시간: " + (new Date()).toString() + " 에 winningState 실행");
			List<Bid> winningList=bidService.selectWinningList();
			logger.info(winningList);
			bidService.updateWinning(winningList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 크론(Job Scheduler) 표현식 - https://en.wikipedia.org/wiki/Cron#CRON_expression
	/**
	 * Cron 표현식(초 분 시 일 월 요일 [연])
	 * * : 모든 값. (매분, 매시, 매일, 매주, 매월, 매요일, 매년 : * * * * * * * )
	 * ? : 특정한 값 없음. 날짜와 요일에만 사용하며, 어떤 값이든 상관없음을 뜻함
	 * - : 범위. (월요일에서 수요일까지 MON-WED)
	 * , : 특별한 값의 추가 (월,수,금 MON,WED,FRI)
	 * / : 증분 ( 0분부터 매 5분 마다 0/5 )
	 * L : 마지막 (날짜와 요일에만 사용하며 매주 마지막 요일(토요일) , 매월 말일을 뜻함)
	 * W: 가장 가까운 평일 (가령 15W라고 하면 15일에서 가장 가까운 평일을 뜻함)
	 * # : 몇째주의 무슨 요일을 표현할 때 사용
	 */
	
	// */10 * * * * *  : 10초 간격 작업 수행
	// 0 0 8-10 * * * :  매일 8, 9, 10시에 작업 수행
	
}
