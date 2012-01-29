package textgame;

public class UserResponse {
    private UserResponseType type;
    public UserResponseType getType() { return type; }

    private String message;
    public String getMessage() { return message; }

    public UserResponse(UserResponseType t, String m) {
        type = t;
        message = m;
    }

    public static UserResponse message(String m) {
        return new UserResponse(UserResponseType.MESSAGE, m);
    }

    public static UserResponse error(String m) {
        return new UserResponse(UserResponseType.ERROR, m);
    }

    public static UserResponse win(String m) {
        return new UserResponse(UserResponseType.WIN, m);
    }

    public static UserResponse quit(String m) {
        return new UserResponse(UserResponseType.QUIT, m);
    }
}
