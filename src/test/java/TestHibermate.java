import dao.DaoGeneric;
import model.ModelUser;
import org.junit.Test;

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


}
