package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.NewTimetableDto;
import com.github.MrPatronO.carworkshop.dtos.TimetableDto;
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
    TimetableDto newTimetable(@RequestBody @Validated NewTimetableDto newTimetableDto) {

        return  timetableService.save(newTimetableDto);
    }

    @GetMapping("/{id}")
    Timetable readIdTimetables(@PathVariable int timetableId) {

        return timetableService.findById(timetableId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<TimetableDto> updateTimetable(@PathVariable Integer id, @RequestBody @Validated TimetableDto timetableDto) {
        return ResponseEntity.ok(timetableService.update(timetableDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteTimetable(@PathVariable int timetableId) {
        timetableService.deleteById(timetableId);
    }
}
