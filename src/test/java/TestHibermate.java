import dao.DaoGeneric;
import hibernate.HibernateUtil;
import model.User;
import org.junit.Test;

public class TestHibermate {

    @Test
    public void testSaveUsingHibernate(){
        DaoGeneric<User> daoGeneric = new DaoGeneric<>();

        User user = new User();
        user.setAge(20);
        user.setEmail("teste@teste.com");
        user.setFirstName("Teste");
        user.setLastName("");
        user.setPassword("teste");
        user.setLogin("teste");

        daoGeneric.save(user);
    }

    @Test
    public void testFind(){
        DaoGeneric<User> daoGeneric = new DaoGeneric<>();

        User user = new User();
        user.setId(1L);
        user = daoGeneric.find(user);

        System.out.println(user);
    }

    @Test
    public void testFind2(){
        DaoGeneric<User> daoGeneric = new DaoGeneric<>();

        User user = daoGeneric.find(User.class,2L);

        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        DaoGeneric<User> daoGeneric = new DaoGeneric<>();

        User user = daoGeneric.find(User.class,1L);

        user.setAge(40);
        user.setFirstName("name updated");
        user.setLastName("");
        user = daoGeneric.updateMerge(user);
        System.out.println(user);
    }


}
