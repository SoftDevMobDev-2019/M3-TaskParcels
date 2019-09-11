package au.edu.swin.sdmd.taskparcels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //TODO #1 set up intent to get a result
    public void buttonHandler(View v) {
        Intent i = new Intent(getApplicationContext(), FormActivity.class);
        startActivityForResult(i, 0);
    }

    // TODO #4 get result back and process/update UI
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO #4a check for result code
        if (requestCode == 0) {
            // TODO #4b if result ok then get data and update UI
            if (resultCode == RESULT_OK) {
                if (intent == null) {
                    Log.i("INTENT", "Intent empty");
                } else {
                    ArrayList<Task> tasks = intent.getParcelableArrayListExtra("TASK_DATA");
                    Task t = tasks.get(0); // get first and only item from list
                    Log.i("INTENT", t.toString());
                    TextView taskView = findViewById(R.id.task_view);
                    taskView.setText(t.toString());
                }
            }
            // TODO #4c add elses/Logs for result not okay
            else Log.i("INTENT", "Result not okay");
        } else Log.i("INTENT", "Code does not match");

        /* Things to try with the code in this method: try triggering the Log statements.
        In addition, try altering the order of the lines in writeToParcel and seeing what happens.
         */

    }
}
