package com.github.MrPatronO.carworkshop.repositories;

import com.github.MrPatronO.carworkshop.models.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Integer> {

}
