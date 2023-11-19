import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LottoDraw extends JPanel {
	public JPanel buttonPanel,buttonMenuPanel,drawButtonPanel,panel1,panel2;
	public JButton[] btnNumArray;
	public JButton drawButton,incldButton,excptButton,clearButton;
	private LottoView view;
	
	public LottoDraw(LottoView v) {
		view = v;

		buttonPanel = new JPanel();               
		buttonPanel.setBounds(10,10,560,330);                 //          메뉴 패널 설정
		buttonPanel.setBackground(Color.white);                    //       배경 흰색
		buttonPanel.setBorder(BorderFactory.createTitledBorder("")); // 패널에 외곽선 설정
		buttonPanel.setLayout(new GridLayout(7,7,5,5));  
		add(buttonPanel);

		btnNumArray = new JButton[45];
		for (int i=0;i<45; i++) {
			btnNumArray[i] = new JButton(Integer.toString(i+1));  
			btnNumArray[i].setBackground(Color.white);             // 45개의 흰색 버튼 생성
			//btnMenuArray[i].addMouseListener(mouseOverListener);    // 버튼에 마우스이벤트 추가
			//btnMenuArray[i].addActionListener(menuButtonListener); // 버튼클릭 이벤트핸들링 
			btnNumArray[i].setVisible(true);
			buttonPanel.add(btnNumArray[i]);                   //  버튼 메뉴 패널 안에 각 버튼 추가
		} //for  
		
		buttonMenuPanel = new JPanel();
		buttonMenuPanel.setBounds(10,350,560,30);                 //          메뉴 패널 설정
		buttonMenuPanel.setBackground(Color.white);  
		buttonMenuPanel.setLayout(new GridLayout(1,5));
		incldButton = new JButton("포함수");
		incldButton.setBackground(new Color(0xCFCFCF));
		buttonMenuPanel.add(incldButton);
		excptButton = new JButton("제외수");
		excptButton.setBackground(new Color(0xFFCBCB));
		buttonMenuPanel.add(excptButton);
		panel1 = new JPanel();
		panel2 = new JPanel();
		buttonMenuPanel.add(panel1);buttonMenuPanel.add(panel2);
		panel1.setBackground(Color.white); panel2.setBackground(Color.white);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ClearButtonListener());
		buttonMenuPanel.add(clearButton);
		
		add(buttonMenuPanel);
		drawButtonPanel = new JPanel();
		drawButtonPanel.setBounds(220,390,140,50);
		drawButtonPanel.setBackground(Color.white);
		drawButtonPanel.setLayout(new BorderLayout());
		drawButton = new JButton("번호 뽑기");
		drawButtonPanel.add(drawButton);
		add(drawButtonPanel);
		
	}

	public void NumberButtonListener(ActionListener listener) {
													// 각 버튼에 이벤트 추가
		for(int i=0;i<45;i++) {
			btnNumArray[i].addActionListener(listener);
		}
		clearButton.addActionListener(listener);
		drawButton.addActionListener(listener);
	}
	/*public void ResultButtonListener(ActionListener listener) {
		clearButton.addActionListener(listener);
	}*/
	class ClearButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			Object obj = e.getSource();
			if(obj == clearButton) {
				view.resultPanel.n=-1;
				for(int i=0; i>15;i++) {
					for(int j=0;j>6;j++) {
						view.resultPanel.drawNumList2[i][j] = 0;
					}
					view.resultPanel.bnusNum2[i]=0;
				}
				view.resultPanel.ShowNumber1(view.resultPanel.drawNumList2,view.resultPanel.bnusNum2);
			
			}
		}
		
	}

}
