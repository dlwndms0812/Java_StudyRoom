import java.util.Scanner;


public class StudyRoom {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in); 
		MgtClass mc=new MgtClass(); //MgtClass ��ü ����
		
		int mode=0;
		
	
		while(true) {
			System.out.println("��带 �������ּ���");
			System.out.println("1.����� ���");
			System.out.println("2.������ ���");
			System.out.println("3.����");
			
			
			mode=sc.nextInt();
		    
			//1.����� ���
			if(mode==1) {
				while(true) {
				    int menu=0;
				    System.out.println(" ");
			     	System.out.println("����� ����Դϴ�.���Ͻô� �޴��� �������ּ���");
				    System.out.println("1.�� �˻�");
				    System.out.println("2.�Խ�");
				    System.out.println("3.���");
				    System.out.println("4.����");
				
				    menu=sc.nextInt();
				    sc.nextLine();
				    
				    if(menu==1) {
				    	System.out.println(" ");
				    	System.out.println("��� �ο��� �Է��ϼ���");
					    int people;
					    people=sc.nextInt();
					    try {
						    System.out.println("��� ������ ����");
						    System.out.println(mc.searchRoom(people)+"�Դϴ�.");
					    }
					    catch(Exception e){
						    System.out.println("��� ������ ���� �����ϴ�");
					    }
				    }
				    
				    else if(menu==2) {
					    System.out.println(" ");
					    System.out.println("�Խ��ϱ� ���ϴ� ���� �̸��� �Է��ϼ���");
					    String room=sc.nextLine();
					    System.out.println("����� �̸��� �Է��ϼ���");
					    String name=sc.nextLine();
				    	System.out.println("�Խ� �ð��� �Է��ϼ��� ��:���� 3�� 30���̸� 1530���� �Է�");
					    int enter=sc.nextInt();
					    try {
					        mc.checkIn(room, name, enter);
					        System.out.println("�Խ� ó���Ǿ����ϴ�.");
					    }
					    catch(Exception e) {
						    System.out.println("�Խǿ� �����Ͽ����ϴ�.");
					    }
				    }
				    else if(menu==3) {
				    	System.out.println(" ");
					    System.out.println("����ϱ� ���ϴ� ���� �̸��� �Է��ϼ���");
					    String room=sc.nextLine();
					    System.out.println("����� �̸��� �Է��ϼ���");
					    String name=sc.nextLine();
					    System.out.println("���� ��¥�� �Է����ּ���.");
					    int day=sc.nextInt();
				    	System.out.println("��� �ð��� �Է��ϼ��� ��:���� 3�� 30���̸� 1530���� �Է�");
					    int exit=sc.nextInt();
					    try {
					        System.out.println("����� "+mc.checkOut(room, name, exit,day)+"�� �Դϴ�.");
					        System.out.println("��� ó���Ǿ����ϴ�.");
					        
					    }
					    catch(Exception e) {
						    System.out.println("��ǿ� �����Ͽ����ϴ�.");
					    }
					
				    }
				    else if(menu==4) {
				    	System.out.println(" ");
				    	System.out.println("����� ��带 �����մϴ�.");
				    	System.out.println(" ");
				    	break;
				    }
				    
				    else {
					    System.out.println(" ");
					    System.out.println("���ڸ� �ٽ� �Է��ϼ���");
					    System.out.println(" ");
				    }
				}
			}
			
			//2.������ ���
			else if(mode==2) {
				while(true) {
				    int menu=0;
				    System.out.println(" ");
				    System.out.println("������ ����Դϴ�. ���Ͻô� �޴��� �������ּ���");
				    System.out.println("1.�� ����");
				    System.out.println("2.�� ����");
				    System.out.println("3.���� �˻�");
				    System.out.println("4.�� ��Ȳ");
				    System.out.println("5.����");
				
				    menu=sc.nextInt();
				    sc.nextLine();
				    
				    if(menu==1) {
				    	System.out.println(" ");
				    	System.out.println("�� �̸��� �������ּ���");
				    	String room=sc.nextLine();
				    	System.out.println("�� �ִ��ο��� �������ּ���");
				    	int maxPeople=sc.nextInt();
				    	System.out.println("���� ����� �������ּ���(1�д���)");
				    	int fee=sc.nextInt();
				    	mc.resRoom(room, maxPeople, fee);
				    	System.out.println("���� �����Ǿ����ϴ�.");
				    }
				    
				    else if(menu==2) {
				    	System.out.println(" ");
				    	System.out.println("������ ���� �̸��� �Է����ּ���");
				    	String room=sc.nextLine();
				    	try {
				    	    mc.remRoom(room);
				    	    System.out.println("���� �����߽��ϴ�.");
				    	}
				    	catch(Exception e) {
				    		System.out.println("���� �������� ���߽��ϴ�.");
				    	}
				    }
				    
				    else if(menu==3) {
				    	System.out.println(" ");
				    	System.out.println("���� �˻��� ���ϴ� ��¥�� �Է����ּ���");
				    	int day=sc.nextInt();
				    	System.out.println(day+"�� �� ������ "+mc.showIncome(day)+"�� �Դϴ�.");
				    }
				    
				    else if(menu==4) {
				    	System.out.println(" ");
				    	System.out.println("���� ������ ���� ����Դϴ�.");
				    	try {
				    	    System.out.println(mc.showRoom());
				    	}
				    	catch(Exception e) {
				    		System.out.println("������ ���� �����ϴ�.");
				    	}
				    }
				    
				    else if(menu==5) {
				    	System.out.println(" ");
				    	System.out.println("������ ��带 �����մϴ�.");
	                    break;
				    }
				
				    else {
					    System.out.println(" ");
					    System.out.println("���ڸ� �ٽ� �Է��ϼ���");
					    System.out.println(" ");
				    }
				 
				}
			}
			
			//3.����
			else if(mode==3) {
				System.out.println(" ");
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


