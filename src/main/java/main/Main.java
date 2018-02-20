package main;

import dao.factory.DaoFactory;
import model.User;

/**
 * @author Andrey Volinskiy on 17.02.2018.
 */
public class Main {

    private static User superUser = new User("superUser", "superUser", "superUser");
    private static User general = new User("general", "general", "general");


    public static void main(String[] args) {

        System.out.println(DaoFactory.getDaoMethods().getAllMessages(superUser, general));
    }
}
