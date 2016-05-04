package catking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import catking.bean.CustomerBean;

public class MemSysDAO {
	private Connection con;
	int MemRecords;
	
	private static Connection getConnection() 
			throws SQLException, ClassNotFoundException, DAOException 
    {
		ConnectionFactory ConFactory = new ConnectionFactory();
        Connection connection = ConFactory.getConnection();
        return connection;
    }
	
	public boolean validLogin(String username, String password) 
			throws DAOException {
		
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int recordNo=0;
		
		try {
			if (con == null)
				con=getConnection();
		
			String sql = "SELECT COUNT(*) from (SELECT DISTINCT cus_id FROM customer WHERE username = '"+
					username + "' AND password = '"+ password +"') as temp";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) 
				recordNo=rs.getInt(1);
				
			if (recordNo>0)
				return true;
			else return false;	

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("«Ë«Ø∆„«≈«Uæﬁß@«R•¢±—∆˝«e∆˝«F°C");
		} finally {
			try {
		
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("«Ê«π∆„«µ«U∂}©Ò«R•¢±—∆˝«e∆˝«F°C");
			}
		}
	}
	
	public boolean memExist(String username, String email) 
			throws DAOException {
		
		
		PreparedStatement st = null;
		ResultSet rs = null;
		int recordNo=0;
		
		try {
			if (con == null)
				con=getConnection();
		
			String sql = "SELECT COUNT(*) from (SELECT DISTINCT cus_id FROM customer WHERE username = '"+
					username + "' OR email = '"+ email +"') as temp";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if (rs.next()) 
				recordNo=rs.getInt(1);
				
			if (recordNo>0)
				return true;
			else return false;	

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("«Ë«Ø∆„«≈«Uæﬁß@«R•¢±—∆˝«e∆˝«F°C");
		} finally {
			try {
		
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("«Ê«π∆„«µ«U∂}©Ò«R•¢±—∆˝«e∆˝«F°C");
			}
		}
	}
		
		
	public void regMem(String cus_name, String email, String address, String tel, String username, String password)
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
		
			sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, customerNumber);
			st.setString(2, cus_name);
			st.setString(3, email);
			st.setString(4, address);
			st.setString(5, tel);
			st.setString(6, username);
			st.setString(7, password);
			
			Date reg_time = new Date(System.currentTimeMillis());
			st.setDate(8, reg_time);
			
			st.executeUpdate();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("«Ë«Ø∆„«≈«Uæﬁß@«R•¢±—∆˝«e∆˝«F°C");
		} finally {
			try {
		
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("«Ê«π∆„«µ«U∂}©Ò«R•¢±—∆˝«e∆˝«F°C");
			}
		}
	}
	
	public CustomerBean getMemInfo(String username, String email) 
			throws DAOException {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			if (con == null)
				con=getConnection();
		
			String sql = "SELECT DISTINCT cus_id FROM customer WHERE username = '"+
					username + "' OR email = '"+ email +"'";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			if (rs.next()) {
				int code = rs.getInt("cus_id");
				String cus_name = rs.getString("cus_name");
				String cus_email = rs.getString("email");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String cus_username = rs.getString("username");
				String pw = rs.getString("password");
				String regtime = rs.getString("reg_time");

				CustomerBean bean = new CustomerBean(code, cus_name, cus_email, address, tel, cus_username, pw, regtime) ;

				return bean;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("«Ë«Ø∆„«≈«Uæﬁß@«R•¢±—∆˝«e∆˝«F°C");
		} finally {
			try {
		
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("«Ê«π∆„«µ«U∂}©Ò«R•¢±—∆˝«e∆˝«F°C");
			}
		}
	}
		
	
}
