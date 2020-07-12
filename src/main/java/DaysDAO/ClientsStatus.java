package DaysDAO;

public class ClientsStatus {
    private final String login;
    private final int status;

    public ClientsStatus(String login, int status) {
        this.login = login;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public int getStatus() {
        return status;
    }
}
