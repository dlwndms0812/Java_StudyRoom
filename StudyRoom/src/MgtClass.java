import java.util.ArrayList;

public class MgtClass {
	
	private RoomClass[] roomArray=new RoomClass[100]; //�� ��ü �迭
	private int[] totalIncome=new int[31]; //��¥�� ����
	private int checkNumRoom=0; //�� ����
	
	//������
	MgtClass(){
		
	}
	
	//�� ����
	void resRoom(String room, int maxPeople, int fee) {
		checkNumRoom++;
		roomArray[checkNumRoom]=new RoomClass(room, maxPeople, fee);
		roomArray[checkNumRoom].setRoom(room);
	}
	
	//�� ����
	boolean remRoom(String roomName) throws Exception {
		boolean remove=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
		    if(roomName.equals(roomArray[i].getRoom())) {
		    	remove=true;
		    	for(int j=i;j<checkNumRoom;j++) {
		    	    roomArray[j]=roomArray[j+1];  //�� �迭�� �ε����� �ϳ��� ����
		    	}
		    	checkNumRoom--;
		    	return remove;
		    }
		}
		if(!remove) {
			throw new Exception(roomName+"���� �������� ���߽��ϴ�.");
		}
		return remove;
	}
	
	
	//�� �����ֱ�
	ArrayList<String> showRoom() throws Exception {
		ArrayList<String> currentRoom=new ArrayList<String>();
	
		if(checkNumRoom!=0) {
    	    for(int i=1;i<=checkNumRoom;i++) {
    	        currentRoom.add(roomArray[i].getRoom());    
    	    }
    	    return (currentRoom);
		}
		else
			throw new Exception("������ ���� �����ϴ�.");
    		
    }
	
	//�� ã��
	ArrayList<String> searchRoom(int peopleNum) throws Exception {
		ArrayList<String> currentRoom=new ArrayList<String>();
		boolean check=false;
		
    	for(int i=1;i<=checkNumRoom;i++) {
    		if(roomArray[i].getPeople()==peopleNum&&roomArray[i].statusRoom()==false) {
    			currentRoom.add(roomArray[i].getRoom()); 
    			check=true;
    	    }
    	}
    	
    	if(check) {
    		return (currentRoom);
    	}
    	else
    		throw new Exception("���� �����ϴ�.");
    		
    		
    }
	
	//üũ��
	void checkIn(String room, String name, int enter) throws Exception{
		boolean check=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
			if(room.equals(roomArray[i].getRoom())) {
				roomArray[i].useRoom();
				roomArray[i].setUser(name);
				roomArray[i].setEnter(enter);
				check=true;
			}
		}
		
		if(!check){
			throw new Exception("üũ�� �� �� �����ϴ�.");
		}
	}
	
	
	//üũ�ƿ�
	int checkOut(String room, String name, int exit, int day) throws Exception{
		boolean check=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
			if(room.equals(roomArray[i].getRoom())) {
				roomArray[i].notuseRoom();
				roomArray[i].setExit(exit);
				roomArray[i].setPay(roomArray[i].getEnter(),roomArray[i].getExit());
				check=true;
				setIncome(day, i);
				int money=roomArray[i].getPay();
				return money;
			}
		}
		
		if(!check){
			throw new Exception("�ش� ���� �����ϴ�.");
		}
		return 0;
	}
	
	//���� �����ϱ�
	void setIncome(int day, int roomNum) {
		totalIncome[day]+=roomArray[roomNum].getPay();
	}
	
	//���� �����ֱ�
	int showIncome(int day) {
		return totalIncome[day];
	}
	
}
