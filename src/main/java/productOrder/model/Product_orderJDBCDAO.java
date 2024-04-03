package productOrder.model;

import java.util.*;
import java.sql.*;

public class Product_orderJDBCDAO implements Product_orderDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "19920130";

	private static final String INSERT_STMT = "INSERT INTO ezban (member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT product_order_no, member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status FROM ezban order by member_no";
	private static final String GET_ONE_STMT = "SELECT product_order_no, member_no, product_price, product_coupon_discount, product_checkout_amount, member_points, birthday_coupon_no, recipient, recipient_phone, recipient_address, product_orderdate, product_paydate, order_closedate, product_payment_status, product_process_status, product_order_allocation_amount, product_order_allocation_status FROM ezban where member_no = ?";
	private static final String DELETE = "DELETE FROM ezban where product_order_no = ?";
	private static final String UPDATE = "UPDATE ezban set member_no=?, product_price=?, product_coupon_discount=?, product_checkout_amount=?, member_points=?, birthday_coupon_no=?, recipient=?, recipient_phone=?, recipient_address=?, product_orderdate=?, product_paydate=?, order_closedate=?, product_payment_status=?, product_process_status=?, product_order_allocation_amount=?, product_order_allocation_status=? where product_order_no = ?";

	@Override
	public void insert(Product_orderVO product_orderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, product_orderVO.getMember_no());
			pstmt.setInt(2, product_orderVO.getProduct_price());
			pstmt.setInt(3, product_orderVO.getProduct_coupon_discount());
			pstmt.setInt(4, product_orderVO.getProduct_checkout_amount());
			pstmt.setInt(5, product_orderVO.getMember_points());
			pstmt.setInt(6, product_orderVO.getBirthday_coupon_no());
			pstmt.setString(7, product_orderVO.getRecipient());
			pstmt.setString(8, product_orderVO.getRecipient_phone());
			pstmt.setString(9, product_orderVO.getRecipient_address());
			pstmt.setTimestamp(10, product_orderVO.getProduct_orderdate());
			pstmt.setTimestamp(11, product_orderVO.getProduct_paydate());
			pstmt.setTimestamp(12, product_orderVO.getOrder_closedate());
			pstmt.setByte(13, product_orderVO.getProduct_payment_status());
			pstmt.setByte(14, product_orderVO.getProduct_process_status());
			pstmt.setInt(15, product_orderVO.getProduct_order_allocation_amount());
			pstmt.setByte(16, product_orderVO.getProduct_order_allocation_status());

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
	public void update(Product_orderVO product_orderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, product_orderVO.getMember_no());
			pstmt.setInt(2, product_orderVO.getProduct_price());
			pstmt.setInt(3, product_orderVO.getProduct_coupon_discount());
			pstmt.setInt(4, product_orderVO.getProduct_checkout_amount());
			pstmt.setInt(5, product_orderVO.getMember_points());
			pstmt.setInt(6, product_orderVO.getBirthday_coupon_no());
			pstmt.setString(7, product_orderVO.getRecipient());
			pstmt.setString(8, product_orderVO.getRecipient_phone());
			pstmt.setString(9, product_orderVO.getRecipient_address());
			pstmt.setTimestamp(10, product_orderVO.getProduct_orderdate());
			pstmt.setTimestamp(11, product_orderVO.getProduct_paydate());
			pstmt.setTimestamp(12, product_orderVO.getOrder_closedate());
			pstmt.setByte(13, product_orderVO.getProduct_payment_status());
			pstmt.setByte(14, product_orderVO.getProduct_process_status());
			pstmt.setInt(15, product_orderVO.getProduct_order_allocation_amount());
			pstmt.setByte(16, product_orderVO.getProduct_order_allocation_status());
			pstmt.setInt(17, product_orderVO.getProduct_order_no());

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
	public Product_orderVO findByPrimaryKey(Integer product_order_no) {

		Product_orderVO product_orderVO = null;
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
				// product_orderVO 也稱為 Domain objects
				product_orderVO = new Product_orderVO();
				product_orderVO.setProduct_order_no(rs.getInt("product_order_no"));
				product_orderVO.setMember_no(rs.getInt("member_no"));
				product_orderVO.setProduct_price(rs.getInt("product_price"));
				product_orderVO.setProduct_coupon_discount(rs.getInt("product_coupon_discount"));
				product_orderVO.setProduct_checkout_amount(rs.getInt("product_checkout_amount"));
				product_orderVO.setMember_points(rs.getInt("member_points"));
				product_orderVO.setBirthday_coupon_no(rs.getInt("product_order_no"));
				product_orderVO.setRecipient(rs.getString("recipient"));
				product_orderVO.setRecipient_phone(rs.getString("recipient_phone"));
				product_orderVO.setRecipient_address(rs.getString("recipient_address"));
				product_orderVO.setProduct_orderdate(rs.getTimestamp("product_orderdate"));
				product_orderVO.setProduct_paydate(rs.getTimestamp("product_paydate"));
				product_orderVO.setOrder_closedate(rs.getTimestamp("order_closedate"));
				product_orderVO.setProduct_payment_status(rs.getByte("product_payment_status"));
				product_orderVO.setProduct_process_status(rs.getByte("product_process_status"));
				product_orderVO.setProduct_order_allocation_amount(rs.getInt("product_order_allocation_amount"));
				product_orderVO.setProduct_order_allocation_status(rs.getByte("product_order_allocation_status"));

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
		return product_orderVO;
	}

	@Override
	public List<Product_orderVO> getAll() {
		List<Product_orderVO> list = new ArrayList<Product_orderVO>();
		Product_orderVO product_orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// product_orderVO 也稱為 Domain objects
				product_orderVO = new Product_orderVO();
				product_orderVO.setProduct_order_no(rs.getInt("product_order_no"));
				product_orderVO.setMember_no(rs.getInt("member_no"));
				product_orderVO.setProduct_price(rs.getInt("product_price"));
				product_orderVO.setProduct_coupon_discount(rs.getInt("product_coupon_discount"));
				product_orderVO.setProduct_checkout_amount(rs.getInt("product_checkout_amount"));
				product_orderVO.setMember_points(rs.getInt("member_points"));
				product_orderVO.setBirthday_coupon_no(rs.getInt("product_order_no"));
				product_orderVO.setRecipient(rs.getString("recipient"));
				product_orderVO.setRecipient_phone(rs.getString("recipient_phone"));
				product_orderVO.setRecipient_address(rs.getString("recipient_address"));
				product_orderVO.setProduct_orderdate(rs.getTimestamp("product_orderdate"));
				product_orderVO.setProduct_paydate(rs.getTimestamp("product_paydate"));
				product_orderVO.setOrder_closedate(rs.getTimestamp("order_closedate"));
				product_orderVO.setProduct_payment_status(rs.getByte("product_payment_status"));
				product_orderVO.setProduct_process_status(rs.getByte("product_process_status"));
				product_orderVO.setProduct_order_allocation_amount(rs.getInt("product_order_allocation_amount"));
				product_orderVO.setProduct_order_allocation_status(rs.getByte("product_order_allocation_status"));
				list.add(product_orderVO); // Store the row in the list
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
//		Product_orderJDBCDAO dao = new Product_orderJDBCDAO();
//
//		// 新增
//		Product_orderVO product_orderVO1 = new Product_orderVO();
//
//		product_orderVO1.setMember_no(100);
//		product_orderVO1.setProduct_price(699);
//		product_orderVO1.setProduct_coupon_discount(100);
//		product_orderVO1.setProduct_checkout_amount(599);
//		product_orderVO1.setMember_points(10);
//		product_orderVO1.setBirthday_coupon_no(1);
//		product_orderVO1.setRecipient("大吳1");
//		product_orderVO1.setRecipient_phone("0912345678");
//		product_orderVO1.setRecipient_address("桃園市中壢區1號");
//		product_orderVO1.setProduct_orderdate(java.sql.Timestamp.valueOf("2024-04-04"));
//		product_orderVO1.setProduct_paydate(java.sql.Timestamp.valueOf("2024-04-04"));
//		product_orderVO1.setOrder_closedate(java.sql.Timestamp.valueOf("2024-04-05"));
//		product_orderVO1.setProduct_payment_status(1);
//		product_orderVO1.setProduct_process_status(2);
//		product_orderVO1.setProduct_order_allocation_amount(500);
//		product_orderVO1.setProduct_order_allocation_status(1);
//		dao.insert(product_orderVO1);
//
//		// 修改
//		Product_orderVO product_orderVO2 = new Product_orderVO();
//		product_orderVO2.setProduct_order_no(11);
//		product_orderVO2.setMember_no(100);
//		product_orderVO2.setProduct_price(699);
//		product_orderVO2.setProduct_coupon_discount(100);
//		product_orderVO2.setProduct_checkout_amount(599);
//		product_orderVO2.setMember_points(10);
//		product_orderVO2.setBirthday_coupon_no(1);
//		product_orderVO2.setRecipient("大吳2");
//		product_orderVO2.setRecipient_phone("0912345678");
//		product_orderVO2.setRecipient_address("桃園市中壢區1號");
//		product_orderVO2.setProduct_orderdate(java.sql.Timestamp.valueOf("2024-04-04"));
//		product_orderVO2.setProduct_paydate(java.sql.Timestamp.valueOf("2024-04-04"));
//		product_orderVO2.setOrder_closedate(java.sql.Timestamp.valueOf("2024-04-05"));
//		product_orderVO2.setProduct_payment_status(1);
//		product_orderVO2.setProduct_process_status(2);
//		product_orderVO2.setProduct_order_allocation_amount(500);
//		product_orderVO2.setProduct_order_allocation_status(1);
//		dao.update(product_orderVO2);
//
//		// 刪除
//		dao.delete(9);
//
//		// 查詢
//		Product_orderVO product_orderVO3 = dao.findByPrimaryKey(1);
//		System.out.print(product_orderVO3.getProduct_order_no() + ",");
//		System.out.print(product_orderVO3.getMember_no() + ",");
//		System.out.print(product_orderVO3.getProduct_price() + ",");
//		System.out.print(product_orderVO3.getProduct_coupon_discount() + ",");
//		System.out.print(product_orderVO3.getProduct_checkout_amount() + ",");
//		System.out.print(product_orderVO3.getMember_points() + ",");
//		System.out.print(product_orderVO3.getBirthday_coupon_no() + ",");
//		System.out.print(product_orderVO3.getRecipient() + ",");
//		System.out.print(product_orderVO3.getRecipient_phone() + ",");
//		System.out.print(product_orderVO3.getRecipient_address() + ",");
//		System.out.print(product_orderVO3.getProduct_orderdate() + ",");
//		System.out.print(product_orderVO3.getProduct_paydate() + ",");
//		System.out.print(product_orderVO3.getOrder_closedate() + ",");
//		System.out.print(product_orderVO3.getProduct_payment_status() + ",");
//		System.out.print(product_orderVO3.getProduct_process_status() + ",");
//		System.out.print(product_orderVO3.getProduct_order_allocation_amount() + ",");
//		System.out.print(product_orderVO3.getProduct_order_allocation_status());
//		System.out.println("================================================");
//
//		// 查詢
//		List<Product_orderVO> list = dao.getAll();
//		for (Product_orderVO aProduct_order : list) {
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