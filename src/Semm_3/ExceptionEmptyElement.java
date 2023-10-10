package Semm_3;

/**
 * Создайте класс исключений, которое будет возникать при обращении к
 * пустому элементу в массиве ссылочного типа. Исключение должно
 * отображать понятное для пользователя сообщение об ошибке
 */
public class ExceptionEmptyElement extends NullPointerException {
    public ExceptionEmptyElement() {
        super("Значение элемента массива не может быть nullевым");
    }
}
