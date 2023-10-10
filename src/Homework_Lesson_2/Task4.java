package Homework_Lesson_2;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        /**
         * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
         * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
         */
        String result = inputLine();
        if (result.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        } else {
            System.out.println("Вы ввели -> " + result);
        }
    }

    public static String inputLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку -> ");
        return scanner.nextLine();
    }

}
