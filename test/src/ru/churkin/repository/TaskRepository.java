package ru.churkin.repository;

import ru.churkin.entity.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskRepository {

	private Map<String, Task> taskMap = new HashMap<>();

	public void createTask(Task task) {
		String id = UUID.randomUUID().toString();
		task.setId(id);
		taskMap.put(id, task);
	}

	public Task findTaskByName(String name) {
		Task task2;
		for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
			task2 = entry.getValue();
			if (name.equals(task2.getName())) {
				return task2;
			}
		}
	}

	public void updateTask(String id, Task task) {
		Task task = taskMap.get(id);
		task.setName();
		task.setDescription();
		task.setTimeStart();
		task.setTimeFinish();
		taskMap.put(id, task);
	}

	public void deleteTask(String id) {
		taskMap.remove(id);
	}


}
