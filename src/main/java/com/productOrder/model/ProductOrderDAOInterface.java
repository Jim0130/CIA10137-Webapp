package com.productOrder.model;

import java.util.*;

public interface ProductOrderDAOInterface {
	public void insert(ProductOrderVO product_orderVO);

	public void update(ProductOrderVO product_orderVO);

	public void delete(Integer product_order_no);

	public ProductOrderVO findByPrimaryKey(Integer product_order_no);

	public List<ProductOrderVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Product_orderVO> getAll(Map<String, String[]> map); 
}
