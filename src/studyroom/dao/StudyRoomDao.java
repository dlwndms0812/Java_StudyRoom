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
    
    //방 생성: 방 이름, 인원 수, 요금 넣기
    public RoomClass resRoomdb(String room, int maxPeople, int fee) {
    	RoomClass roomclass=new RoomClass();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		String sql="INSERT INTO studydb(room_name, room_max, fee) VALUES('"+room+"',"+maxPeople+","+fee+")";
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
		
		String sql="SELECT room_name FROM studydb WHERE use=0 and room_max>="+peopleNum;
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
		
		String sql="UPDATE studydb SET user_name="+name+", checkin="+enter+", use=1 WHERE room_name="+room;
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
		
		String sql="UPDATE studydb SET checkout="+exit+", use=0 WHERE room_name="+room+"and user_name="+name;
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
		int year=day/1000;
		int m=day/100000;
		int d=day%100000;
		String dd=Integer.toString(year)+"-"+Integer.toString(m)+"-"+Integer.toString(d);
		String sql="INSERT INTO incomedb(income_date, income) VALUES('"+dd+"',"+total+")";
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
		int year=day/1000;
		int m=day/100000;
		int d=day%100000;
		String dd=Integer.toString(year)+"-"+Integer.toString(m)+"-"+Integer.toString(d);
		String sql="SELECT income FROM incomedb WHERE income_day="+dd;
	
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
}