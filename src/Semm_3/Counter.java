package Semm_3;


import java.io.Closeable;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий
 * значение внутренней int переменной на 1. делайте так, чтобы с объектом
 * такого типа можно было работать в блоке try-with-resources. Нужно бросить
 * исключение, если работа с объектом типа счетчик была не в ресурсном try
 * и/или ресурс остался открыт. Подумайте какой тип исключения подойдет
 * лучше всего.
 */
public class Counter implements Closeable {
    private Integer number = 0;

    public void add() {
        this.number++;
    }

    @Override
    public void close() {
        this.number = null;
    }

    @Override
    public String toString() {
        return "Counter{" + "number=" + number + '}';
    }
}
