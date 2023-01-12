package com.github.MrPatronO.carworkshop.repositories;

import com.github.MrPatronO.carworkshop.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
