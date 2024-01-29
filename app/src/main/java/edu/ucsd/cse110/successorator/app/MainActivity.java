package edu.ucsd.cse110.successorator.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

import edu.ucsd.cse110.successorator.app.databinding.ActivityMainBinding;
import edu.ucsd.cse110.successorator.lib.data.InMemoryDataSource;
import edu.ucsd.cse110.successorator.lib.domain.Goal;
import edu.ucsd.cse110.successorator.lib.util.Subject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.successoratorgpt));


        var dataSource = InMemoryDataSource.fromDefault();

        var binding = ActivityMainBinding.inflate(getLayoutInflater());

        GoalItemAdapter adapter = new GoalItemAdapter(this, dataSource.getDay(1).getAllGoalsSubject());
        binding.goalList.setAdapter(adapter);

        setContentView(binding.getRoot());
    }
}
