package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.services.TimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timetables")
class TimetableController {


    private final TimetableService timetableService;

    public static final Logger logger = LoggerFactory.getLogger(CarController.class);

    TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping
    ResponseEntity<Timetable> readTimetables(@PathVariable int timetableId) {

        return timetableService.findAll();
    }

    @PostMapping
    Timetable newTimetable(@RequestBody @Validated Timetable newTimetable) {

        return  timetableService.save(newTimetable);
    }

    @GetMapping("/{id}")
    Timetable readIdTimetables(@PathVariable int timetableId) {

        return timetableService.findById(timetableId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    Timetable updateTimetable(@PathVariable int timetableId, @RequestBody @Validated Timetable newTimetable) {
        return timetableService.findById(timetableId)
                .map(timetable -> {
                    timetable.setEndOfRepair(newTimetable.getEndOfRepair());
                    timetable.setWorkplace(newTimetable.getWorkplace());
                    timetable.setStartOfRepair(newTimetable.getStartOfRepair());

                    return timetableService.save(timetable);
                })
                .orElseGet(() -> {
                    newTimetable.setTimetableId(timetableId);
                    return timetableService.save(newTimetable);
                })  ;

    }

    @DeleteMapping("/{id}")
    void deleteTimetable(@PathVariable int timetableId) {
        timetableService.deleteById(timetableId);
    }
}
