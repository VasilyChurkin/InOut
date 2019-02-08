package ru.churkin.entity;

import ru.churkin.dto.TaskDto;

public class Task {

    private String id;
    private String name;
    private String description;
    private String timeStart;
    private String timeFinish;
    private String projectId;

    public Task(String name) {
       this.name = name;
    }

    public Task() {
    }

    public Task(TaskDto taskDto) {
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.timeStart = taskDto.getTimeStart();
        this.timeFinish = taskDto.getTimeFinish();
        this.projectId = taskDto.getProjectId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeFinish(String timeFin) {
        this.timeFinish = timeFin;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
