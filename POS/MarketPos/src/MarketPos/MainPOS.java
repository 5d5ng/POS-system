package MarketPos;

import java.util.Scanner;

public class MainPOS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("사용하시려는 기능을 선택해 주세요");
		System.out.println("\t 1. 관리자");
		System.out.println("\t 2. 판매자");
		String result ;

		while (true) {
			result = sc.next();
			if(result.equals("1") )//관리자
			{
				AdministratorProgram administor = new AdministratorProgram();
				administor.check();
				break;
			}
			else if(result.equals("2") )//판매자
			{
				SellerProgram seller = new SellerProgram();
				seller.go();

				break;

			}
			else {
				System.out.println("입력이 잘못 되었습니다.");
				continue;
			}




		}
		sc.close();

	}
}
