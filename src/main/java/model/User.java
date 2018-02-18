package model;


import lombok.*;

import java.util.List;

/**
 * @author Andrey Volinskiy on 17.02.2018.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
     String login;
    private String password;
    private List<String> messagesTo;
    private List<String> messagesFrom;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
