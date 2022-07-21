import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Chat {
    Connector connector = new Connector();
    Date dateNow = new Date();

    /**
     * Список заблокированных пользователей. Без static список обнуляется.
     */
    static ArrayList<String> blockedUsersList = new ArrayList<>();

    FileWriter writer = new FileWriter(connector.file, true);
    DocMessage docMessage;

    public Chat() throws IOException {
    }

    /**
     * Метод проверяет, находится ли пользователь в списке заблокированных и, если нет, - записывает в файл сообщения,
     * добавляя отправителя и время
     * @param tm сообщение, созданное в классе RegularUser/AdministratorUser/ChatHolder
     * @param user
     * @throws IOException
     */
    public void sendTextMessage(TextMessage tm, RegularUser user) throws IOException {
        if (!blockedUsersList.contains(user.name)) {
            writer.write(tm.showMessage() + "\n" + user.name + ", " + dateNow + "\n");
            writer.flush();
            writer.close();
        }
        else return;
    }

    /**
     * Метод при помощи связки FileReader и Scanner проходится по файлу с сообщениями и выводит их
     * @throws IOException
     */
    public void readTextMessages() throws IOException {
        FileReader reader = new FileReader(connector.file);
        Scanner scan = new Scanner(reader);
        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
        reader.close();
    }

//    public void sendDocMessage(DocMessage dm, User user, String newPath, String newName) {
//        File newFile = new File(newPath, newName);
//        try {
//            boolean create = newFile.createNewFile();
//            if (create)
//                System.out.println("File has been created");
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//    }

}
