public class TextMessagesStorage extends Message{
    private String text;
    public TextMessagesStorage(String text) {
        this.text = text;
    }
    @Override
    String showMessage() {
        return text;
    }
}
