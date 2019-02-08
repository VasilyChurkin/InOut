package ru.churkin.service;

import java.io.IOException;

public interface Command {

    String name();
    String description();
    Object execute() throws IOException;
}
