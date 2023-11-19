import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Lotto extends JFrame {
	static LottoWinNum winNum;

	public static void main(String[] args) { // main 함수
		JFrame frame = new JFrame("Lotto Drawer");   // JFrame 객체 생성
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 닫기버튼을 눌렀을 때 종료
		frame.setResizable(false);                   // 창 크기 고정
		
		LottoView view = new LottoView();    // 설정한 JPanel 클래스 객체
		LottoDraw draw = new LottoDraw(view);
		LottoResult result = new LottoResult(view);
		LottoController controller = new LottoController(view);  // controller에 view를 넘겨주는 객체
		view.drawPanel.NumberButtonListener(controller.numberButtonListener);   // draw에 coltroller의 메뉴버튼리스너 추가
		//view.drawPanel.ResultButtonListener(result.resultButtonListener);
		frame.getContentPane().add(view);   //  JFrame 안에 JPanel객체 넣기
		frame.pack();                        //  내용 크기에 맞게 윈도우조정
		frame.setVisible(true);                //  화면상에 보여지도록 설정
		
		//winNum = new LottoWinNum(view);
		//winNum.WinNumView(1000);	// LottoWinNum클래스로 1000회차 당첨번호 출력
	

	}

}
 