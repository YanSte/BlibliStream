package app.cci.com.bliblistream.Model.Class;

/**
 * Created by DaRk-_-D0G on 06/11/14.
 */
public class User {
    private String name,password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}