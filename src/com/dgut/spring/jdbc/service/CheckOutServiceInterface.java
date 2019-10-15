package com.dgut.spring.jdbc.service;

import java.util.List;

public interface CheckOutServiceInterface {
	public void checkOut(List<Integer> goods, int memberId);
}
