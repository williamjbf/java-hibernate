package dao;

import hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DaoGeneric<E> {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();

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

    public E findById(Class entity, long id){

        E e = (E) entityManager.find(entity,id);
        return e;
    }

    public void delete(E entity){

        Object id = HibernateUtil.getPrimaryKey(entity);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(
                "delete from " + entity.getClass().getSimpleName().toLowerCase()+
                        " where id = " + id).executeUpdate();
        transaction.commit();
    }

    public void deleteById(Class entity, long id){

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.createNativeQuery(
                "delete from " + entity.getSimpleName().toLowerCase()+
                        " where id = " + id).executeUpdate();
        transaction.commit();
    }

}
