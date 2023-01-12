package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.NewTimetableDto;
import com.github.MrPatronO.carworkshop.dtos.TimetableDto;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.services.TimetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetables")
class TimetableController {


    private final TimetableService timetableService;


    TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping
    List<Timetable> readTimetables(Long timetableId) {

        return timetableService.findAll();
    }

    @PostMapping
    TimetableDto newTimetable(@RequestBody @Validated NewTimetableDto newTimetableDto) {

        return  timetableService.save(newTimetableDto);
    }

    @GetMapping("/{id}")
    Timetable readIdTimetables(@PathVariable("id") Long id) {

        return timetableService.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<TimetableDto> updateTimetable(@PathVariable("id") Long id, @RequestBody @Validated TimetableDto timetableDto) {
        return ResponseEntity.ok(timetableService.update(timetableDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteTimetable(@PathVariable("id") Long id) {

        timetableService.deleteById(id);
    }
}
