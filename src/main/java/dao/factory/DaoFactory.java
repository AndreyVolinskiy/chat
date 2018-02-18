package dao.factory;

import dao.impl.DaoImpl;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class DaoFactory {
    public static DaoImpl getDaoMethods() {
        return new DaoImpl();
    }
}
