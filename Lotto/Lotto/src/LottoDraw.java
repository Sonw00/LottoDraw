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
		buttonPanel.setBounds(10,10,560,330);                 //          �޴� �г� ����
		buttonPanel.setBackground(Color.white);                    //       ��� ���
		buttonPanel.setBorder(BorderFactory.createTitledBorder("")); // �гο� �ܰ��� ����
		buttonPanel.setLayout(new GridLayout(7,7,5,5));  
		add(buttonPanel);

		btnNumArray = new JButton[45];
		for (int i=0;i<45; i++) {
			btnNumArray[i] = new JButton(Integer.toString(i+1));  
			btnNumArray[i].setBackground(Color.white);             // 45���� ��� ��ư ����
			//btnMenuArray[i].addMouseListener(mouseOverListener);    // ��ư�� ���콺�̺�Ʈ �߰�
			//btnMenuArray[i].addActionListener(menuButtonListener); // ��ưŬ�� �̺�Ʈ�ڵ鸵 
			btnNumArray[i].setVisible(true);
			buttonPanel.add(btnNumArray[i]);                   //  ��ư �޴� �г� �ȿ� �� ��ư �߰�
		} //for  
		
		buttonMenuPanel = new JPanel();
		buttonMenuPanel.setBounds(10,350,560,30);                 //          �޴� �г� ����
		buttonMenuPanel.setBackground(Color.white);  
		buttonMenuPanel.setLayout(new GridLayout(1,5));
		incldButton = new JButton("���Լ�");
		incldButton.setBackground(new Color(0xCFCFCF));
		buttonMenuPanel.add(incldButton);
		excptButton = new JButton("���ܼ�");
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
		drawButton = new JButton("��ȣ �̱�");
		drawButtonPanel.add(drawButton);
		add(drawButtonPanel);
		
	}

	public void NumberButtonListener(ActionListener listener) {
													// �� ��ư�� �̺�Ʈ �߰�
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
