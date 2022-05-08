package com.joshbarros.springproviders.repositories;

import com.joshbarros.springproviders.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

    @Query("select s from Service s join s.client c " +
            " where upper( c.name ) like upper( :name ) and MONTH(s.date) =:month ")
    List<Service> findByClientNameAndMonth(
            @Param("name") String name,
            @Param("month") Integer month
    );
}
