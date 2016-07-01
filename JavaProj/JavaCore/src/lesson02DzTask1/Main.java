package lesson02DzTask1;

//—творити клас Robot в≥д €кого сл≥д унасл≥дувати CoffeRobot, RobotDancer, RobotCoocker. ¬
//Robot Ї метод work() , в €кому сл≥д описати роботу €ку виконуЇ кожен з робот≥в.
//ƒл€ Robot в метод≥ work() сл≥д написати код, щоб на консоль виводивс€ наступний
//текст Ђя Robot Ц € просто працююї.
//ƒл€ CoffeRobot в метод≥ work() сл≥д написати код, щоб на консоль виводивс€
//наступний текст Ђя CoffeRobot Ц € варю кавуї.
//ƒл€ RobotDancer в метод≥ work() сл≥д написати код, щоб на консоль виводивс€
//наступний текст Ђя RobotDancer Ц € просто танцююї.
//ƒл€ RobotCoocker в метод≥ work() сл≥д написати код, щоб на консоль виводивс€
//наступний текст Ђя RobotCoocker Ц € просто готуюї.
//—творити в Main клас≥ екземпл€ри даних клас≥в ≥ викликати до кожного з них метод work().

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
