import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        RegularUser roman = new RegularUser("Roman");
        AdministratorUser zloy = new AdministratorUser("Zloy");
        zloy.blockRegUser(roman);
        chat.sendTextMessage(roman.fillingTextMessage(), roman);
        chat.readTextMessages();
//        for (int i = 0; i < chat.blockedUsersList.size(); i++) {
//            System.out.println(chat.blockedUsersList.get(i));
//        }

    }
}
