import java.util.Scanner;

abstract class User {
    String name;
    TextMessage tm;
    public User(String name) {
        this.name = name;
    }

    /**
     * Наполнение экземпляра TextMessage текстом сообщения.
     * @return
     */
    TextMessage fillingTextMessage() {
        System.out.println("Enter the text message: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        tm = new TextMessage(text);
        return tm;
    }
}
