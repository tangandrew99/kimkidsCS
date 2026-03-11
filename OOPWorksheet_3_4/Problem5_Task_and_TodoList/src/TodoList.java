import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task t) {
        tasks.__________(t); // TODO
    }

    public void printByPriority(int level) {
        for (__________ task : tasks) { // TODO: fill in type
            if (task.__________() == __________) { // TODO: getter and parameter
                System.out.println(task.__________()); // TODO: description getter
            }
        }
    }

    public int countCompleted() {
        int count = __________; // TODO

        for (Task task : __________) { // TODO: collection name
            if (task.__________()) { // TODO: boolean getter
                count__________; // TODO: increment
            }
        }

        return __________; // TODO
    }
}
