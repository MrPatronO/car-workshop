package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewWorkplaceDto;
import com.github.MrPatronO.carworkshop.dtos.WorkplaceDto;
import com.github.MrPatronO.carworkshop.models.Workplace;
import com.github.MrPatronO.carworkshop.repositories.WorkplaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkplaceService {

    final WorkplaceRepository workplaceRepository;

    WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }


    public WorkplaceDto save(NewWorkplaceDto newWorkplaceDto) {
        Workplace workplace = new Workplace();
        workplace.setType(newWorkplaceDto.getType());
        workplace.setDescription(newWorkplaceDto.getDescription());

        Workplace newWorkplace = workplaceRepository.save(workplace);

        WorkplaceDto workplaceDto = new WorkplaceDto();
        workplaceDto.setWorkplaceId(newWorkplace.getWorkplaceId());
        workplaceDto.setType(newWorkplace.getType());
        workplaceDto.setDescription(newWorkplace.getDescription());

        return workplaceDto;
    }

    public List<Workplace> findAll(){
        return workplaceRepository.findAll();
    };

    public void deleteById(int workplaceId) {
        workplaceRepository.deleteById(workplaceId);
    }

    public Optional<Workplace> findById(Integer workplaceId) {
        return workplaceRepository.findById(workplaceId);
    }

    public WorkplaceDto update(WorkplaceDto workplaceDto, Integer workplaceId) {
        Workplace updatedOrCreatedWorkplace = workplaceRepository.findById(workplaceId)
                .map(workplace -> {
                    workplace.setDescription(workplaceDto.getDescription());
                    workplace.setType(workplaceDto.getType());

                    return workplaceRepository.save(workplace);
                })
                .orElseGet(() -> {
                    Workplace workplace = new Workplace();
                    workplace.setWorkplaceId(workplaceDto.getWorkplaceId());
                    workplace.setDescription(workplaceDto.getDescription());
                    workplace.setType(workplaceDto.getType());

                    return workplaceRepository.save(workplace);
                })  ;
        WorkplaceDto newWorkplaceDto = new WorkplaceDto();
        newWorkplaceDto.setWorkplaceId(updatedOrCreatedWorkplace.getWorkplaceId());
        newWorkplaceDto.setDescription(updatedOrCreatedWorkplace.getDescription());
        newWorkplaceDto.setType(updatedOrCreatedWorkplace.getType());


        return newWorkplaceDto;
    }

 }
