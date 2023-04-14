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

        return mapToWorkplaceDto(newWorkplace);
    }

    public List<Workplace> findAll(){
        return workplaceRepository.findAll();
    };

    public void deleteById(Long id) {
        workplaceRepository.deleteById(id);
    }

    public Optional<Workplace> findById(Long workplaceId) {
        return workplaceRepository.findById(workplaceId);
    }

    public WorkplaceDto update(WorkplaceDto workplaceDto, Long workplaceId) {
        Workplace updatedOrCreatedWorkplace = workplaceRepository.findById(workplaceId)
                .map(workplace -> {

                    mapToWorkplace(workplace ,workplaceDto);
                    return workplaceRepository.save(workplace);
                })
                .orElseGet(() -> {
                    Workplace workplace = new Workplace();
                    workplace.setWorkplaceId(workplaceDto.getWorkplaceId());

                    mapToWorkplace(workplace ,workplaceDto);

                    return workplaceRepository.save(workplace);
                })  ;

        return mapToWorkplaceDto(updatedOrCreatedWorkplace);
    }

    private WorkplaceDto mapToWorkplaceDto(Workplace workplace){
        WorkplaceDto workplaceDto = new WorkplaceDto();
        workplaceDto.setWorkplaceId(workplace.getWorkplaceId());
        workplaceDto.setType(workplace.getType());
        workplaceDto.setDescription(workplace.getDescription());

        return workplaceDto;
    }

    private void mapToWorkplace(Workplace workplace, WorkplaceDto workplaceDto){
        workplace.setDescription(workplaceDto.getDescription());
        workplace.setType(workplaceDto.getType());
    }

 }
