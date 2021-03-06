/**
 * Copyright(c) 2017, BlueAuction. All right reserved
 * @author 김봉환
 * @since 2017. 11. 15.
 */
package kr.co.blueauction.order.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.blueauction.bid.service.BidService;
import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.common.domain.PageMaker2;
import kr.co.blueauction.member.domain.Member;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.order.service.OrderService;
import kr.co.blueauction.product.domain.Product;
import kr.co.blueauction.product.service.ProductService;
/**
 * 중고, 옥션 물품 구매를위한 OrderController
 * @author 김봉환
 * @since 2017. 11. 15
 */
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
	
	/**
	 * 해당아이디에 중고구매 리스트로 이동 - 페이징
	 * @param page
	 * @param perPageNum
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/productorder/{page}/{perPageNum}", method = RequestMethod.GET)
	public String page(@ModelAttribute("page") int page, @ModelAttribute("perPageNum") int perPageNum, Model model, HttpSession session) throws Exception {
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String auctionFlag = "N";
		Map<String, Object> map = orderService.orderListCriteria(cri, memberId, auctionFlag);

		model.addAttribute("map", map);
		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(orderService.listCountCriteria(memberId, auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);
		return "member/productorder";
	}

	/**
	 * 해당아이디에 옥션구매 리스트로 이동 - 페이징
	 * @param page
	 * @param perPageNum
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/auctionorder/{page}/{perPageNum}", method = RequestMethod.GET)
	public String auctionorderpage(@ModelAttribute("page") int page, @ModelAttribute("perPageNum") int perPageNum, Model model, HttpSession session) throws Exception {
		Criteria cri=new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		Object member = session.getAttribute("login");
		Member member1 = (Member) member;
		String memberId = member1.getMemberId();
		String auctionFlag = "Y";

		Map<String, Object> map = orderService.orderListCriteria(cri, memberId, auctionFlag);
		model.addAttribute("map", map);

		PageMaker2 pageMaker2 = new PageMaker2();
		pageMaker2.setCri(cri);
		pageMaker2.setTotalCount(orderService.listCountCriteria(memberId, auctionFlag));
		model.addAttribute("pageMaker", pageMaker2);

		return "member/auctionorder";
	}

	/**
	 * 결제화면
	 * @param productId
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.GET)
	public String paymentGET(@ModelAttribute("productId") int productId, HttpSession session, Model model) throws Exception {
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

	/**
	 * 주문
	 * @param orders
	 * @param productId
	 * @param session
	 * @param model
	 * @param rttr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/payment/{productId}", method = RequestMethod.POST)
	public String paymentPOST(@ModelAttribute("orders") Orders orders, @ModelAttribute("productId") int productId,
			HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		if (orderService.ordercount(productId) >= 1) {
			rttr.addFlashAttribute("result", "결제를 실패하였습니다.");
			rttr.addFlashAttribute("why", "이미 판매가 완료되었습니다.");
		} else {
			orderService.insert(orders);
			if (orderService.readByProductId(productId) != null) {
				orderService.update((orderService.readByProductId(productId).getOrderId()));
				rttr.addFlashAttribute("result", "결제를 성공하였습니다.");
			} 
		}
		return "redirect:/order/payment/payresult";
	}

	/**
	 * 주문 결제 완료 화면
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/payment/payresult", method = RequestMethod.GET)
	public String payresultget() throws Exception {
		return "payment/payresult";
	}

}
