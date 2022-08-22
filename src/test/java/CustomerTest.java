import com.sakila.database.demo.customer.customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    void test_setActorID(){
        customer testCustomer = new customer();
        testCustomer.setCustomerId(1568);
        assertEquals(1568, testCustomer.getCustomerId(), "Expected to return 1568 and didnt.");
    }
    @Test
    void test_setFirstName(){
        customer testCustomer = new customer();
        testCustomer.setFirstName("JACK");
        assertEquals("JACK", testCustomer.getFirstName(), "Expected to return JACK and didnt.");
    }
    @Test
    void test_setLastName(){
        customer testCustomer = new customer();
        testCustomer.setLastName("JACK");
        assertEquals("JACK", testCustomer.getLastName(), "Expected to return JACK and didnt.");
    }
    @Test
    void test_setFirstEmail(){
        customer testCustomer = new customer();
        testCustomer.setEmail("jack@email.com");
        assertEquals("jack@email.com", testCustomer.getEmail(), "Expected to return jack@email.com and didnt.");
    }
    @Test
    void test_setActive(){
        customer testCustomer = new customer();
        testCustomer.setActive((byte) 0);
        assertEquals((byte) 0, testCustomer.getActive(), "Expected to return (byte) 0 and didnt.");
    }
    @Test
    void test_setStoreId(){
        customer testCustomer = new customer();
        testCustomer.setStoreId(1);
        assertEquals(1, testCustomer.getStoreId(), "Expected to return 1 and didnt.");
    }
    @Test
    void test_setAddressId(){
        customer testCustomer = new customer();
        testCustomer.setAddressId(1);
        assertEquals(1, testCustomer.getAddressId(), "Expected to return 1 and didnt.");
    }
}
