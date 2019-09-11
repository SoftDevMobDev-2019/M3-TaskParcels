package au.edu.swin.sdmd.taskparcels;

// TODO #2 turn Task into a parcelable object

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {


    private String name = "";
    private String grade = "";
    private boolean complete = false;

    private Task(Parcel in) {
        name = in.readString();
        grade = in.readString();
        complete = in.readInt() == 1;
    }

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

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(grade);
        dest.writeInt(complete ? 1 : 0);
    }

}
