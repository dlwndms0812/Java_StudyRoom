package studyroom.gui;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import studyroom.dto.MgtClass;
import java.awt.event.*;
import java.awt.*;

public class UserGUI extends JPanel implements ActionListener{
	JButton[] btn=new JButton[4];
    JLabel jl2=new JLabel();
    Font font=new Font("나눔바른펜OTF 굵게", Font.BOLD, 15);
    JLabel jl3=new JLabel();
    MgtClass mc=new MgtClass();
    
	public UserGUI() {
		
		this.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(100,120);
		jl.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 25));
    	jl.setForeground(new Color(142, 196, 240));
		jl.setHorizontalAlignment(JLabel.CENTER);
		add(jl);
		
		//결과 값
		//테두리 안되나?
		jl2.setSize(300,50);
		jl2.setLocation(50,180);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		jl2.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 10));
    	jl2.setForeground(new Color(142, 196, 240));
		add(jl2);
		
		jl3.setSize(200,50);
		jl3.setLocation(100,230);
		jl3.setHorizontalAlignment(JLabel.CENTER);
		jl3.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 10));
    	jl3.setForeground(new Color(142, 196, 240));
		add(jl3);
		jl3.setVisible(false);
		
		//버튼
		String[] str= {"방 검색", "입실", "퇴실", "뒤로가기"};
		
		for(int i=0;i<4;i++) {
			btn[i]=new JButton(str[i]);
			btn[i].setSize(220,40);
			btn[i].setLocation(90, 300+i*70);
			btn[i].setBackground(Color.white);
    		MatteBorder b=new MatteBorder(1,1,1,1,new Color(142, 196, 250));
    		btn[i].setBorder(b);
    		btn[i].setBackground(new Color(142, 196, 240));
    		btn[i].setForeground(Color.white);
    		btn[i].setFont(font);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		
		this.setBackground(Color.white);
		setSize(400,700);
		setVisible(true);
	}
	
	public void setjl2(String str) {
		jl2.setText(str);
	}
	
	public void actionPerformed(ActionEvent e) {
		//방 검색
		if(e.getSource()==btn[0]) {
			//팝업으로 입력받기
			String people=JOptionPane.showInputDialog("사용할 인원을 입력하세요");
			int p=Integer.parseInt(people);
			
			try {
			    //jl2.setText("사용 가능한 방은 "+mc.searchRoom(p)+ "입니다");
				//jl2.setText("null은 사용가능한 방이 없다는 뜻입니다");
				JOptionPane.showMessageDialog(null, mc.searchRoom(p));
			    
			    //jl3.setVisible(true);
			} catch(Exception ee) {
				jl2.setText("사용 가능한 방이 없습니다");
			}
		}
        
		//입실
		else if(e.getSource()==btn[1]) {
			jl3.setVisible(false);
			String room=JOptionPane.showInputDialog("입실하기 원하는 방의 이름을 입력하세요");
			String name=JOptionPane.showInputDialog("사용자 이름을 입력하세요");
			String time=JOptionPane.showInputDialog("입실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
			int t=Integer.parseInt(time);
			try {
				mc.checkIn(room, name, t);
				jl2.setText("입실 처리되었습니다");
			}
			catch(Exception ee) {
				jl2.setText("입실에 실패하였습니다");
			}
		}
		
		//퇴실
		else if(e.getSource()==btn[2]) {
			jl3.setVisible(false);
			String room=JOptionPane.showInputDialog("퇴실하기 원하는 방의 이름을 입력하세요");
			String name=JOptionPane.showInputDialog("사용자 이름을 입력하세요");
			String day=JOptionPane.showInputDialog("오늘 날짜를 입력해주세요");
			String time=JOptionPane.showInputDialog("퇴실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
			
			int d=Integer.parseInt(day);
			int t=Integer.parseInt(time);
			try {
				//total+=day 하는 함수 만들기
				jl2.setText("요금은 "+mc.checkOut(room,name,t,d)+"원 입니다 퇴실처리 되었습니다"); 
			} catch(Exception ee) {
				jl2.setText("퇴실에 실패하였습니다");
			}
		}
		
		//뒤로가기
		else if(e.getSource()==btn[3]) {
    		this.setVisible(false);
    		MainGUI mainGUI=new MainGUI();
    		
		}
		
		
	}
  
}
