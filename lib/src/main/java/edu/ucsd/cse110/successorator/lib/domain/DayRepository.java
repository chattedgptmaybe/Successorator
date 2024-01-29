package edu.ucsd.cse110.successorator.lib.domain;

import java.util.List;

import edu.ucsd.cse110.successorator.lib.data.InMemoryDataSource;
import edu.ucsd.cse110.successorator.lib.util.Subject;

public class DayRepository {
    private final InMemoryDataSource dataSource;

    public DayRepository(InMemoryDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Integer count() {
        return dataSource.getDays().size();
    }

    public Subject<Day> findDay(int id) {
        return dataSource.getDaySubject(id);
    }

    public Subject<List<Day>> findAllDays() {
        return dataSource.getAllDaysSubject();
    }

    public void save(Day Day) {
        dataSource.putDay(Day);
    }
}
