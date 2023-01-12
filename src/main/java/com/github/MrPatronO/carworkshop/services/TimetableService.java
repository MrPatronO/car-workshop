package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewTimetableDto;
import com.github.MrPatronO.carworkshop.dtos.TimetableDto;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.repositories.TimetableRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService{

    final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public TimetableDto save(NewTimetableDto newTimetableDto) {
        Timetable timetable = new Timetable();
        timetable.setEndOfRepair(newTimetableDto.getEndOfRepair());
        timetable.setStartOfRepair(newTimetableDto.getStartOfRepair());
        timetable.setWorkplace(newTimetableDto.getWorkplace());


        Timetable newTimetable = timetableRepository.save(timetable);

        TimetableDto timetableDto = new TimetableDto();
        timetableDto.setTimetableId(newTimetable.getTimetableId());
        timetableDto.setEndOfRepair(newTimetable.getEndOfRepair());
        timetableDto.setStartOfRepair(newTimetable.getStartOfRepair());
        timetableDto.setWorkplace(newTimetable.getWorkplace());

        return timetableDto;
    }



    public Optional<Timetable> findById(Long timetableId) {
        return timetableRepository.findById(timetableId);
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    public TimetableDto update(TimetableDto timetableDto, Long timetableId) {
        Timetable updatedOrCreatedTimetable = timetableRepository.findById(timetableId)
                .map(timetable -> {
                    timetable.setEndOfRepair(timetableDto.getEndOfRepair());
                    timetable.setStartOfRepair(timetableDto.getStartOfRepair());
                    timetable.setWorkplace(timetableDto.getWorkplace());
                    return timetableRepository.save(timetable);
                })
                .orElseGet(() -> {
                    Timetable timetable = new Timetable();
                    timetable.setTimetableId(timetableDto.getTimetableId());
                    timetable.setEndOfRepair(timetableDto.getEndOfRepair());
                    timetable.setStartOfRepair(timetableDto.getStartOfRepair());
                    timetable.setWorkplace(timetableDto.getWorkplace());


                    return timetableRepository.save(timetable);
                })  ;
        TimetableDto newTimetableDto = new TimetableDto();
        newTimetableDto.setTimetableId(updatedOrCreatedTimetable.getTimetableId());
        newTimetableDto.setEndOfRepair(updatedOrCreatedTimetable.getEndOfRepair());
        newTimetableDto.setStartOfRepair(updatedOrCreatedTimetable.getStartOfRepair());
        newTimetableDto.setWorkplace(updatedOrCreatedTimetable.getWorkplace());

        return newTimetableDto;
    }

    public void deleteById(Long id) {
        timetableRepository.deleteById(id);
    }
}
