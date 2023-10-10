package Semm_3;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив
 * размером 4х4. При подаче массива другого размера необходимо бросить
 * исключение MyArraySizeException.
 */
public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Ваша матрица не квадрат");
    }
}
