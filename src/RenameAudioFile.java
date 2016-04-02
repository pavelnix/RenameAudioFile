import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 01.04.2016.
 */
public class RenameAudioFile {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(args[0]));

        File[] filesList;
        File filesPath = new File("."); // создаем объект на папку с файлами
        filesList = filesPath.listFiles(); // записываем файлы из папки в массив объектов типа File
        for(File file : filesList){
            String str = file.getName();
            if( (str.endsWith(".mp3") && (!str.endsWith("..mp3")))){
                    System.out.println(str);
                str = str.replaceFirst(".mp3", "..mp3");
                file.renameTo(new File(str));
            }
        }

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
