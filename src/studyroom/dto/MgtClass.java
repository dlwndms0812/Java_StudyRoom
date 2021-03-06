package studyroom.dto;
import java.util.ArrayList;
import java.util.Arrays;

import studyroom.dao.StudyRoomDao;
import studyroom.gui.UserGUI;

public class MgtClass {
	private StudyRoomDao dao=new StudyRoomDao();
	private RoomClass[] roomArray=new RoomClass[100]; //방 객체 배열
	private int[] totalIncome=new int[31]; //날짜별 매출
	private int checkNumRoom=0; //방 개수
    
	//생성자
	public MgtClass(){
		
	}
	
	//방 생성
	public void resRoom(String room, int maxPeople, int fee) {
		dao.resRoomdb(room, maxPeople, fee);
		//삭제 해야하나??
		checkNumRoom++;
		roomArray[checkNumRoom]=new RoomClass();
		roomArray[checkNumRoom].roomClass(room, maxPeople, fee);
		roomArray[checkNumRoom].setRoom(room);
	}
	
	//방 삭제
	public void remRoom(String roomName) {//throws Exception {
		
		/*boolean remove=false;
		
		
		for(int i=1;i<=checkNumRoom;i++) {
		    if(roomName.equals(roomArray[i].getRoom())) {
		    	remove=true;
		    	for(int j=i;j<checkNumRoom;j++) {
		    	    roomArray[j]=roomArray[j+1];  //방 배열의 인덱스를 하나씩 당기기
		    	}
		    	dao.remRoomdb(roomName);
		    	checkNumRoom--;
		    	return remove;
		    }
		}
		if(!remove) {
			throw new Exception(roomName+"방을 삭제하지 못했습니다..");
		}
		return remove;
		*/
		try {
			dao.remRoomdb(roomName);
		
		} catch(Exception ee) {
			
		}
	}
	
	
	//방 보여주기
	public ArrayList showRoom() throws Exception {
		//String[] arr=new String[15];
		//int cnt=0;
		ArrayList<String> list=new ArrayList<String>();
		//if(checkNumRoom!=0) {
    	    //for(int i=1;i<=checkNumRoom;i++) {
    	    	//String st=roomArray[i].getRoom();
    	       // arr[cnt]=st;
    	       // cnt++;
    	   // }
    	  // String str= Arrays.toString(arr);
    	   //return (str);
			
			//return dao.showRoomdb();
		//}
		//else
		//	throw new Exception("생성된 방이 없습니다.");
    	try {
    		return dao.showRoomdb();
    		
    	} catch(Exception e) {
    		list.add("생성된 방이 없습니다");
    		return list;
    	}
    	
    }
	
	//방 찾기
	public String searchRoom(int peopleNum) { //throws Exception {
		String[] arr=new String[15];
		boolean check=false;
		int cnt=0;
		
    	/*for(int i=1;i<=checkNumRoom;i++) {
    		if(roomArray[i].getPeople()==peopleNum&&roomArray[i].statusRoom()==false) {
    			String st=roomArray[i].getRoom();
    	        arr[cnt]=st;
    	        cnt++;
    			check=true;
    			
    	    }
    	}*/
    	String str=dao.searchRoomdb(peopleNum)+"";
    	return str;
    	/*if(check) {
    	    String str= Arrays.toString(arr);
     	    return (str);
    	}
    	else
    		throw new Exception("방이 없습니다.");
    		
    		*/
    }
	
	//체크인
	public void checkIn(String room, String name, int enter) {//throws Exception{
		/*boolean check=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
			if(room.equals(roomArray[i].getRoom())) {
				
				roomArray[i].checkIn(name,enter);
				check=true;
			}
		}*/
		try {
		    dao.checkindb(room, name, enter);
		}
		catch(Exception e) {
			UserGUI user=new UserGUI();
			user.setjl2("입실에 실패했습니다");
		    //("입실에 실패했습니다.");
		}	
			//if(!check){
		
		//	throw new Exception("체크인 할 수 없습니다.");
		//}
	}
	
	
	//체크아웃
	public int checkOut(String room, String name, int exit, int day) throws Exception{
		/*
		boolean check=false;
		
		for(int i=1;i<=checkNumRoom;i++) {
			if(room.equals(roomArray[i].getRoom())) {
				dao.checkoutdb(room, name, exit);
				roomArray[i].checkOut(exit);
				check=true;
				int fee=dao.fee(room); //여기서 요금을 얻어오고
				dao.total(day, fee); //여기다 오늘 날짜의 요금 더하기
				int money=roomArray[i].getPay();
				return fee;
			}
		}
		
		if(!check){
			throw new Exception("해당 방이 없습니다.");
		}*/
		dao.checkoutdb(room, name, exit);
		//System.out.println("체크아웃 완료");
		int fee=dao.fee(room); //여기서 요금을 얻어오고
		//System.out.println("fee 완료");
		//dao.total(day, fee); //여기다 오늘 날짜의 요금 더하기  //여기가 문제
		//System.out.println("total 완료");
		
		//day 데베 만들기
		dao.setday(day);
		//기존의 day의 요금 가져와서 +fee 하기
		int i=dao.get_fee(day);
		int new_fee=i+fee;
		//day에 요금 입력
		dao.checkout_fee(day, new_fee);
		return fee;
	}
	
	//매출 설정하기
	public void setIncome(int day) { //roomNum 대신에 방 이름으로 바꿔야 할 듯, 위에 체크아웃도 바꾸기
		//totalIncome[day]+=roomArray[roomNum].getPay();
	    int t=dao.total(day, 0);
		dao.setIncomedb(0, day);
	}
	
	//매출 보여주기
	public int showIncome(int day) {
		//return totalIncome[day];
		int income=dao.showIncomedb(day);
		return income;
	}
	
	//방 개수 반환
	public int roomNum() {
		return checkNumRoom;
	}
}
