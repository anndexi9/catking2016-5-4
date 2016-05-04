package catking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import catking.bean.ItemBean;

public class ItemDAO {
	private Connection con;
	int noOfRecords;
	
	private static Connection getConnection() 
			throws SQLException, ClassNotFoundException, DAOException 
    {
		ConnectionFactory ConFactory = new ConnectionFactory();
        Connection connection = ConFactory.getConnection();
        return connection;
    }
	

	public int getNoOfRecords(){
		return noOfRecords;
	}
	
	public List<ItemBean> findAll(int offset, int noOfRecords) 
			throws DAOException {
		

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			if (con == null)
				con=getConnection();
			
			
			String sql = "select * from item ORDER BY item_id offset "
	                 + offset + " limit " + noOfRecords; 
			
			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String category = rs.getString("category");
				String sub_cat = rs.getString("sub_cat");
				String brand = rs.getString("brand");
				int price = rs.getInt("price");
				String memo = rs.getString("memo");
				String datetime = rs.getString("update_time");

				ItemBean bean = new ItemBean(id, name,  category,  sub_cat,
						 brand,  price, memo,  datetime);
				list.add(bean);
			}st.close();
			rs.close();

			st = con.prepareStatement("SELECT COUNT(*) from item");

			rs = st.executeQuery();
			
			if (rs.next())
			this.noOfRecords= rs.getInt(1);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {

				if(rs != null) rs.close();
				if(st != null) st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}


	public List<ItemBean> findByKeyword(String paraVal,int offset, int noOfRecords) throws DAOException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			if (con == null)
				con=getConnection();
		
			String sql = "SELECT * FROM item where 'item_name' LIKE "+ "%";
//				String sql = "SELECT * FROM item where 'price' = '3000'";
//			String sql = "SELECT * FROM item WHERE ((item_name '%"+ paraVal +"%')"
//					+ "OR (category LIKE '%" + paraVal + "%')"
//					+ "OR (sub_cat LIKE '%" + paraVal +"%')"
//					+ "OR (memo LIKE '%" + paraVal +"%')"
//					+ "OR (brand LIKE '%" + paraVal +"%') ) ";
			//+ "OR (brand LIKE '%" + paraVal +"%') ORDER BY item_id) limit '2'";
						//	+ "　offset "+ offset + " limit " + noOfRecords;

			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String category = rs.getString("category");
				String sub_cat = rs.getString("sub_cat");
				String brand = rs.getString("brand");
				int price = rs.getInt("price");
				String memo = rs.getString("memo");
				String datetime = rs.getString("update_time");

				ItemBean bean = new ItemBean(id, name,  category,  sub_cat,
						 brand,  price, memo,  datetime);
				list.add(bean);
			}//st.close();
			//rs.close();
			/*
			sql= "SELECT COUNT(*) from (SELECT DISTINCT item_id FROM item WHERE (item_name LIKE '%"+ paraVal +"%')"
							+ "OR (category LIKE '%" + paraVal + "%')"
							+ "OR (sub_cat LIKE '%" + paraVal +"%')"
							+ "OR (memo LIKE '%" + paraVal +"%')"
							+ "OR (brand LIKE '%" + paraVal +"%') ORDER BY item_id) as temp";
			
			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			if (rs.next())
			this.noOfRecords= rs.getInt(1);*/
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				
				if(rs != null) rs.close();
				if(st != null) st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}



	public List<ItemBean> findByCategory(String cat,int offset,int noOfRecords) throws DAOException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			if (con == null)
				con=getConnection();
			
			String catCol= "";

			if (cat.equals("food")){
				catCol="フード";
			}else if (cat.equals("toy")){
				catCol="おもちゃ";
			}else if (cat.equals("home")){
				catCol="家具";
			}else if (cat.equals("zakka")){
				catCol="雑貨";
			}else catCol="";

			String sql = "SELECT * FROM item WHERE category = '"
					+ catCol +"' ORDER BY item_id "
					+ "offset "+ offset + " limit " + noOfRecords;

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String category = rs.getString("category");
				String sub_cat = rs.getString("sub_cat");
				String brand = rs.getString("brand");
				int price = rs.getInt("price");
				String memo = rs.getString("memo");
				String datetime = rs.getString("update_time");

				ItemBean bean = new ItemBean( id,  name,  category, sub_cat,
						 brand, price,  memo,  datetime) ;
				list.add(bean);
			}
			st.close();
			rs.close();
			
			sql= "SELECT COUNT(*) from (SELECT DISTINCT item_id FROM item WHERE category = '"+
					catCol + "' ORDER BY item_id) as temp";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			if (rs.next())
			this.noOfRecords= rs.getInt(1);

			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {

				if(rs != null) rs.close();
				if(st != null) st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}


	public List<ItemBean> findBySubcategory(String sub, int offset, int noOfRecords) throws DAOException {
		

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			if (con == null)
				con=getConnection();
			
			String catCol= "";

			if (sub.equals("dry")){
				catCol="ドライフード";
			}else if (sub.equals("wet")){
				catCol="ウェットフード";
			}else if (sub.equals("snack")){
				catCol="スナック";
			}else if (sub.equals("tsume")){
				catCol="爪とぎ";
			}else if (sub.equals("matatabi")){
					catCol="またたびトイ";
			}else if (sub.equals("tower")){
					catCol="キャットタワー";
			}else if (sub.equals("bed")){
					catCol="ベッド";
			}else if (sub.equals("toilet")){
				catCol="トイレ";
			}else if (sub.equals("collar")){
				catCol="首輪";
			}else if (sub.equals("sand")){
			catCol="砂";
	}
				else catCol="";

			String sql = "SELECT * FROM item WHERE sub_cat = '"
					+ catCol +"' ORDER BY item_id "
					+ "offset " + offset + " limit " + noOfRecords;

			st = con.prepareStatement(sql); 

			rs = st.executeQuery();

			List<ItemBean> list = new ArrayList<ItemBean>();
			while (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String category = rs.getString("category");
				String sub_cat = rs.getString("sub_cat");
				String brand = rs.getString("brand");
				int price = rs.getInt("price");
				String memo = rs.getString("memo");
				String datetime = rs.getString("update_time");

				ItemBean bean = new ItemBean( id,  name,  category, sub_cat,
						 brand, price,  memo,  datetime) ;
				list.add(bean);
			}st.close();
			rs.close();
			
			sql= "SELECT COUNT(*) from (SELECT DISTINCT item_id FROM item WHERE sub_cat = '"+
					catCol + "' ORDER BY item_id) as temp";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			
			if (rs.next())
			this.noOfRecords= rs.getInt(1);

			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {

				if(rs != null) rs.close();
				if(st != null) st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public ItemBean findByPrimaryKey(int key) throws DAOException {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			if (con == null)
				con=getConnection();

			String sql = "SELECT * FROM item WHERE item_id = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, key);

			rs = st.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String category = rs.getString("category");
				String sub_cat = rs.getString("sub_cat");
				String brand = rs.getString("brand");
				int price = rs.getInt("price");
				String memo = rs.getString("memo");
				String datetime = rs.getString("update_time");

				ItemBean bean = new ItemBean( id,  name,  category, sub_cat,
						 brand, price,  memo,  datetime) ;

				return bean;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {

				if(rs != null) rs.close();
				if(st != null) st.close();
				con.close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

}
