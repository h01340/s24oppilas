package bookstoreproject.bookstore.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignUpForm {

    @NotEmpty
    @Size(min = 5, max = 25)
    private String username = "";

    @NotEmpty
    @Size(min = 5, max = 25)
    private String password = "";

    @NotEmpty
    @Size(min = 5, max = 25)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SignUpForm username(String username) {
        setUsername(username);
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpForm password(String password) {
        setPassword(password);
        return this;
    }

    public String getPasswordCheck() {
        return this.passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public SignUpForm passwordCheck(String passwordCheck) {
        setPasswordCheck(passwordCheck);
        return this;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SignUpForm role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", passwordCheck='" + getPasswordCheck() + "'" +
                ", role='" + getRole() + "'" +
                "}";
    }
}
