package lesson02DzTask1;

//�������� ���� Robot �� ����� ��� ����������� CoffeRobot, RobotDancer, RobotCoocker. �
//Robot � ����� work() , � ����� ��� ������� ������ ��� ������ ����� � ������.
//��� Robot � ����� work() ��� �������� ���, ��� �� ������� ��������� ���������
//����� �� Robot � � ������ �������.
//��� CoffeRobot � ����� work() ��� �������� ���, ��� �� ������� ���������
//��������� ����� �� CoffeRobot � � ���� ����.
//��� RobotDancer � ����� work() ��� �������� ���, ��� �� ������� ���������
//��������� ����� �� RobotDancer � � ������ �������.
//��� RobotCoocker � ����� work() ��� �������� ���, ��� �� ������� ���������
//��������� ����� �� RobotCoocker � � ������ ������.
//�������� � Main ���� ���������� ����� ����� � ��������� �� ������� � ��� ����� work().

public class Main {

	public static void main(String[] args) {

		Robot robot = new Robot();
		robot.work();

		CoffeRobot coffeRobot = new CoffeRobot();
		coffeRobot.work();

		RobotDancer robotDancer = new RobotDancer();
		robotDancer.work();

		RobotCoocker robotCoocker = new RobotCoocker();
		robotCoocker.work();

	}

}
