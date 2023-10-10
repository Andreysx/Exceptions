package Homework_Lesson_2;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        try {
            System.out.println(task01());
        } catch (Exception e) {
            System.out.println("Ошибка ввода, повторите попытку");
            System.out.println(task01());
        }
    }

    /**
     * Задание 1
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
     * и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
     * вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */
    public static float task01() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число -> ");
        return Float.parseFloat(scanner.nextLine());
    }

}
