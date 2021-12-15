package studyroom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studyroom.dto.RoomClass;


public class StudyRoomDao {
    private static String dburl="jdbc:mysql://localhost:3306/studyroom?useSSL=false&serverTimezone=UTC"; //변경
    private static String dbuser="studyuser";
    private static String dbpasswd="study123";
    
    static int day_array[]=new int[10000];
    
    //방 생성: 방 이름, 인원 수, 요금 넣기
    public RoomClass resRoomdb(String room, int maxPeople, int fee) {
    	RoomClass roomclass=new RoomClass();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="INSERT INTO studydb(room_name, room_max, fee, use_room) VALUES('"+room+"',"+maxPeople+","+fee+","+0+")";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
            
			//roomclass.roomClass(room, maxPeople, fee);
			//roomclass.setRoom(room);
			
            ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return roomclass; //이거 반환이 맞나..?
    }
    
    //방 삭제: 방 이름으로 삭제
    public void remRoomdb(String roomName) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="DELETE FROM studydb WHERE room_name= '"+roomName+"'";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
            
			
            ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
    //방 보여주기:현재 있는 방 다 보여주기
    public ArrayList showRoomdb() {
    	ArrayList list=new ArrayList();
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="SELECT room_name, room_max FROM studydb";
		try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					String name=rs.getString(1);
					int max=rs.getInt(2);
					String maxx=Integer.toString(max);
				
					list.add("방 이름:"+name+", ");
					list.add("인원 수:"+maxx+"  ");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
    }
    
    //방 찾기: 인원수로 찾기
    public ArrayList searchRoomdb(int peopleNum) {
        ArrayList list=new ArrayList();
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="SELECT room_name FROM studydb WHERE use_room=0 and room_max>="+peopleNum;
		try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					String name=rs.getString(1);
				
					list.add("방 이름:"+name+", ");
					
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
    }
    
    //체크인: 이름, 시간 넣기, use=1
    public RoomClass checkindb(String room, String name, int enter) {
       RoomClass roomclass=new RoomClass();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="UPDATE studydb SET user_name='"+name+"', checkin="+enter+", use_room=1 WHERE room_name='"+room+"'";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
            
			//roomclass.checkIn(name, enter); //이게 맞나..?
			
            ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return roomclass; 
    	
    }
    
    //체크아웃: 방 이름, 사용자 이름, 퇴실 시간, 날짜로 반환, use=0
    public RoomClass checkoutdb(String room, String name, int exit) {
       RoomClass roomclass=new RoomClass();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="UPDATE studydb SET checkout="+exit+", use_room=0 WHERE room_name='"+room+"' and user_name='"+name+"'";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
            
			//roomclass.checkIn(name, enter); //이게 맞나..?

            ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return roomclass; 
    }
    
    //매출 설정: 방 이름, 날짜 incomedb
    public RoomClass setIncomedb(int total, int day) {
        RoomClass roomclass=new RoomClass();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		//그냥 day를 date가 아닌 integer로 하기
		String sql="INSERT INTO incomedb(income_day, income) VALUES('"+day+"',"+total+")";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
      
			
            ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return roomclass; 
    }
    
    //매출 보여주기:날짜로 반환
    public int showIncomedb(int day) {
    	int income=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		
		String sql="SELECT income FROM incomedb WHERE income_day="+day;
	
		try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					income=rs.getInt(1);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return income; 
    }
    
    public int fee(String room_name) {
    	//요금 계산하기
    	int sum=0;
    	int in=0;
    	int out=0;
    	int fee=0;
    	int h=0;
    	int m=0; 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
    	String sql="SELECT checkin, checkout, fee FROM studydb WHERE room_name='"+room_name+"'";
    	
    	try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpasswd);
				PreparedStatement ps=conn.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next()) {
					in=rs.getInt(1);
					out=rs.getInt(2);
					fee=rs.getInt(3);
					} 
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			
		}
    	int in_h=in/100;
    	int in_m=in%100;
    	int out_h=out/100;
    	int out_m=out%100;
    	h=out_h-in_h;
    	m=out_m-in_m;
    	if(m<0) {
    		h-=1;
    		m=0;
    		m=60+out_m-in_m;
    	}
    	sum=(h*60+m)*fee;
    	
    	//day_array[day]+=sum;
    	//System.out.println(sum);
		return sum; 
    }
    
    public int total(int day, int money) {
    	//총 수입 계산해서 저장할 수 있는 함수 만들기
    	//여기서 날짜별로 계산하고 setIncomedb로 가야할듯
    	day_array[day]+=money;
    	int d=day_array[day];
    	return d;
    }
  
   
   public void setday(int day) {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="INSERT INTO incomedb(income_day, income) VALUES('"+day+"',"+0+")";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
     
			
           ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
   }
   
   public void checkout_fee(int day, int money) {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="UPDATE incomedb SET income="+money+" WHERE income_day="+day+"";
		try (Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
    
			
          ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
   }
   
   public int get_fee(int day) {
	  int fee=0;
   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	String sql="SELECT income FROM incomedb WHERE income_day="+day;
	try(Connection conn=DriverManager.getConnection(dburl,dbuser,dbpasswd);
			PreparedStatement ps=conn.prepareStatement(sql)){
		try(ResultSet rs=ps.executeQuery()){
			while(rs.next()) {
				fee=rs.getInt(1);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} catch(Exception ex) {
		ex.printStackTrace();
	}
	return fee;
  }
}
