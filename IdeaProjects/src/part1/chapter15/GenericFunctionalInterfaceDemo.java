package part1.chapter15;

class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Lambda is converted to: " + reverse.func("Lambda"));
        System.out.println("Expression is converted to: " + reverse.func("Expression"));

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Factorial of 3: " + factorial.func(3));
        System.out.println("Factorial of 5: " + factorial.func(5));
    }
}
