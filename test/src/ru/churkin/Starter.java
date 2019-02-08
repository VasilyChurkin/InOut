package ru.churkin;

import ru.churkin.repository.TaskRepository;
import ru.churkin.service.TaskService;
import ru.churkin.service.Command;
import ru.churkin.service.TaskCreate;
import ru.churkin.service.TaskDelete;
import ru.churkin.service.TaskReadByID;
import ru.churkin.service.TaskUpdate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Starter {

	public void init() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		final TaskCreate taskCreate = new TaskCreate(reader);
		final TaskReadByID taskReadByID = new TaskReadByID();
		final TaskUpdate taskUpdate = new TaskUpdate();
		final TaskDelete taskDelete = new TaskDelete();


		Map<String, Command> nameToCommand = new HashMap<>();
		nameToCommand.put(taskCreate.name(), taskCreate);
		nameToCommand.put(taskReadByID.name(), taskReadByID);
		nameToCommand.put(taskUpdate.name(), taskUpdate);
		nameToCommand.put(taskDelete.name(), taskDelete);

		TaskRepository taskRepository = new TaskRepository();
		TaskService taskService = new TaskService(taskRepository, nameToCommand);

		// попросили пользователя ввести команду
		String commandName = reader.readLine();
		taskService.execute(commandName);

		System.out.println("enter 'help'");

		if ("help".equals(reader.readLine())) {
			for (Map.Entry<String, Command> entry : nameToCommand.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
//        if ("help".equals(reader.readLine())) {
//            for (Map.Entry<String, Object> entry : commandMap.entrySet())
//            {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
//        }


		List<String> quitCommands = Arrays.asList("quit", "q", "QUIT", "Q", "EXIT", "exit");


		// TODO - новый код
		String userInput = reader.readLine();

		while (!quitCommands.contains(userInput)) {

			userInput = reader.readLine().trim();

			if ("help".equalsIgnoreCase(userInput)) {
				// TODO - логика help
			} else {
				try {
					taskService.execute(userInput);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}
}
