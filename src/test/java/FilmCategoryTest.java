import com.sakila.database.demo.category.FilmCategory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FilmCategoryTest {
    @Test
    void test_setCategoryID(){
        FilmCategory testFilmCategory = new FilmCategory();
        testFilmCategory.setCategoryId(1568);
        assertEquals(1568, testFilmCategory.getCategoryId(), "Expected to return 1568 and didnt.");
    }
    @Test
    void test_setFilmID(){
        FilmCategory testFilmCategory = new FilmCategory();
        testFilmCategory.setFilmId(147);
        assertEquals(147, testFilmCategory.getFilmId(), "Expected to return 147 and didnt.");
    }

    @Test
    void test_ToString() {
        assertFalse(new FilmCategory().toString().contains("@"));
    }
}
