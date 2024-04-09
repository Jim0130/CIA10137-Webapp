package com.productOrder.model;

import java.util.*;
import java.sql.*;

public class ProductOrderJDBCDAO implements ProductOrderDAOInterface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/ezban?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "19920130";

	private static final String INSERT_STMT = "INSERT INTO product_order (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_order_no, member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status FROM product_order order by product_order_no";
	private static final String GET_ONE_STMT = "SELECT product_order_no, member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status FROM product_order where product_order_no = ?";
	private static final String DELETE = "DELETE FROM product_order where product_order_no = ?";
	//													               1			   2
	private static final String UPDATE = "UPDATE product_order set member_no=?, product_price=?, "
			//				3					   4				        5
			+ "product_coupon_discount=?, product_checkout_amount=?, member_points=?, "
			//				6             7             8					9
			+ "birthday_coupon_no=?, recipient=?, recipient_phone=?, recipient_address=?, "
			//				10			  11				12
			+ "product_orderdate=?, product_paydate=?, order_closedate=?, "
			//				13					   14
			+ "product_payment_status=?, product_process_status=?, "
			//				15								     16
			+ "product_order_allocation_amount=?, product_order_allocation_status=? "
			//				17
			+ "where product_order_no = ?";

	@Override
	public void insert(ProductOrderVO productOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productOrderVO.getMember_no());
			pstmt.setInt(2, productOrderVO.getProduct_price());
			pstmt.setInt(3, productOrderVO.getProduct_coupon_discount());
			pstmt.setInt(4, productOrderVO.getProduct_checkout_amount());
			pstmt.setInt(5, productOrderVO.getMember_points());
			pstmt.setInt(6, productOrderVO.getBirthday_coupon_no());
			pstmt.setString(7, productOrderVO.getRecipient());
			pstmt.setString(8, productOrderVO.getRecipient_phone());
			pstmt.setString(9, productOrderVO.getRecipient_address());
			pstmt.setTimestamp(10, productOrderVO.getProduct_orderdate());
			pstmt.setTimestamp(11, productOrderVO.getProduct_paydate());
			pstmt.setTimestamp(12, productOrderVO.getOrder_closedate());
			pstmt.setByte(13, productOrderVO.getProduct_payment_status());
			pstmt.setByte(14, productOrderVO.getProduct_process_status());
			pstmt.setInt(15, productOrderVO.getProduct_order_allocation_amount());
			pstmt.setByte(16, productOrderVO.getProduct_order_allocation_status());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ProductOrderVO productOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productOrderVO.getMember_no());
			pstmt.setInt(2, productOrderVO.getProduct_price());
			pstmt.setInt(3, productOrderVO.getProduct_coupon_discount());
			pstmt.setInt(4, productOrderVO.getProduct_checkout_amount());
			pstmt.setInt(5, productOrderVO.getMember_points());
			pstmt.setInt(6, productOrderVO.getBirthday_coupon_no());
			pstmt.setString(7, productOrderVO.getRecipient());
			pstmt.setString(8, productOrderVO.getRecipient_phone());
			pstmt.setString(9, productOrderVO.getRecipient_address());
			pstmt.setTimestamp(10, productOrderVO.getProduct_orderdate());
			pstmt.setTimestamp(11, productOrderVO.getProduct_paydate());
			pstmt.setTimestamp(12, productOrderVO.getOrder_closedate());
			pstmt.setByte(13, productOrderVO.getProduct_payment_status());
			pstmt.setByte(14, productOrderVO.getProduct_process_status());
			pstmt.setInt(15, productOrderVO.getProduct_order_allocation_amount());
			pstmt.setByte(16, productOrderVO.getProduct_order_allocation_status());
			pstmt.setInt(17, productOrderVO.getProduct_order_no());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer product_order_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_order_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ProductOrderVO findByPrimaryKey(Integer product_order_no) {

		ProductOrderVO productOrderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_order_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// productOrderVO 也稱為 Domain objects
				productOrderVO = new ProductOrderVO();
				productOrderVO.setProduct_order_no(rs.getInt("product_order_no"));
				productOrderVO.setMember_no(rs.getInt("member_no"));
				productOrderVO.setProduct_price(rs.getInt("product_price"));
				productOrderVO.setProduct_coupon_discount(rs.getInt("product_coupon_discount"));
				productOrderVO.setProduct_checkout_amount(rs.getInt("product_checkout_amount"));
				productOrderVO.setMember_points(rs.getInt("member_points"));
				productOrderVO.setBirthday_coupon_no(rs.getInt("birthday_coupon_no"));
				productOrderVO.setRecipient(rs.getString("recipient"));
				productOrderVO.setRecipient_phone(rs.getString("recipient_phone"));
				productOrderVO.setRecipient_address(rs.getString("recipient_address"));
				productOrderVO.setProduct_orderdate(rs.getTimestamp("product_orderdate"));
				productOrderVO.setProduct_paydate(rs.getTimestamp("product_paydate"));
				productOrderVO.setOrder_closedate(rs.getTimestamp("order_closedate"));
				productOrderVO.setProduct_payment_status(rs.getByte("product_payment_status"));
				productOrderVO.setProduct_process_status(rs.getByte("product_process_status"));
				productOrderVO.setProduct_order_allocation_amount(rs.getInt("product_order_allocation_amount"));
				productOrderVO.setProduct_order_allocation_status(rs.getByte("product_order_allocation_status"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productOrderVO;
	}

	@Override
	public List<ProductOrderVO> getAll() {
		List<ProductOrderVO> list = new ArrayList<ProductOrderVO>();
		ProductOrderVO productOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// productOrderVO 也稱為 Domain objects
				productOrderVO = new ProductOrderVO();
				productOrderVO.setProduct_order_no(rs.getInt("product_order_no"));
				productOrderVO.setMember_no(rs.getInt("member_no"));
				productOrderVO.setProduct_price(rs.getInt("product_price"));
				productOrderVO.setProduct_coupon_discount(rs.getInt("product_coupon_discount"));
				productOrderVO.setProduct_checkout_amount(rs.getInt("product_checkout_amount"));
				productOrderVO.setMember_points(rs.getInt("member_points"));
				productOrderVO.setBirthday_coupon_no(rs.getInt("birthday_coupon_no"));
				productOrderVO.setRecipient(rs.getString("recipient"));
				productOrderVO.setRecipient_phone(rs.getString("recipient_phone"));
				productOrderVO.setRecipient_address(rs.getString("recipient_address"));
				productOrderVO.setProduct_orderdate(rs.getTimestamp("product_orderdate"));
				productOrderVO.setProduct_paydate(rs.getTimestamp("product_paydate"));
				productOrderVO.setOrder_closedate(rs.getTimestamp("order_closedate"));
				productOrderVO.setProduct_payment_status(rs.getByte("product_payment_status"));
				productOrderVO.setProduct_process_status(rs.getByte("product_process_status"));
				productOrderVO.setProduct_order_allocation_amount(rs.getInt("product_order_allocation_amount"));
				productOrderVO.setProduct_order_allocation_status(rs.getByte("product_order_allocation_status"));
				list.add(productOrderVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

//	public static void main(String[] args) {
//
//		ProductOrderJDBCDAO dao = new ProductOrderJDBCDAO();
//		
//		// 新增
//		ProductOrderVO productOrderVO1 = new ProductOrderVO();

//		productOrderVO1.setMember_no(1);
//		productOrderVO1.setProduct_price(699);
//		productOrderVO1.setProduct_coupon_discount(100);
//		productOrderVO1.setProduct_checkout_amount(599);
//		productOrderVO1.setMember_points(10);
//		productOrderVO1.setBirthday_coupon_no(1);
//		productOrderVO1.setRecipient("大吳1");
//		productOrderVO1.setRecipient_phone("0912345678");
//		productOrderVO1.setRecipient_address("桃園市中壢區1號");
//		productOrderVO1.setProduct_orderdate(java.sql.Timestamp.valueOf("2024-04-04 00:00:00"));
//		productOrderVO1.setProduct_paydate(java.sql.Timestamp.valueOf("2024-04-04 00:00:00"));
//		productOrderVO1.setOrder_closedate(java.sql.Timestamp.valueOf("2024-04-05 00:00:00"));
//		productOrderVO1.setProduct_payment_status((byte)1);
//		productOrderVO1.setProduct_process_status((byte)2);
//		productOrderVO1.setProduct_order_allocation_amount(500);
//		productOrderVO1.setProduct_order_allocation_status((byte)1);
//		dao.insert(productOrderVO1);
//
//		// 修改
//		ProductOrderVO productOrderVO2 = new ProductOrderVO();
//		productOrderVO2.setProduct_order_no(2);
//		productOrderVO2.setMember_no(1);
//		productOrderVO2.setProduct_price(699);
//		productOrderVO2.setProduct_coupon_discount(100);
//		productOrderVO2.setProduct_checkout_amount(599);
//		productOrderVO2.setMember_points(10);
//		productOrderVO2.setBirthday_coupon_no(1);
//		productOrderVO2.setRecipient("大吳2");
//		productOrderVO2.setRecipient_phone("0912345678");
//		productOrderVO2.setRecipient_address("桃園市中壢區1號");
//		productOrderVO2.setProduct_orderdate(java.sql.Timestamp.valueOf("2024-04-04 00:00:00"));
//		productOrderVO2.setProduct_paydate(java.sql.Timestamp.valueOf("2024-04-04 00:00:00"));
//		productOrderVO2.setOrder_closedate(java.sql.Timestamp.valueOf("2024-04-05 00:10:00"));
//		productOrderVO2.setProduct_payment_status((byte)1);
//		productOrderVO2.setProduct_process_status((byte)2);
//		productOrderVO2.setProduct_order_allocation_amount(500);
//		productOrderVO2.setProduct_order_allocation_status((byte)1);
//		dao.update(productOrderVO2);
//
//		// 刪除
//		dao.delete(3);
//
//		// 查詢
//		ProductOrderVO productOrderVO3 = dao.findByPrimaryKey(1);
//		System.out.print(productOrderVO3.getProduct_order_no() + ",");
//		System.out.print(productOrderVO3.getMember_no() + ",");
//		System.out.print(productOrderVO3.getProduct_price() + ",");
//		System.out.print(productOrderVO3.getProduct_coupon_discount() + ",");
//		System.out.print(productOrderVO3.getProduct_checkout_amount() + ",");
//		System.out.print(productOrderVO3.getMember_points() + ",");
//		System.out.print(productOrderVO3.getBirthday_coupon_no() + ",");
//		System.out.print(productOrderVO3.getRecipient() + ",");
//		System.out.print(productOrderVO3.getRecipient_phone() + ",");
//		System.out.print(productOrderVO3.getRecipient_address() + ",");
//		System.out.print(productOrderVO3.getProduct_orderdate() + ",");
//		System.out.print(productOrderVO3.getProduct_paydate() + ",");
//		System.out.print(productOrderVO3.getOrder_closedate() + ",");
//		System.out.print(productOrderVO3.getProduct_payment_status() + ",");
//		System.out.print(productOrderVO3.getProduct_process_status() + ",");
//		System.out.print(productOrderVO3.getProduct_order_allocation_amount() + ",");
//		System.out.print(productOrderVO3.getProduct_order_allocation_status());
//		System.out.println("================================================");
//
//		// 查詢
//		List<ProductOrderVO> list = dao.getAll();
//		for (ProductOrderVO aProduct_order : list) {
//			System.out.print(aProduct_order.getProduct_order_no() + ",");
//			System.out.print(aProduct_order.getMember_no() + ",");
//			System.out.print(aProduct_order.getProduct_price() + ",");
//			System.out.print(aProduct_order.getProduct_coupon_discount() + ",");
//			System.out.print(aProduct_order.getProduct_checkout_amount() + ",");
//			System.out.print(aProduct_order.getMember_points() + ",");
//			System.out.print(aProduct_order.getBirthday_coupon_no() + ",");
//			System.out.print(aProduct_order.getRecipient() + ",");
//			System.out.print(aProduct_order.getRecipient_phone() + ",");
//			System.out.print(aProduct_order.getRecipient_address() + ",");
//			System.out.print(aProduct_order.getProduct_orderdate() + ",");
//			System.out.print(aProduct_order.getProduct_paydate() + ",");
//			System.out.print(aProduct_order.getOrder_closedate() + ",");
//			System.out.print(aProduct_order.getProduct_payment_status() + ",");
//			System.out.print(aProduct_order.getProduct_process_status() + ",");
//			System.out.print(aProduct_order.getProduct_order_allocation_amount() + ",");
//			System.out.print(aProduct_order.getProduct_order_allocation_status());
//			System.out.println();
//		}
//	}
}