import java.io.File;

/**
 * ������� ����� ����� (������ 4 ������� � �����)
 */
public class DelFourAudioFile {
    public static void main(String[] args){
        File[] filesList;
        File filesPath = new File("."); // ������� ������ �� ����� � �������
        filesList = filesPath.listFiles(); // ���������� ����� �� ����� � ������ �������� ���� File
        for(File file : filesList){
            String str = file.getName();
            if( (str.endsWith(".mp3") ) ) {
                System.out.println(str);
                str = str.substring(4);
                file.renameTo(new File(str));
            }
        }
    }
}
