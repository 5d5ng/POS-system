package testPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
public class Test {

	public static void main(String[] args) {
//		System.out.println("검색할 학생의 학번을 입력하라");
//		System.out.println();
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
//
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
//					"201512119"); // 데이터베이스 연결  
//
//			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
//			PreparedStatement pstmt = null;
//
//			ResultSet rs = stmt.executeQuery("select * from customer"); // excuteQuery 메소드를 이용하여 select 문을 실행
//
//			String sql1 = "insert into customer values ('아씨발','011222','B',300,22)";	
//			   stmt.executeUpdate(sql1);
//			
//			
//			while (rs.next()) { //다음 방문할 값이 존재하는 동안 루프
//				String cname = rs.getString("cname"); // getInt(1)
//				String phone = rs.getString("phone");
//				String grade = rs.getString("grade");
//				int saving = rs.getInt("saving");
//				int age =  rs.getInt("age");
//				System.out.format(" %s \n",phone);
//			}
//
//			rs.close();
//			stmt.close();
//			con.close();
//
//		} catch (SQLException se) {
//			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
//		} catch (ClassNotFoundException cnfe) {
//			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
//		} finally {
//
//		}
//
//	}
	int n=3;
	String s  = "sew"+n;
	System.out.println(s);
	}
	

}
