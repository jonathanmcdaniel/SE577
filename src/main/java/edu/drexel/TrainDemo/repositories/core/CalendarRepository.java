package edu.drexel.TrainDemo.repositories.core;

import edu.drexel.TrainDemo.models.core.Calendar;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface CalendarRepository extends CrudRepository<Calendar, Long> {
    List<Calendar> findByStartDate(Date startDate);
    List<Calendar> findByEndDate(Date endDate);
    List<Calendar> findByStartDateGreaterThan(Date startDate);
}