package part1.chapter18;

import java.util.Arrays;

class ArraysDemo {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = -3 * i;
        }
        System.out.print("Source array: ");
        display(array);
        Arrays.sort(array);
        System.out.print("Sorted array: ");
        display(array);
        Arrays.fill(array, 2, 6, -1);
        System.out.print("Array after fill(): ");
        display(array);
        Arrays.sort(array);
        System.out.print("After another sort: ");
        display(array);

        System.out.print("Value -9 is on position: ");
        System.out.println(Arrays.binarySearch(array, -9));
    }

    static void display(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
