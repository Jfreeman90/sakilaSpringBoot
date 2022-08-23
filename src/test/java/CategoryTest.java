import com.sakila.database.demo.category.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    @Test
    void test_setCategoryId(){
        Category testCategory = new Category();
        testCategory.setCategoryId(7899);
        assertEquals(7899, testCategory.getCategoryId(), "Expected to return 7899 and didnt.");
    }

    @Test
    void test_setCategoryName(){
        Category testCategory = new Category();
        testCategory. setName("ACTION");
        assertEquals("ACTION", testCategory.getName(), "Expected to return ACTION and didnt.");
    }
}
