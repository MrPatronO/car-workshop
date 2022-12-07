package com.github.MrPatronO.carworkshop.services;


import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.models.Workplace;
import com.github.MrPatronO.carworkshop.repositories.TimetableRepository;
import com.github.MrPatronO.carworkshop.services.interfaces.TimetableInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimetableService implements TimetableInterface {

    final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public Timetable save(Timetable timetable) {
        return timetableRepository.save(timetable);
    }


    public Optional<Timetable> findById(Integer integer) {
        return timetableRepository.findById(integer);
    }

    public void delete(Timetable timetable) {
        timetableRepository.delete(timetable);
    }

    public boolean existsById(Integer integer) {
        return timetableRepository.existsById(integer);
    }

    @Override
    public Workplace save(Workplace workplace) {
        return null;
    }

    @Override
    public ResponseEntity<Timetable> findAll() {
        return null;
    }

    @Override
    public void deleteById(int timetableId) {

    }
}
