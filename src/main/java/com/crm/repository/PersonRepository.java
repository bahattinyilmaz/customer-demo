package com.crm.repository;

import com.crm.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query("select u from Person u where u.username = ?1")
    Optional<Person> findByUserName(String userName);

}
