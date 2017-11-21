/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.blueauction.bid.domain.Bid;
import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.controller.MemberController;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;

/**
 * @author 김수진
 * @since 2017. 11. 15.
 */
@Controller
public class BidController {
	private static final Logger logger = LoggerFactory.getLogger(BidController.class);

	@Inject
	private BidService service;

	//입찰목록을 가저온다
	@RequestMapping(value ="/member/mypage/bidlist", method = RequestMethod.GET)
	public String mybidlist(@ModelAttribute("bid") Bid bid, HttpSession session, Model model) throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/mybidlist에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String winning = "N";
		// 상품을 받아옴
		List<Bid> bids = service.bidList(memberId, winning);
		model.addAttribute("bids", bids);
		logger.info(bids.toString());
		return "member/bidlist";
	}
	
	//낙찰목록을가져온다
	@RequestMapping(value ="/member/mypage/winninglist", method = RequestMethod.GET)
	public String mywinninglist(@ModelAttribute("bid") Bid bid, HttpSession session, Model model) throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/mybidlist에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String winning = "Y";
		// 상품을 받아옴
		List<Bid> bids = service.bidList(memberId, winning);
		model.addAttribute("bids", bids);
		logger.info(bids.toString());
		return "member/winninglist";
	}

}
