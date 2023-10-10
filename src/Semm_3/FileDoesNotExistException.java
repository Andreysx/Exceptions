package Semm_3;

import java.io.IOException;

/**
 * Создайте класс исключения, которое будет возникать при попытке открыть
 * несуществующий файл. Исключение должно отображать понятное для
 * пользователя сообщение об ошибке.
 */
public class FileDoesNotExistException extends IOException {
    public FileDoesNotExistException(String path) {
        super(path + " -> По указанному пути файл не найден");
    }
}
