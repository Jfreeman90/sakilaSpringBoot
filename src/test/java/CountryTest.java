import com.sakila.database.demo.Address.Country;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {
    //test for all country getters and setters
    @Test
    void test_setCountryID(){
        Country testCountry = new Country();
        testCountry.setCountryId(15);
        assertEquals(15, testCountry.getCountryId(), "Expected to get 15 and didnt.");
    }

    @Test
    void test_setCountryName(){
        Country testCountry = new Country();
        testCountry.setCountry("EGYPT");;
        assertEquals("EGYPT", testCountry.getCountry(), "Expected to get EGYPT and didnt.");
    }
}
