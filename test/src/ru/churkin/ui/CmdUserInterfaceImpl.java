package ru.churkin.ui;

import ru.churkin.dto.TaskDto;

import java.io.BufferedReader;
import java.io.IOException;

public class CmdUserInterfaceImpl implements UserInterface {

	private BufferedReader reader;

	public CmdUserInterfaceImpl(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public TaskDto createTask() throws IOException {
		System.out.println("Введите название задачи:");
		String name = reader.readLine();
		TaskDto taskDto = new TaskDto();
		taskDto.setName(name);
		return taskDto;
	}

	@Override
	public boolean deleteTask() {
		return false;
	}

	@Override
	public TaskDto updateTask() {
		return null;
	}

	@Override
	public String findTask() {
		return null;
	}
}
