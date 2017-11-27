package kr.co.blueauction.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import javax.inject.Inject;
import javax.print.DocFlavor.STRING;
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

import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.member.controller.MemberController;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.order.service.OrderService;
import kr.co.blueauction.product.controller.ProductDetailController;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Inject
	private OrderService orderService;

	@Inject
	private ProductService productService;
	
	@Inject
	private BidService bidService;

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	/*
	 * @RequestMapping("/payment") public String payment(HttpServletRequest request)
	 * { HttpSession session = request.getSession();
	 * System.out.println(request.getHeader("test"));
	 * 
	 * System.out.println(session.getAttribute("login"));
	 * 
	 * return "/mypage"; }
	 */
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

		Map<String, Object> map = orderService.orderList(memberId, auctionFlag);

		model.addAttribute("map", map);

		return "member/productorder";
	}

	@RequestMapping(value = "/member/mypage/auctionorder", method = RequestMethod.GET)
	public String auctionorder(@ModelAttribute("order") Orders order, HttpSession session, Model model)
			throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/productorder에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "Y";

		// 상품을 받아옴
		Map<String, Object> map = orderService.orderList(memberId, auctionFlag);
		model.addAttribute("map", map);
		return "member/auctionorder";
	}

	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.GET)
	public String paymentGET(@ModelAttribute("productId") int productId, HttpSession session, HttpServletRequest req,
			Model model) throws Exception {
		logger.info("paymentGET 컨트롤러 실행");
		// 로그인된 정보를 불러온다
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("member", member);
		logger.info(member.toString());

		Product product = productService.read(productId);
		if(product.getCategoryId()==2) {
			int maxPrice=bidService.getMaxPrice(productId);
			product.setPrice(maxPrice);
		}
		
		model.addAttribute("product", product);

		return "payment/payment";
	}

	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.POST)
	public String paymentPOST(@ModelAttribute("orders") Orders orders, HttpSession session) throws Exception {
		logger.info("paymentPOST 실행");
		orderService.insert(orders);
		logger.info(orders.toString());
		return "redirect:/order/payment/payresult";
	}

	@RequestMapping(value = "/payment/payresult", method = RequestMethod.GET)
	public String payresultget(@ModelAttribute("orders") Orders orders, HttpSession session) throws Exception {
		logger.info("paymentget 실행");
		logger.info(orders.toString());
		logger.info("리절트페이지에서" + orders.toString());
		orderService.update(orders.getOrderId());
		return "payment/payresult";
	}

}
