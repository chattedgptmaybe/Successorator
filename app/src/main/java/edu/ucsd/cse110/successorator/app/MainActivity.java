package edu.ucsd.cse110.successorator.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

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

        ArrayAdapter adapter = new ArrayAdapter<Subject<Goal>>(this,
                binding.goalList.getRootView(), dataSource.getGoalsSubject());
        binding.goalList.setAdapter(adapter);

        setContentView(binding.getRoot());
    }
}

public class GoalItemAdapter