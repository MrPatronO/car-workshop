package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.models.Workplace;
import com.github.MrPatronO.carworkshop.services.WorkplaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workplaces")
class WorkplaceController {

    private final WorkplaceService workplaceService;

    public static final Logger logger = LoggerFactory.getLogger(CarController.class);

    WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }


    @GetMapping
    ResponseEntity<Workplace> readWorkplacess(@PathVariable int workplaceId) {

        return workplaceService.findAll();
    }

    @PostMapping
    Workplace newWorkplace(@RequestBody @Validated Workplace newWorkplace) {

        return  workplaceService.save(newWorkplace);
    }

    @GetMapping("/{id}")
    Workplace readIdWorkplaces(@PathVariable int workplaceId) {

        return workplaceService.findById(workplaceId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    Workplace updateWorkplace(@PathVariable int workplaceId, @RequestBody @Validated Workplace newWorkplace) {
        return workplaceService.findById(workplaceId)
                .map(workplace -> {
                    workplace.setDescription(newWorkplace.getDescription());
                    workplace.setType(newWorkplace.getType());

                    return workplaceService.save(workplace);
                })
                .orElseGet(() -> {
                    newWorkplace.setWorkplaceId(workplaceId);
                    return workplaceService.save(newWorkplace);
                })  ;

    }

    @DeleteMapping("/{id}")
    void deleteWorkplace(@PathVariable int workplaceId) {
        workplaceService.deleteById(workplaceId);
    }

}
