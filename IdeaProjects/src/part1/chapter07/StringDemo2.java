package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class StringDemo2 {
    public static void main(String[] args) {
        String string1 = "First string";
        String string2 = "Second string";
        String string3 = string1;

        System.out.println("Length of first string: " + string1.length());
        System.out.println("Character with index 3 in first string: " + string1.charAt(3));

        if (string1.equals(string2))
            System.out.println("string1 == string2");
        else
            System.out.println("string1 != string2");

        if (string1.equals(string3))
            System.out.println("string1 == string3");
        else
            System.out.println("string1 != string3");

    }
}
