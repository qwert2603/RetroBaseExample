package com.qwert2603.retrobase_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.postgresql.Driver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Class.forName(Driver.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TextView textView = (TextView) findViewById(R.id.text_view);

        DataManager dataManager = new DataManager();

        dataManager.getAllRecordsFromDataBase()
                .subscribe(records -> textView.setText(records.toString()));

        int id = 3885;
        dataManager.removeRecord(id)
                .subscribe(
                        () -> Toast.makeText(MainActivity.this, "Deleted record with id == " + id, Toast.LENGTH_SHORT).show(),
                        Throwable::printStackTrace
                );
    }
}
