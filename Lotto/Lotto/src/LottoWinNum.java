import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LottoWinNum extends JPanel {
	
	private LottoView view;
	private JPanel topPanel,topCenterPanel,midPanel, bottomPanel;
	public JTextField txtDrwNo, num1, num2, num3, num4, num5, num6,numBonus;
	public JTextField[] numArray;
	public Long[] longArray;
	public Long bnusNo;
	public JButton beforeButton,nextButton;
	public JLabel drwDateLabel;
	public String date,result;
	
	public LottoWinNum(LottoView v) {
		view = v;
		
		topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setLayout(new BorderLayout());
		
		beforeButton = new JButton("<-");
		beforeButton.addActionListener(new WinNumButtonListener());
		topPanel.add(beforeButton,BorderLayout.WEST);
		
		nextButton = new JButton("->");
		nextButton.addActionListener(new WinNumButtonListener());
		topPanel.add(nextButton,BorderLayout.EAST);
		
		topCenterPanel = new JPanel();
		topCenterPanel.setBackground(Color.white);
		topPanel.add(topCenterPanel,BorderLayout.CENTER);
		
		txtDrwNo = new JTextField("1040",4);
		txtDrwNo.addActionListener(new WinNumButtonListener());
		topCenterPanel.add(new JLabel("제"));
		topCenterPanel.add(txtDrwNo);
		topCenterPanel.add(new JLabel("회 당첨번호"));
		add(topPanel);
		
		midPanel = new JPanel();
		midPanel.setBackground(Color.white);
		midPanel.setLayout(new BorderLayout());
		drwDateLabel = new JLabel("");
		drwDateLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		midPanel.add(drwDateLabel);
		add(midPanel);
		
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		bottomPanel.setLayout(new GridLayout(1,10,10,0));

		bottomPanel.add(new JLabel(" "));	
		numArray = new JTextField[6];
		for(int i=0;i<6;i++) {
			numArray[i] = new JTextField(Integer.toString(i));
			numArray[i].setEditable(false);
			numArray[i].setBackground(Color.white);
			bottomPanel.add(numArray[i]);
		}
		JLabel Plus = new JLabel("+");
		bottomPanel.add(Plus);
		Plus.setHorizontalAlignment(SwingConstants.CENTER); 
		numBonus = new JTextField("");
		numBonus.setEditable(false);
		numBonus.setBackground(Color.white);
		bottomPanel.add(numBonus);
		
		bottomPanel.add(new JLabel(" "));
		add(bottomPanel);
		
		WinNumView(Integer.parseInt(txtDrwNo.getText()));
		
		
	}

	public class WinNumButtonListener implements ActionListener{
					 							// 버튼 클릭 이벤트 컨트롤러
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj == beforeButton) {
				if(Integer.parseInt(txtDrwNo.getText())>1) {
					txtDrwNo.setText(Integer.toString(Integer.parseInt(txtDrwNo.getText())-1));
					WinNumView(Integer.parseInt(txtDrwNo.getText()));
				}
			}
			if(obj == nextButton) {
				if(Integer.parseInt(txtDrwNo.getText())<1040) {
					txtDrwNo.setText(Integer.toString(Integer.parseInt(txtDrwNo.getText())+1));
					WinNumView(Integer.parseInt(txtDrwNo.getText()));
				}
			}
			if(obj == txtDrwNo) {
				WinNumView(Integer.parseInt(txtDrwNo.getText()));
			}
		}
	}
	
	public void WinNumView(int key){

		//int key = 1000;
		String line = "";
		result = "";
	
		try {
			String apiURL = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
			URL url = new URL(apiURL+key);
	
			BufferedReader bf;
			bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			while((line = bf.readLine()) != null) {
				result = result.concat(line);
			}	
			JSONParser jsonParser = new JSONParser();		// JSONparser를 만들어 문자열 데이터를 객체화한다.
			Object obj = jsonParser.parse(result);
			JSONObject jsonObject  = (JSONObject)obj;			// 객체를 JSON객체로 변환
			
			date = (String)jsonObject.get("drwNoDate");
			drwDateLabel.setText(date);
			
			longArray = new Long[6];
			
			longArray[0] = (Long) jsonObject.get("drwtNo1");
			longArray[1] = (Long) jsonObject.get("drwtNo2");
			longArray[2] = (Long) jsonObject.get("drwtNo3");
			longArray[3] = (Long) jsonObject.get("drwtNo4");
			longArray[4] = (Long) jsonObject.get("drwtNo5");
			longArray[5] = (Long) jsonObject.get("drwtNo6");
			for(int i=0;i<6;i++) {
				numArray[i].setText(Long.toString(longArray[i]));
			}
			bnusNo =  (Long)jsonObject.get("bnusNo");
			numBonus.setText(Long.toString(bnusNo));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
