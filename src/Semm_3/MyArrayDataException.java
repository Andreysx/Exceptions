package Semm_3;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. делайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Нужно бросить
 * исключение, если работа с объектом типа счетчик была не в ресурсном try
 * и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
 * лучше всего.
 */
public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super(String.format("Неправильный элемент на месте %d:%d", i, j));
    }
}
