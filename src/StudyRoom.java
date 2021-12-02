import java.util.Scanner;

import studyroom.dto.MgtClass;
import studyroom.dto.RoomClass;
import studyroom.dto.UserClass;
import java.io.*;

public class StudyRoom {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in); 
		MgtClass mc=new MgtClass(); //MgtClass 객체 생성
		
		int mode=0;
		
	
		while(true) {
			System.out.println("모드를 선택해주세요");
			System.out.println("1.사용자 모드");
			System.out.println("2.관리자 모드");
			System.out.println("3.종료");
			System.out.println("4.저장");
			System.out.println("5.불러오기");
			
			
			mode=sc.nextInt();
		    
			//1.사용자 모드
			if(mode==1) {
				while(true) {
				    int menu=0;
				    System.out.println(" ");
			     	System.out.println("사용자 모드입니다.원하시는 메뉴를 선택해주세요");
				    System.out.println("1.방 검색");
				    System.out.println("2.입실");
				    System.out.println("3.퇴실");
				    System.out.println("4.종료");
				
				    menu=sc.nextInt();
				    sc.nextLine();
				    
				    if(menu==1) {
				    	System.out.println(" ");
				    	System.out.println("사용 인원을 입력하세요");
					    int people;
					    people=sc.nextInt();
					    try {
						    System.out.println("사용 가능한 방은"+mc.searchRoom(people)+"입니다.");
						    //ArrayList가 아닌 배열을 사용하면 배열이 다 차지않는 이상 null값이 나오기에, 사용자로 하여금 오해를 불러일으키지 않도록 경고문 작성함
						    System.out.println("(주의) null은 사용 가능한 방이 아닙니다. 이 점 주의해주세요.");  
					    }
					    catch(Exception e){
						    System.out.println("사용 가능한 방이 없습니다");
					    }
				    }
				    
				    else if(menu==2) {
					    System.out.println(" ");
					    System.out.println("입실하기 원하는 방의 이름을 입력하세요");
					    String room=sc.nextLine();
					    System.out.println("사용자 이름을 입력하세요");
					    String name=sc.nextLine();
				    	System.out.println("입실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
					    int enter=sc.nextInt();
					    try {
					        mc.checkIn(room, name, enter);
					        System.out.println("입실 처리되었습니다.");
					    }
					    catch(Exception e) {
						    System.out.println("입실에 실패하였습니다.");
					    }
				    }
				    else if(menu==3) {
				    	System.out.println(" ");
					    System.out.println("퇴실하기 원하는 방의 이름을 입력하세요");
					    String room=sc.nextLine();
					    System.out.println("사용자 이름을 입력하세요");
					    String name=sc.nextLine();
					    System.out.println("오늘 날짜를 입력해주세요.");
					    int day=sc.nextInt();
				    	System.out.println("퇴실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
					    int exit=sc.nextInt();
					    try {
					        System.out.println("요금은 "+mc.checkOut(room, name, exit,day)+"원 입니다.");
					        System.out.println("퇴실 처리되었습니다.");
					        
					    }
					    catch(Exception e) {
						    System.out.println("퇴실에 실패하였습니다.");
					    }
					
				    }
				    else if(menu==4) {
				    	System.out.println(" ");
				    	System.out.println("사용자 모드를 종료합니다.");
				    	System.out.println(" ");
				    	break;
				    }
				    
				    else {
					    System.out.println(" ");
					    System.out.println("숫자를 다시 입력하세요");
					    System.out.println(" ");
				    }
				}
			}
			
			//2.관리자 모드
			else if(mode==2) {
				while(true) {
				    int menu=0;
				    System.out.println(" ");
				    System.out.println("관리자 모드입니다. 원하시는 메뉴를 선택해주세요");
				    System.out.println("1.방 생성");
				    System.out.println("2.방 삭제");
				    System.out.println("3.매출 검색");
				    System.out.println("4.방 현황");
				    System.out.println("5.종료");
				
				    menu=sc.nextInt();
				    sc.nextLine();
				    
				    if(menu==1) {
				    	System.out.println(" ");
				    	System.out.println("방 이름을 설정해주세요");
				    	String room=sc.nextLine();
				    	System.out.println("방 최대인원을 설정해주세요");
				    	int maxPeople=sc.nextInt();
				    	System.out.println("방의 요금을 설정해주세요(1분단위)");
				    	int fee=sc.nextInt();
				    	mc.resRoom(room, maxPeople, fee);
				    	System.out.println("방이 생성되었습니다.");
				    }
				    
				    else if(menu==2) {
				    	System.out.println(" ");
				    	System.out.println("삭제할 방의 이름을 입력해주세요");
				    	String room=sc.nextLine();
				    	try {
				    	    mc.remRoom(room);
				    	    System.out.println("방을 삭제했습니다.");
				    	}
				    	catch(Exception e) {
				    		System.out.println("방을 삭제하지 못했습니다.");
				    	}
				    }
				    
				    else if(menu==3) {
				    	System.out.println(" ");
				    	System.out.println("매출 검색을 원하는 날짜를 입력해주세요");
				    	int day=sc.nextInt();
				    	System.out.println(day+"의 총 매출은 "+mc.showIncome(day)+"원 입니다.");
				    }
				    
				    else if(menu==4) {
				    	System.out.println(" ");
				    	try {
				    	    System.out.println("현재 생성된 방의 목록입니다: "+mc.showRoom());
				    	   //ArrayList가 아닌 배열을 사용하면 배열이 다 차지않는 이상 null값이 나오기에, 사용자로 하여금 오해를 불러일으키지 않도록 경고문 작성함
				    	    System.out.println("(주의) null은 생성된 방이 없다는 뜻입니다. 이 점 주의해주세요.");
				    	}
				    	catch(Exception e) {
				    		System.out.println("생성된 방이 없습니다.");
				    	}
				    }
				    
				    else if(menu==5) {
				    	System.out.println(" ");
				    	System.out.println("관리자 모드를 종료합니다.");
	                    break;
				    }
				
				    else {
					    System.out.println(" ");
					    System.out.println("숫자를 다시 입력하세요");
					    System.out.println(" ");
				    }
				 
				}
			}
			
			//3.종료
			else if(mode==3) {
				System.out.println(" ");
				System.out.println("종료합니다.");
				break;
			}
			
			//4. 파일 저장
			else if(mode==4) {
				System.out.println(" ");
				System.out.println("저장할 날짜를 입력하세요.");
				int day=sc.nextInt();
				
				DataOutputStream out=null;
				
				try {
					out=new DataOutputStream(new FileOutputStream("output.dat")); //파일 열기
					out.writeInt(mc.roomNum()); //room의 개수
					out.writeInt(mc.showIncome(day)); //total 금액
					try {
						String str=mc.showRoom()+"";
						out.writeUTF(str); //room 정보
					}
					catch(Exception e) {
			    		System.out.println("생성된 방이 없습니다.");
			    	}
				}
				catch(IOException ioe) {
					System.out.println("파일로 출력할 수 없습니다.");
				}
				finally {
					try {
						out.close(); //파일 닫기
						System.out.println(" ");
						System.out.println("저장되었습니다.");
					}
					catch(Exception e) {
						
					}
				}
			}
			
			//5. 파일 불러오기
			else if(mode==5) {
				System.out.println(" ");
				
				DataInputStream in=null;
				
				try {
					in=new DataInputStream(new FileInputStream("output.dat")); //파일 열기
					
					 System.out.println("방의 개수는 "+in.readInt()+"개");
					 System.out.println("총 금액은" +in.readInt()+"원");
					 System.out.println("방 현황: "+in.readUTF());
						
				}
				catch(FileNotFoundException fnfe) {
					System.out.println("파일이 존재하지 않습니다.");
				}
				catch(EOFException eofe) {
					System.out.println("끝");
				}
				catch(IOException iofe) {
					System.out.println("실패하였습니다.");
				}
				finally {
					try {
						in.close(); //파일 닫기
					}
					catch(Exception e) {
						
					}
				}
			}
			
			else {
				System.out.println("숫자를 다시 입력하세요");
				System.out.println(" ");
			}
			
	    }
   
    }
}


