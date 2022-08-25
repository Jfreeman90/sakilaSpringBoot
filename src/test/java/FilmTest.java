import com.sakila.database.demo.category.Category;
import com.sakila.database.demo.film.Film;
import com.sakila.database.demo.language.Language;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FilmTest {
    //test every getter and setter inside the film class.
    @Test
    void test_setFilmId(){
        Film testFilm = new Film();
        testFilm.setFilmId(546);
        assertEquals(546, testFilm.getFilmId(), "Expected to return 546 and didnt");
    }

    @Test
    void test_setFilmTitle(){
        Film testFilm= new Film();
        testFilm.setTitle("INCREDIBLE HULK");
        assertEquals("INCREDIBLE HULK", testFilm.getTitle(), "Expected to return INCREDIBLE HULK and didnt.");
    }

    @Test
    void test_setDescription(){
        Film testFilm= new Film();
        testFilm.setDescription("This is an outline of a test description...");
        assertEquals("This is an outline of a test description...", testFilm.getDescription(), "Expected to return description and didnt.");
    }

    @Test
    void test_setReleaseYear(){
        Film testFilm= new Film();
        testFilm.setReleaseYear(2022);
        assertEquals(2022, testFilm.getReleaseYear(), "Expected to return 2022 and didnt.");
    }

    @Test
    void test_setLanguageId(){
        Film testFilm = new Film();
        testFilm.setLanguageId(5);
        assertEquals(5, testFilm.getLanguageId(), "Expected to return 5 and didnt.");
    }

    @Test
    void test_setRentalDuration(){
        Film testFilm = new Film();
        testFilm.setRentalDuration(12);
        assertEquals(12, testFilm.getRentalDuration(), "Expected to return 12 and didnt.");
    }

    @Test
    void test_setRentalRate(){
        Film testFilm = new Film();
        testFilm.setRentalRate(BigDecimal.valueOf(12.99));
        assertEquals(BigDecimal.valueOf(12.99), testFilm.getRentalRate(), "Expected to return 12.99 and didnt.");
    }

    @Test
    void test_setLength(){
        Film testFilm = new Film();
        testFilm.setLength(10);
        assertEquals(10,testFilm.getLength(),"Expected to return 10 and didnt.");
    }

    @Test
    void test_setReplacementCost(){
        Film testFilm = new Film();
        testFilm.setReplacementCost(BigDecimal.valueOf(2.52));
        assertEquals(BigDecimal.valueOf(2.52), testFilm.getReplacementCost(), "Expected to return 2.52 and didnt.");
    }

    @Test
    void test_setRating(){
        Film testFilm = new Film();
        testFilm.setRating("pg-12");
        assertEquals("pg-12", testFilm.getRating(), "Expected to return pg-12 and didnt.");
    }

    @Test
    void test_setSpecialFeatures(){
        Film testFilm = new Film();
        testFilm.setSpecialFeatures("Special features entry; post credit scene");
        assertEquals("Special features entry; post credit scene", testFilm.getSpecialFeatures() ,"Special features entry; post credit scene");
    }

    @Test
    void test_setScore(){
        Film testFilm = new Film();
        testFilm.setScore(5.6);
        assertEquals(5.6,testFilm.getScore(), "Expected to return 5.6 and didnt");
    }

    @Test
    void test_setScoreCount(){
        Film testFilm = new Film();
        testFilm.setScoreCount(1564L);
        assertEquals(1564L,testFilm.getScoreCount(), "Expected to return 1564L and didnt");
    }

    @Test
    void test_setScoreTotal(){
        Film testFilm = new Film();
        testFilm.setScoreTotal(174L);
        assertEquals(174L,testFilm.getScoreTotal(), "Expected to return 174L and didnt");
    }

    @Test
    void test_setTicketsReserved(){
        Film testFilm = new Film();
        testFilm.setTicketsReserved(174);
        assertEquals(174,testFilm.getTicketsReserved(), "Expected to return 174 and didnt");
    }

    @Test
    void test_setLanguage(){
        Film testFilm= new Film();
        Language testLanguage = new Language();
        testLanguage.setLanguageId(45);
        testLanguage.setName("english");
        testFilm.setLanguage(testLanguage);
        assertEquals(45,testFilm.getLanguage().getLanguageId(), "Expected to return 45 and didnt");
        assertEquals("english",testFilm.getLanguage().getName(), "Expected to return english and didnt");
    }

    @Test
    void test_ToString() {
        assertFalse(new Film().toString().contains("@"));
    }

}
