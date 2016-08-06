package part1.chapter17;

class IsDemo {
    public static void main(String[] args) {
        char[] a = {'a', 'b', '5', '?', 'A', ' '};
        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i]))
                System.out.println(a[i] + " is a Digit");
            if (Character.isLetter(a[i]))
                System.out.println(a[i] + " is a Letter");
            if (Character.isWhitespace(a[i]))
                System.out.println(a[i] + " is a WhiteSpace");
            if (Character.isUpperCase(a[i]))
                System.out.println(a[i] + " is UpperCase");
            if (Character.isLowerCase(a[i]))
                System.out.println(a[i] + " is LowerCase");
        }
    }
}
