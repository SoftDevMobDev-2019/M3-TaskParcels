package au.edu.swin.sdmd.taskparcels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;


public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String grade;
    private boolean complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Spinner spinner = findViewById(R.id.grade_spinner);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        grade = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        grade = parent.getItemAtPosition(0).toString();
    }

    public void onCheckboxClicked(View view) {
        complete = ((CheckBox) view).isChecked();
    }

    // TODO #5 add in some simple form validation

    @Override
    public void onBackPressed() {
        // TODO #3 handle returning the form details when back pressed

        // TODO #3a create intent and task
        Intent i = new Intent();
        EditText name = findViewById(R.id.task_name);
        Task task = new Task(name.getText().toString(), grade, complete);

        // TODO #3b create list for task to be attached to parcelable
        ArrayList<Task> tasks = new ArrayList<Task>();  // need a list even for one item
        tasks.add(task);

        // TODO #3c add list to intent, set result
        i.putParcelableArrayListExtra("TASK_DATA",tasks);
        setResult(RESULT_OK, i);

        // TODO #3d return
        super.onBackPressed(); // do not forget
    }


}