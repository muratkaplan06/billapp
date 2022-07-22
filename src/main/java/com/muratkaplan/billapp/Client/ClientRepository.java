package com.muratkaplan.billapp.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    @Query("SELECT c FROM Client c WHERE c.firstName=?1")
    Optional<Client> findClientByFirstName(String firstName);
    @Query("SELECT c FROM Client c WHERE c.lastName=?1")
    Optional<Client> findClientByLastName(String lastName);
}
