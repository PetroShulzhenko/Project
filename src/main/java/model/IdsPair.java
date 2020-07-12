package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IdsPair {
    @XmlElement
    private final String login;
    @XmlElement
    private final String password;

    public IdsPair(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "IdsPair={" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                "}";
    }
}
