import java.util.Scanner;

public class StudyRoom {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		MgtClass mc=new MgtClass();
		int menu=0;
		while(menu!=4) {
			System.out.println("�޴��� �������ּ���");
			System.out.println("1.�� ����");
			System.out.println("2.�� ����");
			System.out.println("3.�� �� ã��");
			System.out.println("4.����");
			
			menu=sc.nextInt();
		
			
			if(menu==1) {
				System.out.println("���ο��� ���� �����Ͻðڽ��ϱ�?");
				int people;
				people=sc.nextInt();
				mc.resRoom(people);
				System.out.println(people+"�ο��� ���� �����Ǿ����ϴ�.");
				System.out.println(" ");
			}
			
			else if(menu==2) {
				System.out.println("� ���� �����Ͻðڽ��ϱ�?");
				mc.showRoom();
				int delete;
				delete=sc.nextInt();
				mc.remRoom(delete);
				
			}
			
			else if(menu==3) {
				System.out.println("���ο� ���� �˻��Ͻðڽ��ϱ�?");
				int people;
				people=sc.nextInt();
				mc.searchRoom(people);
				System.out.println(" ");
				
			}
			
			else if(menu==4) {
				System.out.println("�����մϴ�.");
				break;
			}
			else {
				System.out.println("���ڸ� �ٽ� �Է��ϼ���");
				System.out.println(" ");
			}
		}
	}
   
}


