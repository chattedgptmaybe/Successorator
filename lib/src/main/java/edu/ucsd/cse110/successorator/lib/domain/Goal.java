package edu.ucsd.cse110.successorator.lib.domain;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Goal {
    private final @NonNull String name;
    private final @NonNull String description;

    private final @NonNull Integer priority;
    private final @NonNull Integer id;

    public Goal(@NonNull String name, @NonNull String description, @NonNull Integer priority, @NonNull Integer id) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.id = id;
    }

    @NonNull
    public String name() {
        return name;
    }

    @NonNull
    public String description() {
        return description;
    }

    @NonNull
    public Integer priority() {
        return priority;
    }

    @NonNull
    public Integer id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goal)) return false;
        Goal goal = (Goal) o;
        return Objects.equals(name, goal.name) && Objects.equals(description, goal.description) && Objects.equals(priority, goal.priority) && Objects.equals(id, goal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, priority, id);
    }
}
