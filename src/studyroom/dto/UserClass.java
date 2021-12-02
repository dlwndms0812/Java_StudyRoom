package studyroom.dto;

public class UserClass {
    private String name; //사용자 이름
    
    //생성자
    UserClass(){
    }
    
    //사용자 이름 설정
    void setName(String name) {
    	this.name=name;
    }
    
    //사용자 이름 반환
    String getName() {
    	return name;
    }
}
