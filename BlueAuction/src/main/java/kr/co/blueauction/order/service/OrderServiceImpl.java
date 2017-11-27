package kr.co.blueauction.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.blueauction.common.domain.Criteria;
import kr.co.blueauction.order.dao.OrdersDao;
import kr.co.blueauction.order.domain.Orders;
import kr.co.blueauction.product.dao.ProductDao;
import kr.co.blueauction.product.domain.Product;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrdersDao ordersDao;
	@Inject
	private ProductDao productDao;

	@Override
	public void insert(Orders orders) {
		ordersDao.insert(orders);
	}

	@Override
	public List<Orders> listAll() {
		return ordersDao.listAll();
	}

	@Override
	public Orders readByNo(int orderNo) {
		return ordersDao.readByNo(orderNo);
	}

	@Override
	public void update(Orders orders) {
		ordersDao.update(orders);
	}

	@Override
	public void delete(int orderNo) {
		ordersDao.delete(orderNo);
	}
	


	@Override
	   /** 로그인된 회원의 중고or 옥션 구매 리스트를 조회 **/
	   public Map<String, Object> orderList(String memberId, String auctionFlag) throws Exception{
	      Map<String, Object> map = new HashMap<String, Object>();
	      List<Product> productList=new ArrayList<Product>();
	      List<Orders> orderList= ordersDao.orderList(memberId, auctionFlag);
	      map.put("orderList", orderList);
	      
	      if(orderList != null) {
	         //Map<String, Object> productList = new HashMap<String, Object>();
	    	  
	         Product product = null;
	         for (Orders order : orderList) {
	            product = productDao.read(order.getProductId());
	            productList.add(product);
	         }
	         map.put("productList", productList);
	      }
	      
	      return map;
	   }
	
	@Override
	   /** 로그인된 회원의 중고or 옥션 구매 리스트를 조회  패이징**/
	   public Map<String, Object> orderListCriteria(Criteria cri, String memberId, String auctionFlag) throws Exception{
	      Map<String, Object> map = new HashMap<String, Object>();
	      List<Product> productList=new ArrayList<Product>();
	      List<Orders> orderList= ordersDao.orderListCriteria(cri, memberId, auctionFlag);
	      map.put("orderList", orderList);
	      
	      if(orderList != null) {
	         //Map<String, Object> productList = new HashMap<String, Object>();
	    	  
	         Product product = null;
	         for (Orders order : orderList) {
	            product = productDao.read(order.getProductId());
	            System.out.println(product.toString());
	            productList.add(product);
	         }
	         map.put("productList", productList);
	      }
	      
	      return map;
	   }

	@Override
	public int listCountCriteria(String memberId, String auctionFlag) throws Exception{
		return ordersDao.countPaging(memberId, auctionFlag);
	}
	
	@Override
	public Orders select(int orderId) throws Exception{
		return ordersDao.select(orderId);
	}
	@Override
	public void update(int orderId) throws Exception{
		 ordersDao.update(orderId);
	}
}
