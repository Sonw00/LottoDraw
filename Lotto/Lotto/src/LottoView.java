import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LottoView extends JPanel{
	public JPanel lblPanel, buttonPanel;
	public JLabel lblLotto;
	public LottoResult resultPanel;
	public LottoWinNum winNumPanel;
	public LottoDraw drawPanel;
	
	
	public LottoView() {// 클래스의 생성자
		setPreferredSize(new Dimension(600,800));    // 전체화면 LottoView 패널
		setBackground(Color.white);                         
		setLayout(null);               

		lblPanel = new JPanel();               
		lblPanel.setBounds(10,10,580,50);                 
		lblPanel.setBackground(Color.white);                     // 화면상단의 라벨 패널
		lblPanel.setLayout(new BorderLayout());  
		lblPanel.setVisible(true);
		
		lblLotto = new JLabel("LOTTO NUMBER DRAWER"); 				// 화면 상단의 "LOTTO NUMBER DRAWER" 문자열 라벨
		lblLotto.setHorizontalAlignment(SwingConstants.CENTER); 
		lblLotto.setVisible(true);						
		lblPanel.add(lblLotto);

		add(lblPanel);
		
		winNumPanel = new LottoWinNum(this);               
		winNumPanel.setBounds(10,70,580,130);                 //          당첨번호 조회 패널
		winNumPanel.setBackground(Color.white);                   
		winNumPanel.setBorder(BorderFactory.createTitledBorder("")); 
		winNumPanel.setLayout(new GridLayout(3,1));
		add(winNumPanel);
		

		drawPanel = new LottoDraw(this);               
		drawPanel.setBounds(10,210,580,440);                 //          버튼추첨 패널
		drawPanel.setBackground(Color.white);                    
		drawPanel.setBorder(BorderFactory.createTitledBorder("")); 
		drawPanel.setLayout(null);  
		add(drawPanel);
	
		

		resultPanel = new LottoResult(this);               
		resultPanel.setBounds(10,660,580,130);                 //          추첨번호 출력 패널 설정
		resultPanel.setBackground(Color.white);                   
		resultPanel.setBorder(BorderFactory.createTitledBorder("")); 
		resultPanel.setLayout(new GridLayout(3,1,10,10));  
		add(resultPanel);
	}

}
