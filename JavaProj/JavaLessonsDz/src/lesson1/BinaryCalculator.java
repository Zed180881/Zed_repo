package lesson1;

public class BinaryCalculator {

	public static String binaryAddition(String s1, String s2) {
	    if (s1 == null || s2 == null) return "";
	    int first = s1.length() - 1;
	    int second = s2.length() - 1;
	    StringBuilder sb = new StringBuilder();
	    int carry = 0;
	    while (first >= 0 || second >= 0) {
	        int sum = carry;
	        if (first >= 0) {
	            sum += s1.charAt(first) - '0';
	            first--;
	        }
	        if (second >= 0) {
	            sum += s2.charAt(second) - '0';
	            second--;
	        }
	        carry = sum >> 1;
	        sum = sum & 1;
	        sb.append(sum == 0 ? '0' : '1');
	    }
	    if (carry > 0)
	        sb.append('1');

	    sb.reverse();
	    return String.valueOf(sb);
	}
	
	public static void main(String[] args) {
		long firstNumber = 456;
		long secondNumber = 158;
		String firstNumberinBinary = Long.toBinaryString(firstNumber);
		String secondNumberinBinary = Long.toBinaryString(secondNumber);
		System.out.println("����� ����� "+firstNumber+" ������� " + firstNumberinBinary + " � ������� ������");
		System.out.println("����� ����� "+secondNumber+" ������� " + secondNumberinBinary + " � ������� ������");
		String binarySumResult = binaryAddition(firstNumberinBinary,secondNumberinBinary);
		int decimalSumresult = Integer.parseInt(binarySumResult, 2);
		System.out.println("���� ����� � ��������� ������ = "+decimalSumresult+" � ������� ������ = "+binarySumResult);		
	}
}
