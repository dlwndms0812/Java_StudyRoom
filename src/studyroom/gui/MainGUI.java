package studyroom.gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainGUI extends JFrame{
    public MainGUI() {
    	setTitle("메인화면");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Container c=getContentPane();
    	c.setLayout(null);
    	
    	//제목
    	JLabel jl=new JLabel("Study Room");
    	jl.setSize(200,30);
    	jl.setLocation(100,120);
    	jl.setFont(new Font("Dialog", Font.BOLD, 25));
    	jl.setHorizontalAlignment(JLabel.CENTER);
    	add(jl);
    	
    	//버튼
    	String[] str= {"사용자 모드", "관리자 모드", "저장", "불러오기", "종료"};
    	JButton[] btn=new JButton[5];
    	for(int i=0;i<5;i++) {
    		btn[i]=new JButton(str[i]);
    		btn[i].setSize(220,40);
    		btn[i].setLocation(90,300+i*70);
    		add(btn[i]);
    	}
    	
    	setSize(400,700);
    	setVisible(true);
    }
    
    public static void main(String[] args) {
    	new MainGUI();
    }
}
