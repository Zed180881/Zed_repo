package part1.chapter10;

class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }
}
