package com.github.MrPatronO.carworkshop.controllers;

import com.github.MrPatronO.carworkshop.dtos.NewRepairDto;
import com.github.MrPatronO.carworkshop.dtos.RepairDto;
import com.github.MrPatronO.carworkshop.models.Repair;
import com.github.MrPatronO.carworkshop.services.RepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairs")
class RepairController {

    @Autowired
    private final RepairService repairService;

    RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    List<Repair> readRepair(Repair repairId) {

        return repairService.findAll(repairId);
    }

    @PostMapping
    RepairDto newRepair(@RequestBody @Validated NewRepairDto newRepairDto) {

        return  repairService.save(newRepairDto);
    }


    @GetMapping("/{id}")
    Repair readIdOrders(@PathVariable("id") Long id) {

        return repairService.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<RepairDto> updateRepair(@PathVariable("id") Long id, @RequestBody @Validated RepairDto repairDto) {
        return ResponseEntity.ok(repairService.update(repairDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable("id") Long id) {
        repairService.deleteById(id);
    }
}
