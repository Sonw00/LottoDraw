import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LottoResult extends JPanel {

	LottoView view;
	private JPanel topPanel,midPanel,bottomPanel;
	public JTextField topNumBonus,midNumBonus,bottomNumBonus; 
	public JTextField[] topNum,midNum,bottomNum;
	public JButton upButton,downButton;
	public JLabel topIndex,midIndex,bottomIndex;
	public ResultButtonListener resultButtonListener;

	public int n=-1;
	public int page=1;
	
	public Integer[][] drawNumList2 = new Integer[15][6];
	public Integer[] bnusNum2 = new Integer[15];
	
	LottoResult(LottoView v){
		view = v;
		resultButtonListener = new ResultButtonListener();

		topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setLayout(new GridLayout(1,10,10,0));

		topIndex = new JLabel(" ");
		topPanel.add(topIndex);
		topNum = new JTextField[6];
		for(int i=0;i<6;i++) {
			topNum[i] = new JTextField(" ");
			topNum[i].setEditable(false);
			topNum[i].setBackground(Color.white);
			topPanel.add(topNum[i]);
		}
		JLabel topPlus = new JLabel("+");
		topPanel.add(topPlus);
		topPlus.setHorizontalAlignment(SwingConstants.CENTER); 
		topNumBonus = new JTextField("");
		topNumBonus.setEditable(false);
		topNumBonus.setBackground(Color.white);
		topPanel.add(topNumBonus);
		upButton = new JButton("^");
		upButton.addActionListener(resultButtonListener);
		topPanel.add(upButton);
		add(topPanel);

		
		midPanel = new JPanel();
		midPanel.setBackground(Color.white);
		midPanel.setLayout(new GridLayout(1,10,10,0));
		
		midIndex = new JLabel(" ");
		midPanel.add(midIndex);	
		midNum = new JTextField[6];
		for(int i=0;i<6;i++) {
			midNum[i] = new JTextField(" ");
			midNum[i].setEditable(false);
			midNum[i].setBackground(Color.white);
			midPanel.add(midNum[i]);
		}
		JLabel midPlus = new JLabel("+");
		midPanel.add(midPlus);
		midPlus.setHorizontalAlignment(SwingConstants.CENTER); 
		midNumBonus = new JTextField("");
		midNumBonus.setEditable(false);
		midNumBonus.setBackground(Color.white);
		midPanel.add(midNumBonus);
		midPanel.add(new JLabel(" "));	
		add(midPanel);
		
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		bottomPanel.setLayout(new GridLayout(1,10,10,0));
		
		bottomIndex = new JLabel(" ");
		bottomPanel.add(bottomIndex);
		bottomNum = new JTextField[6];
		for(int i=0;i<6;i++) {
			bottomNum[i] = new JTextField(" ");
			bottomNum[i].setEditable(false);
			bottomNum[i].setBackground(Color.white);
			bottomPanel.add(bottomNum[i]);
		}
		JLabel bottomPlus = new JLabel("+");
		bottomPanel.add(bottomPlus);
		bottomPlus.setHorizontalAlignment(SwingConstants.CENTER); 
		bottomNumBonus = new JTextField("");
		bottomNumBonus.setEditable(false);
		bottomNumBonus.setBackground(Color.white);
		bottomPanel.add(bottomNumBonus);
		
		downButton = new JButton("v");
		downButton.addActionListener(resultButtonListener);
		bottomPanel.add(downButton);
		add(bottomPanel);

	}
	void drawButtonPressed(Integer[] drawNumList, int bnusNum) {
		n++;
		if(n<15) {
		for(int i=0; i<drawNumList.length;i++) {
			drawNumList2[n][i] = drawNumList[i];
			bnusNum2[n] = bnusNum;
		//topNum[i].setText(Integer.toString(drawNumList2[n][i]));
		//topNumBonus.setText(Integer.toString(bnusNum));
		//System.out.println(drawNumList2[n][i]); 
		//System.out.println(bnusNum2[n]);
		}
		}
		if(0<=n && n<=2) {
			ShowNumber1(drawNumList2,bnusNum2);
		}
		if(3<=n && n<=5) {
			ShowNumber2(drawNumList2,bnusNum2);
		}
		if(6<=n && n<=8) {
			ShowNumber3(drawNumList2,bnusNum2);
		}
		if(9<=n && n<=11) {
			ShowNumber4(drawNumList2,bnusNum2);
		}

		if(12<=n && n<=14) {
			ShowNumber5(drawNumList2,bnusNum2);
		}
		if(n>=15) {
			JOptionPane.showMessageDialog(null, "마지막 추첨번호입니다.");
		}
	}

	class ResultButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj == upButton) {
				if(page == 1) {
				}
				if(page == 2) {
					ShowNumber1(drawNumList2,bnusNum2);
				}
				if(page == 3) {ShowNumber2(drawNumList2,bnusNum2);
				}
				if(page == 4) {ShowNumber3(drawNumList2,bnusNum2);
				}
				if(page == 5) {ShowNumber4(drawNumList2,bnusNum2);
				}
			}
			if(obj == downButton) {
				if(page==5) {
				}
				if(page==4&&n>=12) {
					ShowNumber5(drawNumList2,bnusNum2);
				}
				if(page==3&&n>=9) {
					ShowNumber4(drawNumList2,bnusNum2);
				}
				if(page==2&&n>=6) {
					ShowNumber3(drawNumList2,bnusNum2);
				}
				if(page==1&&n>=3) {
					ShowNumber2(drawNumList2,bnusNum2);
				}
			}
		/*	if(obj == view.drawPanel.clearButton) {

				n=-1;
				for(int i=0; i>15;i++) {
					for(int j=0;j>6;j++) {
						drawNumList2[i][j] = 0;
					}
					bnusNum2[i]=0;
				}
				ShowNumber1(drawNumList2,bnusNum2);
				
				System.out.println(">> " + topNum[0].getText());
				System.out.println(">>2222 " + view.resultPanel.topNum[0].getText());
			}*/
		}
	}

	void ShowNumber1(Integer[][] NumList2,Integer bnusNum[]) {

		for(int i=0; i<6; i++) {
			if(n==-1) {
				view.resultPanel.topNum[i].setText("");
				view.resultPanel.topNumBonus.setText("");
				view.resultPanel.midNum[i].setText("");
				view.resultPanel.midNumBonus.setText("");
				view.resultPanel.bottomNum[i].setText("");
				view.resultPanel.bottomNumBonus.setText("");}
			if(n==0) {
				topNum[i].setText(Integer.toString(drawNumList2[0][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[0]));
				midNum[i].setText(" ");
				midNumBonus.setText(" ");
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==1) {
				topNum[i].setText(Integer.toString(drawNumList2[0][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[0]));
				midNum[i].setText(Integer.toString(drawNumList2[1][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[1]));
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==2) {
				topNum[i].setText(Integer.toString(drawNumList2[0][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[0]));
				midNum[i].setText(Integer.toString(drawNumList2[1][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[1]));
				bottomNum[i].setText(Integer.toString(drawNumList2[2][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[2]));}
			if(n>2) {
				topNum[i].setText(Integer.toString(drawNumList2[0][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[0]));
				midNum[i].setText(Integer.toString(drawNumList2[1][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[1]));
				bottomNum[i].setText(Integer.toString(drawNumList2[2][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[2]));
			}
			
	}
		topIndex.setText("1");
		midIndex.setText("2");
		bottomIndex.setText("3");
		page=1;
	}

	void ShowNumber2(Integer[][] NumList2,Integer bnusNum[]) {

		for(int i=0; i<6; i++) {
			if(n==3) {
				topNum[i].setText(Integer.toString(drawNumList2[3][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[3]));
				midNum[i].setText(" ");
				midNumBonus.setText(" ");
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==4) {
				topNum[i].setText(Integer.toString(drawNumList2[3][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[3]));
				midNum[i].setText(Integer.toString(drawNumList2[4][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[4]));
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==5) {
				topNum[i].setText(Integer.toString(drawNumList2[3][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[3]));
				midNum[i].setText(Integer.toString(drawNumList2[4][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[4]));
				bottomNum[i].setText(Integer.toString(drawNumList2[5][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[5]));}

			if(n>5) {
				topNum[i].setText(Integer.toString(drawNumList2[3][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[3]));
				midNum[i].setText(Integer.toString(drawNumList2[4][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[4]));
				bottomNum[i].setText(Integer.toString(drawNumList2[5][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[5]));
			}
	}
		topIndex.setText("4");
		midIndex.setText("5");
		bottomIndex.setText("6");
		page=2;
	}

	void ShowNumber3(Integer[][] NumList2,Integer bnusNum[]) {

		for(int i=0; i<6; i++) {
			if(n==6) {
				topNum[i].setText(Integer.toString(drawNumList2[6][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[6]));
				midNum[i].setText(" ");
				midNumBonus.setText(" ");
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==7) {
				topNum[i].setText(Integer.toString(drawNumList2[6][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[6]));
				midNum[i].setText(Integer.toString(drawNumList2[7][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[7]));
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==8) {
				topNum[i].setText(Integer.toString(drawNumList2[6][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[6]));
				midNum[i].setText(Integer.toString(drawNumList2[7][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[7]));
				bottomNum[i].setText(Integer.toString(drawNumList2[8][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[8]));}
			if(n>8) {
				topNum[i].setText(Integer.toString(drawNumList2[6][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[6]));
				midNum[i].setText(Integer.toString(drawNumList2[7][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[7]));
				bottomNum[i].setText(Integer.toString(drawNumList2[8][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[8]));
			}
	}
		topIndex.setText("7");
		midIndex.setText("8");
		bottomIndex.setText("9");
		page=3;
	}

	void ShowNumber4(Integer[][] NumList2,Integer bnusNum[]) {

		for(int i=0; i<6; i++) {
			if(n==9) {
				topNum[i].setText(Integer.toString(drawNumList2[9][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[9]));
				midNum[i].setText(" ");
				midNumBonus.setText(" ");
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==10) {
				topNum[i].setText(Integer.toString(drawNumList2[9][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[9]));
				midNum[i].setText(Integer.toString(drawNumList2[10][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[10]));
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==11) {
				topNum[i].setText(Integer.toString(drawNumList2[9][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[9]));
				midNum[i].setText(Integer.toString(drawNumList2[10][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[10]));
				bottomNum[i].setText(Integer.toString(drawNumList2[11][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[11]));}
			if(n>11) {
				topNum[i].setText(Integer.toString(drawNumList2[9][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[9]));
				midNum[i].setText(Integer.toString(drawNumList2[10][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[10]));
				bottomNum[i].setText(Integer.toString(drawNumList2[11][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[11]));
			}
	}
		topIndex.setText("10");
		midIndex.setText("11");
		bottomIndex.setText("12");
		page=4;
	}

	void ShowNumber5(Integer[][] NumList2,Integer bnusNum[]) {

		for(int i=0; i<6; i++) {
			if(n==12) {
				topNum[i].setText(Integer.toString(drawNumList2[12][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[12]));
				midNum[i].setText(" ");
				midNumBonus.setText(" ");
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==13) {
				topNum[i].setText(Integer.toString(drawNumList2[12][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[12]));
				midNum[i].setText(Integer.toString(drawNumList2[13][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[13]));
				bottomNum[i].setText(" ");
				bottomNumBonus.setText(" ");}
			if(n==14) {
				topNum[i].setText(Integer.toString(drawNumList2[12][i]));
				topNumBonus.setText(Integer.toString(bnusNum2[12]));
				midNum[i].setText(Integer.toString(drawNumList2[13][i]));
				midNumBonus.setText(Integer.toString(bnusNum2[13]));
				bottomNum[i].setText(Integer.toString(drawNumList2[14][i]));
				bottomNumBonus.setText(Integer.toString(bnusNum2[14]));}
	}
		topIndex.setText("13");
		midIndex.setText("14");
		bottomIndex.setText("15");
		page=5;
	}
}
