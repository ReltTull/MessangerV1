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
     * Список участиков чата.
     */
    static ArrayList<String> chatMembers = new ArrayList<>();
    /**
     * Добавление юзера в чат.
     * @param user
     */
    void addUserToChat(User user) {
        chatMembers.add(user.name);
    }

    static ArrayList<String> chatAdmins = new ArrayList<>();
    void addAdmin(User user) {
        if (chatMembers.contains(user.name)) {
            chatAdmins.add(user.name);
        }
    }

    /**
     * Список заблокированных пользователей. Без static список обнуляется.
     */
    static ArrayList<String> blockedUsersList = new ArrayList<>();

    void showBlockedUsers() {
        System.out.println("Blocked users: ");
        for (int i = 0; i < blockedUsersList.size(); i++) {
            System.out.println(blockedUsersList.get(i));
        }
    }

    FileWriter writer = new FileWriter(connector.file, true);
    DocMessage docMessage;

    public Chat() throws IOException {
    }

    /**
     * Метод проверяет, находится ли пользователь в списке участников чата и не заблокирован ли он, и, если нет, -
     * записывает в файл сообщения, добавляя отправителя и время.
     * @param tm сообщение, созданное в классе RegularUser/AdministratorUser/ChatHolder
     * @param user
     * @throws IOException
     */
    public void sendTextMessage(TextMessage tm, User user) throws IOException {
        if ((chatMembers.contains(user.name)) && (!blockedUsersList.contains(user.name))) {
            writer.write(tm.showMessage() + "\n" + user.name + ", " + dateNow + "\n");
            writer.flush();
            writer.close();
        }
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
