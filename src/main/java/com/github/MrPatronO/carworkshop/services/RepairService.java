package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewRepairDto;
import com.github.MrPatronO.carworkshop.dtos.RepairDto;
import com.github.MrPatronO.carworkshop.models.Repair;
import com.github.MrPatronO.carworkshop.repositories.RepairRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepairService {

    final RepairRepository repairRepository;

    RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }


    public RepairDto save(NewRepairDto newRepairDto) {
        Repair repair = new Repair();
        repair.setCar(newRepairDto.getCar());
        repair.setClient(newRepairDto.getClient());
        repair.setDescription(newRepairDto.getDescription());
        repair.setPrice(newRepairDto.getPrice());
        repair.setStand(newRepairDto.getStand());
        repair.setTimetable(newRepairDto.getTimetable());

        Repair newRepair = repairRepository.save(repair);

        RepairDto repairDto = new RepairDto();
        repairDto.setRepairId(newRepair.getRepairId());
        repairDto.setCar(newRepair.getCar());
        repairDto.setClient(newRepair.getClient());
        repairDto.setDescription(newRepair.getDescription());
        repairDto.setPrice(newRepair.getPrice());
        repairDto.setStand(newRepair.getStand());
        repairDto.setTimetable(newRepair.getTimetable());

        return repairDto;
    }


    public ResponseEntity<Repair> findAll(Repair repair) {
        return repairRepository.findAll(repair);
    }


    public void deleteById(int repairId) {
        repairRepository.deleteById(repairId);
    }

    public Optional<Repair> findById(Integer repairId) {
        return repairRepository.findById(repairId);
    }

    public void delete(Repair repair) {
        repairRepository.delete(repair);
    }

    public boolean exists(Integer id) {
        return repairRepository.existsById(id);
    }

    public RepairDto update(RepairDto repairDto, Integer repairId) {
        Repair updatedOrCreatedRepair = repairRepository.findById(repairId)
                .map(repair -> {
                    repair.setTimetable(repairDto.getTimetable());
                    repair.setCar(repairDto.getCar());
                    repair.setClient(repairDto.getClient());
                    repair.setDescription(repairDto.getDescription());
                    repair.setPrice(repairDto.getPrice());
                    repair.setStatus(repairDto.getStatus());
                    repair.setStand(repairDto.getStand());

                    return repairRepository.save(repair);
                })
                .orElseGet(() -> {
                    Repair repair = new Repair();
                    repair.setRepairId(repairDto.getRepairId());
                    repair.setTimetable(repairDto.getTimetable());
                    repair.setCar(repairDto.getCar());
                    repair.setClient(repairDto.getClient());
                    repair.setDescription(repairDto.getDescription());
                    repair.setPrice(repairDto.getPrice());
                    repair.setStatus(repairDto.getStatus());
                    repair.setStand(repairDto.getStand());

                    return repairRepository.save(repair);
                });
        RepairDto newRepairDto = new RepairDto();
        newRepairDto.setRepairId(updatedOrCreatedRepair.getRepairId());
        newRepairDto.setTimetable(updatedOrCreatedRepair.getTimetable());
        newRepairDto.setCar(updatedOrCreatedRepair.getCar());
        newRepairDto.setClient(updatedOrCreatedRepair.getClient());
        newRepairDto.setDescription(updatedOrCreatedRepair.getDescription());
        newRepairDto.setPrice(updatedOrCreatedRepair.getPrice());
        newRepairDto.setStatus(updatedOrCreatedRepair.getStatus());
        newRepairDto.setStand(updatedOrCreatedRepair.getStand());

        return newRepairDto;
    }
}