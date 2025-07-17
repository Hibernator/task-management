package com.baeldung.ls.persistence.model;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectInMemory {
    private Long id;
    private String internalId;
    private String name;
    private LocalDate dateCreated;

    public ProjectInMemory(Long id, String name, LocalDate dateCreated) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public ProjectInMemory(ProjectInMemory projectInMemory) {
        this.id = projectInMemory.getId();
        this.name = projectInMemory.getName();
        this.dateCreated = projectInMemory.getDateCreated();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProjectInMemory projectInMemory = (ProjectInMemory) o;
        return Objects.equals(id, projectInMemory.id)
                && Objects.equals(name, projectInMemory.name)
                && Objects.equals(dateCreated, projectInMemory.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreated);
    }

    @Override
    public String toString() {
        return "ProjectInMemory{" + "id=" + id + ", name='" + name + '\'' + ", dateCreated=" + dateCreated + '}';
    }
}
