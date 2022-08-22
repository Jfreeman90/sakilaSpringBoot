import com.sakila.database.demo.language.language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageTest {
    @Test
    void test_setLanguageId(){
        language testLanguage = new language();
        testLanguage.setLanguageId(1000);
        assertEquals(1000, testLanguage.getLanguageId(), "Expected to return 1000 and didnt.");
    }

    @Test
    void test_setCategoryName(){
        language testLanguage = new language();
        testLanguage.setName("CHINESE");
        assertEquals("CHINESE", testLanguage.getName(), "Expected to return CHINESE and didnt.");
    }
}
