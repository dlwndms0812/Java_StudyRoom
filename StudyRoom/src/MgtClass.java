import java.util.ArrayList;

public class MgtClass {
	
	private RoomClass[] roomArray=new RoomClass[100]; //방 객체 배열
	private int[] totalIncome=new int[31]; //날짜별 매출
	private int checkNumRoom=0; //방 개수
	
	//생성자
	MgtClass(){
		
	}
	
	//방 생성
	void resRoom(String room, int maxPeople, int fee) {
		checkNumRoom++;
		roomArray[checkNumRoom]=new RoomClass(room, maxPeople, fee);
		roomArray[checkNumRoom].setRoom(room);
	}
	
	//방 삭제
	boolean remRoom(String roomName) throws Exception {
		boolean remove=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
		    if(roomName.equals(roomArray[i].getRoom())) {
		    	remove=true;
		    	for(int j=i;j<checkNumRoom;j++) {
		    	    roomArray[j]=roomArray[j+1];  //방 배열의 인덱스를 하나씩 당기기
		    	}
		    	checkNumRoom--;
		    	return remove;
		    }
		}
		if(!remove) {
			throw new Exception(roomName+"방을 삭제하지 못했습니다.");
		}
		return remove;
	}
	
	
	//방 보여주기
	ArrayList<String> showRoom() throws Exception {
		ArrayList<String> currentRoom=new ArrayList<String>();
	
		if(checkNumRoom!=0) {
    	    for(int i=1;i<=checkNumRoom;i++) {
    	        currentRoom.add(roomArray[i].getRoom());    
    	    }
    	    return (currentRoom);
		}
		else
			throw new Exception("생성된 방이 없습니다.");
    		
    }
	
	//방 찾기
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
    		throw new Exception("방이 없습니다.");
    		
    		
    }
	
	//체크인
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
			throw new Exception("체크인 할 수 없습니다.");
		}
	}
	
	
	//체크아웃
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
			throw new Exception("해당 방이 없습니다.");
		}
		return 0;
	}
	
	//매출 설정하기
	void setIncome(int day, int roomNum) {
		totalIncome[day]+=roomArray[roomNum].getPay();
	}
	
	//매출 보여주기
	int showIncome(int day) {
		return totalIncome[day];
	}
	
}
