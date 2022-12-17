package com.github.MrPatronO.carworkshop.repositories;

import com.github.MrPatronO.carworkshop.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
