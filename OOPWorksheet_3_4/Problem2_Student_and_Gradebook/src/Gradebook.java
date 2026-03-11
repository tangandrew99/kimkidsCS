import java.util.ArrayList;

public class Gradebook {
    private ArrayList<Student> students;

    public Gradebook(ArrayList<Student> students) {
        this.students = students;
    }

    public void printResults() {
        for (int i = __________; i < students.__________(); i__________) { // TODO
            Student s = students.__________(i); // TODO

            if (s.getGrade() __________ 60) { // TODO: comparison operator
                System.out.println(s.getName() + ": Pass");
            } else {
                System.out.println(s.__________() + ": Fail"); // TODO
            }
        }
    }

    // Helper used by tests — do not modify
    public boolean didPass(int index) {
        return students.get(index).getGrade() >= 60;
    }
}
