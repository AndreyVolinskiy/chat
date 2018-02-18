package dao;

import model.User;

import java.util.List;

/**
 * @author Andrey Volinskiy on 17.02.2018.
 */
public interface Dao {

    User getUserById(int id);

    User getUserByLogin(String name);

    List<User> getAllUsers();

    void createNewUser(User user);

    void writeMessageToDB(String message, User userFrom, User userTo);

}
