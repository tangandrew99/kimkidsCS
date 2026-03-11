import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    public void testCountCompleted_none() {
        TodoList list = new TodoList();
        list.addTask(new Task("Buy milk", 1));
        list.addTask(new Task("Do laundry", 2));
        assertEquals(0, list.countCompleted());
    }

    @Test
    public void testCountCompleted_some() {
        TodoList list = new TodoList();
        Task t1 = new Task("Write code", 1);
        Task t2 = new Task("Review PR", 2);
        Task t3 = new Task("Deploy", 1);
        t1.markDone();
        t3.markDone();
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        assertEquals(2, list.countCompleted());
    }

    @Test
    public void testCountCompleted_all() {
        TodoList list = new TodoList();
        Task t = new Task("Only task", 3);
        t.markDone();
        list.addTask(t);
        assertEquals(1, list.countCompleted());
    }

    @Test
    public void testMarkDone_togglesField() {
        Task t = new Task("Test task", 1);
        assertFalse(t.isDone());
        t.markDone();
        assertTrue(t.isDone());
    }
}
