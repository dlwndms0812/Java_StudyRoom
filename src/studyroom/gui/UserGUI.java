package studyroom.gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class UserGUI extends JFrame{
	public UserGUI() {
		setTitle("사용자모드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(100,80);
		jl.setFont(new Font("Dialog", Font.BOLD,25));
		jl.setHorizontalAlignment(JLabel.CENTER);
		add(jl);
		
		//안내문구
		JLabel jl2=new JLabel("안내문구(나중에 버튼 누르면 바뀜)");
		jl2.setSize(200,50);
		jl2.setLocation(100,150);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		add(jl2);
		
		//입력 및 버튼
		JTextField tf=new JTextField("이곳에 입력하세요");
		tf.setSize(230,40);
		tf.setLocation(50,220);
		add(tf);
		JButton input=new JButton("입력");
		input.setSize(70,40);
		input.setLocation(300,220);
		add(input);
		
		//버튼
		String[] str= {"방 검색", "입실", "퇴실", "종료"};
		JButton[] btn=new JButton[4];
		for(int i=0;i<4;i++) {
			btn[i]=new JButton(str[i]);
			btn[i].setSize(220,40);
			btn[i].setLocation(90, 300+i*70);
			add(btn[i]);
		}
		
		//팝업
		
		setSize(400,700);
		setVisible(true);
	}
  
	public static void main(String[] args) {
		new UserGUI();
	}
}
