package au.edu.swin.sdmd.taskparcels;

// TODO #2 turn Task into a parcelable object

public class Task {


    private String name = "";
    private String grade = "";
    private boolean complete = false;

    public Task(String name, String grade, boolean complete) {
        update(name, grade, complete);
    }

    private void update(String name, String grade, boolean complete) {
        this.name = name;
        this.grade = grade;
        this.complete = complete;
    }

    @Override
    public String toString() {
        if (complete) {
            return "Task " + name + " complete for " + grade + " grade";
        } else {
            return "Task " + name + " not yet complete for " + grade + " grade";
        }
    }

}
