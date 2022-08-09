import com.sakila.database.demo.Film.Film;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {
    //test every getter and setter inside the film class.
    @Test
    public void test_setFilmTitle(){
        Film testFilm= new Film();
        testFilm.setTitle("INCREDIBLE HULK");
        assertEquals("INCREDIBLE HULK", testFilm.getTitle(), "Expected to return INCREDIBLE HULK and didnt.");
    }

    @Test
    public void test_setDescription(){
        Film testFilm= new Film();
        testFilm.setDescription("This is an outline of a test description...");
        assertEquals("This is an outline of a test description...", testFilm.getDescription(), "Expected to return description and didnt.");
    }

    @Test
    public void test_setReleaseYear(){
        Film testFilm= new Film();
        testFilm.setReleaseYear(2022);
        assertEquals(2022, testFilm.getReleaseYear(), "Expected to return 2022 and didnt.");
    }

    @Test
    public void test_setLanguageId(){
        Film testFilm = new Film();
        testFilm.setLanguageId(5);
        assertEquals(5, testFilm.getLanguageId(), "Expected to return 5 and didnt.");
    }

    @Test
    public void test_setRentalDuration(){
        Film testFilm = new Film();
        testFilm.setRentalDuration(12);
        assertEquals(12, testFilm.getRentalDuration(), "Expected to return 12 and didnt.");
    }

    @Test
    public void test_setRentalRate(){
        Film testFilm = new Film();
        testFilm.setRentalRate(BigDecimal.valueOf(12.99));
        assertEquals(BigDecimal.valueOf(12.99), testFilm.getRentalRate(), "Expected to return 12.99 and didnt.");
    }

    @Test
    public void test_setLength(){
        Film testFilm = new Film();
        testFilm.setLength(10);
        assertEquals(10,testFilm.getLength(),"Expected to return 10 and didnt.");
    }

    @Test public void test_setReplacementCost(){
        Film testFilm = new Film();
        testFilm.setReplacementCost(BigDecimal.valueOf(2.52));
        assertEquals(BigDecimal.valueOf(2.52), testFilm.getReplacementCost(), "Expected to return 2.52 and didnt.");
    }

    @Test public void test_setRating(){
        Film testFilm = new Film();
        testFilm.setRating("pg-12");
        assertEquals("pg-12", testFilm.getRating(), "Expected to return pg-12 and didnt.");
    }

    @Test public void test_setSpecialFeatures(){
        Film testFilm = new Film();
        testFilm.setSpecialFeatures("Special features entry; post credit scene");
        assertEquals("Special features entry; post credit scene", testFilm.getSpecialFeatures() ,"Special features entry; post credit scene");
    }

}
