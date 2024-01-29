package edu.ucsd.cse110.successorator.app;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import edu.ucsd.cse110.successorator.app.databinding.ActivityMainBinding;
import edu.ucsd.cse110.successorator.app.databinding.ListviewGoallistBinding;
import edu.ucsd.cse110.successorator.lib.domain.Goal;
import edu.ucsd.cse110.successorator.lib.util.Subject;

public class GoalItemAdapter extends AppCompatActivity implements ListAdapter {
    Activity activity;
    Subject<List<Goal>> goalList;
    int size;

    public GoalItemAdapter(Activity activity, Subject<List<Goal>> goalList) {
        this.goalList = goalList;
        if (goalList.getValue() != null) {
            size = goalList.getValue().size();
        } else {
            size = 1;
        }

        this.activity = activity;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ListviewGoallistBinding binding;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(LAYOUT_INFLATER_SERVICE);
            binding = ListviewGoallistBinding.inflate(inflater);
        } else {
            binding = ListviewGoallistBinding.bind(view);
        }

        TextView itemGoalTitle = binding.itemGoalTitle;
        TextView itemGoalDescription = binding.itemGoalDescription;
        TextView itemGoalPriority = binding.itemGoalPriority;

        if (goalList.getValue() != null) {
            Goal goal = goalList.getValue().get(position);

            itemGoalTitle.setText(goal.name());
            itemGoalDescription.setText(goal.description());
            itemGoalPriority.setText(String.valueOf(goal.priority()));
        } else {
            itemGoalTitle.setText(R.string.invalid);
            itemGoalDescription.setText(R.string.invalid);
            itemGoalPriority.setText("x");
        }

        return binding.getRoot();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        // TODO Auto-generated method stub
        return false;

    }
}