import com.sakila.database.demo.film.FilmInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FilmInfoTest {
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

    @Test
    void test_setScoreCount(){
        FilmInfo testFilmInfo = new FilmInfo();
        testFilmInfo.setScoreCount(56L);
        assertEquals(56L,testFilmInfo.getScoreCount(), "Expected to return 56L and didnt");
    }

    @Test
    void test_ToString() {
        assertFalse(new FilmInfo().toString().contains("@"));
    }
}
