package lesson06;

public class Main {

	public static void main(String[] args) {
//		Person person = new Person("Ivan", 25, Sex.valueOf("MALE"));

//		System.out.println(Sex.FEMALE.toString().equals("FEMALE"));
//
		Month[] months = Month.values();

		for (Month month : months)
			if(month.getSeason()==Seasons.SUMMER)
				System.out.println(month);
//			System.out.println(month);
//		
//		System.out.println(Month.APRIL);
//		System.out.println(Month.APRIL.name());
//		System.out.println(Month.APRIL.compareTo(Month.OCTOBER));
	}

}
