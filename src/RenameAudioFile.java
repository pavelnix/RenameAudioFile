import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 01.04.2016.
 */
public class RenameAudioFile {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(args[0]);
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
