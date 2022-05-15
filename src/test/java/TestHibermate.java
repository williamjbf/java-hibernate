import dao.DaoGeneric;
import model.ModelUser;
import org.junit.Test;

import java.util.List;

public class TestHibermate {

    @Test
    public void testSaveUsingHibernate(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = new ModelUser();
        modelUser.setAge(20);
        modelUser.setEmail("teste@teste.com");
        modelUser.setFirstName("Teste");
        modelUser.setLastName("");
        modelUser.setPassword("teste");
        modelUser.setLogin("teste");

        daoGeneric.save(modelUser);
    }

    @Test
    public void testFind(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = new ModelUser();
        modelUser.setId(1L);
        modelUser = daoGeneric.find(modelUser);

        System.out.println(modelUser);
    }

    @Test
    public void testFindById(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = daoGeneric.findById(ModelUser.class,2L);

        System.out.println(modelUser);
    }

    @Test
    public void testUpdate(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = daoGeneric.findById(ModelUser.class,1L);

        modelUser.setAge(40);
        modelUser.setFirstName("name updated");
        modelUser.setLastName("");
        modelUser = daoGeneric.updateMerge(modelUser);
        System.out.println(modelUser);
    }

    @Test
    public void testDelete(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = new ModelUser();
        modelUser.setFirstName("test delete");
        modelUser.setId(2L);

        modelUser = daoGeneric.updateMerge(modelUser);
        daoGeneric.delete(modelUser);

        modelUser = daoGeneric.findById(ModelUser.class, 2L);
        System.out.println(modelUser);
    }

    @Test
    public void testDeleteById(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        ModelUser modelUser = new ModelUser();
        modelUser.setFirstName("test delete by ID");
        modelUser.setId(2L);

        modelUser = daoGeneric.updateMerge(modelUser);
        daoGeneric.deleteById(ModelUser.class, 2L);

        modelUser = daoGeneric.findById(ModelUser.class, 2L);
        System.out.println(modelUser);

    }

    @Test
    public void testFindAll(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<>();

        List<ModelUser> list = daoGeneric.listAll(ModelUser.class);
        for (ModelUser user: list){
            System.out.println(user);
        }
    }
    @Test
    public void testQueryListOrder(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<ModelUser>();

        List<ModelUser> list = daoGeneric.getEntityManager()
                .createQuery("from ModelUser order by id")
                .getResultList();

        for(ModelUser user:list){
            System.out.println(user);
        }
    }

    @Test
    public void testQueryListMaxResult(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<ModelUser>();

        List<ModelUser> list = daoGeneric.getEntityManager()
                .createQuery("from ModelUser order by id")
                .setMaxResults(5)
                .getResultList();

        for(ModelUser user:list){
            System.out.println(user);
        }
    }
    @Test
    public void testQueryListParameter(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<ModelUser>();

        ModelUser newUser = new ModelUser();
        newUser.setFirstName("test where");
        daoGeneric.updateMerge(newUser);

        List<ModelUser> list = daoGeneric.getEntityManager()
                .createQuery(" from ModelUser where firstname = :name")
                .setParameter("name", "test where")
                .getResultList();

        for(ModelUser user:list){
            System.out.println(user);
        }

    }
    @Test
    public void testQuerySumAge(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<ModelUser>();

        Long sum = (Long) daoGeneric.getEntityManager().createQuery("select sum(age) from ModelUser ").getSingleResult();

        System.out.println("sum of ages :" + sum);
    }

    @Test
    public void testQueryAvarageAge(){
        DaoGeneric<ModelUser> daoGeneric = new DaoGeneric<ModelUser>();

        Double avg = (Double) daoGeneric.getEntityManager().createQuery("select avg(age) from ModelUser ").getSingleResult();

        System.out.println("avarage ages: " + avg);
    }
}
