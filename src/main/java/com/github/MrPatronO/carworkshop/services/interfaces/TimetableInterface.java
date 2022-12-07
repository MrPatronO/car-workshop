package com.github.MrPatronO.carworkshop.services.interfaces;

import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.models.Workplace;
import org.springframework.http.ResponseEntity;

public interface TimetableInterface {

    public abstract Workplace save(Workplace workplace);

    ResponseEntity<Timetable> findAll();

    void deleteById(int timetableId);
}
