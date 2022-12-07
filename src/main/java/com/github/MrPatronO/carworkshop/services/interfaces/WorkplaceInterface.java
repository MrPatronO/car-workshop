package com.github.MrPatronO.carworkshop.services.interfaces;

import com.github.MrPatronO.carworkshop.models.Workplace;
import org.springframework.http.ResponseEntity;

public interface WorkplaceInterface {

    public abstract Workplace save(Workplace workplace);

    ResponseEntity<Workplace> findAll();

    void deleteById(int workplaceId);
}
