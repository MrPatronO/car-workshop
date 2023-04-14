package com.github.MrPatronO.carworkshop.repositories;

import com.github.MrPatronO.carworkshop.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    @Query(value = "SELECT timetable.start_of_repair, timetable.end_of_repair from public.timetable" +
            "where (start_of_repair <= :startOfRepair AND end_of_repair >= :startOfRepair)" +
            "OR (start_of_repair <= :endOfRepair AND end_of_repair >= :endOfRepair)" +
            "OR (start_of_repair > :startOfRepair AND end_of_repair < :endOfRepair)", nativeQuery = true)
    List<Timetable> findTimetableInPeriod(LocalDateTime startOfRepair, LocalDateTime endOfRepair);

}
