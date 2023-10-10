package Semm_3;

/**
 * Создайте класс исключения, который будет выбрасываться при делении на
 * 0. Исключение должно отображать понятное для пользователя сообщение
 * об ошибке.
 */
public class MyException extends RuntimeException {
    public MyException() {
        super("Нельзя делить на 0 целые числа");
    }
}
