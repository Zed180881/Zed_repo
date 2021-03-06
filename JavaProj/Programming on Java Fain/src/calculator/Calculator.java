package calculator;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
	
	JPanel windowContent;
	JFormattedTextField displayField;
	
	JButton[] numButtons;
	
	JButton buttonPoint;
	JButton buttonEqual;
	JButton buttonPlus;
	JButton buttonMinus;
	JButton buttonDiv;
	JButton buttonMult;
	JPanel p1;
	JPanel p2;
	
		Calculator(){
			windowContent= new JPanel();
			
			BorderLayout bl = new BorderLayout();
			windowContent.setLayout(bl);
			
			displayField = new JFormattedTextField();
			displayField.setColumns(30);
			displayField.setHorizontalAlignment(SwingConstants.RIGHT);
			windowContent.add("North",displayField);

//��������� ������ ������ � �������
			
			numButtons= new JButton[10];			
			for(byte i=0;i<10;i++){
				numButtons[i] = new JButton(Byte.toString(i));
			}
			

			buttonPoint = new JButton(".");
			buttonEqual=new JButton("=");
			
			p1 = new JPanel();
			GridLayout gl =new GridLayout(4,3);
			p1.setLayout(gl);
			
// ��������� ������ � ������ (��� 0_ 
			for(byte i=1;i<10;i++){
				p1.add(numButtons[i]);
			}
// ������ ������ 0
			p1.add(numButtons[0]);			

			p1.add(buttonPoint);
			p1.add(buttonEqual);
			
			windowContent.add("Center",p1);
			
			buttonPlus = new JButton("+");
			buttonMinus = new JButton("-");
			buttonDiv = new JButton("/");
			buttonMult = new JButton("*");
			
			p2 = new JPanel();
			p2.setLayout(new GridLayout(4, 1));
			
			p2.add(buttonPlus);
			p2.add(buttonMinus);
			p2.add(buttonDiv);
			p2.add(buttonMult);
			
			windowContent.add("East", p2);			
			
			JFrame frame = new JFrame("Calculator");
			frame.setContentPane(windowContent);
			
			frame.pack();
			frame.setVisible(true);	
			
			CalculatorEngine calcEngine = new CalculatorEngine(this);

			for (byte i=0; i<10; i++){
				numButtons[i].addActionListener(calcEngine);
			}			
			buttonPoint.addActionListener(calcEngine);
			buttonPlus.addActionListener(calcEngine);
			buttonMinus.addActionListener(calcEngine);
			buttonDiv.addActionListener(calcEngine);
			buttonMult.addActionListener(calcEngine);
			buttonEqual.addActionListener(calcEngine);
		}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Calculator calc;
		calc = new Calculator();

	}

}
