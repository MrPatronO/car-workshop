package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewRepairDto;
import com.github.MrPatronO.carworkshop.dtos.RepairDto;
import com.github.MrPatronO.carworkshop.models.*;
import com.github.MrPatronO.carworkshop.repositories.RepairRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class RepairService {


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
        Client client = clientService.findById(newRepairDto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
        Car car = carService.findById(newRepairDto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        Workplace workplace = workplaceService.findById(newRepairDto.getWorkplaceId()).orElseThrow(() -> new RuntimeException("Workplace not found"));
        Timetable timetable = timetableService.findById(newRepairDto.getTimetableId()).orElseThrow(() -> new RuntimeException("Timetable not found"));

        Repair repair = new Repair();
        mapToRepair(newRepairDto.getDescription(), newRepairDto.getPrice(), client, car, workplace, timetable, repair);

        Repair newRepair = repairRepository.save(repair);

        return mapToRepairDto(newRepair);
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
                    Client client = clientService.findById(repairDto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
                    Car car = carService.findById(repairDto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
                    Workplace workplace = workplaceService.findById(repairDto.getWorkplaceId()).orElseThrow(() -> new RuntimeException("Workplace not found"));
                    Timetable timetable = timetableService.findById(repairDto.getTimetableId()).orElseThrow(() -> new RuntimeException("Timetable not found"));

                    mapToRepair(repairDto.getDescription(), repairDto.getPrice(), client, car, workplace, timetable, repair);

                    return repairRepository.save(repair);

                })
                .orElseGet(() -> {
                    Client client = clientService.findById(repairDto.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
                    Car car = carService.findById(repairDto.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
                    Workplace workplace = workplaceService.findById(repairDto.getWorkplaceId()).orElseThrow(() -> new RuntimeException("Workplace not found"));
                    Timetable timetable = timetableService.findById(repairDto.getTimetableId()).orElseThrow(() -> new RuntimeException("Timetable not found"));

                    Repair repair = new Repair();
                    mapToRepair(repairDto.getDescription(), repairDto.getPrice(), client, car, workplace, timetable, repair);

                    return repairRepository.save(repair);
                });

        return mapToRepairDto(updatedOrCreatedRepair);
    }


    private RepairDto mapToRepairDto(Repair repair) {

        RepairDto repairDto = new RepairDto();
        repairDto.setRepairId(repair.getRepairId());
        repairDto.setCarId(repair.getCar().getCarId());
        repairDto.setClientId(repair.getClient().getClientId());
        repairDto.setDescription(repair.getDescription());
        repairDto.setPrice(repair.getPrice());
        repairDto.setWorkplaceId(repair.getWorkplace().getWorkplaceId());
        repairDto.setTimetableId(repair.getTimetable().getTimetableId());

        return repairDto;
    }

    private void mapToRepair(String description, BigDecimal price, Client client, Car car, Workplace workplace, Timetable timetable, Repair repair) {
        repair.setCar(car);
        repair.setClient(client);
        repair.setDescription(description);
        repair.setPrice(price);
        repair.setWorkplace(workplace);
        repair.setTimetable(timetable);
    }

}