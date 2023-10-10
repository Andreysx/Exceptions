package Homework_Lesson_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FinalWork {
    /**
     * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
     * разделенные пробелом: Фамилия Имя Отчество датарождения номертелефона пол
     * <p>
     * Форматы данных:
     * фамилия, имя, отчество - строки
     * датарождения - строка формата dd.mm.yyyy
     * номертелефона - целое беззнаковое число без форматирования
     * пол - символ латиницей f или m
     * <p>
     * Приложение должно проверить введенные данные по количеству.
     * Если количество не совпадает с требуемым, вернуть код ошибки, обработать его
     * и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
     * <p>
     * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
     * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
     * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
     * пользователю выведено сообщение с информацией, что именно неверно.
     * <p>
     * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
     * в него в одну строку должны записаться полученные данные, вида
     * <p>
     * <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
     * <p>
     * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
     * <p>
     * Не забудьте закрыть соединение с файлом.
     * <p>
     * При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
     * пользователь должен увидеть стектрейс ошибки.
     */
    public static void main(String[] args) throws Exception {
        inputProcessing(inputData());
    }


    /**
     * Метод, который просит пользователя ввести необходимые данные
     *
     * @return строка введённых данных
     */
    private static String inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите следующие данные в произвольном порядке, разделенные пробелом:\n"
                + "  * Фамилия Имя Отчество датарождения номертелефона пол\n"
                + "Форматы данных:\n"
                + "  * фамилия, имя, отчество - строки\n"
                + "  * датарождения - строка формата dd.mm.yyyy\n"
                + "  * номертелефона - целое беззнаковое число без форматирования (11 цифр)\n"
                + "  * пол - символ латиницей f или m");
        return scanner.nextLine();
    }


    /**
     * Метод, который получает строку данных, введённую пользователем.
     * Проверяет, корректно и полностью ли введены данные. В случае, если данные введены некорректно,
     * пробрасывается исключение, какие данные введены неверно. Если всё в порядке, то вызывается метод
     * writeData(), записывающий данне в файл с названием по фамилии из данных.
     *
     * @param input строка введённых данный через пробел(ФИО деньрождения номертелефона пол)
     * @throws Exception проброс исключения в случае некорректных или отсутствующих данных
     */
    private static void inputProcessing(String input) throws Exception {
        String surname = null;
        String name = null;
        String patronymic = null;
        String birthDate = null;
        Long phoneNumber = null;
        String gender = null;

        ArrayList<String> inputData = new ArrayList<>(Arrays.asList(input.trim().split(" ")));

        for (String inputDataEl : inputData) {
            if (checkGender(inputDataEl)) {
                if (gender == null) {
                    gender = inputDataEl;
                }
            } else if (checkPhone(inputDataEl)) {
                if (phoneNumber == null) {
                    phoneNumber = Long.parseLong(inputDataEl);
                }
            } else if (checkDate(inputDataEl)) {
                if (birthDate == null) {
                    birthDate = inputDataEl;
                }
            } else if (checkName(inputDataEl)) {
                if (surname == null) {
                    surname = inputDataEl;
                } else if (name == null) {
                    name = inputDataEl;
                } else if (patronymic == null) {
                    patronymic = inputDataEl;
                }
            }
        }

        if (surname == null || name == null || patronymic == null) {
            throw new FullNameException("Некорректно введены данные ФИО");
        }

        if (birthDate == null) {
            throw new BirthDateException("День рождения введён некорректно или отсутствует");
        }

        if (phoneNumber == null) {
            throw new PhoneNumberException("Номер телефона введён некорректно или отсутствует");
        }

        if (gender == null) {
            throw new GenderException("Пол человека введён некорректно или отсутствует");
        }

        writeData(surname, name, patronymic, birthDate, phoneNumber, gender);
    }


    /**
     * Метод записи данных в файл
     *
     * @param surname     фамилия (String)
     * @param name        имя (String)
     * @param patronymic  отчество (String)
     * @param birthDate   день рождения (String)
     * @param phoneNumber номер телефона (Integer)
     * @param gender      пол (String)
     */
    private static void writeData(
            String surname,
            String name,
            String patronymic,
            String birthDate,
            Long phoneNumber,
            String gender
    ) {
        try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
            String data = surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
            writer.append(data).append("\n");
            writer.flush();
        } catch (RuntimeException | IOException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
        }

        System.out.println("Данные успешно добавлены в файл " + surname + ".txt");
    }


    /**
     * Метод проверяет верность введённой даты.
     * На заметку. Если дата рождения совпадает с текущей датой, или год рождения совпадает или чуть меньше,
     * то странно думать, что у маленького человека есть номер телефона :)
     * Но, чтобы избежать магических цифр в коде, отпустим этот момент.
     *
     * @param date - метод принимает дату в виде стоки
     * @return true - если дата корректна, false - если дата некорректна
     */
    private static boolean checkDate(String date) {
        Pattern pattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher matcher = pattern.matcher(date);

        if (matcher.find()) {
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            Calendar calendar = Calendar.getInstance();
            int currDay = calendar.get(Calendar.DAY_OF_MONTH);
            int currMonth = calendar.get(Calendar.MONTH) + 1;
            int currYear = calendar.get(Calendar.YEAR);

            if (year <= currYear) {
                if (month > 0 && month <= 12) {
                    if (day > 0) {
                        if (year == currYear && month > currMonth) {
                            return false;
                        } else if (year == currYear && month == currMonth && day > currDay) {
                            return false;
                        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
                            return true;
                        } else if (month == 2) {
                            if (year % 4 == 0) {
                                if (day <= 29) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                if (day <= 28) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        } else if (day <= 31) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return false;
    }


    /**
     * Метод проверяет пол человека
     *
     * @param gender - строка должна содержать m (мужчина) или f (женщина)
     * @return true - если дата корректна, false - если дата некорректна
     */
    private static boolean checkGender(String gender) {
        return gender.matches("[fm]");
    }


    /**
     * Метод проверяет номер телефона
     *
     * @param phone - строка должна содержать одиннадцать цифр
     * @return true - если дата корректна, false - если дата некорректна
     */
    private static boolean checkPhone(String phone) {
        return phone.matches("\\d{11}");
    }


    /**
     * Метод проверяет фамилию или имя, или отчество человека, которые ввёл пользователь
     *
     * @param name строка должна содержать фамилию или имя, или отчество
     * @return true - если дата корректна, false - если дата некорректна
     */
    private static boolean checkName(String name) {
        return name.trim().matches("^[\\p{L}]+$");
    }


    /**
     * Исключение, возникающее при некорректных ФИО человека
     */
    public static class FullNameException extends Exception {
        public FullNameException(String errorMessage) {
            super(errorMessage);
        }
    }


    /**
     * Исключение, возникающее при отсутствии введёной даты рождения человека
     */
    public static class BirthDateException extends Exception {
        public BirthDateException(String errorMessage) {
            super(errorMessage);
        }
    }


    /**
     * Исключение, возникающее при отсутствии введённыго номера телефона человека
     */
    public static class PhoneNumberException extends Exception {
        public PhoneNumberException(String errorMessage) {
            super(errorMessage);
        }
    }


    /**
     * Исключение, возникающее при отсутствии введённого пола человека
     */
    public static class GenderException extends Exception {
        public GenderException(String errorMessage) {
            super(errorMessage);
        }
    }
}
