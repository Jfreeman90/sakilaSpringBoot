import com.sakila.database.demo.category.filmCategory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmCategoryTest {
    @Test
    void test_setCategoryID(){
        filmCategory testFilmCategory = new filmCategory();
        testFilmCategory.setCategoryId(1568);
        assertEquals(1568, testFilmCategory.getCategoryId(), "Expected to return 1568 and didnt.");
    }
    @Test
    void test_setFilmID(){
        filmCategory testFilmCategory = new filmCategory();
        testFilmCategory.setFilmId(147);
        assertEquals(147, testFilmCategory.getFilmId(), "Expected to return 147 and didnt.");
    }
}
