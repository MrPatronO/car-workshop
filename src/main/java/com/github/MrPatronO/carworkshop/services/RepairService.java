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
            repairDto.setCarId(newRepair.getCar().getCarId());
            repairDto.setClientId(newRepair.getClient().getClientId());
            repairDto.setDescription(newRepair.getDescription());
            repairDto.setPrice(newRepair.getPrice());
            repairDto.setWorkplaceId(newRepair.getWorkplace().getWorkplaceId());
            repairDto.setTimetableId(newRepair.getTimetable().getTimetableId());

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
        logger.info("clientId =" + repairDto.getClientId() + " carId = " + repairDto.getCarId() + " workplaceId = " + repairDto.getWorkplaceId() + " timetableId = " + repairDto.getTimetableId());
        Client client = clientService.findById(repairDto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
        Car car = carService.findById(repairDto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        Workplace workplace = workplaceService.findById(repairDto.getWorkplaceId()).orElseThrow(() -> new RuntimeException("Workplace not found"));
        Timetable timetable = timetableService.findById(repairDto.getTimetableId()).orElseThrow(() -> new RuntimeException("Timetable not found"));

        Repair repair = new Repair();
        repair.setCar(car);
        repair.setClient(client);
        repair.setDescription(repairDto.getDescription());
        repair.setPrice(repairDto.getPrice());
        repair.setWorkplace(workplace);
        repair.setTimetable(timetable);

        Repair newRepair = repairRepository.save(repair);

        Repair updatedOrCreatedRepair = repairRepository.findById(repairId)
                .map(repairs -> {
                    repairs.setTimetable(newRepair.getTimetable());
                    repairs.setCar(newRepair.getCar());
                    repairs.setClient(newRepair.getClient());
                    repairs.setDescription(newRepair.getDescription());
                    repairs.setPrice(newRepair.getPrice());
                    repairs.setWorkplace(newRepair.getWorkplace());

                    return repairRepository.save(repair);
                })
                .orElseGet(() -> {
                    Repair repairs = new Repair();
                    repairs.setRepairId(newRepair.getRepairId());
                    repairs.setTimetable(newRepair.getTimetable());
                    repairs.setCar(newRepair.getCar());
                    repairs.setClient(newRepair.getClient());
                    repairs.setDescription(newRepair.getDescription());
                    repairs.setPrice(newRepair.getPrice());
                    repairs.setWorkplace(newRepair.getWorkplace());

                    return repairRepository.save(repair);
                });
        RepairDto newRepairDto = new RepairDto();
        newRepairDto.setRepairId(updatedOrCreatedRepair.getRepairId());
        newRepairDto.setTimetableId(updatedOrCreatedRepair.getTimetable().getTimetableId());
        newRepairDto.setCarId(updatedOrCreatedRepair.getCar().getCarId());
        newRepairDto.setClientId(updatedOrCreatedRepair.getClient().getClientId());
        newRepairDto.setDescription(updatedOrCreatedRepair.getDescription());
        newRepairDto.setPrice(updatedOrCreatedRepair.getPrice());
        newRepairDto.setWorkplaceId(updatedOrCreatedRepair.getWorkplace().getWorkplaceId());

        return newRepairDto;
    }

}