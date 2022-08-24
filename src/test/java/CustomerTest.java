import com.sakila.database.demo.customer.Customer;
import com.sakila.database.demo.film.Film;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomerTest {
    //customer constructor test
    @Test
    void test_constructor(){
        Customer testCustomer = new Customer("JACK", "JACK", "jack@email.com", 1, 1);
        assertEquals("JACK", testCustomer.getFirstName(), "Expected to return JACK and didnt.");
        assertEquals("JACK", testCustomer.getLastName(), "Expected to return JACK and didnt.");
        assertEquals("jack@email.com", testCustomer.getEmail(), "Expected to return jack@email.com and didnt.");
        assertEquals(1, testCustomer.getStoreId(), "Expected to return 1 and didnt.");
        assertEquals(1, testCustomer.getAddressId(), "Expected to return 1 and didnt.");
    }

    @Test
    void test_setActorID(){
        Customer testCustomer = new Customer();
        testCustomer.setCustomerId(1568);
        assertEquals(1568, testCustomer.getCustomerId(), "Expected to return 1568 and didnt.");
    }
    @Test
    void test_setFirstName(){
        Customer testCustomer = new Customer();
        testCustomer.setFirstName("JACK");
        assertEquals("JACK", testCustomer.getFirstName(), "Expected to return JACK and didnt.");
    }
    @Test
    void test_setLastName(){
        Customer testCustomer = new Customer();
        testCustomer.setLastName("JACK");
        assertEquals("JACK", testCustomer.getLastName(), "Expected to return JACK and didnt.");
    }
    @Test
    void test_setFirstEmail(){
        Customer testCustomer = new Customer();
        testCustomer.setEmail("jack@email.com");
        assertEquals("jack@email.com", testCustomer.getEmail(), "Expected to return jack@email.com and didnt.");
    }
    @Test
    void test_setActive(){
        Customer testCustomer = new Customer();
        testCustomer.setActive((byte) 0);
        assertEquals((byte) 0, testCustomer.getActive(), "Expected to return (byte) 0 and didnt.");
    }
    @Test
    void test_setStoreId(){
        Customer testCustomer = new Customer();
        testCustomer.setStoreId(1);
        assertEquals(1, testCustomer.getStoreId(), "Expected to return 1 and didnt.");
    }
    @Test
    void test_setAddressId(){
        Customer testCustomer = new Customer();
        testCustomer.setAddressId(1);
        assertEquals(1, testCustomer.getAddressId(), "Expected to return 1 and didnt.");
    }

    @Test
    void test_ToString() {
        assertFalse(new Film().toString().contains("@"));
    }
}
