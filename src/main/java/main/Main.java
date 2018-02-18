package main;

import dao.factory.DaoFactory;
import dao.impl.DaoImpl;
import model.User;
import service.factory.ServiceFactory;

/**
 * @author Andrey Volinskiy on 17.02.2018.
 */
public class Main {


    public static void main(String[] args) {
        User general = new User();
        general.setName("general1");
        general.setLogin("general");
        general.setPassword("general1");

        System.out.println(ServiceFactory.getServiceMethods().checkRegistration(general));

    }

}
