import java.io.File;
import java.util.regex.Pattern;

/**
 * � �������� ���� ����� ..mp3 ������� �� �����,
 * � .mp3 ����� �������� . �� ���� ..mp3
 * qwerty.mp3 -> qwerty..mp3
 * asdfg..mp3
 */

/**
 * ������
 * ������� ������� ����� �������� ���� ��� ������ �������������
 * �� .com ��� .ru ��� .ua. ������ ����� ����������� ��������� ������.
 public static boolean test(String testString){
 Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
 Matcher m = p.matcher(testString);
 return m.matches();
 ��� ��������, � ��� ���:
  testString.matches(".+\\.(com|ua|ru)") ����� ���
 */
public class AddTwoDotToAudioFile {
    public static void main(String[] args){
        File[] filesList;
        File filesPath = new File("."); // ������� ������ �� ����� � �������
        filesList = filesPath.listFiles(); // ���������� ����� �� ����� � ������ �������� ���� File
        for(File file : filesList){
            String str = file.getName();
            if( (str.endsWith(".mp3") && (!str.endsWith("..mp3")))){
                System.out.println(str);
                str = str.replaceFirst(".mp3", "..mp3");
                file.renameTo(new File(str));
            }
        }
    }
}
