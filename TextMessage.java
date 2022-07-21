public class TextMessage extends Message{
    private String text;
    public TextMessage(String text) {
        this.text = text;
    }
    @Override
    String showMessage() {
        return text;
    }
}
