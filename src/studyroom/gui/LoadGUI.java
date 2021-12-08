package studyroom.gui;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.event.*;
import java.awt.*;

public class LoadGUI extends JPanel implements ActionListener{
	JButton input=new JButton("입력");
	JButton btn=new JButton("뒤로가기");
	Font font=new Font("나눔바른펜OTF 굵게", Font.BOLD, 15);
	
    public LoadGUI() {
    	
		this.setLayout(null);
		
		//제목
		JLabel jl=new JLabel("Study Room");
		jl.setSize(200,30);
		jl.setLocation(100,80);
		jl.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 25));
    	jl.setForeground(new Color(142, 196, 240));
		jl.setHorizontalAlignment(JLabel.CENTER);
		add(jl);
		
		//안내문구
		JLabel jl2=new JLabel("불러올 날짜를 입력하세요");
		jl2.setSize(200,50);
		jl2.setLocation(100,150);
		jl2.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 15));
    	jl2.setForeground(new Color(142, 196, 240));
		jl2.setHorizontalAlignment(JLabel.CENTER);
		add(jl2);
		JLabel jl3=new JLabel("예시:2021.12.7 -> 20211207");
		jl3.setSize(200,50);
		jl3.setLocation(100,170);
		jl3.setFont(new Font("나눔바른펜OTF 굵게", Font.BOLD, 10));
    	jl3.setForeground(new Color(142, 196, 240));
		jl3.setHorizontalAlignment(JLabel.CENTER);
		add(jl3);
		
		MatteBorder b=new MatteBorder(1,1,1,1,new Color(142, 196, 250));
		
		//입력 및 버튼
		JTextField tf=new JTextField("이곳에 입력하세요");
		tf.setSize(230,40);
		tf.setLocation(50,220);
		tf.setBorder(b);
		add(tf);
		
		input.setSize(70,40);
		input.setLocation(300,220);
		input.setBorder(b);
		input.setBackground(new Color(142, 196, 240));
		input.setForeground(Color.white);
		input.setFont(font);
		input.addActionListener(this);
		add(input);
		
		//버튼
		btn.setSize(220,40);
		btn.setLocation(90, 330);
		btn.setBorder(b);
		btn.setBackground(new Color(142, 196, 240));
		btn.setForeground(Color.white);
		btn.setFont(font);
		btn.addActionListener(this);
	    add(btn);
		
	    this.setBackground(Color.white);
		setSize(400,700);
		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    	//입력
    	if(e.getSource()==input) {
    		//수입만 db에서 불러오기
    		JOptionPane.showMessageDialog(null, "ㅇㅇ날의 수입은 얼마입니다");
    	}
    	
    	//뒤로가기
    	else if (e.getSource()==btn){
    		this.setVisible(false);
    		MainGUI mainGUI=new MainGUI();
    	}
    }
}
