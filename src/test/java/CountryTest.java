import com.sakila.database.demo.address.country;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {
    //test for all country getters and setters
    @Test
    void test_setCountryID(){
        country testCountry = new country();
        testCountry.setCountryId(15);
        assertEquals(15, testCountry.getCountryId(), "Expected to get 15 and didnt.");
    }

    @Test
    void test_setCountryName(){
        country testCountry = new country();
        testCountry.setCountry("EGYPT");;
        assertEquals("EGYPT", testCountry.getCountry(), "Expected to get EGYPT and didnt.");
    }
}
