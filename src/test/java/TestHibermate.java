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
        user.setLastName("2");
        user.setPassword("teste");
        user.setLogin("teste");

        daoGeneric.save(user);
    }


}
