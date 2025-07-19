package com.baeldung.ls.service;

import com.baeldung.ls.exception.TaskNotSavedException;
import com.baeldung.ls.persistence.model.Task;

import java.util.List;

public interface ITaskService {

    List<Task> findAll();

    Task save(Task task) throws TaskNotSavedException;
}
