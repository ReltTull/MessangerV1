import java.io.File;

public class DocMessage extends Message{
    String path;
    String name;
    File doc;
    public DocMessage(String path, String name) {
        this.path = path;
        this.name = name;
    }

    @Override
    Object showMessage() {
        return doc;
    }
}
