package service;

import model.User;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public interface Service {

    boolean checkRegistration(User user);

    void registration(User user);
}
