package MarketPos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SellerProgram {
	Scanner scan;//글을 입력하는 것.
	DBconnector dbconnecter;//DBconnector class를 상속.
	String user_num = "";//고객 번호

	
	public SellerProgram() {
		scan = new Scanner(System.in);//글을 입력하는 객체 생성
	}

	public void go() {//DBconnector class 연결.
		System.out.println("판매자 프로그램을 시작합니다.");
		dbconnecter = new DBconnector();//객체 생성
		start();//start 메소드 연결
	}

   //메뉴 메소드
	public void start() {
		while (true) {
			System.out.println("사용하시려는 기능을 선택해 주세요");

			System.out.println("\t 1. 회원 추가");
			System.out.println("\t 2. 물건 구매");
			System.out.println("\t 3. 종료");

			String result = scan.next();//6개의 기능 중 1개 입력

			switch (result) {
			case "1"://회원 추가
			    customer_add();//메소드 이동
				break;
			case "2"://물건 구매
				print_start();
				purchase();
				print_finish();
				break;
			case "3"://종료
				System.out.println("시스템을 종료합니다.");
				System.exit(1);
			default:
				System.out.println("입력이 잘못 되었습니다.");
				break;
			}
		}
	}



	//고객 등록 메소드
	public void customer_add() {
		
		String cname; //이름
		String phone; //전화번호
		char grade ='B'; //멤버등급
		int saving = 0; //적립금
		int age; //나이
		

		System.out.println("회원등록을 시작합니다.");
		System.out.println("이름을 입력해 주세요");
		cname = scan.next();
		System.out.println("전화번호를 입력해 주세요");
		phone = scan.next();
		System.out.println("나이 입력해 주세요");
		age = scan.nextInt();
					
		dbconnecter.addCustomer(cname, phone, grade, saving,age);//값 저장.
		System.out.println("등록이 완료 되었습니다.");
	}
	
	

	public void purchase() {
		
		String cardnum=null;
		int cash=0;
		int fee;
		int balance=0;
		
		System.out.println("지금부터 상품 구매를 시작하겠습니다.");
		ArrayList<String> prod_item_list = new ArrayList<String>(); //상품 바코드
		ArrayList<Integer> prod_count_list = new ArrayList<Integer>();//상품 개수
		ArrayList<String> prod_price_list;   //상품가격   
		ArrayList<String> prod_pname_list;   //상품이름
		int count = 0;
		while (true) {//무한루프(break 될때까지 반복)
			System.out.println("바코드를 입력해주세요");
			String item = scan.next();
			System.out.println("물품개수를 입력해주세요");
			 count = scan.nextInt();
			if(dbconnecter.checkProduct(item,count)) {
			prod_item_list.add(item);//구매하려는 물품의 바코드를 물품 번호 list에 저장
			prod_count_list.add(count);//구매하려는 물품의 개수를 list에 저장
			}
			System.out.println("구매종료시 1 입력/ 추가로 구매는 아무키 입력.");
			if (scan.next().equals("1"))//1누르면 구매 메소드에서 나감.
				break;
		}
		
		prod_price_list = dbconnecter.pricecalculation(prod_item_list,count); 
		prod_pname_list = dbconnecter.pnamecalculation(prod_item_list);
		fee = calculation(prod_price_list,prod_count_list);
			
		
		System.out.println("=======================");
		System.out.println("회원여부를 선텍헤 주세요");
		System.out.println("-----------------------");
		System.out.println("\t 1. 회원구매.");
		System.out.println("\t 2. 비회원구매.");
		System.out.println("\t 3. 종료.");
		System.out.println("=======================");
		

		String result = scan.next();

		switch (result) {
		case "1":
			System.out.println("회원 폰번호를 입력해주세요");
			String phone = scan.next();
			if(dbconnecter.checkCustomer(phone)) dbconnecter.membercalculation(phone,fee);
			else checkRegister(phone,fee);
			
			
			break;
		case "2":
			break;
		case "3":
			System.out.println("시스템을 종료합니다.");
			System.exit(1);
		default:
			return;
		}
		
		System.out.println("=======================");
		System.out.println("결제 방법을 선택해 주십시오.");
		System.out.println("-----------------------");
		System.out.println("\t1. 현금");
		System.out.println("\t2. 신용카드");
		System.out.println("\t3. 종료");
		System.out.println("=======================");
		
	
		String result2 = scan.next();
		switch (result2) {
		case "1":
			System.out.println("낸 금액을 입력하시오");
			cash = scan.nextInt();
			balance = cashcalculation(cash,fee);
			break;
		case "2": 
			System.out.println("카드번호를 입력하시오");
			cardnum = scan.next();
			break;
		case "3"://종료
			System.out.println("시스템을 종료합니다.");
			System.exit(1);
		default:
			System.out.println("잘못된 입력값입니다.");
			break;
	
		}
		
		books_add(prod_item_list,prod_count_list,prod_price_list,prod_pname_list,cash);
		
		//재고 정리 기능 필요
		product_print(prod_pname_list,prod_count_list,prod_price_list,fee,cash);
	}

	private void product_print(ArrayList<String> pname_list, ArrayList<Integer> count_list,ArrayList<String> price_list, int fee, int cash) {
		
		
		for(int i=0;i<pname_list.size();i++) {
			System.out.println("상품명: "+ pname_list.get(i) +"개수"+ count_list.get(i));
			
		}
		System.out.println("총액:"+fee);
		System.out.println("받은 금액:"+cash);
		
	
	}

	private void books_add(ArrayList<String> item_list,ArrayList<Integer> count_list,ArrayList<String> price_list,ArrayList<String> pname_list,int cash) {
		for(int i = 0;i<item_list.size();i++) {
			if(cash != 0)
			dbconnecter.addBooks(item_list.get(i), count_list.get(i), price_list.get(i), pname_list.get(i),"cash");//값 저장.
			else dbconnecter.addBooks(item_list.get(i), count_list.get(i), price_list.get(i), pname_list.get(i),"card");
		}
		System.out.println("장부 기록이 완료되었습니다.");
		
	}
	
	//fee를 계산하는 메소드
	public int calculation(ArrayList<String> prod_count_price,ArrayList<Integer> count_list) {	//물품 번호,물품 개수를 이용해서 비용을 확인 
		int fee =0;
		
		for (int i = 0; i < count_list.size(); i++) {
			fee += Integer.parseInt(prod_count_price.get(i))
					* count_list.get(i);
		}

		System.out.println(count_list.size() + "개/ 총 금액 계산완료 =" + fee);// 구입물품의 개수, 총 금액 출력
		return fee; //총금액 호출
	}

	private int cashcalculation(int cash, int fee) {
		int balance = cash - fee;
		System.out.println("받은돈 = "+ cash+"  거스름돈 = "+ balance);
		return cash-fee;	
	}

	private void checkRegister(String phone, int fee) {
		System.out.println("=======================");
		System.out.println("회원등록을 하시겠습니까");
		System.out.println("-----------------------");
		System.out.println("\t 1. 네.");
		System.out.println("\t 2. 아니요.");
		System.out.println("\t 3. 종료.");
		System.out.println("=======================");
		
		String result = scan.next();

		switch (result) {
		case "1":
			customer_add();
			dbconnecter.membercalculation(phone,fee);
			break;
		case "2":
			break;
		case "3" :
			System.out.println("시스템을 종료합니다.");
			System.exit(1);
		}
		
	}
	
	private void print_finish() {
		System.out.println("영수증을 출력하였습니다.");
	}

	private void print_start() { 
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("receipt.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
