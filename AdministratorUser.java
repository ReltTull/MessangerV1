import java.io.IOException;

public class AdministratorUser extends User {
    Chat chat = new Chat();
    @Override
    TextMessagesStorage fillingTextMessage() {
        return super.fillingTextMessage();
    }

    public AdministratorUser(String name) throws IOException {
        super(name);
    }

    /**
     * Добавление пользователя в список заблокированных.
     * @param target
     */
    void blockRegUser(RegularUser target) {
        chat.blockedUsersList.add(target.name);
    }
}
