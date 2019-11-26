package MarketPos;


import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.mysql.jdbc.PreparedStatement;

public class DBconnector {
	String url;
	BufferedWriter bw;//쓰기
	BufferedReader br;//읽기
	String urlbooks,urlcustomer,urlproduct,urladministrator;
	//	 private static Connection con;
	//	 private static Statement stmt;
	//	 private static ResultSet rs;
	//txt 파일로 연결
	public DBconnector() {
		urlbooks = "books.txt";
		urlcustomer = "customer.txt";
		urlproduct = "product.txt";
		urladministrator = "administrator.txt";
	}

	//관리자가 맞는지 확인하는 메소드
	public boolean checkPw(String inputPW) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from administrator"); // excuteQuery 메소드를 이용하여 select 문을 실행

			while (rs.next()) { //다음 방문할 값이 존재하는 동안 루프
				String pw = rs.getString("password"); // getInt(1)
				if(pw.equals(inputPW)) {
					System.out.println("관리자모드 로그인 성공 ");
					return true;
				}
			}

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
		return false;

	}

	//물품을 추가하는 메소드
	public void addProduct(String barcode, String pname, String ptype, String pamount, String expiration,int price) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			String sql = " insert into product values(' "+barcode+" ',' "+pname+" ',' " + ptype +" ',' "+ pamount +" ',' "+expiration + "' ,"+price+ ")" ; 	
			stmt.executeUpdate(sql);

			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}		

		System.out.println( barcode + "\t" +pname+ "\t" +ptype+ "\t" +pamount + "\t" +expiration + "\t" + price + "제품 추가 완료");
	}

	//상품 조회를 출력하는 메소드
	public void pdisplay() {
		System.out.println("상품 조회 출력");
		System.out.println("바코드	제품이름	제품종류	제품수량	유통기한		가격");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from product"); // excuteQuery 메소드를 이용하여 select 문을 실행

			while (rs.next()) { //다음 방문할 값이 존재하는 동안 루프
				String barcode = rs.getString("barcode");
				String pname = rs.getString("pname");
				String ptype = rs.getString("ptype");
				String pamount = rs.getString("pamount");
				String expiration = rs.getString("expiration");
				int price = rs.getInt("price");							
				System.out.println(barcode+"  "+pname+"  "+ptype+"  "+pamount+"  "+expiration+" "+price);
			}
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}

	}

	//상품을 검색하는 메소드
	public void psearch(String key) {
		System.out.println("상품 검색 출력");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from product where barcode = '"+key+"'"); // excuteQuery 메소드를 이용하여 select 문을 실행
			rs.next();		
			System.out.println("상품을 찾았습니다");
			System.out.println("바코드	제품이름	제품종류	제품수량	유통기한		가격");

			String barcode = rs.getString("barcode");
			String pname = rs.getString("pname");
			String ptype = rs.getString("ptype");
			String pamount = rs.getString("pamount");
			String expiration = rs.getString("expiration");
			int price = rs.getInt("price");	
			String line =barcode+"\t"+pname+"\t"+ptype+"\t"+pamount+"\t"+expiration+"\t"+price;
			System.out.println(line);

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("찾으시는 제품이 없습니다." );
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
	}
	//고객 조회를 출력하는 메소드
	public void cdisplay() {
		System.out.println("고객 조회 출력");
		System.out.println("이름	전화번호	회원등급	적립금	나이");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from customer"); // excuteQuery 메소드를 이용하여 select 문을 실행
			while (rs.next()) { //다음 방문할 값이 존재하는 동안 루프

				String cname = rs.getString("cname");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				int saving = rs.getInt("saving");	
				int age = rs.getInt("age");	
				String line =cname+"\t"+phone+"\t"+grade+"\t"+saving+"\t"+age;
				System.out.println(line);

			}

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}

	}

	//고객을 검색하는 메소드
	public void csearch(String key) {
		System.out.println("고객 검색 출력");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from customer where phone = '"+key+"'"); // excuteQuery 메소드를 이용하여 select 문을 실행
			rs.next();		
			System.out.println("고객을 찾았습니다");
			System.out.println("이름	전화번호	회원등급	적립금	나이");			
			String cname = rs.getString("cname");
			String phone = rs.getString("phone");
			String grade = rs.getString("grade");
			int saving = rs.getInt("saving");
			int age = rs.getInt("age");
			String line =cname+"\t"+phone+"\t"+grade+"\t"+saving+"\t"+age;
			System.out.println(line);

			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("찾으시는 고객이 없습니다." );
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
	}


	public void bdisplay() {
		System.out.println("장부 출력");
		System.out.println("바코드	구매개수	제품이름	결제수단	가격");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from books"); // excuteQuery 메소드를 이용하여 select 문을 실행
			while(rs.next()) {								
				String barcode = rs.getString("barcode");
				int amount = rs.getInt("amount");
				String pname = rs.getString("pname");
				String method = rs.getString("method");
				int price = rs.getInt("price");					
				String line =barcode+"\t"+amount+"\t"+pname+"\t"+method+"\t"+price;
				System.out.println(line);

			}
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
	}

	//회원을 등록하는 메소드
	public void addCustomer(String cname, String phone, char grade, int saving,int age) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			String sql = " insert into Customer values(' "+cname+" ',' "+phone+" ',' " + grade +" ', "+ saving +" , "+age +  ")" ; 	
			stmt.executeUpdate(sql);

			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}		

		System.out.println(cname + "/" + phone  + "/" + grade   + "/"
				+ saving  + "/" + age + "/ 회원 추가 완료");	
	}


	//구매가능한 상품인지 확인하는 메소드
	public boolean checkProduct(String item, int count) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from product where barcode = '"+item+"'"); // item 으로 바코드 확인하고 
			rs.next();		

			String pamount = rs.getString("pamount");
			String exp = rs.getString("expiration");
			exp = exp.substring(0, exp.lastIndexOf('-')+3 );

			if(Integer.parseInt(pamount)<count) {
				System.out.println("재고가 부족합니다.");
			}
			else if(!isValidExp(exp)) {
				System.out.println("유통기한이 지났습니다.");
			}
			else {
				return true;
			}				
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {
		}
		return false;
	}

	private boolean isValidExp(String exp) {
		Date today = new Date();
		SimpleDateFormat  format1 = new  SimpleDateFormat("yyyy-MM-dd");
		String present = format1.format(today);
		if(exp.compareTo(present)>=0 ) {
			return true;
		}

		return false;

	}

	public void addBooks(String barcode, Integer amount, String price, String pname, String method) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			String sql = " insert into books values(' "+barcode+" ',"+ amount +",' " + pname +" ',' "+ method +" ', "+Integer.parseInt(price) +  ")" ; 	
			stmt.executeUpdate(sql);
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}		

		System.out.println(barcode + "/" + amount  + "/" + pname   + "/"
				+ method  + "/" + price + "원/ 장부 추가 완료");	
	}


	//제품개수를 조정하는 메소드
	public void renew_pamount(String key,int count) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			String chk = "SELECT barcode from PRODUCT  ";
			ResultSet rs = stmt.executeQuery(chk);
			boolean flag = false;
			while(rs.next()) {
				String tempBarcode = rs.getString("barcode");
				if(tempBarcode.equals(key)) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				String sql = "UPDATE PRODUCT SET pamount = pamount +"+ count +"where barcode ='"+ key+"'"  ;
				stmt.executeUpdate(sql);
				System.out.println("재고가 조정되었습니다");
			}
			else {
				System.err.println("바코드와 일치하는 제품이 없습니다.");
			}
			stmt.close();
			rs.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}		

	}

	//가격데이터를 넘기는  메소드
	public ArrayList<String> pricecalculation(ArrayList<String> item_list,int count) {	 
		ArrayList<String> price_list = new ArrayList<String>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  

			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select barcode,price from product"); // excuteQuery 메소드를 이용하여 select 문을 실행
			while(rs.next()) {
				String barcode = rs.getString("barcode");
				int getPrice = rs.getInt("price");
				for(String target : item_list) {
					if(target.equals(barcode)) {
						int val = count*getPrice;
						price_list.add(Integer.toString(val));	
					}
				}				
			}
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다. (이름 데이터 오류)" + se.getMessage() );
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
		return price_list;

	}

	//상품이름데이터를 넘기는  메소드
	public ArrayList<String> pnamecalculation(ArrayList<String> item_list) {	 

		ArrayList<String> pname_list = new ArrayList<String>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select barcode, pname from product"); // excuteQuery 메소드를 이용하여 select 문을 실행
			while(rs.next()) {	
				String barcode = rs.getString("barcode");
				String pname = rs.getString("pname");	
				for(String target :item_list) {
					if(target.equals(barcode)) {
						pname_list.add(pname);
					}
				}

			}
			rs.close();
			stmt.close();
		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다. (이름 데이터 오류)" + se.getMessage() );
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}
		return pname_list;

	}

	//회원인지 확인하는 메소드
	public boolean checkCustomer(String phone) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성
			ResultSet rs = stmt.executeQuery("select * from customer where phone = '"+phone+"'"); // item 으로 바코드 확인하고 
			while(rs.next()) {			
				String target = rs.getString("phone");
				if(target.equals(phone)) {
					return true;
				}
			}
			rs.close();
			stmt.close();
			return false;
		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {
		}
		return false;
	}

	// 회원인 경우 계산 
	public void membercalculation(String phone,int fee) {
		String grade = "N";
		int saving = 0;	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "db201512119",
					"201512119"); // 데이터베이스 연결  
			Statement stmt = con.createStatement(); //커넥션에서 statement 객체 생성

			ResultSet rs = stmt.executeQuery("select grade,saving from customer where phone = '"+phone+"'"); // item 으로 바코드 확인하고 

			rs.next();

			grade = rs.getString("grade");
			String prevGrade = grade;
			saving = rs.getInt("saving");

			switch (grade) {
			case "S":
				saving += fee * 0.05;
				break;
			case "A":
				saving += fee * 0.02;
				break;
			case "B":
				saving += fee * 0.01;
				break;
			default:
				System.out.println("시스템 오류");
				break;
			}

			if(saving >= 1000.0)
				grade = "S";

			else if(saving>=500.0)
				grade = "A";

			else 	grade = "B";

			String sql = "UPDATE CUSTOMER SET grade ='"+ grade+"', saving = " +saving +"where phone = '"+phone+ "' ";
			stmt.executeUpdate(sql);
			if(!prevGrade.equals(grade))
				System.out.println("등급이 갱신 되었습니다 갱신된 등급:"+ grade);

			System.out.println("적립금이 조정되었습니다 보유적립금:"+saving);


			rs.close();
			stmt.close();


		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {
		}



	}




}




