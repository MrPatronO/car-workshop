package com.github.MrPatronO.carworkshop.repository;

import com.github.MrPatronO.carworkshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
