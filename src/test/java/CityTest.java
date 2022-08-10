import com.sakila.database.demo.Address.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTest {
    //test all of city getters and setters
    @Test
    void test_setCityID(){
        City testCity = new City();
        testCity.setCityId(22);
        assertEquals(22, testCity.getCityId(), "Expected to get 22 and didnt.");
    }

    @Test
    void test_setCityName(){
        City testCity = new City();
        testCity.setCity("PARIS");;
        assertEquals("PARIS", testCity.getCity(), "Expected to get PARIS and didnt.");
    }
}
