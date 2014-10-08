/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pompeu
 */
public class ConnectionFactoryJPA {

    private final static EntityManagerFactory MANAGERFACTORY
            = Persistence.createEntityManagerFactory("emp2PU");
    private static final EntityManager ENRYTIMANAGER = MANAGERFACTORY.createEntityManager();
    //private  EntityTransaction tran = entityManager.getTransaction();
    private static ConnectionFactoryJPA INSTANCE = null;

    private ConnectionFactoryJPA() {

    }
    
    public static ConnectionFactoryJPA getinstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionFactoryJPA();
        }
        return INSTANCE;
    }

    public static EntityManager getEntityManager() {
        return ENRYTIMANAGER;
    }

}
