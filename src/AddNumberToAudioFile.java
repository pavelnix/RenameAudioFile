import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Аргументом программы является файл вида
 * 1 qwert.
 * 2 ncjdfv.
 * Программа считывает строку из файла, ищет в каталоге файл (qwert. + .mp3) и
 * переименовывает его в 001 qwert..mp3
 */

/**
 * Todo
 * добавить логирование какие файлы были переименованы а какие нет.
 */

public class AddNumberToAudioFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
       while (scanner.hasNext()){
            int number = scanner.nextInt();
            System.out.println(number);
            scanner.skip(Pattern.compile("([ ]+)"));
            String fileName = scanner.nextLine();
            System.out.println(fileName);
            fileName += ".mp3";
            File file = new File(fileName); // создаем объект на файл test.txt
            if(file.exists()){ // если файл существует, то переименовываем его
                  file.renameTo(new File(String.format("%03d %s", number, fileName)));//number + fileName));
            }
            else{
                System.out.println("File not found!");
            }
            System.out.println();
        }
    }
 }
