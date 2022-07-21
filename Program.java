import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        RegularUser roman = new RegularUser("Roman");
        chat.addUserToChat(roman);
        AdministratorUser admin = new AdministratorUser("Admin");
        chat.addUserToChat(admin);
//        admin.blockRegUser(roman);
//        chat.sendTextMessage(admin.fillingTextMessage(), admin);
        chat.sendTextMessage(roman.fillingTextMessage(), roman);
        chat.readTextMessages();
//        chat.showBlockedUsers();

    }
}
