package Semm_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson_1_Tasks {
    public static void main(String[] args) {

        // Задача 2 найти файл если он существует, и не прекращать работу приложения
        {
            Scanner scanner = new Scanner(System.in);

            boolean flag = true;
            while (flag) {
                System.out.print("Введите имя файла -> ");
                var fileName = scanner.nextLine();
                try {
                    FileReader fileReader = new FileReader(fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("Не удается найти указанный файл");
                    continue;
                }
                flag = false;
            }
        }

        // Задача 3
        {

            int[] defArray = compareArrays(
                    new int[]{1, 5, 3, 4, 5},
                    new int[]{6, 4, 2, 5, 9});
            if (defArray == null) {
                System.out.println("Массивы не равны, без обид");
            } else {
                System.out.println(Arrays.toString(defArray));
            }

        }

        // Задача 4
        {
            int[][] array = new int[][]
                    {
                            {1, 0, 1, 1, 0},
                            {1, 0, 1, 0, 0},
                            {1, 0, 1, 0, 0},
                            {1, 0, 1, 0, 1},
                            {1, 0, 1, 0, 1}
                    };
            int[][] array2 = null;

            int result = sumArray(array);
            if (result == -1) {
                System.out.println("Значения должны быть 0 или 1");
            } else if (result == -2) {
                System.out.println("Массив не квадратный, а твоя голова да");
            } else if (result == -3) {
                System.out.println("Массив должен быть инициализирован");
            } else {
                System.out.println(result);
            }
        }

    }


    /*
    Задача 3.
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */
    private static int[] compareArrays(int[] x, int[] y) {
        if (x.length == y.length) {
            int[] m = new int[x.length];
            for (int i = 0; i < x.length; i++) {
                m[i] = x[i] + y[i];
            }
            return m;
        }
        return null;
    }

    /*
    Задача 4.
    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива.
    При этом накладываем на метод 2 ограничения: метод может работать только с квадратными
    массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
    Если нарушается одно из условий, метод должен вернуть код ошибки.
    Программа должна корректно обработать код ошибки и вывести соответствующее сообщение пользователю.
     */
    private static int sumArray(int[][] array) {
        if (array == null) {
            return -3;
        }
        int row = array.length;
        int column = array[0].length;
        int sum = 0;
        if (row == column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (array[i][j] != 0 && array[i][j] != 1) {
                        return -1;
                    }
                    sum += array[i][j];
                }
            }
            return sum;
        }
        return -2;
    }


}
