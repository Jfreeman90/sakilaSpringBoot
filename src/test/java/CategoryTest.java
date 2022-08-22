import com.sakila.database.demo.category.category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    @Test
    void test_setCategoryId(){
        category testCategory = new category();
        testCategory.setCategoryId(7899);
        assertEquals(7899, testCategory.getCategoryId(), "Expected to return 7899 and didnt.");
    }

    @Test
    void test_setCategoryName(){
        category testCategory = new category();
        testCategory. setName("ACTION");
        assertEquals("ACTION", testCategory.getName(), "Expected to return ACTION and didnt.");
    }
}
