package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.NewWorkplaceDto;
import com.github.MrPatronO.carworkshop.dtos.WorkplaceDto;
import com.github.MrPatronO.carworkshop.models.Workplace;
import com.github.MrPatronO.carworkshop.services.WorkplaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workplaces")
class WorkplaceController {

    private final WorkplaceService workplaceService;

    private static final Logger logger = LoggerFactory.getLogger(WorkplaceController.class);

    WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }


    @GetMapping
    ResponseEntity<List<Workplace>> readWorkplaces() {

        return ResponseEntity.ok(workplaceService.findAll());
    }

    @PostMapping
    WorkplaceDto newWorkplace(@RequestBody @Validated NewWorkplaceDto newWorkplaceDto) {

        return  workplaceService.save(newWorkplaceDto);
    }

    @GetMapping("/{id}")
    Workplace readIdWorkplaces(Integer workplaceId) {

        return workplaceService.findById(workplaceId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<WorkplaceDto> updateWorkplace(@PathVariable Integer id, @RequestBody @Validated WorkplaceDto workplaceDto) {
        return ResponseEntity.ok(workplaceService.update(workplaceDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteWorkplace(Integer workplaceId) {
        workplaceService.deleteById(workplaceId);
    }

}
