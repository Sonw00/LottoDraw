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
	
	
	public LottoView() {// Ŭ������ ������
		setPreferredSize(new Dimension(600,800));    // ��üȭ�� LottoView �г�
		setBackground(Color.white);                         
		setLayout(null);               

		lblPanel = new JPanel();               
		lblPanel.setBounds(10,10,580,50);                 
		lblPanel.setBackground(Color.white);                     // ȭ������ �� �г�
		lblPanel.setLayout(new BorderLayout());  
		lblPanel.setVisible(true);
		
		lblLotto = new JLabel("LOTTO NUMBER DRAWER"); 				// ȭ�� ����� "LOTTO NUMBER DRAWER" ���ڿ� ��
		lblLotto.setHorizontalAlignment(SwingConstants.CENTER); 
		lblLotto.setVisible(true);						
		lblPanel.add(lblLotto);

		add(lblPanel);
		
		winNumPanel = new LottoWinNum(this);               
		winNumPanel.setBounds(10,70,580,130);                 //          ��÷��ȣ ��ȸ �г�
		winNumPanel.setBackground(Color.white);                   
		winNumPanel.setBorder(BorderFactory.createTitledBorder("")); 
		winNumPanel.setLayout(new GridLayout(3,1));
		add(winNumPanel);
		

		drawPanel = new LottoDraw(this);               
		drawPanel.setBounds(10,210,580,440);                 //          ��ư��÷ �г�
		drawPanel.setBackground(Color.white);                    
		drawPanel.setBorder(BorderFactory.createTitledBorder("")); 
		drawPanel.setLayout(null);  
		add(drawPanel);
	
		

		resultPanel = new LottoResult(this);               
		resultPanel.setBounds(10,660,580,130);                 //          ��÷��ȣ ��� �г� ����
		resultPanel.setBackground(Color.white);                   
		resultPanel.setBorder(BorderFactory.createTitledBorder("")); 
		resultPanel.setLayout(new GridLayout(3,1,10,10));  
		add(resultPanel);
	}

}
