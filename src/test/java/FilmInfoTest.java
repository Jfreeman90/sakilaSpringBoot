import com.sakila.database.demo.film.filmInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmInfoTest {
    @Test
    void test_setFilmId(){
        filmInfo testFilmInfo = new filmInfo();
        testFilmInfo.setFilmId(546);
        assertEquals(546, testFilmInfo.getFilmId(), "Expected to return 546 and didnt");
    }

    @Test
    void test_setFilmTitle(){
        filmInfo testFilmInfo = new filmInfo();
        testFilmInfo.setTitle("INCREDIBLE HULK");
        assertEquals("INCREDIBLE HULK", testFilmInfo.getTitle(), "Expected to return INCREDIBLE HULK and didnt.");
    }

    @Test
    void test_setReleaseYear(){
        filmInfo testFilmInfo = new filmInfo();
        testFilmInfo.setReleaseYear(2022);
        assertEquals(2022, testFilmInfo.getReleaseYear(), "Expected to return 2022 and didnt.");
    }

    @Test
    void test_setScore(){
        filmInfo testFilmInfo = new filmInfo();
        testFilmInfo.setScore(5.6);
        assertEquals(5.6,testFilmInfo.getScore(), "Expected to return 5.6 and didnt");
    }
}
