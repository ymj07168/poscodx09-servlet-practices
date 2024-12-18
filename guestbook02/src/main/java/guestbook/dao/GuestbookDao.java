package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.vo.GuestbookVo;

public class GuestbookDao {

	public List<GuestbookVo> findAll() {
		
		List<GuestbookVo> result = new ArrayList<>();
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select id, name, contents, date_format(reg_date, '%Y-%m-%d %h:%i:%s') from guestbook order by reg_date desc");
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String contents = rs.getString(3);
				String regDate = rs.getString(4);
				
				GuestbookVo vo = new GuestbookVo();
				vo.setId(id);
				vo.setName(name);
				vo.setContents(contents);
				vo.setRegDate(regDate);
				
				result.add(vo);
			}
			
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		
		return result;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.0.5:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;
	}

	public int insert(GuestbookVo vo) {
		int count = 0;

		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into guestbook values(null, ?, ?, ?, now())");
		) {
						
			// 4. Parameter binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContents());
			
			// 5. SQL 실행
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		
		return count;
	}

	public int deleteByIdAndPassword(Long id, String password) {
		int count = 0;

		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from guestbook where id = ? and password = ?;");
		) {
						
			pstmt.setLong(1, id);
			pstmt.setString(2, password);
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		
		return count;
		
	}
}
