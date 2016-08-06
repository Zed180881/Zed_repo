package part1.chapter19;

import java.util.Optional;

class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty();
        Optional<String> hasVal = Optional.of("ABCDEFG");

        if (noVal.isPresent())
            System.out.println("Not shown");
        else
            System.out.println("Object noVal has no value");
        if (hasVal.isPresent())
            System.out.println("Object hasVal contain String: " + hasVal.get());

        String defStr = noVal.orElse("Default String");
        System.out.println(defStr);
    }
}
