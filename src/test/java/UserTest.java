import com.sakila.database.demo.user.user;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void test_createUser(){
        user testUser = new user("testemail@email.com", "usernametest", "paSSwordtest123");
        assertEquals("testemail@email.com", testUser.getEmail(), "Expected to return testemail@email.com and didnt.");
        assertEquals("usernametest", testUser.getUsername(), "Expected to return usernametest and didnt.");
        assertEquals("paSSwordtest123", testUser.getPassword(), "Expected to return paSSwordtest123 and didnt.");
        assertEquals(1, testUser.getActive(), "Expected to return 1 and didnt.");
    }

    @Test
    void test_setUserId(){
        user testUser = new user();
        testUser.setUserId(8);
        assertEquals(8, testUser.getUserId(), "Expected to return 8 and didnt.");
    }

    @Test
    void test_setEmail(){
        user testUser = new user();
        testUser.setEmail("testemail@email.com");
        assertEquals("testemail@email.com", testUser.getEmail(), "Expected to return testemail@email.com and didnt.");
    }

    @Test
    void test_setUsername(){
        user testUser = new user();
        testUser.setUsername("usernametest");
        assertEquals("usernametest", testUser.getUsername(), "Expected to return usernametest and didnt.");
    }

    @Test
    void test_setPassword(){
        user testUser = new user();
        testUser.setPassword("paSSwordtest123");
        assertEquals("paSSwordtest123", testUser.getPassword(), "Expected to return paSSwordtest123 and didnt.");
    }

    @Test
    void test_setActive(){
        user testUser = new user();
        testUser.setActive(0);
        assertEquals(0, testUser.getActive(), "Expected to return 0 and didnt.");
    }

}
