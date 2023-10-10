package Semm_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Lesson_2_Tasks {
    public static void main(String[] args) {
//        String res = "Исключения не было";
//        try {
//            Integer result = temp_divide(5, 3);
//        } catch (ArithmeticException e) {
//            res = "Было исключение";
//        } finally {
//            System.out.println(res);
//        }
//        Integer result = temp_divide(5, 0);

//        try {
//            FileReader fileReader = new FileReader("text.txt");
//            String result = "";
//            while (fileReader.ready()) {
//                result += (char) fileReader.read();
//            }
//            String[] strSplit = result.split(","); // ["5", "3"]
//            int i = Integer.parseInt(strSplit[0]) / Integer.parseInt(strSplit[1]);
//            System.out.println(strSplit[1000]);
//        } catch (IOException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
//            System.out.println(e.getMessage());
//        }

//        try {
//            divide_v2(5, 0);
//        } catch (TheBestException e){
//            System.out.println(e.getMessage());
//        }

        try(FileWriter fileWriter = new FileWriter("ttt.txt")){
            fileWriter.write("111");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(FileReader fileReader = new FileReader("ttt.txt")){
            while(fileReader.ready()){
                System.out.print((char) fileReader.read());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Integer temp_divide(int a, int b) throws ArithmeticException{
        return divide(a, b);
    }

    //    Написать приложение выкидывающие и перехватывающие исключение.
//    С выводом в консоль сообщения было исключение или нет.
    public static Integer divide(int a, int b) throws ArithmeticException{
        if (b == 0)
            throw new ArithmeticException("Было ИСКЛЮЧЕНИЕ");
        return a / b;
    }

    public static Integer divide_v2(int a, int b) throws TheBestException{
        if (b == 0)
            throw new TheBestException("Вызвано исключение TheBestException");
        return a / b;
    }

}
