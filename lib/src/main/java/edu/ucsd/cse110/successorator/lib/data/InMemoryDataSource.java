package edu.ucsd.cse110.successorator.lib.data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ucsd.cse110.successorator.lib.domain.*;
import edu.ucsd.cse110.successorator.lib.util.*;

/**
 * Class used as a sort of "database" of decks and Goals that exist. This
 * will be replaced with a real database in the future, but can also be used
 * for testing.
 */

public class InMemoryDataSource {
    private final Map<Integer, Goal> Goals
            = new HashMap<>();
    private final Map<Integer, Subject<Goal>> GoalSubjects
            = new HashMap<>();
    private final Subject<List<Goal>> allGoalsSubject
            = new Subject<>();

    private final Map<Integer, Day> Days
            = new HashMap<>();
    private final Map<Integer, Subject<Day>> DaySubjects
            = new HashMap<>();
    private final Subject<List<Day>> allDaysSubject
            = new Subject<>();

    public InMemoryDataSource() {
    }

    public List<Goal> getGoals() {
        return List.copyOf(Goals.values());
    }

    public Goal getGoal(int id) {
        return Goals.get(id);
    }

    public Subject<Goal> getGoalSubject(int id) {
        if (!GoalSubjects.containsKey(id)) {
            var subject = new Subject<Goal>();
            subject.setValue(getGoal(id));
            GoalSubjects.put(id, subject);
        }

        return GoalSubjects.get(id);
    }

    public Subject<List<Goal>> getAllGoalsSubject() {
        return allGoalsSubject;
    }

    public void putGoal(Goal Goal) {
        Goals.put(Goal.id(), Goal);
        if (GoalSubjects.containsKey(Goal.id())) {
            GoalSubjects.get(Goal.id()).setValue(Goal);
        }

        allGoalsSubject.setValue(getGoals());
    }


    public List<Day> getDays() {
        return List.copyOf(Days.values());
    }

    public Day getDay(int id) {
        return Days.get(id);
    }

    public Subject<Day> getDaySubject(int id) {
        if (!DaySubjects.containsKey(id)) {
            var subject = new Subject<Day>();
            subject.setValue(getDay(id));
            DaySubjects.put(id, subject);
        }

        return DaySubjects.get(id);
    }

    public Subject<List<Day>> getAllDaysSubject() {
        return allDaysSubject;
    }

    public void putDay(Day Day) {
        Days.put(Day.id(), Day);
        if (DaySubjects.containsKey(Day.id())) {
            DaySubjects.get(Day.id()).setValue(Day);
        }

        allDaysSubject.setValue(getDays());
    }

    public final static List<Goal> DEFAULT_GOALS = List.of(
            new Goal("SRP", "Single Responsibility Principle", 10, 1),
            new Goal("OCP", "Open-Closed Principle", 10, 2),
            new Goal("LSP", "Liskov Substitution Principle", 10, 3),
            new Goal("ISP", "Interface Segregation Principle", 10, 4),
            new Goal("DIP", "Dependency Inversion Principle", 10, 5),
            new Goal("LKP", "Least Knowledge Principle (Law of Demeter)", 10, 6)
    );
    public final static List<Day> DEFAULT_DAYS = List.of(
            new Day(new Date(),
                    List.of(
                        DEFAULT_GOALS.get(0),
                        DEFAULT_GOALS.get(1),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(3),
                        DEFAULT_GOALS.get(4),
                        DEFAULT_GOALS.get(5),
                        DEFAULT_GOALS.get(1),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(2),
                        DEFAULT_GOALS.get(1)),
                    1),
            new Day(new Date(),
                    List.of(
                            DEFAULT_GOALS.get(1),
                            DEFAULT_GOALS.get(2)),
                    2)
    );

    public static InMemoryDataSource fromDefault() {
        var data = new InMemoryDataSource();
        for (Goal Goal : DEFAULT_GOALS) {
            data.putGoal(Goal);
        }
        for (Day Day : DEFAULT_DAYS) {
            data.putDay(Day);
        }
        return data;
    }
}