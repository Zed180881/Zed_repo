package tictactoe;
/**
* ���� ��������-������ �� ����� 3x3
*/

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class TicTacToe extends Applet implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Button squares[] [];
	Button newGameButton;
	Label score;
	Label plScore;
	Label compScore;
	int plPoints = 0;
	int compPoints = 0;
	int emptySquaresLeft=9;
/**
* ����� init � ��� ����������� �������
*/

	public void init() {
		//������������� �������� ������������ �������, ����� � ����
		this.setLayout(new BorderLayout());
		this.setBackground(Color.CYAN);
		// �������� ����� ������� ���, ����� �� ��� ������
		// � ���� ������ 20
		Font appletFont=new Font("Monospased",Font.BOLD, 20);
		this.setFont(appletFont);
		// ������� ������ �New Game� � ������������ � ���
		// ��������� ��������			
		plScore = new Label("Player - " + plPoints + " points");
		compScore = new Label("Computer - " + compPoints + " points");
		newGameButton=new Button("New Game");
		newGameButton.addActionListener(this);
		Panel topPanel=new Panel();
		topPanel.setLayout(new GridLayout(3,1));
		topPanel.add(plScore);
		topPanel.add(compScore);
		topPanel.add(newGameButton);		
		this.add(topPanel,"North");
		Panel centerPanel=new Panel();
		centerPanel.setLayout(new GridLayout(3,3));
		this.add(centerPanel,"Center");
		score=new Label("Your turn!");
		this.add(score,"South");
		// ������� ������, ����� ������� ������ �� 9 ������
		squares=new Button[3][3];
		// ������� ������, ��������� ������ �� ��� � �������
		// ������������ � ��� ���������, ������ ��
		// � ��������� ���� � ��������� �� ������
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
			squares[i][j]=new Button();
			squares[i][j].addActionListener(this);
			squares[i][j].setBackground(Color.ORANGE);
			centerPanel.add(squares[i][j]);
			}
		}
	}
/**
* ���� ����� ����� ������������ ��� �������
* @param ActionEvent ������
*/
	public void actionPerformed(ActionEvent e) {
		Button theButton = (Button) e.getSource();
		// ��� ������ New Game ?
		if (theButton ==newGameButton){
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++) {
					squares[i][j].setEnabled(true);
					squares[i][j].setLabel("");
					squares[i][j].setBackground(Color.ORANGE);
				}
			}
			emptySquaresLeft=9;
			score.setText("Your turn!");
			newGameButton.setEnabled(false);
			return; // ������� �� ������
		}
		String winner = "";
		// ��� ���� �� ������?
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
			if ( theButton == squares[i][j] && theButton.getLabel() == "") {
				squares[i][j].setLabel("X");
				winner = lookForWinner();
				if(!"".equals(winner)){
					endTheGame();
				} else {
					computerMove();
					winner = lookForWinner();
					if ( !"".equals(winner)){
						endTheGame();
					}
				}
				break;
			}
			}
		} // ����� ����� for
		if ( winner.equals("X") ) {
			score.setText("You won!");
			plPoints++;
			plScore.setText("Player - " + plPoints + " points");
		} else if (winner.equals("O")){
			score.setText("You lost!");
			compPoints++;
			compScore.setText("Computer - " + compPoints + " points");
		} else if (winner.equals("T")){
			score.setText("It's a tie!");
		}
	} // ����� ������ actionPerformed		
/**
* ���� ����� ���������� ����� ������� ����, ����� ������,
* ���� �� ����������. �� ��������� ������ ���, �������
* � ���������, ����� ����� ��� ������ � ����������� ���������
* (�� �������)
* @return "X", "O", "T" � �����, "" - ��� ��� ����������
*/
	String lookForWinner() {
		String theWinner = "";
		emptySquaresLeft--;
		if (emptySquaresLeft==0){
			return "T"; // ��� �����. T �� ����������� ����� tie
		}
		// ��������� ��� 1 � �������� ������� 0,1,2
		if (!squares[0][0].getLabel().equals("") &&
		squares[0][0].getLabel().equals(squares[0][1].getLabel()) &&
		squares[0][0].getLabel().equals(squares[0][2].getLabel())) {
			theWinner = squares[0][0].getLabel();
			highlightWinner(0,0,0,1,0,2);
		// ��������� ��� 2 � �������� ������� 3,4,5
		} else if (!squares[1][0].getLabel().equals("") &&
		squares[1][0].getLabel().equals(squares[1][1].getLabel()) &&
		squares[1][0].getLabel().equals(squares[1][2].getLabel())) {
			theWinner = squares[1][0].getLabel();
			highlightWinner(1,0,1,1,1,2);
		// ��������� ��� 3 � �������� ������� 6,7,8
		} else if ( ! squares[2][0].getLabel().equals("") &&
		squares[2][0].getLabel().equals(squares[2][1].getLabel()) &&
		squares[2][0].getLabel().equals(squares[2][2].getLabel())) {
			theWinner = squares[2][0].getLabel();
			highlightWinner(2,0,2,1,2,2);
		// ��������� ������� 1 � �������� ������� 0,3,6
		} else if ( ! squares[0][0].getLabel().equals("") &&
		squares[0][0].getLabel().equals(squares[1][0].getLabel()) &&
		squares[0][0].getLabel().equals(squares[2][0].getLabel())) {
			theWinner = squares[0][0].getLabel();
			highlightWinner(0,0,1,0,2,0);
		// ��������� ������� 2 � �������� ������� 1,4,7
		} else if ( ! squares[0][1].getLabel().equals("") &&
		squares[0][1].getLabel().equals(squares[1][1].getLabel()) &&
		squares[0][1].getLabel().equals(squares[2][1].getLabel())) {
			theWinner = squares[0][1].getLabel();
			highlightWinner(0,1,1,1,2,1);
		// ��������� ������� 3 � �������� ������� 2,5,8
		} else if ( ! squares[0][2].getLabel().equals("") &&
		squares[0][2].getLabel().equals(squares[1][2].getLabel()) &&
		squares[0][2].getLabel().equals(squares[2][2].getLabel())) {
			theWinner = squares[0][2].getLabel();
			highlightWinner(0,2,1,2,2,2);
		// ��������� ������ ��������� � �������� ������� 0,4,8
		} else if ( ! squares[0][0].getLabel().equals("") &&
		squares[0][0].getLabel().equals(squares[1][1].getLabel()) &&
		squares[0][0].getLabel().equals(squares[2][2].getLabel())) {
			theWinner = squares[0][0].getLabel();
			highlightWinner(0,0,1,1,2,2);
		// ��������� ������ ��������� � �������� ������� 2,4,6
		} else if ( ! squares[0][2].getLabel().equals("") &&
		squares[0][2].getLabel().equals(squares[1][1].getLabel()) &&
		squares[0][2].getLabel().equals(squares[2][0].getLabel())) {
			theWinner = squares[0][2].getLabel();
			highlightWinner(0,2,1,1,2,0);
		}
		return theWinner;
	}
/**
* ���� ����� ��������� ����� ������, ����� �����
* ������ ������������ ���. ���� ������� ���
* �� ������, ���������� ��������� ������.
*/
	void computerMove() {
		int selectedSquare;
		// ������� ��������� �������� ����� ������ ������
		// ����� � ����� �������� � ��������, ����� ��������
		selectedSquare = findEmptySquare("O");
		// ���� �� �� ����� ����� ��� ������, �� ���� ��
		// ���������� �� ���� ��������� ������� ��� �� 3-�
		// ���������,�������� ����� ����� � ����� ����������
		if ( selectedSquare == -1 ) {
		selectedSquare = findEmptySquare("X");
		}
		// ���� selectedSquare ��� ��� ����� -1, ��
		// ���������� ������ ����������� ������
		if ( (selectedSquare == -1)
		&&(squares[1][1].getLabel().equals("")) ){
			selectedSquare=1;
			printMove(selectedSquare, selectedSquare);
		}
		// �� ������� � ����������� �������...
		// ������ �������� ��������� ������
		if ( selectedSquare == -1 ){
			selectedSquare = getRandomSquare();
		}
	}
	//������ ������� �����������, ��� ��� ������ 
	//������ ����� ������ ����
	//����� ��������� ����� ��� ������ �� ����� �������
	int printMove(int x, int y){
	     squares[x][y].setLabel("O");
//	     squares[x][y].setEnabled(false);
	     return 0;
	}
/**
* ���� ����� ��������� ������ ���, ������� � ���������
* ����� ������, ���� �� � ��� ��� ������
* � ����������� ��������� � ������ �������.
* @param ���������� X � ��� ������������ � O � ��� �����
* @return ���������� ��������� ������,
* ��� -1, ���� �� ������� ��� ������
* � ����������� ���������
*/
	int findEmptySquare(String player) {
		int weight[][] = new int[3][3];
		for ( int i = 0; i < 3; i++ ) {
			for ( int j = 0; j < 3; j++ ) {
				if ( squares[i][j].getLabel().equals("O") ) {
					weight[i][j] = -1;
				} else if ( squares[i][j].getLabel().equals("X") ) {
					weight[i][j] = 1;
				} else {
					weight[i][j] = 0;
				}
			}
		}
		int twoWeights = player.equals("O") ? -2 : 2;
		// ��������, ���� �� � ���� 1 ��� ���������� ������ �
		// ���� ������.
		if ( weight[0][0] + weight[0][1] + weight[0][2] == twoWeights ) {
			if ( weight[0][0] == 0 )
				return printMove(0,0);
			else if ( weight[0][1] == 0 )
				return printMove(0,1);
			else
				return printMove(0,2);
		}
		// ��������, ���� �� � ���� 2 ��� ���������� ������ �
		// ���� ������.
		if (weight[1][0] +weight[1][1] + weight[1][2] == twoWeights) {
			if ( weight[1][0] == 0 )
				printMove(1,0);
			else if ( weight[1][1] == 0 )
				return printMove(1,1);
			else
				return printMove(1,2);
		}
		// ��������, ���� �� � ���� 3 ��� ���������� ������ �
		// ���� ������.
		if (weight[2][0] + weight[2][1] +weight[2][2] == twoWeights ) {
			if ( weight[2][0] == 0 )
				return printMove(2,0);
			else if ( weight[2][1] == 0 )
				return printMove(2,1);
			else
				return printMove(2,2);
		}
		// ��������, ���� �� � ������� 1 ��� ���������� ������ �
		// ���� ������.
		if (weight[0][0] + weight[1][0] + weight[2][0] == twoWeights) {
			if ( weight[0][0] == 0 )
				return printMove(0,0);
			else if ( weight[1][0] == 0 )
				return printMove(1,0);
			else
				return printMove(2,0);
		}
		// ��������, ���� �� � ������� 2 ��� ���������� ������
		// � ���� ������.
		if (weight[0][1] +weight[1][1] + weight[2][1] == twoWeights ) {
			if ( weight[0][1] == 0 )
				return printMove(0,1);
			else if ( weight[1][1] == 0 )
				return printMove(1,1);
			else
				return printMove(2,1);
		}
		// ��������, ���� �� � ������� 3 ��� ���������� ������
		// � ���� ������.
		if (weight[0][2] + weight[1][2] + weight[2][2] == twoWeights ){
			if ( weight[0][2] == 0 )
				return printMove(0,2);
			else if ( weight[1][2] == 0 )
				return printMove(1,2);
			else
				return printMove(2,2);
		}
		// ��������, ���� �� � ��������� 1 ��� ���������� ������
		// � ���� ������.
		if (weight[0][0] + weight[1][2] + weight[2][2] == twoWeights ){
			if ( weight[0][0] == 0 )
				return printMove(0,0);
			else if ( weight[1][2] == 0 )
				return printMove(1,1);
			else
				return printMove(2,2);
		}
		// ��������, ���� �� � ��������� 2 ��� ���������� ������
		// � ���� ������.
		if (weight[0][2] + weight[1][1] + weight[2][0] == twoWeights ){
			if ( weight[0][2] == 0 )
				return printMove(0,2);
			else if ( weight[1][1] == 0 )
				return printMove(1,1);
			else
				return printMove(2,0);
		}
		// �� ������� ���� ���������� �������� ������
		return -1;
	} // ����� ������ findEmptySquare()
/**
* ���� ����� �������� ����� ������ ������
* @return �������� ��������� ����� ������
*/
	int getRandomSquare() {
		boolean gotEmptySquare = false;
		int selectedSquareX= -1;
		int selectedSquareY=0;
		do {
			selectedSquareX = (int) (Math.random() * 3 );
			selectedSquareY = (int) (Math.random() * 3 );
			if (squares[selectedSquareX][selectedSquareY].getLabel().equals("")){
				gotEmptySquare = true; // ����� ��������� ����
			}
		} while (!gotEmptySquare );
		return printMove(selectedSquareX,selectedSquareY);
	} // ����� ������ getRandomSquare()
/**
* ���� ����� �������� ���������� �����.
* @param ������, ������ � ������ ������ ��� ���������
*/
	void highlightWinner(int win1, int win2, int win3, int win4, int win5, int win6) {
		squares[win1][win2].setBackground(Color.CYAN);
		squares[win3][win4].setBackground(Color.CYAN);
		squares[win5][win6].setBackground(Color.CYAN);
	}
// ������ ������������ ������ � ��������� ������ �New Game�
	void endTheGame(){
		newGameButton.setEnabled(true);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				squares[i][j].setEnabled(false);
			}
		}
	}
	public static void main(String[] args){
        //��������� ����� main() ��� Java ����������
        Applet tictac=new TicTacToe();
        JFrame frame=new JFrame("�������� � ������");
        frame.getContentPane().add(tictac);
        frame.setSize(200,300);
        tictac.init();
        tictac.start();
        //����������� �������, ����� 
        //�� ����� ����� ��������� �����
        frame.setVisible(true); 
	}
} // ����� ������