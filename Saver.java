import java.io.*;
import java.util.Scanner;


public class Saver {
    String path;
    File save;

    Connector connector = new Connector();
    public Saver(String path) throws IOException {
        this.path = path;
        this.save = new File(path);
        save.createNewFile();
    }

    void fillingSaveFile() throws IOException {
        FileReader fileReader = new FileReader(connector.file);
        Scanner scanner = new Scanner(fileReader);
        FileWriter fileWriter = new FileWriter(save);
        while (scanner.hasNext()) {
            fileWriter.write(scanner.nextLine());
        }
        fileWriter.flush();
        fileWriter.close();


    }


}
