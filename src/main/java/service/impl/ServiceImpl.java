package service.impl;

import dao.factory.DaoFactory;
import model.User;
import service.Service;

import java.util.List;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class ServiceImpl implements Service {
    @Override
    public boolean checkRegistration(User chekingUser) throws NullPointerException {
        String password;
        String login = chekingUser.getLogin();
        User registeredUser = DaoFactory.getDaoMethods().getUserByLogin(login);
        if (registeredUser == null) {
            return false;
        } else {
            password = registeredUser.getPassword();
            try {
                return password.equals(chekingUser.getPassword());
            } catch (NullPointerException e) {
                return false;
            }
        }
    }

    @Override
    public User getUserById(int id) {
        return DaoFactory.getDaoMethods().getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return DaoFactory.getDaoMethods().getUserByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return DaoFactory.getDaoMethods().getAllUsers();
    }

    @Override
    public void createNewUser(User user) {
        DaoFactory.getDaoMethods().createNewUser(user);
    }

    @Override
    public void writeMessageToDB(String message, User userFrom, User userTo) {
        DaoFactory.getDaoMethods().writeMessageToDB(message, userFrom, userTo);
    }

    @Override
    public String getAllMessages(User userFrom, User userTo) {
        return DaoFactory.getDaoMethods().getAllMessages(userFrom, userTo);
    }
}