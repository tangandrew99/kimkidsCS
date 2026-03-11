public class Task {
    private String  description;
    private int     priority;
    private boolean done;

    public Task(String description, int priority) {
        this.description = description;
        this.priority    = priority;
        this.done        = false;
    }

    public void markDone() { this.__________ = true; } // TODO: field name

    public int     getPriority()    { return priority;    }
    public boolean isDone()         { return done;        }
    public String  getDescription() { return description; }
}
