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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker2;
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

	@RequestMapping(value = "/mypage/productorder", method = RequestMethod.GET)
	public String productorder2(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/productorder에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "N";

		// Map<String, Object> map = orderService.orderList(memberId, auctionFlag);
		Map<String, Object> map = orderService.orderListCriteria(cri, memberId, auctionFlag);

		model.addAttribute("map", map);
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(orderService.listCountCriteria(memberId, auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/productorder";
	}

	@RequestMapping(value = "/auctionorder", method = RequestMethod.GET)
	public String auctionorder(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model) throws Exception {
		// login 세션을 가저옴
		Object member = session.getAttribute("login");
		logger.info("/member/mypage/productorder에서 " + member.toString());
		Member member1 = (Member) member;
		// 세션에 저장되어 있는 멤버에서 memberId를 가저옴
		String memberId = member1.getMemberId();
		String auctionFlag = "Y";

		// 상품을 받아옴
		Map<String, Object> map = orderService.orderListCriteria(cri, memberId, auctionFlag);
		model.addAttribute("map", map);

		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(orderService.listCountCriteria(memberId, auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);

		return "member/auctionorder";
	}

	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.GET)
	public String paymentGET(@ModelAttribute("productId") int productId, HttpSession session, HttpServletRequest req,
			Model model) throws Exception {
		logger.info("paymentGET 컨트롤러 실행");
		// 로그인된 정보를 불러온다
		Member member = (Member) session.getAttribute("login");
		model.addAttribute("member", member);

		Product product = productService.read(productId);
		if (product.getCategoryId() == 2) {
			int maxPrice = bidService.getMaxPrice(productId);
			product.setPrice(maxPrice);
		}

		model.addAttribute("product", product);

		return "payment/payment";
	}

	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.POST)
	public String paymentPOST(@ModelAttribute("orders") Orders orders, @ModelAttribute("productId") int productId,
			HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("paymentPOST 실행");
		if (orderService.ordercount(productId) >= 1) {
			logger.info("주문할수 없습니다");
			rttr.addFlashAttribute("result", "결제를 실패하였습니다.");
		} else {
			orderService.insert(orders);
			if (orderService.select2(productId) != null) {
				orderService.update((orderService.select2(productId).getOrderId()));
				rttr.addFlashAttribute("result", "결제를 성공하였습니다.");
			} 
		}
		return "redirect:/order/payment/payresult";
	}

	@RequestMapping(value = "/payment/payresult", method = RequestMethod.GET)
	public String payresultget(@ModelAttribute("orders") Orders orders, HttpSession session) throws Exception {
		logger.info("paymentget 실행");

		return "payment/payresult";
	}

}
