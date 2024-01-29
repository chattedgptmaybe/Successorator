package edu.ucsd.cse110.successorator.lib.domain;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.List;

import edu.ucsd.cse110.successorator.lib.util.Subject;

public class Day {
    private final @NonNull Integer id;
    private final @NonNull Date date;
    private final @NonNull List<Goal> goals;

    public Day(@NonNull Date date, @NonNull List<Goal> goals, @NonNull Integer id) {
        this.date = date;
        this.goals = goals;
        this.id = id;
    }

    @NonNull
    public Date date() {
        return date;
    }

    @NonNull
    public List<Goal> goals() {
        return goals;
    }

    @NonNull
    public Integer id() {
        return id;
    }

    static public Day addGoals(Day day, List<Goal> goalsList) {
        // TODO:: placeholder
        return new Day(day.date, day.goals, day.id);
    }

    public Subject<List<Goal>> getAllGoalsSubject() {
        Subject<List<Goal>> allGoalsSubject = new Subject<>();

        allGoalsSubject.setValue(goals);

        return allGoalsSubject;
    }
}
