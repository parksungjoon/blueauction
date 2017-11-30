/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김수진
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.bid.controller;

import java.util.List;
import java.util.Map;

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
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker2;
import kr.co.blueauction.login.LoginDTO;
import kr.co.blueauction.member.controller.MemberController;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.product.domain.Product;

/**
 * @author 김수진
 * @author 김봉환
 * @since 2017. 11. 15.
 */
@RequestMapping("/bid")
@Controller
public class BidController {
	private static final Logger logger = LoggerFactory.getLogger(BidController.class);

	@Inject
	private BidService service;

	
	/**
	 * 해당아이디 입찰리스트로 이동
	 * @param page
	 * @param perPageNum
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/mypage/bidlist/{page}/{perPageNum}", method = RequestMethod.GET)
	public String mybidlistpage(@ModelAttribute("page") int page, @ModelAttribute("perPageNum") int perPageNum, Model model, HttpSession session) throws Exception {
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String winning = "N";
		Map<String, Object> map= service.bidListCriteria(cri, memberId, winning);
		model.addAttribute("map", map);
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(service.bidCountCriteria(memberId, winning));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/bidlist";
	}
	
	/**
	 * 해당아이디 낙찰리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/mypage/winninglist/{page}/{perPageNum}", method = RequestMethod.GET)
	public String mywinninglistpage(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model) throws Exception {
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String winning = "Y";
		Map<String, Object> map= service.bidListCriteria(cri, memberId, winning);
		model.addAttribute("map", map);
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(service.bidCountCriteria(memberId, winning));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/winninglist";
	}

}
