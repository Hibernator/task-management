package com.baeldung.ls.service.impl;

import com.baeldung.ls.exception.TaskNotSavedException;
import com.baeldung.ls.persistence.model.Task;
import com.baeldung.ls.persistence.repository.ITaskRepository;
import com.baeldung.ls.service.ITaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private ITaskRepository taskRepository;

    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) throws TaskNotSavedException {
        return taskRepository.save(task);
        //        throw new TaskNotSavedException("Unable to save task.");
    }
}
