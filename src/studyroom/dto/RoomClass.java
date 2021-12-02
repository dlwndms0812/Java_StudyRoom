package studyroom.dto;

public class RoomClass {
	private int enter; //입실 시간
    private	int exit; //퇴실 시간
	private boolean status; //사용중인지 아닌지 상태를 나타냄
	private String room; //방 이름
	private int fee; //요금
	private int calFee; //계산된 요금
	private int maxPeople;  //최대 인원 수 
	
	
	private UserClass user=new UserClass(); //사용하는 사용자 객체
	
	//생성자
	public RoomClass(){
		
	}
	
	void roomClass(String room, int maxPeople, int fee){
		this.room=room;
		this.maxPeople=maxPeople;
		this.fee=fee;
	}
	
	
	//최대 인원수 설정
	void setPeople(int maxPeople) {
		this.maxPeople=maxPeople;
	}
	
	//최대 인원수 반환
	int getPeople() {
		return maxPeople;
	}
	
	
	//요금 계산
	void setPay(int enter, int exit) {
		//입력받은 시간을 분단위로 계산하기
		int h1=enter/100;
		int m1=enter%100;
		int h2=exit/100;
		int m2=exit%100;
		
		int h3=h2-h1;
		int m3=m2-m1;
		if(m3<0) {
			m3+=60;
			h3-=1;
		}
		int time=h3*60+m3;
        calFee=time*fee;
	}
	
	//요금 반환
	int getPay() {
		return calFee;
	}

	//방 이름 설정
	void setRoom(String room) {
		this.room=room;
	}
	
	//방 이름 반환
	String getRoom() {
		return room;
	}
	
	
	//입실 시간 설정
	void setEnter(int enter) {
		this.enter=enter;
	}
	
	//입실 시간 반환
	int getEnter() {
		return enter;
	}
	
	//퇴실 시간 설정
	void setExit(int exit) {
		this.exit=exit;
	}
	
	//퇴실 시간 반환
	int getExit() {
		return exit;
	}
	
	//방 사용중 설정
	void useRoom() {
	    this.status=true;	
	}
	
	//방 사용중 아님 설정
	void notuseRoom() {
		this.status=false;
	}
	
	//방 사용 현황 반환
	boolean statusRoom() {
		return status;
	}
	
	//방 사용자 이름 설정
	void setUser(String name) {
		user.setName(name);
	}
	
	//방 사용자 이름 반환
	String getUser() {
		return user.getName();
	}
	
	//체크인
	void checkIn(String name, int enter) {
		useRoom();
		setUser(name);
		setEnter(enter);
	}
	
	//체크아웃
	void checkOut(int exit) {
		notuseRoom();
		setExit(exit);
		setPay(getEnter(),getExit());
	}
}
