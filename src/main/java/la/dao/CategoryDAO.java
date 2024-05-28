package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.Category;

public class CategoryDAO extends DAO {
	//全件検索
	public List<Category> findAll() throws DAOException {
		List<Category> list = new ArrayList<Category>();
		
		String sql = "SELECT code, name FROM Category ORDER BY code";

		try (
				Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int code = rs.getInt("code");       //コードを取得
				String name = rs.getString("name"); //名前を取得
				
				list.add(new Category(code, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}
		
		return list;
	}

	public List<Category> findAll(int limit, int offset) throws DAOException {
		List<Category> list = new ArrayList<Category>();
		
		String sql = "SELECT code, name FROM Category ORDER BY code";
		sql += " LIMIT ? OFFSET ?";

		try (
				Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setInt(2, offset);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int code = rs.getInt("code");       //コードを取得
				String name = rs.getString("name"); //名前を取得
				
				list.add(new Category(code, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}
		
		return list;
	}

	public int getCategoryRecords() throws DAOException {
		int record = 0;
		
		String sql = "SELECT count(*) AS record FROM Category";

		try (
				Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				record = rs.getInt("record"); //レコード数を取得
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}
		
		return record;
	}

	//コード検索
	public Category findByCode(int _code) throws DAOException {
		Category category = null;
		
		String sql = "SELECT code, name FROM Category WHERE code = ?";

		try (
				Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, _code);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int code = rs.getInt("code");       //コードを取得
				String name = rs.getString("name"); //名前を取得
				
				category = new Category(code, name);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}

		return category;
	}

	//Categoryテーブル登録用メソッド
	public int insert(String name) throws DAOException {
		int rows = 0;

		String sql = "INSERT INTO Category(name) VALUES(?)";

		try (
			Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);

			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}

		return rows;
	}

	//Categoryテーブル変更用メソッド
	public int update(int code, String name) throws DAOException {
		int rows = 0;

		String sql = "UPDATE Category SET name = ? WHERE code = ?";

		try (
			Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, code);

			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}

		return rows;
	}

	//Categoryテーブル削除用メソッド
	public int delete(int code) throws DAOException {
		int rows = 0;

		String sql = "DELETE FROM Category WHERE code = ?";

		try (
			Connection con = getConnect();
		) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, code);

			rows = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("DBエラー");
		}

		return rows;
	}

}
