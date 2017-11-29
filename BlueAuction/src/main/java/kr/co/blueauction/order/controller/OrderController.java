package kr.co.blueauction.order.controller;

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
 *
 * @author 정지현
 * @author 김봉환
 * @since 2015.11.20
 *
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
	 * 해당아이디에 중고구매 리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/productorder", method = RequestMethod.GET)
	public String productorder2(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model)
			throws Exception {
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
	 * 해당아이디에 옥션구매 리스트로 이동
	 * @param cri
	 * @param session
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mypage/auctionorder", method = RequestMethod.GET)
	public String auctionorder(@ModelAttribute("cri") Criteria cri, HttpSession session, Model model) throws Exception {
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
			if (orderService.select2(productId) != null) {
				orderService.update((orderService.select2(productId).getOrderId()));
				rttr.addFlashAttribute("result", "결제를 성공하였습니다.");
			} 
		}
		return "redirect:/order/payment/payresult";
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/payment/payresult", method = RequestMethod.GET)
	public String payresultget() throws Exception {
		return "payment/payresult";
	}

}
