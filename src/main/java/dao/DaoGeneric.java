package dao;

import hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGeneric<E> {

    private EntityManager entityManager = HibernateUtil.getEntityManager();

    public void save(E entity){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

}
