
public class RoomClass {
	private int enter; //�Խ� �ð�
    private	int exit; //��ǽð�
	private boolean status; //��������� �ƴ��� ���¸� ��Ÿ��
	private String room; //�� �̸�
	private int fee; //���
	private int calFee; //���� ���
	private int maxPeople;  //�ִ� �ο� �� 
	
	
	private String user; //����ϴ� ����� ��ü
	
	//������
	RoomClass(String room, int maxPeople, int fee){
		this.room=room;
		this.maxPeople=maxPeople;
		this.fee=fee;
	}
	
	
	//�ִ� �ο��� ����
	void setPeople(int maxPeople) {
		this.maxPeople=maxPeople;
	}
	
	//�ִ� �ο��� ��ȯ
	int getPeople() {
		return maxPeople;
	}
	
	
	//��� ���
	void setPay(int enter, int exit) {
		//�Է¹��� �ð��� �д����� ����ϱ�
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
	
	//��� ��ȯ
	int getPay() {
		return calFee;
	}

	//�� �̸� ����
	void setRoom(String room) {
		this.room=room;
	}
	
	//�� �̸� ��ȯ
	String getRoom() {
		return room;
	}
	
	
	//�Խǽð� ����
	void setEnter(int enter) {
		this.enter=enter;
	}
	
	//�Խǽð� ��ȯ
	int getEnter() {
		return enter;
	}
	
	//��ǽð� ����
	void setExit(int exit) {
		this.exit=exit;
	}
	
	//��ǽð� ��ȯ
	int getExit() {
		return exit;
	}
	
	//�� ����� ����
	void useRoom() {
	    this.status=true;	
	}
	
	//�� ����� �ƴ� ����
	void notuseRoom() {
		this.status=false;
	}
	
	//�� ��� ��Ȳ ��ȯ
	boolean statusRoom() {
		return status;
	}
	
	//�� ����� �̸� ����
	void setUser(String user) {
		this.user=user;
	}
	
	//�� ����� �̸� ��ȯ
	String getUser(String user) {
		return user;
	}
}
