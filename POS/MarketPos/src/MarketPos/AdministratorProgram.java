package MarketPos;
import java.util.Scanner;
public class AdministratorProgram {
	public static Scanner scan;//글을 입력하는 것.
	public static DBconnector dbconnecter;//DBconnector class를 상속.
	

	
	public AdministratorProgram() {
		scan = new Scanner(System.in);//글을 입력하는 객체 생성
		this.dbconnecter = new DBconnector();
	}
	
	public void check() {
		System.out.println("관리자 패스워드를 입력해주세요.(종료 시 'N' 입력)");
		String PW = scan.next();
		if(dbconnecter.checkPw(PW)) {
			go();
		}
		else if(PW.equalsIgnoreCase("N")) {
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		else {
			System.out.println("패스워드가 맞지 않습니다.");
		}
		
	}

	public void go() {//DBconnector class 연결.
		System.out.println("관리자 프로그램을 시작합니다.");
		start();//start 메소드 연결
	}
	
	   //메뉴 메소드
		public void start() {
			while (true) {
				
				System.out.println("=======================");
				System.out.println("사용하시려는 기능을 선택해 주세요");
				System.out.println("-----------------------");
				System.out.println("\t 1. 물품 관리 및 조회");
				System.out.println("\t 2. 고객 조희");
				System.out.println("\t 3. 장부 조회");
				System.out.println("\t 4. 종료");
				System.out.println("=======================");

				String result = scan.next();

				switch (result) {
				case "1"://관리 및 조회
					ProductCheck();
					break;
				case "2": //고객조회
					CustomerCheck();
					break;
				case "3":
					dbconnecter.bdisplay();
					break;
				case "4"://종료
					System.out.println("시스템을 종료합니다.");
					break;
				default:
					System.out.println("입력이 잘못 되었습니다.");
					break;
				}
				if (result.equals("4"))
					break;
			}
		}
		
		public void ProductCheck() {
			System.out.println("=======================");
			System.out.println("물품 관리 및 조회를 시작합니다.");
			System.out.println("-----------------------");
			System.out.println("\t 1. 상품 등록.");
			System.out.println("\t 2. 상품 조회.");
			System.out.println("\t 3. 상품 검색.");
			System.out.println("\t 4. 재고 추가.");
			System.out.println("\t 5. 종료.");
			System.out.println("=======================");

			String result = scan.next();

			switch (result) {
			case "1":
				product_add();
				break;
			case "2":
				dbconnecter.pdisplay();
				break;
			case "3":
				System.out.println("상품 바코드를 입력해주세요");
				String key = scan.next();
				dbconnecter.psearch(key);
				break;
			case "4":
				product_update();
			default:
				break;
			}
		}
		

		private void product_update() {	
			System.out.println("추가할 제품의 바코드를 입력하세요");
			String barcode = scan.next();
			System.out.println("추가된 재고를 입력하세요");
			int increaseAmount = scan.nextInt();
			
			dbconnecter.renew_pamount(barcode,increaseAmount);
		
		}

		public void product_add() {
			
			String barcode; //바코드
			String pname; //제품이름
			String ptype; //제품종류
			String pamount; //제품수량
			String expiration; //유통기한
			int price; //제품가격
			

			System.out.println("상품 추가를 시작합니다.");
			System.out.println("바코드를 입력해 주세요");
			barcode = scan.next();
			System.out.println("제품이름 입력해 주세요");
			pname = scan.next();
			System.out.println("제품종류 입력해 주세요");
			ptype = scan.next();
			System.out.println("제품수량 입력해 주세요");
			pamount = scan.next();
			System.out.println("유통기한 입력해 주세요");
			expiration = scan.next();
			System.out.println("가격 입력해 주세요");
			price = scan.nextInt();
						
			dbconnecter.addProduct(barcode, pname,ptype, pamount, expiration,price);//값 저장.
			System.out.println("등록이 완료 되었습니다.");
		}
		
		public void CustomerCheck() {
			System.out.println("=======================");
			System.out.println("고객조회를 시작합니다.");
			System.out.println("-----------------------");
			System.out.println("\t 1. 고객조회.");
			System.out.println("\t 2. 고객검색.");
			System.out.println("\t 3. 종료.");
			System.out.println("=======================");

			String result = scan.next();

			switch (result) {
			case "1":
				dbconnecter.cdisplay();
				break;
			case "2":
				System.out.println("고객전화번호를 입력해주세요(ex-0101234)");
				String key = scan.next();
				dbconnecter.csearch(key);
				break;
			default:
				break;
			}
		}

			
		
 
}
