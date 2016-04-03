import java.io.File;
import java.util.regex.Pattern;

/**
 * В каталоге есть файлы ..mp3 трогать не нужно,
 * а .mp3 нужно добавить . то есть ..mp3
 * qwerty.mp3 -> qwerty..mp3
 * asdfg..mp3
 */

/**
 * ВОПРОС
 * Напишем простой метод проверки того что строка заканчивается
 * на .com или .ru или .ua. Этакий очень примитивный валидатор ссылки.
 public static boolean test(String testString){
 Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
 Matcher m = p.matcher(testString);
 return m.matches();
 Так работает, а вот так:
  testString.matches(".+\\.(com|ua|ru)") вроде нет
 */
public class AddTwoDotToAudioFile {
    public static void main(String[] args){
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
    }
}
