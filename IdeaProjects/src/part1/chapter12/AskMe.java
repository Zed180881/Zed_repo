package part1.chapter12;

class AskMe {
    static void answer(Answers answers) {
        switch (answers) {
            case NO:
                System.out.println("No.");
                break;
            case YES:
                System.out.println("Yes");
                break;
            case MAYBE:
                System.out.println("Maybe");
                break;
            case LATER:
                System.out.println("Later");
                break;
            case SOON:
                System.out.println("Soon");
                break;
            case NEVER:
                System.out.println("Never");
                break;
        }
    }

    public static void main(String[] args) {
        Question question1 = new Question();
        answer(question1.ask());
        answer(question1.ask());
        answer(question1.ask());
        answer(question1.ask());
    }
}
