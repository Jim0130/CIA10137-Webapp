package productOrder.model;

import java.util.*;

public interface Product_orderDAO_interface {
	public void insert(Product_orderVO product_orderVO);

	public void update(Product_orderVO product_orderVO);

	public void delete(Integer product_order_no);

	public Product_orderVO findByPrimaryKey(Integer product_order_no);

	public List<Product_orderVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<Product_orderVO> getAll(Map<String, String[]> map); 
}
