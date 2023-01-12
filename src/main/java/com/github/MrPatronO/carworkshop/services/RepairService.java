package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewRepairDto;
import com.github.MrPatronO.carworkshop.dtos.RepairDto;
import com.github.MrPatronO.carworkshop.models.*;
import com.github.MrPatronO.carworkshop.repositories.RepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    public static final Logger logger = LoggerFactory.getLogger(RepairService.class);

    final RepairRepository repairRepository;
    ClientService clientService;
    CarService carService;
    WorkplaceService workplaceService;
    TimetableService timetableService;

    RepairService(RepairRepository repairRepository, ClientService clientService, CarService carService, WorkplaceService workplaceService, TimetableService timetableService) {
        this.repairRepository = repairRepository;
        this.clientService = clientService;
        this.carService = carService;
        this.workplaceService = workplaceService;
        this.timetableService = timetableService;
    }

    public RepairDto save(NewRepairDto newRepairDto) {
        logger.info("clientId =" + newRepairDto.getClientId() + " carId = " + newRepairDto.getCarId() + " workplaceId = " + newRepairDto.getWorkplaceId() + " timetableId = " + newRepairDto.getTimetableId());
        Client client = clientService.findById(newRepairDto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
        Car car = carService.findById(newRepairDto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        Workplace workplace = workplaceService.findById(newRepairDto.getWorkplaceId()).orElseThrow(() -> new RuntimeException("Workplace not found"));
        Timetable timetable = timetableService.findById(newRepairDto.getTimetableId()).orElseThrow(() -> new RuntimeException("Timetable not found"));

            Repair repair = new Repair();
            repair.setCar(car);
            repair.setClient(client);
            repair.setDescription(newRepairDto.getDescription());
            repair.setPrice(newRepairDto.getPrice());
            repair.setWorkplace(workplace);
            repair.setTimetable(timetable);

            Repair newRepair = repairRepository.save(repair);

            RepairDto repairDto = new RepairDto();
            repairDto.setRepairId(newRepair.getRepairId());
            repairDto.setCarId(newRepair.getCar());
            repairDto.setClientId(newRepair.getClient());
            repairDto.setDescription(newRepair.getDescription());
            repairDto.setPrice(newRepair.getPrice());
            repairDto.setWorkplaceId(newRepair.getWorkplace());
            repairDto.setTimetableId(newRepair.getTimetable());

            return repairDto;
    }

    public List<Repair> findAll(Repair repair) {
        return repairRepository.findAll();
    }


    public void deleteById(Long id) {
        repairRepository.deleteById(id);
    }

    public Optional<Repair> findById(Long repairId) {
        return repairRepository.findById(repairId);
    }

    public RepairDto update(RepairDto repairDto, Long repairId) {
        Repair updatedOrCreatedRepair = repairRepository.findById(repairId)
                .map(repair -> {
                    repair.setTimetable(repairDto.getTimetableId());
                    repair.setCar(repairDto.getCarId());
                    repair.setClient(repairDto.getClientId());
                    repair.setDescription(repairDto.getDescription());
                    repair.setPrice(repairDto.getPrice());
                    repair.setWorkplace(repairDto.getWorkplaceId());

                    return repairRepository.save(repair);
                })
                .orElseGet(() -> {
                    Repair repair = new Repair();
                    repair.setRepairId(repairDto.getRepairId());
                    repair.setTimetable(repairDto.getTimetableId());
                    repair.setCar(repairDto.getCarId());
                    repair.setClient(repairDto.getClientId());
                    repair.setDescription(repairDto.getDescription());
                    repair.setPrice(repairDto.getPrice());
                    repair.setWorkplace(repairDto.getWorkplaceId());

                    return repairRepository.save(repair);
                });
        RepairDto newRepairDto = new RepairDto();
        newRepairDto.setRepairId(updatedOrCreatedRepair.getRepairId());
        newRepairDto.setTimetableId(updatedOrCreatedRepair.getTimetable());
        newRepairDto.setCarId(updatedOrCreatedRepair.getCar());
        newRepairDto.setClientId(updatedOrCreatedRepair.getClient());
        newRepairDto.setDescription(updatedOrCreatedRepair.getDescription());
        newRepairDto.setPrice(updatedOrCreatedRepair.getPrice());
        newRepairDto.setWorkplaceId(updatedOrCreatedRepair.getWorkplace());

        return newRepairDto;
    }

}