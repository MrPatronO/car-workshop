package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewRepairDto;
import com.github.MrPatronO.carworkshop.dtos.RepairDto;
import com.github.MrPatronO.carworkshop.models.*;
import com.github.MrPatronO.carworkshop.repositories.RepairRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public RepairDto save(NewRepairDto newRepairDto, Integer clientId, Integer carId, Integer workplaceId, Integer timetableId) {
        Optional<Client> client = clientService.findById(clientId);
        Optional<Car> car = carService.findById(carId);
        Optional<Workplace> workplace = workplaceService.findById(workplaceId);
        Optional<Timetable> timetable = timetableService.findById(timetableId);


        if (client.isPresent() && car.isPresent() && workplace.isPresent() && timetable.isPresent() ) {
            Repair repair = new Repair();
            repair.setCar(car.get());
            repair.setClient(client.get());
            repair.setDescription(newRepairDto.getDescription());
            repair.setPrice(newRepairDto.getPrice());
            repair.setWorkplace(workplace.get());
            repair.setTimetable(timetable.get());
            Repair newRepair = repairRepository.save(repair);

            RepairDto repairDto = new RepairDto();
            repairDto.setRepairId(newRepair.getRepairId());
            repairDto.setCarId(car.get());
            repairDto.setClientId(client.get());
            repairDto.setDescription(newRepair.getDescription());
            repairDto.setPrice(newRepair.getPrice());
            repairDto.setWorkplaceId(workplace.get());
            repairDto.setTimetableId(timetable.get());

            logger.trace("A TRACE Message");
            logger.debug("A DEBUG Message");
            logger.warn("A WARN Message");
            logger.error("An ERROR Message");
            logger.info("clientId", clientId);

            return repairDto;
        } throw new IllegalArgumentException("Wrong id!");
    }

    public ResponseEntity<Repair> findAll(Repair repair) {
        return null;
    }


    public void deleteById(int repairId) {
        repairRepository.deleteById(repairId);
    }

    public Optional<Repair> findById(Integer repairId) {
        return repairRepository.findById(repairId);
    }

    public RepairDto update(RepairDto repairDto, Integer repairId) {
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