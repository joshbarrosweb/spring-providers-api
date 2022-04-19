package com.joshbarros.springproviders.repositories;

import com.joshbarros.springproviders.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
