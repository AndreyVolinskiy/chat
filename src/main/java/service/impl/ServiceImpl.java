package service.impl;

import dao.factory.DaoFactory;
import model.User;
import service.Service;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class ServiceImpl implements Service {
    @Override
    public boolean checkRegistration(User chekingUser) throws NullPointerException{
        String password;
        String login = chekingUser.getLogin();
        User registeredUser = DaoFactory.getDaoMethods().getUserByLogin(login);
        if (registeredUser == null) {
            return false;
        } else {
            password = registeredUser.getPassword();
            return password.equals(chekingUser.getPassword());
        }
    }
}