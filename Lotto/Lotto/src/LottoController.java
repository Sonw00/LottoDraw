import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

public class LottoController {

	public LottoView view;
	public NumberButtonListener numberButtonListener;
	public Set<Integer> includNumSet = new TreeSet<Integer>();
	public Set<Integer> excludNumSet = new TreeSet<Integer>();
	
	public LottoController(LottoView v) {
		view = v;
		numberButtonListener = new NumberButtonListener();
		
	}
	
	class NumberButtonListener implements ActionListener{
		public Set<Integer> drawNumSet;
		public int bnusNum;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			for(int i=0; i<45;i++) {			// 선택된 버튼 검사
				if (obj == view.drawPanel.btnNumArray[i]) {
					int n = i+1;
					if(includNumSet.contains(n)) {
						view.drawPanel.btnNumArray[i].setBackground(new Color(0xFFCBCB));;
						includNumSet.remove(n);
						excludNumSet.add(n);
					}
					else if(excludNumSet.contains(n)) {
						view.drawPanel.btnNumArray[i].setBackground(Color.white);
						excludNumSet.remove(n);
					}
					else {
						view.drawPanel.btnNumArray[i].setBackground(new Color(0xCFCFCF));
						includNumSet.add(n);
					}
				}
			}
			System.out.println("included number : " + includNumSet);
			System.out.println("excluded number : " + excludNumSet);
			if(obj == view.drawPanel.clearButton) {
				for(int i=0; i<45;i++) {	
					view.drawPanel.btnNumArray[i].setBackground(Color.white);
				}
				includNumSet.clear();
				excludNumSet.clear();
			}
			if(obj == view.drawPanel.drawButton) {
				drawNumSet = new TreeSet<Integer>();
				Integer[] drawNumList;
				
				
				if(includNumSet.size()<=6) {
					drawNumSet.addAll(includNumSet);
					for(int i=0; i<(6-includNumSet.size());i++) {
						int d;
						do {
						d = (int)((Math.random()*45.0) + 1.0);}
						while(drawNumSet.contains(d)||excludNumSet.contains(d));
						drawNumSet.add(d);
					}
					do {
					bnusNum = (int)((Math.random()*45.0) + 1.0);}
					while(drawNumSet.contains(bnusNum)||excludNumSet.contains(bnusNum));
				}
				if(includNumSet.size()>6) {
					for(int i=0; i<6; i++) {
						int d;
						do {
						d = (int)((Math.random()*45.0) + 1.0);}
						while(!includNumSet.contains(d)||drawNumSet.contains(d)); 
						drawNumSet.add(d);
					}
					do {
					bnusNum = (int)((Math.random()*45.0) + 1.0);}
					while(!includNumSet.contains(bnusNum)||drawNumSet.contains(bnusNum)); 
				}
				System.out.print(" draw number : " + drawNumSet);
				System.out.println(" + "+bnusNum);
				drawNumList = drawNumSet.toArray(new Integer[0]);
				view.resultPanel.drawButtonPressed(drawNumList, bnusNum);
			}
	}
}
}
