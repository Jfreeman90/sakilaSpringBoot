import com.sakila.database.demo.actor.actor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {
    //test actor constructor
    @Test
    void test_actorConstructor(){
        actor testActor = new actor("JACK", "RUST");
        assertEquals("JACK", testActor.getFirstName(), "Expected to return JACK and didnt.");
        assertEquals("RUST", testActor.getLastName(), "Expected to return RUST and didnt.");
    }

    //test for all actor getters and setters
    @Test
    void test_setActorID(){
        actor testActor = new actor();
        testActor.setActorId(1568);
        assertEquals(1568, testActor.getActorId(), "Expected to return 1568 and didnt.");
    }

    @Test
    void test_setFirstName(){
        actor testActor = new actor();
        testActor.setFirstName("DEAN");
        assertEquals("DEAN", testActor.getFirstName(), "Expected to return DEAN and didnt.");
    }

    @Test
    void test_setLastName(){
        actor testActor = new actor();
        testActor.setLastName("MCDONALD");
        assertEquals("MCDONALD", testActor.getLastName(), "Expected to return MCDONALD and didnt.");
    }

}
