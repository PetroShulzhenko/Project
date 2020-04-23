package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login {
    @XmlElement
    private final String login;
    @XmlElement
    private final String password;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Login other = (Login) o;

        return login.equals(other.login) & password.equals(other.password);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();

        return result;
    }
}
