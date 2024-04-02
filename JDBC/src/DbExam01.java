import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DbExam01 {

	Connection conn; // 여긴 타입과 객체명을 선언한다. 통상 이렇게 안하지만 JDBC에선 이렇게 처리한다. 
	PreparedStatement pstmt;
	// 미리 컴파일된 SQL 문을 나타내는 객체입니다.
	// SQL 문은 미리 컴파일되어 PreparedStatement 객체에 저장됩니다.
	//	이 객체를 사용하여 이 문을 효율적으로 여러 번 실행할 수 있습니다.
	
	public DbExam01() {
		this("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "gangnam", "qwe123!@#");
		// 데이터베이스/ 호스트/ 포트/ DB이름 / 아이디/ 비번
	}

	
	public DbExam01(String url, String user, String pw) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw); // 실제로 conn의 객체가 생성된 부분

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private void creatDb() {
		// TODO Auto-generated method stub
		try {
			String s = "drop table if exists student2;";
			String sql = "create table student2(\r\n" + "id int, \r\n" + "username varchar(20), \r\n"
					+ "primary key(id)\r\n" + ")\r\n";

			pstmt = conn.prepareStatement(s);// 실제로 prepareStatement의 객체가 생성된 부분
			// new부분까지 포함된 객체 create 문으로 new부분 불필요하게 처리됨. 
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void dbInput() {
		try {
			String sql = "insert into student2 value(7,'superma')";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbInput2(int x, String y) {
		try {
			String sql = "insert into student2 value(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, x); // 위치가 0부터 시작하지 않음에 유의
			pstmt.setString(2, y);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void dbInput3(String[] str) {
		// TODO Auto-generated method stub
		
	
			try {
				String sql = "insert into student2 value(?,?)";
				pstmt = conn.prepareStatement(sql);
				
				for (int i = 0; i < str.length; i++)
					// for 문을 활용하여 다수의 데이터 입력
					{
				pstmt.setInt(1, i+13); // 위치가 0부터 시작하지 않음에 유의
				pstmt.setString(2, str[i]);
				pstmt.executeUpdate();
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
	private void dbInput4(int id, String name) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into student2 value(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 위치가 0부터 시작하지 않음에 유의
			pstmt.setString(2, name);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		DbExam01 exam = new DbExam01();

		exam.delete("AAA");
		
		System.out.println("Success");

	}


	private void delete(String str) {
	
		try {
		String sql = "delete from student2 where username = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, str);
		pstmt.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}


	private void update(String str, int x) {
		try {
		String sql = "update student2 set username=? where id =?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, str);
		pstmt.setInt(2, x);
		pstmt.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}


	private void result()throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from student2";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { //계속 엔터로 너머간다. 
			int deptNo = rs.getInt(1);
			String deptName = rs.getString(2);
			
			System.out.println(deptName+ " " + deptNo);
		}
		
	}
}
