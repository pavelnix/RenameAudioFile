import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���������� ��������� �������� ���� ����
 * 1 qwert.
 * 2 ncjdfv.
 * ��������� ��������� ������ �� �����, ���� � �������� ���� (qwert. + .mp3) �
 * ��������������� ��� � 001 qwert..mp3
 */

/**
 * Todo
 * �������� ����������� ����� ����� ���� ������������� � ����� ���.
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
            File file = new File(fileName); // ������� ������ �� ���� test.txt
            if(file.exists()){ // ���� ���� ����������, �� ��������������� ���
                  file.renameTo(new File(String.format("%03d %s", number, fileName)));//number + fileName));
            }
            else{
                System.out.println("File not found!");
            }
            System.out.println();
        }
    }
 }
