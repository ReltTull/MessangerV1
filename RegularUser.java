public class RegularUser extends User{
//    DocMessage dm;

    public RegularUser(String name) {
        super(name);
    }

    @Override
    TextMessagesStorage fillingTextMessage() {
        return super.fillingTextMessage();
    }


//    DocMessage createDocMessage(String path, String name) {
//        dm = new DocMessage(path, name);
//        return dm;
//    }

}
