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

@RestController
@RequestMapping("/repairs")
class RepairController {

    @Autowired
    private final RepairService repairService;

    public static final Logger logger = LoggerFactory.getLogger(RepairController.class);

    RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    ResponseEntity<Repair> readRepair(Repair repairId) {

        return repairService.findAll(repairId);
    }

    @PostMapping
    RepairDto newRepair(@RequestBody @Validated NewRepairDto newRepairDto, Integer clientId, Integer carId, Integer workplaceId, Integer timetableId) {

        return  repairService.save(newRepairDto, clientId, carId, workplaceId, timetableId);
    }


    @GetMapping("/{id}")
    Repair readIdOrders(Integer orderId) {

        return repairService.findById(orderId)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<RepairDto> updateRepair(@PathVariable Integer id, @RequestBody @Validated RepairDto repairDto) {
        return ResponseEntity.ok(repairService.update(repairDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteOrder(Integer orderId) {
        repairService.deleteById(orderId);
    }
}
