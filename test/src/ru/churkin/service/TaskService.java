package ru.churkin.service;

import ru.churkin.repository.TaskRepository;

import java.io.IOException;
import java.util.Map;

public class TaskService {
	private TaskRepository taskRepository;
	private Map<String, Command> nameToCommand;

	public TaskService(TaskRepository taskRepository, Map<String, Command> nameToCommand) {
		this.taskRepository = taskRepository;
		this.nameToCommand = nameToCommand;
	}

	public TaskRepository getTaskRepository() {
		return taskRepository;
	}

	public void execute(String commandName) throws IOException {
		Command command = nameToCommand.get(commandName);
		if (command == null) {
			throw new IllegalArgumentException("Нет такой команды");
		}
		command.execute();
	}
}


