import com.sakila.database.demo.film.film;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {
    //test every getter and setter inside the film class.
    @Test
    void test_setFilmId(){
        film testFilm = new film();
        testFilm.setFilmId(546);
        assertEquals(546, testFilm.getFilmId(), "Expected to return 546 and didnt");
    }

    @Test
    void test_setFilmTitle(){
        film testFilm= new film();
        testFilm.setTitle("INCREDIBLE HULK");
        assertEquals("INCREDIBLE HULK", testFilm.getTitle(), "Expected to return INCREDIBLE HULK and didnt.");
    }

    @Test
    void test_setDescription(){
        film testFilm= new film();
        testFilm.setDescription("This is an outline of a test description...");
        assertEquals("This is an outline of a test description...", testFilm.getDescription(), "Expected to return description and didnt.");
    }

    @Test
    void test_setReleaseYear(){
        film testFilm= new film();
        testFilm.setReleaseYear(2022);
        assertEquals(2022, testFilm.getReleaseYear(), "Expected to return 2022 and didnt.");
    }

    @Test
    void test_setLanguageId(){
        film testFilm = new film();
        testFilm.setLanguageId(5);
        assertEquals(5, testFilm.getLanguageId(), "Expected to return 5 and didnt.");
    }

    @Test
    void test_setRentalDuration(){
        film testFilm = new film();
        testFilm.setRentalDuration(12);
        assertEquals(12, testFilm.getRentalDuration(), "Expected to return 12 and didnt.");
    }

    @Test
    void test_setRentalRate(){
        film testFilm = new film();
        testFilm.setRentalRate(BigDecimal.valueOf(12.99));
        assertEquals(BigDecimal.valueOf(12.99), testFilm.getRentalRate(), "Expected to return 12.99 and didnt.");
    }

    @Test
    void test_setLength(){
        film testFilm = new film();
        testFilm.setLength(10);
        assertEquals(10,testFilm.getLength(),"Expected to return 10 and didnt.");
    }

    @Test
    void test_setReplacementCost(){
        film testFilm = new film();
        testFilm.setReplacementCost(BigDecimal.valueOf(2.52));
        assertEquals(BigDecimal.valueOf(2.52), testFilm.getReplacementCost(), "Expected to return 2.52 and didnt.");
    }

    @Test
    void test_setRating(){
        film testFilm = new film();
        testFilm.setRating("pg-12");
        assertEquals("pg-12", testFilm.getRating(), "Expected to return pg-12 and didnt.");
    }

    @Test
    void test_setSpecialFeatures(){
        film testFilm = new film();
        testFilm.setSpecialFeatures("Special features entry; post credit scene");
        assertEquals("Special features entry; post credit scene", testFilm.getSpecialFeatures() ,"Special features entry; post credit scene");
    }

    @Test
    void test_setScore(){
        film testFilm = new film();
        testFilm.setScore(5.6);
        assertEquals(5.6,testFilm.getScore(), "Expected to return 5.6 and didnt");
    }

    @Test
    void test_setScoreCount(){
        film testFilm = new film();
        testFilm.setScoreCount(1564L);
        assertEquals(1564L,testFilm.getScoreCount(), "Expected to return 1564L and didnt");
    }

    @Test
    void test_setScoreTotal(){
        film testFilm = new film();
        testFilm.setScoreCount(174L);
        assertEquals(174L,testFilm.getScoreCount(), "Expected to return 174L and didnt");
    }
}
