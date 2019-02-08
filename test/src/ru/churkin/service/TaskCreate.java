package ru.churkin.service;

import ru.churkin.dto.TaskDto;
import ru.churkin.entity.Task;
import ru.churkin.exception.TaskAlreadyExistsException;
import ru.churkin.repository.TaskRepository;
import ru.churkin.ui.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;

//
public class TaskCreate implements Command {

	private BufferedReader reader;
	private UserInterface userInterface;
	private TaskRepository taskRepository;

	public TaskCreate(BufferedReader reader, UserInterface userInterface, TaskRepository taskRepository) {
		this.reader = reader;
		this.userInterface = userInterface;
		this.taskRepository = taskRepository;
	}
	@Override
	public String name() {
		return "taskCreate";
	}

	@Override
	public String description() {
		return "Create new task";
	}

	@Override
	public void execute() throws IOException {
//		System.out.println("enter new task parameters: name, description, timeStart, timeFinish");
//		Task newTask = new Task();
//		newTask.setProjectId(reader.readLine()); ///-------как пользователь введет этот огромный ID
//		newTask.setName(reader.readLine());
//		newTask.setDescription(reader.readLine());
//		newTask.setTimeFinish(reader.readLine());
//		newTask.setTimeFinish(reader.readLine());
//		// TODO - закрыть в finally
////		reader.close();

		TaskDto taskDto = userInterface.createTask();
		validate(taskDto);

		Task task = new Task(taskDto);
		taskRepository.createTask(task);
	}

	// return new Task;
	private void validate(TaskDto taskDto) {
		if (taskRepository.findTaskByName(taskDto.getName()) != null) {
			throw new TaskAlreadyExistsException("Уже есть такая задача");
		}
	}
}
