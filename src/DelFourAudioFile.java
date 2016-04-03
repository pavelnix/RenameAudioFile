import java.io.File;

/**
 * Удаляет номер файла (первые 4 символа в имени)
 */
public class DelFourAudioFile {
    public static void main(String[] args){
        File[] filesList;
        File filesPath = new File("."); // создаем объект на папку с файлами
        filesList = filesPath.listFiles(); // записываем файлы из папки в массив объектов типа File
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
