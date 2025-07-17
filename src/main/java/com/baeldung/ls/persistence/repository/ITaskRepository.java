package com.baeldung.ls.persistence.repository;

import com.baeldung.ls.persistence.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends ListCrudRepository<Task, Long> {

    @Query("select t from Task t where t.name like %:name%")
    List<Task> findByNameMatches(String name);
}
