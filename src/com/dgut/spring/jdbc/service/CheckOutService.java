package com.dgut.spring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutService implements CheckOutServiceInterface {

	@Autowired
	private ShopServiceInterface shopService;

	@Transactional
	public void checkOut(List<Integer> goods, int memberId) {
		for (Integer goodsId : goods) {
			shopService.sellGoods(goodsId, memberId);
		}
	}

}
