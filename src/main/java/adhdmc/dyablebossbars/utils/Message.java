package adhdmc.dyablebossbars.utils;

public enum Message {
    NO_PERMISSION_COLOR("<red>You do not have permission to dye bossbars <colorperm>");

    private final String Message;

    Message(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
