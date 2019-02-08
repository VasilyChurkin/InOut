package ru.churkin.ui;

import ru.churkin.dto.TaskDto;

import java.io.IOException;

public interface UserInterface {

	TaskDto createTask() throws IOException;

	boolean deleteTask();

	TaskDto updateTask();

	String findTask();
}
