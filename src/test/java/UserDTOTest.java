import com.sakila.database.demo.user.UserDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserDTOTest {

    @Test
    void test_setUserId(){
        UserDTO testUser = new UserDTO();
        testUser.setUserId(8);
        assertEquals(8, testUser.getUserId(), "Expected to return 8 and didnt.");
    }

    @Test
    void test_setEmail(){
        UserDTO testUser = new UserDTO();
        testUser.setEmail("testemail@email.com");
        assertEquals("testemail@email.com", testUser.getEmail(), "Expected to return testemail@email.com and didnt.");
    }

    @Test
    void test_setUsername(){
        UserDTO testUser = new UserDTO();
        testUser.setUsername("usernametest");
        assertEquals("usernametest", testUser.getUsername(), "Expected to return usernametest and didnt.");
    }


    @Test
    void test_setActive(){
        UserDTO testUser = new UserDTO();
        testUser.setActive(0);
        assertEquals(0, testUser.getActive(), "Expected to return 0 and didnt.");
    }

}
