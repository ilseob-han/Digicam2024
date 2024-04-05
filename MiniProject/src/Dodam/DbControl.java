package Dodam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DbControl {

	Connection conn; // 여긴 타입과 객체명을 선언한다. 통상 이렇게 안하지만 JDBC에선 이렇게 처리한다. 
	PreparedStatement pstmt;
	// 미리 컴파일된 SQL 문을 나타내는 객체입니다.
	// SQL 문은 미리 컴파일되어 PreparedStatement 객체에 저장됩니다.
	//	이 객체를 사용하여 이 문을 효율적으로 여러 번 실행할 수 있습니다.

	public DbControl() {
		this("jdbc:mysql://localhost:3306/dodam?serverTimezone=UTC", "gangnam", "qwe123!@#");
		// 데이터베이스/ 호스트/ 포트/ DB이름 / 아이디/ 비번
	}

	
	public DbControl(String url, String user, String pw) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw); // 실제로 conn의 객체가 생성된 부분

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
		
		String logInfoReturn(String ID)throws SQLException {
			// 아이디를 받아서 비밀번호 리턴하는 메서드
			String user = null;
			String pass = null;
			String sql = "select * from USERS where user =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) { //계속 엔터로 너머간다. 
				user = rs.getString(1);
				pass = rs.getString(2);		
//				System.out.println("DB리턴값"+user+ " " + pass);
			}
			
			return pass;
		}
		
		String existCheck(String ID) throws SQLException {
			String user = null;

		    String sql = "SELECT COUNT(*) FROM USERS WHERE user = ?";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, ID);
		    ResultSet rs = pstmt.executeQuery();

			while(rs.next()) { //계속 엔터로 너머간다. 
				user = rs.getString(1);
			}
			System.out.println("DB"+user);
			return user;
		}

		public void dbInput(String table, String i, String j, String k) {
		    try {
		        // 테이블 이름을 직접 문자열에 포함
		        String sql = "INSERT INTO " + table + " VALUES (?, ?, ?)";
		        pstmt = conn.prepareStatement(sql);
		        // 첫 번째와 두 번째 파라미터 설정
		        pstmt.setString(1, i);
		        pstmt.setString(2, j);
		        pstmt.setString(3, k);
		        
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
			
		public static void main(String[] args) throws SQLException {
			
			
			DbControl dbControl = new DbControl();
//			dbControl.logInfoReturn("1234");
//			System.out.println(dbControl.logInfoReturn("1234"));
//		
//			System.out.println(dbControl.existCheck("1234"));
//			System.out.println("Success");
			
			dbControl.dbInput("users","moon","3333","3333");
		}
		
}
