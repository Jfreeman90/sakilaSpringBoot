import com.sakila.database.demo.Language.Language;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageTest {
    @Test
    void test_setLanguageId(){
        Language testLanguage = new Language();
        testLanguage.setLanguageId(1000);
        assertEquals(1000, testLanguage.getLanguageId(), "Expected to return 1000 and didnt.");
    }

    @Test
    void test_setCategoryName(){
        Language testLanguage = new Language();
        testLanguage.setName("CHINESE");
        assertEquals("CHINESE", testLanguage.getName(), "Expected to return CHINESE and didnt.");
    }

}
