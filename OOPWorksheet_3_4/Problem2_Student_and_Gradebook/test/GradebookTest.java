import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GradebookTest {

    @Test
    public void testPass() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Alice", 90));
        Gradebook gb = new Gradebook(list);
        assertTrue(gb.didPass(0));
    }

    @Test
    public void testFail() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Bob", 45));
        Gradebook gb = new Gradebook(list);
        assertFalse(gb.didPass(0));
    }

    @Test
    public void testExactlyPass() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Carol", 60));
        Gradebook gb = new Gradebook(list);
        assertTrue(gb.didPass(0));
    }

    @Test
    public void testGetters() {
        Student s = new Student("Dana", 75);
        assertEquals("Dana", s.getName());
        assertEquals(75, s.getGrade());
    }
}
