package com.joshbarros.springproviders.repositories;

import com.joshbarros.springproviders.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
