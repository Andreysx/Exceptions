package Homework_Lesson_2;

public class Task2 {
    public static void main(String[] args) {
        /**
         * Если необходимо, исправьте данный код
         * Задание 2
         */
        try {
            int d = 0;
            double[] intArray = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
