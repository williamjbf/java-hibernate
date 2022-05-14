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

    public E updateMerge(E entity){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        E savedEntity = entityManager.merge(entity);
        transaction.commit();
        return savedEntity;
    }

    public E find(E entity){
        Object id = HibernateUtil.getPrimaryKey(entity);

        E e = (E) entityManager.find(entity.getClass(),id);
        return e;
    }

    public E find(Class entity, long id){

        E e = (E) entityManager.find(entity,id);
        return e;
    }

}
