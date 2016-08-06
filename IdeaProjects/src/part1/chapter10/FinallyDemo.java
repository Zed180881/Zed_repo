package part1.chapter10;

class FinallyDemo {
    static void procA() {
        try {
            System.out.println("In method procA()");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("finally block in procA()");
        }
    }

    static void procB() {
        try {
            System.out.println("In method procB()");
            return;
        } finally {
            System.out.println("finally block in procB()");
        }
    }

    static void procC() {
        try {
            System.out.println("In method procC()");
        } finally {
            System.out.println("finally block in procC()");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception catched");
        }
        procB();
        procC();
    }

}