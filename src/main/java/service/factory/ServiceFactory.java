package service.factory;

import service.impl.ServiceImpl;

/**
 * @author Andrey Volinskiy on 18.02.2018.
 */
public class ServiceFactory {
    public static ServiceImpl getServiceMethods() {
        return new ServiceImpl();
    }
}
