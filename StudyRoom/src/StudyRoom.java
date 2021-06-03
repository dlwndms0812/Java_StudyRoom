import java.util.Scanner;

public class StudyRoom {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		MgtClass mc=new MgtClass();
		int menu=0;
		while(menu!=4) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1.룸 생성");
			System.out.println("2.룸 삭제");
			System.out.println("3.빈 방 찾기");
			System.out.println("4.종료");
			
			menu=sc.nextInt();
		
			
			if(menu==1) {
				System.out.println("몇인용의 방을 생성하시겠습니까?");
				int people;
				people=sc.nextInt();
				mc.resRoom(people);
				System.out.println(people+"인용의 방이 생성되었습니다.");
				System.out.println(" ");
			}
			
			else if(menu==2) {
				System.out.println("어떤 방을 삭제하시겠습니까?");
				mc.showRoom();
				int delete;
				delete=sc.nextInt();
				mc.remRoom(delete);
				
			}
			
			else if(menu==3) {
				System.out.println("몇인용 방을 검색하시겠습니까?");
				int people;
				people=sc.nextInt();
				mc.searchRoom(people);
				System.out.println(" ");
				
			}
			
			else if(menu==4) {
				System.out.println("종료합니다.");
				break;
			}
			else {
				System.out.println("숫자를 다시 입력하세요");
				System.out.println(" ");
			}
		}
	}
   
}


