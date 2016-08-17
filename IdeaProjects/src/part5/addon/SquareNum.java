package part5.addon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * В этом классе демнострируеться применение
 * документирующих комментариев
 *
 * @author Герберт Шилдт
 * @version 1.2
 */

public class SquareNum {
    /**
     * Этот метод возвращает квадрат числа.
     * Это многомтрочное описание. В нем можно ввести
     * столько строк, сколько потрпебуется.
     *
     * @param num Значение, которое требуеться возвести в квадрат
     * @return num Значение возведенное в квадрат
     */
    public double square(double num) {
        return num * num;
    }

    /**
     * Этот метод вводит число, заданное пользователем
     *
     * @return Введенное значение типа double
     * @throws IOException Если при вводе возникает ошибка, то
     *                     генерируется исключение типа IOException
     * @see IOException
     */
    public double getNumber() throws IOException {
        // создать буферизированный поток чтения
        // типа BufferedReader, используя стандартній
        // поток ввода System.in
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inData = new BufferedReader(isr);
        String str;
        str = inData.readLine();
        return new Double(str).doubleValue();
    }

    /**
     * Этот метод демонстрирует применение метода square()
     *
     * @param args Не используется
     * @throws IOException Если при вводе возникает ошибка, то
     *                     генерируется исключение типа IOException
     * @see IOException
     */
    public static void main(String[] args) throws IOException {
        SquareNum ob = new SquareNum();
        double val;
        System.out.println("Введите значение для возведения в квадрат: ");
        val = ob.getNumber();
        val = ob.square(val);
        System.out.println("Квадрат значения равен " + val);
    }
}
