package kr.co.blueauction.order.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.blueauction.member.controller.MemberController;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.order.service.OrderService;
import kr.co.blueauction.product.domain.Product;

@Controller
public class OrderController {

	@Inject
	private OrderService orderService;

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping("/payment")
	public String payment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(request.getHeader("test"));

		System.out.println(session.getAttribute("login"));

		return "/mypage";
	}

	@RequestMapping(value = "/member/mypage/productorder", method = RequestMethod.GET)
	public String productorder(@ModelAttribute("order") Orders order, HttpSession session, Model model)
			throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/productorder에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "N";

		// 상품을 받아옴
		List<Orders> orders = orderService.orderList(memberId, auctionFlag);
		model.addAttribute("orders", orders);
		logger.info(orders.toString());
		return "member/productorder";
	}

}
