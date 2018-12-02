package io.swagger.client.auth;

public class AuthData {


    private static AuthData instance;
    public static AuthData getInstance() {
        if (instance == null) {
            instance = new AuthData();
            instance.username = "";
            instance.password = "";
        }

        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
}