package part1.chapter15;

class BlockLambdaDemo2 {
    public static void main(String[] args) {
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Lambda is converted to: " + reverse.func("Lambda"));
        System.out.println("Expression is converted to: " + reverse.func("Expression"));
    }
}
