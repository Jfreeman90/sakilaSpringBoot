import com.sakila.database.demo.filmActor.filmActor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmActorTest {
    @Test
    void test_setActorID(){
        filmActor testFilmActor = new filmActor();
        testFilmActor.setActorId(1568);
        assertEquals(1568, testFilmActor.getActorId(), "Expected to return 1568 and didnt.");
    }
    @Test
    void test_setFilmID(){
        filmActor testFilmActor = new filmActor();
        testFilmActor.setFilmId(147);
        assertEquals(147, testFilmActor.getFilmId(), "Expected to return 147 and didnt.");
    }
}
