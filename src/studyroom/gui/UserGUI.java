package studyroom.gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class UserGUI extends JPanel implements ActionListener{
	JButton[] btn=new JButton[4];
    JLabel jl2=new JLabel();

	public UserGUI() {
		
		this.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(100,120);
		jl.setFont(new Font("Dialog", Font.BOLD,25));
		jl.setHorizontalAlignment(JLabel.CENTER);
		add(jl);
		
		//결과 값
		//테두리 안되나?
		jl2.setSize(200,50);
		jl2.setLocation(100,150);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		add(jl2);
		
		//버튼
		String[] str= {"방 검색", "입실", "퇴실", "종료"};
		
		for(int i=0;i<4;i++) {
			btn[i]=new JButton(str[i]);
			btn[i].setSize(220,40);
			btn[i].setLocation(90, 300+i*70);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		
		this.setBackground(Color.white);
		setSize(400,700);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		//방 검색
		if(e.getSource()==btn[0]) {
			//팝업으로 입력받기
			String people=JOptionPane.showInputDialog("사용할 인원을 입력하세요");
			try {
			    jl2.setText("사용 가능한 방은 ?? 입니다 (null은 사용가능한 방이 없음)"); 
			} catch(Exception ee) {
				jl2.setText("사용 가능한 방이 없습니다");
			}
		}
        
		//입실
		else if(e.getSource()==btn[1]) {
			String room=JOptionPane.showInputDialog("입실하기 원하는 방의 이름을 입력하세요");
			String name=JOptionPane.showInputDialog("사용자 이름을 입력하세요");
			String time=JOptionPane.showInputDialog("입실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
			
			try {
				jl2.setText("입실 처리되었습니다");
			}
			catch(Exception ee) {
				jl2.setText("입실에 실패하였습니다");
			}
		}
		
		//퇴실
		else if(e.getSource()==btn[2]) {
			String room=JOptionPane.showInputDialog("퇴실하기 원하는 방의 이름을 입력하세요");
			String name=JOptionPane.showInputDialog("사용자 이름을 입력하세요");
			String day=JOptionPane.showInputDialog("오늘 날짜를 입력해주세요");
			String time=JOptionPane.showInputDialog("퇴실 시간을 입력하세요 예:오후 3시 30분이면 1530으로 입력");
			
			try {
				jl2.setText("요금은 ?입니다 퇴실처리 되었습니다");
			} catch(Exception ee) {
				jl2.setText("퇴실에 실패하였습니다");
			}
		}
		
		//종료
		else if(e.getSource()==btn[3]) {
			System.exit(0);
			//종료가 좋을까 뒤로가기가 좋을까?
		}
		
		
	}
  
}
