package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Project;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProjectRepository
        extends ListCrudRepository<Project, Long>, ListPagingAndSortingRepository<Project, Long> {

    // Spring will automatically implement this method because the method name follows the naming convention
    List<Project> findByNameContaining(String name);

    List<Project> findByDateCreatedBetween(LocalDate start, LocalDate end);
}
