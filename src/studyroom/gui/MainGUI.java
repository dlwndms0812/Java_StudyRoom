package studyroom.gui;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.*;
import java.awt.*;

public class MainGUI extends JFrame implements ActionListener{
	JButton[] btn=new JButton[5];
	JPanel main=new JPanel();
	Container c=getContentPane();
	
	UserGUI user=new UserGUI();
	ManagerGUI manager=new ManagerGUI();
	UploadGUI upload=new UploadGUI();
	LoadGUI load=new LoadGUI();
	
	Font font=new Font("나눔바른펜OTF 굵게", Font.BOLD, 15);
    public MainGUI() {
    	setTitle("STUDY ROOM");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	c.setLayout(null);
    	c.setBackground(Color.white);
    	//메인화면
    	main.setLayout(null);
    	
    	//제목
    	JLabel jl=new JLabel("Study Room");
    	jl.setSize(200,30);
    	jl.setLocation(100,120);
    	jl.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 25));
    	jl.setForeground(new Color(142, 196, 240));
    	jl.setHorizontalAlignment(JLabel.CENTER);
    	main.add(jl);
    	
    	//버튼
    	String[] str= {"사용자 모드", "관리자 모드", "저장", "불러오기", "종료"};
    	
    	for(int i=0;i<5;i++) {
    		btn[i]=new JButton(str[i]);
    		btn[i].setSize(220,40);
    		btn[i].setLocation(90,300+i*70);
    		btn[i].setBackground(Color.white);
    		MatteBorder b=new MatteBorder(1,1,1,1,new Color(142, 196, 250));
    		btn[i].setBorder(b);
    		btn[i].setBackground(new Color(142, 196, 240));
    		btn[i].setForeground(Color.white);
    		main.add(btn[i]);
    		btn[i].setFont(font);
    		btn[i].addActionListener(this);
    	}
    	
  
    	
    	main.setBackground(Color.white);
    	main.setSize(400,700);
    	main.setVisible(true);
    	
        //패널추가
        c.add(user);
        user.setVisible(false);
    	c.add(manager);
    	manager.setVisible(false);
    	c.add(upload);
    	upload.setVisible(false);
    	c.add(load);
    	load.setVisible(false);
    	
    	c.add(main);
    	setSize(400,700);
    	setVisible(true);
    	
    }
    
    
    public void actionPerformed(ActionEvent e) {
    	//사용자모드
    	if(e.getSource()==btn[0]) {
    		main.setVisible(false);
    		user.setVisible(true);
    	}
    	
    	//관리자모드
    	else if(e.getSource()==btn[1]) {
    		main.setVisible(false);
    		manager.setVisible(false);
    	}
    	
    	//저장
        else if(e.getSource()==btn[2]) {
        	main.setVisible(false);
        	upload.setVisible(false);
        }
    	
    	//불러오기
        else if(e.getSource()==btn[3]) {
        	main.setVisible(false);
        	load.setVisible(false);
    	}
    	
    	//종료
        else if(e.getSource()==btn[4]) {
        	System.exit(0);	
    	}
    }
    public static void main(String[] args) {
    	new MainGUI();
    }
}
