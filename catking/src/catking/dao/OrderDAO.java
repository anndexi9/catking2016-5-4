package catking.dao;

import java.sql.Connection;

import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import catking.dao.ConnectionFactory;
import catking.bean.CartBean;
import catking.bean.CustomerBean;
import catking.bean.ItemBean;

public class OrderDAO {
	private Connection con;
	
	private static Connection getConnection() 
			throws SQLException, ClassNotFoundException, DAOException 
    {
		ConnectionFactory ConFactory = new ConnectionFactory();
        Connection connection = ConFactory.getConnection();
        return connection;
    }
	

	public int saveOrder(CustomerBean customer, CartBean cart)
			throws DAOException {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			if (con == null)
				con=getConnection();
			
			int customerNumber = 0;
			String sql = "SELECT nextval('customer_cus_id_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				customerNumber = rs.getInt(1);
			}
			rs.close();
			st.close();
		
			sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?)";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, customerNumber);
			st.setString(2, customer.getName());
			st.setString(3, customer.getAddress());
			st.setString(4, customer.getTel());
			st.setString(5, customer.getEmail());
		
			st.executeUpdate();
			st.close();

			int orderNumber = 0;
			sql = "SELECT nextval('ordered_order_id_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) {
				orderNumber = rs.getInt(1);
			}
			rs.close();
			st.close();

			sql = "INSERT INTO ordered VALUES(?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			
			st.setInt(1, orderNumber);
			st.setInt(2, customerNumber);
			Date today = new Date(System.currentTimeMillis());
			st.setDate(3, today);
			st.setInt(4, cart.getTotal());
		
			st.executeUpdate();
			st.close();

		
			sql = "INSERT INTO order_detail VALUES(?, ?, ?)";
			st = con.prepareStatement(sql);
			Map<Integer, ItemBean> items = cart.getItems();
			Collection<ItemBean> list = items.values();
			for (ItemBean item : list) {
				st.setInt(1, orderNumber);
				st.setInt(2, item.getId());
				st.setInt(3, item.getQty());
				st.executeUpdate();
			}
			st.close();
			return orderNumber;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
		
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

}
