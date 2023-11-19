import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JFrame;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Lotto extends JFrame {
	static LottoWinNum winNum;

	public static void main(String[] args) { // main �Լ�
		JFrame frame = new JFrame("Lotto Drawer");   // JFrame ��ü ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // �ݱ��ư�� ������ �� ����
		frame.setResizable(false);                   // â ũ�� ����
		
		LottoView view = new LottoView();    // ������ JPanel Ŭ���� ��ü
		LottoDraw draw = new LottoDraw(view);
		LottoResult result = new LottoResult(view);
		LottoController controller = new LottoController(view);  // controller�� view�� �Ѱ��ִ� ��ü
		view.drawPanel.NumberButtonListener(controller.numberButtonListener);   // draw�� coltroller�� �޴���ư������ �߰�
		//view.drawPanel.ResultButtonListener(result.resultButtonListener);
		frame.getContentPane().add(view);   //  JFrame �ȿ� JPanel��ü �ֱ�
		frame.pack();                        //  ���� ũ�⿡ �°� ����������
		frame.setVisible(true);                //  ȭ��� ���������� ����
		
		//winNum = new LottoWinNum(view);
		//winNum.WinNumView(1000);	// LottoWinNumŬ������ 1000ȸ�� ��÷��ȣ ���
	

	}

}
 