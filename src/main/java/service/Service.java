package service;

import model.User;

import java.util.List;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public interface Service {

    boolean checkRegistration(User user);

    User getUserById(int id);

    User getUserByLogin(String name);

    List<User> getAllUsers();

    void createNewUser(User user);

    void writeMessageToDB(String message, User userFrom, User userTo);

    String getAllMessages(User userFrom, User userTo);

}
