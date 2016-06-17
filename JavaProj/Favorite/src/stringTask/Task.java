package stringTask;

/* 
–азберитесь почему не работает метод main()
*/
public class Task {
    public static void main(String[] args) {
        System.out.println("Hello");
        
    }


    public static class Object {
        public String string1;
        public String string2;        
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
