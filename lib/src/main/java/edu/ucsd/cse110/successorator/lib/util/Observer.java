package edu.ucsd.cse110.successorator.lib.util;


import androidx.annotation.Nullable;

/**
 * An observer of a subject
 * @param <T> the type ofe the subject
 */
public interface Observer<T> {

    /**
     * Called when the subject changes with the new value.
     *
     * aparam value The new value of the subject.
     * @apiNote A null value indicates that the subject has no value yet.
     */
    void onChanged(@Nullable T value);
}
