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

    }

    // TODO #4 get result back and process/update UI
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO #4a check for result code
        // TODO #4b if result ok then get data and update UI
        // TODO #4c add elses/Logs for result not okay

    }
}
