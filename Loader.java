import java.io.*;
import java.util.Scanner;

public class Loader {
    File path;
    Chat chat = new Chat();

    /**
     * Передача пути к файлу сохранению
     * @throws IOException
     */
    public Loader() throws IOException {
        this.path = new File("Saves//Save1.txt");
    }

    /**
     * Чтение файла сохранения и запись с него текста в рабочий чат. Проблема: не сохраняются изначальные отступы
     * @throws IOException
     */
    void load () throws IOException {
        cleanWorkFile();
        FileReader fr = new FileReader(path);
        Scanner scan = new Scanner(fr);
        FileWriter fw = new FileWriter(chat.connector.file);
        while (scan.hasNext()) {
            fw.write(scan.nextLine());
        }
        fw.flush();
        fw.close();
    }

    /**
     * Чистка рабочего файла для дальнейшей загрузки сохранения
     * @throws IOException
     */
    void cleanWorkFile() throws IOException {
        FileReader fileReader = new FileReader(chat.connector.file);
        FileWriter deleter = new FileWriter(chat.connector.file);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNext()) {
            deleter.write("");
        }
    }

}
