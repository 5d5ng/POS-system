package MarketPos;

import java.util.Scanner;

public class MainPOS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("����Ͻ÷��� ����� ������ �ּ���");
		System.out.println("\t 1. ������");
		System.out.println("\t 2. �Ǹ���");
		String result ;

		while (true) {
			result = sc.next();
			if(result.equals("1") )//������
			{
				AdministratorProgram administor = new AdministratorProgram();
				administor.check();
				break;
			}
			else if(result.equals("2") )//�Ǹ���
			{
				SellerProgram seller = new SellerProgram();
				seller.go();

				break;

			}
			else {
				System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
				continue;
			}




		}
		sc.close();

	}
}
