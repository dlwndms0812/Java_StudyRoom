package studyroom.gui;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import studyroom.dto.MgtClass;
import java.awt.event.*;
import java.awt.*;

public class ManagerGUI extends JPanel implements ActionListener{
	JButton[] btn=new JButton[5];
    JLabel jl2=new JLabel();
   
    Font font=new Font("나눔바른펜OTF 굵게", Font.BOLD, 15);
	MgtClass mc=new MgtClass();
    public ManagerGUI() {
		this.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(130,80);
		jl.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 25));
    	jl.setForeground(new Color(142, 196, 240));
		add(jl);
		
		//결과값
		
		jl2.setSize(200,50);
		jl2.setLocation(100,150);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		jl2.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 15));
    	jl2.setForeground(new Color(142, 196, 240));
		add(jl2);
		
		
		//버튼
		String[] str= {"방 생성", "방 삭제", "매출 검색","방 현황", "뒤로가기"};

		for(int i=0;i<5;i++) {
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
		
		//팝업
		this.setBackground(Color.white);
		setSize(400,700);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//방 생성
		if(e.getSource()==btn[0]) {
			String room=JOptionPane.showInputDialog("방 이름을 설정해주세요");
			String people=JOptionPane.showInputDialog("방 최대인원을 설정해주세요");
			String fee=JOptionPane.showInputDialog("방의 요금을 설정해주세요(1분단위)");
			int p=Integer.parseInt(people);
			int f=Integer.parseInt(fee);
			
			try {
				mc.resRoom(room, p, f);
				jl2.setText("방이 생성되었습니다");
			}catch(Exception ee) {
				jl2.setText("방을 생성하는데 실패했습니다");
			}
		}
		
		//방 삭제
		else if(e.getSource()==btn[1]) {
			String room=JOptionPane.showInputDialog("삭제할 방의 이름을 입력해주세요");
			try {
				mc.remRoom(room);
				jl2.setText("방을 삭제했습니다");
			} catch(Exception ee) {
				jl2.setText("방을 삭제하지 못했습니다");
			}
		}
		
		//매출 검색
		else if(e.getSource()==btn[2]) {
			String day=JOptionPane.showInputDialog("매출 검색을 원하는 날짜를 입력해주세요");
			int d=Integer.parseInt(day);
			
			jl2.setText(day+"일의 총 매출은 "+mc.showIncome(d)+ " 원입니다");
		}
		
		//방 현황
		else if(e.getSource()==btn[3]) {
			try {
			    jl2.setText("현재 생성된 방의 목록입니다 "+mc.showRoom()); //이게 맞나..? 사용중을 찾아야하는거 아닌가 모르겠다
			} catch(Exception ee) {
				jl2.setText("생성된 방이 없습니다");
			}
		}
		
		//뒤로가기
		else if(e.getSource()==btn[4]) {
    		this.setVisible(false);
    		MainGUI mainGUI=new MainGUI();
		}
	}
	
}
