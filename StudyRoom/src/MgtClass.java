
public class MgtClass {
	int day;
	int peopleNum;
	RoomClass[] roomArray=new RoomClass[100];
	int[] totalIncome=new int[31];
	int income;
	static int checkNumRoom=0;
	int roomNum;
	
	
	int searchPay(int day) {
		return day;
	}
	
    int todayIncome(int income) {
		return income;
	}
	
	int total(int totalIncome[], int day) {
		return totalIncome[day];
	}
	
	void searchRoom(int peopleNum) {
		for(int i=0;i<checkNumRoom;i++) {
			if(roomArray[checkNumRoom].status==false&&roomArray[checkNumRoom].getPeople()==peopleNum) {
				System.out.println(checkNumRoom+"�� ���� ������ϴ�.");
			}
			else
				System.out.println("�ش��ϴ� ���� �����ϴ�.");
		}
	}
	
	void resRoom(int peopleNum) {
		checkNumRoom++;
		roomArray[checkNumRoom]=new RoomClass();
		roomArray[checkNumRoom].setPeople(peopleNum);
	}
	
	void remRoom(int roomNum) {
		try {
		    roomArray[roomNum].setPeople(0);
		    System.out.println(roomNum+"�� ���� �����Ǿ����ϴ�.");
			System.out.println(" ");
		}
		catch(NullPointerException e) {
			System.out.println("�� ��ȣ�� �߸��Ǿ����ϴ�.");
			System.out.println(" ");
		}
	}
	
    void showRoom() {
    	for(int i=0;i<checkNumRoom;i++) {
    		System.out.println(checkNumRoom+"�� ��, �ִ� �ο���"+roomArray[checkNumRoom].getPeople()+"��");
    	}
    }

}
