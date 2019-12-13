package MarketPos;
import java.util.Scanner;
public class AdministratorProgram {
	public static Scanner scan;//���� �Է��ϴ� ��.
	public static DBconnector dbconnecter;//DBconnector class�� ���.
	

	
	public AdministratorProgram() {
		scan = new Scanner(System.in);//���� �Է��ϴ� ��ü ����
		this.dbconnecter = new DBconnector();
	}
	
	public void check() {
		System.out.println("������ �н����带 �Է����ּ���.(���� �� 'N' �Է�)");
		String PW = scan.next();
		if(dbconnecter.checkPw(PW)) {
			go();
		}
		else if(PW.equalsIgnoreCase("N")) {
			System.out.println("���α׷��� �����մϴ�.");
			return;
		}
		else {
			System.out.println("�н����尡 ���� �ʽ��ϴ�.");
		}
		
	}

	public void go() {//DBconnector class ����.
		System.out.println("������ ���α׷��� �����մϴ�.");
		start();//start �޼ҵ� ����
	}
	
	   //�޴� �޼ҵ�
		public void start() {
			while (true) {
				
				System.out.println("=======================");
				System.out.println("����Ͻ÷��� ����� ������ �ּ���");
				System.out.println("-----------------------");
				System.out.println("\t 1. ��ǰ ���� �� ��ȸ");
				System.out.println("\t 2. �� ����");
				System.out.println("\t 3. ��� ��ȸ");
				System.out.println("\t 4. ����");
				System.out.println("=======================");

				String result = scan.next();

				switch (result) {
				case "1"://���� �� ��ȸ
					ProductCheck();
					break;
				case "2": //����ȸ
					CustomerCheck();
					break;
				case "3":
					dbconnecter.bdisplay();
					break;
				case "4"://����
					System.out.println("�ý����� �����մϴ�.");
					break;
				default:
					System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
					break;
				}
				if (result.equals("4"))
					break;
			}
		}
		
		public void ProductCheck() {
			System.out.println("=======================");
			System.out.println("��ǰ ���� �� ��ȸ�� �����մϴ�.");
			System.out.println("-----------------------");
			System.out.println("\t 1. ��ǰ ���.");
			System.out.println("\t 2. ��ǰ ��ȸ.");
			System.out.println("\t 3. ��ǰ �˻�.");
			System.out.println("\t 4. ��� �߰�.");
			System.out.println("\t 5. ����.");
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
				System.out.println("��ǰ ���ڵ带 �Է����ּ���");
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
			System.out.println("�߰��� ��ǰ�� ���ڵ带 �Է��ϼ���");
			String barcode = scan.next();
			System.out.println("�߰��� ��� �Է��ϼ���");
			int increaseAmount = scan.nextInt();
			
			dbconnecter.renew_pamount(barcode,increaseAmount);
		
		}

		public void product_add() {
			
			String barcode; //���ڵ�
			String pname; //��ǰ�̸�
			String ptype; //��ǰ����
			String pamount; //��ǰ����
			String expiration; //�������
			int price; //��ǰ����
			

			System.out.println("��ǰ �߰��� �����մϴ�.");
			System.out.println("���ڵ带 �Է��� �ּ���");
			barcode = scan.next();
			System.out.println("��ǰ�̸� �Է��� �ּ���");
			pname = scan.next();
			System.out.println("��ǰ���� �Է��� �ּ���");
			ptype = scan.next();
			System.out.println("��ǰ���� �Է��� �ּ���");
			pamount = scan.next();
			System.out.println("������� �Է��� �ּ���");
			expiration = scan.next();
			System.out.println("���� �Է��� �ּ���");
			price = scan.nextInt();
						
			dbconnecter.addProduct(barcode, pname,ptype, pamount, expiration,price);//�� ����.
			System.out.println("����� �Ϸ� �Ǿ����ϴ�.");
		}
		
		public void CustomerCheck() {
			System.out.println("=======================");
			System.out.println("����ȸ�� �����մϴ�.");
			System.out.println("-----------------------");
			System.out.println("\t 1. ����ȸ.");
			System.out.println("\t 2. ���˻�.");
			System.out.println("\t 3. ����.");
			System.out.println("=======================");

			String result = scan.next();

			switch (result) {
			case "1":
				dbconnecter.cdisplay();
				break;
			case "2":
				System.out.println("����ȭ��ȣ�� �Է����ּ���(ex-0101234)");
				String key = scan.next();
				dbconnecter.csearch(key);
				break;
			default:
				break;
			}
		}

			
		
 
}
