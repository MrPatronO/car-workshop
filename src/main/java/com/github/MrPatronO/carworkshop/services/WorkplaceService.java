package com.github.MrPatronO.carworkshop.services;


import com.github.MrPatronO.carworkshop.models.Workplace;
import com.github.MrPatronO.carworkshop.repositories.WorkplaceRepository;
import com.github.MrPatronO.carworkshop.services.interfaces.WorkplaceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkplaceService implements WorkplaceInterface {
    final WorkplaceRepository workplaceRepository;

    WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    public Workplace save(Workplace workplace) {
        return workplaceRepository.save(workplace);
    }

    @Override
    public ResponseEntity<Workplace> findAll() {
        return null;
    }

    @Override
    public void deleteById(int workplaceId) {

    }

    public Optional<Workplace> findById(Integer integer) {
        return workplaceRepository.findById(integer);
    }

    public void delete(Workplace workplace) {
        workplaceRepository.delete(workplace);
    }

    public boolean existsByWorkplaceId(Integer integer) {
        return workplaceRepository.existsById(integer);
    }


}
