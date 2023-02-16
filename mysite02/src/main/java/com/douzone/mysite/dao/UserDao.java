package com.douzone.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7

import com.douzone.mysite.vo.UserVo;

public class UserDao {
<<<<<<< HEAD

	public void insert(UserVo vo) {
=======
	public Boolean deleteByNoAndPassword(Long no, String password) {
		boolean result = false;

>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

<<<<<<< HEAD
			String sql = "insert into user values (null, ?, ?, password(?), ?, now())";
=======
			String sql = "";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.setString(2, password);

			int count = pstmt.executeUpdate();

			result = count == 1;
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public void insert(UserVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into user values(null, ?, ?, password(?), ?, now())";
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());

<<<<<<< HEAD
			pstmt.executeUpdate();
=======
			int count = pstmt.executeUpdate();
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7

		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public UserVo findByEmailAndPassword(UserVo vo) {
		UserVo result = null;
<<<<<<< HEAD

=======
		
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, name from user where email = ? and password = password(?)";
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPassword());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVo();

				Long no = rs.getLong(1);
				String name = rs.getString(2);

				result.setNo(no);
				result.setName(name);
			}
=======
			pstmt.setString(1,vo.getEmail());
			pstmt.setString(1,vo.getPassword());

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new UserVo();
				
				Long no = rs.getLong(1);
				String name = rs.getString(2);
			}

>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
<<<<<<< HEAD
=======

>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

<<<<<<< HEAD
	public UserVo findByNo(Long no) {
		UserVo result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select no, name, email, password, gender, join_date  from user where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new UserVo();

				Long voNo = rs.getLong(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);
				String joinDate = rs.getString(6);

				result.setNo(voNo);
				result.setName(name);
				result.setEmail(email);
				result.setPassword(password);
				result.setGender(gender);
				result.setJoinDate(joinDate);

			}
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public void update(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			if (vo.getPassword() == null || vo.getPassword().isEmpty() || vo.getPassword().isBlank() || vo.getPassword().contains(" ")) {
				String sql = "update user set name = ?, gender = ? where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getGender());
				pstmt.setLong(3, vo.getNo());

			} else {
				String sql = "update user set name = ?, password = password(?), gender = ? where no = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getGender());
				pstmt.setLong(4, vo.getNo());
			}
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

=======
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://192.168.10.115:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
