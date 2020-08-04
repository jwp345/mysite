package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bit2020.mysite.vo.UserVo;

@Repository
public class UserRepository {
	public boolean save(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			
			// 1. JDBC Driver(MariaDB Driver)
			connection = getConnection();
			
			// 3. sql 준비
			String sql = "insert into user values(null, ?, ?, password(?), ?, now())";
			pstmt = connection.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());


			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public UserVo findByNo(Long no) {
		UserVo result = null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			
			// 1. JDBC Driver(MariaDB Driver)
			connection = getConnection();
			
			// 3. sql 준비
			String sql = "select no, name, email, gender from user where no=?";
			pstmt = connection.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setLong(1, no);

			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 결과 가져오기
			if(rs.next()) {
				result = new UserVo();
				
				result.setNo(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setGender(rs.getString(4));
			}
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			
			// 1. JDBC Driver(MariaDB Driver)
			connection = getConnection();
			
			// 3. sql 준비
			String sql = "select no, name from user where email=? and password=password(?)";
			pstmt = connection.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 결과 가져오기
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	public boolean updateByEmail(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			// 1. JDBC Driver(MariaDB Driver)
			connection = getConnection();
			
			// 3. sql 준비
			String sql = "update user set name=?, password=password(?), gender=? where email=?";
			pstmt = connection.prepareStatement(sql);

			//4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getEmail());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0)
				result = true;
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection(){
		Connection connection = null;
		
		try {
		// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");
					
					//2. 연결하기
			String url  = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;
	}
	
}
