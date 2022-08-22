import com.sakila.database.demo.address.address;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    //test address getters and setters
    @Test
    void test_setAddressId(){
        address testAddress = new address();
        testAddress.setAddressId(1234);
        assertEquals(1234, testAddress.getAddressId(), "Expected to return 1234 but didnt.");
    }

    @Test
    void test_setAddress(){
        address testAddress = new address();
        testAddress.setAddress("43 NEW ADDRESS LANE");
        assertEquals("43 NEW ADDRESS LANE",testAddress.getAddress(),"Expected to return 43 NEW ADDRESS LANE but didnt");
    }

    @Test
    void test_setDistrict(){
        address testAddress = new address();
        testAddress.setDistrict("ALBERTA");
        assertEquals("ALBERTA", testAddress.getDistrict(), "Expected to return ALBERTA but didnt");
    }

    @Test
    void test_setPostalCode(){
        address testAddress = new address();
        testAddress.setPostalCode("WS6 3HG");
        assertEquals("WS6 3HG", testAddress.getPostalCode(), "Expected to return WS6 3HG but didnt");
    }

    @Test
    void test_setPhone(){
        address testAddress = new address();
        testAddress.setPhone("1567498161");
        assertEquals("1567498161", testAddress.getPhone(), "Expected to return 1567498161 but didnt.");
    }
}
