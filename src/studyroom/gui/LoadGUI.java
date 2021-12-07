package studyroom.gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LoadGUI extends JPanel{
    public LoadGUI() {
    	
		this.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(100,80);
		jl.setFont(new Font("Dialog", Font.BOLD,25));
		jl.setHorizontalAlignment(JLabel.CENTER);
		add(jl);
		
		//안내문구
		JLabel jl2=new JLabel("불러올 날짜를 입력하세요");
		jl2.setSize(200,50);
		jl2.setLocation(100,150);
		jl2.setHorizontalAlignment(JLabel.CENTER);
		add(jl2);
		JLabel jl3=new JLabel("예시:2021.12.7 -> 20211207");
		jl3.setSize(200,50);
		jl3.setLocation(100,170);
		jl3.setHorizontalAlignment(JLabel.CENTER);
		add(jl3);
		
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
		JButton btn=new JButton("종료");
		btn.setSize(220,40);
		btn.setLocation(90, 330);
	    add(btn);
		
		
		//팝업
		
	    this.setBackground(Color.white);
		setSize(400,700);
		setVisible(true);
    }
    
}
