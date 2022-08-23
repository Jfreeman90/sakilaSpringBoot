import com.sakila.database.demo.actor.Actor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {
    //test actor constructor
    @Test
    void test_actorConstructor(){
        Actor testActor = new Actor("JACK", "RUST");
        assertEquals("JACK", testActor.getFirstName(), "Expected to return JACK and didnt.");
        assertEquals("RUST", testActor.getLastName(), "Expected to return RUST and didnt.");
    }

    //test for all actor getters and setters
    @Test
    void test_setActorID(){
        Actor testActor = new Actor();
        testActor.setActorId(1568);
        assertEquals(1568, testActor.getActorId(), "Expected to return 1568 and didnt.");
    }

    @Test
    void test_setFirstName(){
        Actor testActor = new Actor();
        testActor.setFirstName("DEAN");
        assertEquals("DEAN", testActor.getFirstName(), "Expected to return DEAN and didnt.");
    }

    @Test
    void test_setLastName(){
        Actor testActor = new Actor();
        testActor.setLastName("MCDONALD");
        assertEquals("MCDONALD", testActor.getLastName(), "Expected to return MCDONALD and didnt.");
    }

}
