import com.sakila.database.demo.Film.FilmInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmInfoTest {
    @Test
    void test_setFilmId(){
        FilmInfo testFilmInfo = new FilmInfo();
        testFilmInfo.setFilmId(546);
        assertEquals(546, testFilmInfo.getFilmId(), "Expected to return 546 and didnt");
    }

    @Test
    void test_setFilmTitle(){
        FilmInfo testFilmInfo = new FilmInfo();
        testFilmInfo.setTitle("INCREDIBLE HULK");
        assertEquals("INCREDIBLE HULK", testFilmInfo.getTitle(), "Expected to return INCREDIBLE HULK and didnt.");
    }

    @Test
    void test_setReleaseYear(){
        FilmInfo testFilmInfo = new FilmInfo();
        testFilmInfo.setReleaseYear(2022);
        assertEquals(2022, testFilmInfo.getReleaseYear(), "Expected to return 2022 and didnt.");
    }

    @Test
    void test_setScore(){
        FilmInfo testFilmInfo = new FilmInfo();
        testFilmInfo.setScore(5.6);
        assertEquals(5.6,testFilmInfo.getScore(), "Expected to return 5.6 and didnt");
    }
}
